package com.hibuddy.springboot.service.user;

import com.hibuddy.springboot.domain.buddy.BuddyList;
import com.hibuddy.springboot.domain.buddy.BuddyListRepository;
import com.hibuddy.springboot.domain.user.UserHobby;
import com.hibuddy.springboot.domain.user.UserHobbyRepository;
import com.hibuddy.springboot.domain.user.User;
import com.hibuddy.springboot.domain.user.UserRepository;
import com.hibuddy.springboot.service.buddy.BuddyService;
import com.hibuddy.springboot.web.dto.SameHobbyBuddyDto;
import com.hibuddy.springboot.web.dto.UserResponseDto;
import com.hibuddy.springboot.web.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
@Service //Service는 트랜잭션, 도메인 간 순서 보장의 역할만 함. 비지니스 로직은 Domain에서 처리.
public class UserService {
    private final UserRepository userRepository;
    private final UserHobbyRepository userHobbyRepository;
    private final BuddyListRepository buddyListRepository;

    public boolean confirmUserId(String userId) {
        return userRepository.findByUserId(userId).isPresent();
    }

    @Transactional
    public String save(UserRequestDto requestDto) { //비즈니스 로직 처리
        userRepository.save(requestDto.toUserEntity());
        return userHobbyRepository.save(requestDto.toHobbyEntity()).getUserId();
    }

    //JPA의 영속성 컨텍스트. 트랜잭션 과정에서 DB에서 데이터를 가져오면, 트랙잭션이 끝나는 시점에 해당 테이블에 변경분을 반영
    //즉, Entity 객체의 값만 변경하면 별로도 Update 쿼리를 날리지 않아도 알아서 해줌.
    @Transactional
    public String update(String userId, UserRequestDto dto) {
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다. id=" + userId));
        user.update(dto.toUserEntity());
        UserHobby userHobby = userHobbyRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다. id=" + userId));
        userHobby.update(dto.toHobbyEntity());
        return user.getUserId();
    }

    @Transactional(readOnly = true) //트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선됨.
    public UserResponseDto findByUserId(String userId) {
        User entity = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다. id=" + userId));
        return new UserResponseDto(entity);
    }

    @Transactional(readOnly = true) //트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선됨.
    public UserResponseDto findTotalInfo(String userId) {
        return userRepository.findTotalInfo(userId).get(0);
    }

    //user와 취미가 겹치는 사람 찾기
    @Transactional(readOnly = true)
    public List<SameHobbyBuddyDto> findByHobby(String userId) {
        UserHobby hobbies = userHobbyRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다. id=" + userId));
        List<SameHobbyBuddyDto> dtoList = userRepository.findByHobby(hobbies.getHobby1(), hobbies.getHobby2(), hobbies.getHobby3());
        List<BuddyList> buddyLists = buddyListRepository.findAllByUserId(userId);

        //취미가 겹치는 사람들 중 본인과 이미 친구인 사람 제거
        Iterator<SameHobbyBuddyDto> iter = dtoList.iterator();
        while (iter.hasNext()) {
            String dtoId = iter.next().getUserId();
            if(dtoId.equals(userId)){
                iter.remove();
                continue;
            }
            for (BuddyList b : buddyLists) {
                if (dtoId.equals(b.getBuddyId())){
                    iter.remove();
                    break;
                }
            }
        }
        return dtoList;
    }
}