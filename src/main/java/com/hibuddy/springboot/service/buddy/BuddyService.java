package com.hibuddy.springboot.service.buddy;

import com.hibuddy.springboot.domain.buddy.BuddyList;
import com.hibuddy.springboot.domain.buddy.BuddyListRepository;
import com.hibuddy.springboot.domain.buddy.BuddyRequest;
import com.hibuddy.springboot.domain.buddy.BuddyRequestRepository;
import com.hibuddy.springboot.domain.user.UserHobbyRepository;
import com.hibuddy.springboot.domain.user.UserRepository;
import com.hibuddy.springboot.web.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service //Service는 트랜잭션, 도메인 간 순서 보장의 역할만 함. 비지니스 로직은 Domain에서 처리.
public class BuddyService {
    private final UserRepository userRepository;
    private final UserHobbyRepository userHobbyRepository;
    private final BuddyRequestRepository buddyRequestRepository;
    private final BuddyListRepository buddyListRepository;


    @Transactional
    public String save(String userId, String requestedId) {
        //찾아보고 없으면 입력
        Optional<BuddyRequest> buddyRequest = buddyRequestRepository.findByUserAndBuddyId(userId, requestedId);
        if (!buddyRequest.isPresent()) {
            buddyRequestRepository.save(
                    BuddyRequest.builder()
                            .userId(userId)
                            .requestedId(requestedId)
                            .build());
        }
        return userId;
    }

    public List<UserResponseDto> findBuddies(String userId) {
        List<BuddyList> buddyList = buddyListRepository.findAllByUserId(userId);
        List<UserResponseDto> originDtos = userRepository.findTotalInfo("");//모든 회원 정보
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for(int i=0;i<originDtos.size();i++){
            for(int j=0;j<buddyList.size();j++)
                if (originDtos.get(i).getUserId().equals(buddyList.get(j).getBuddyId()))
                    userResponseDtos.add(originDtos.get(i));//친구 정보면 담음
        }
        return userResponseDtos;
    }

    public List<UserResponseDto> findRequests(String userId) {
        List<String> requestIds = buddyRequestRepository.findByUserId(userId);
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        for (String uId : requestIds)
            userResponseDtos.add(userRepository.findTotalInfo(uId).get(0));
        return userResponseDtos;
    }

    public String accept(String userId, String buddyId) {
        BuddyRequest buddyRequest = buddyRequestRepository.findByUserAndBuddyId(buddyId, userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 요청이 없습니다." + userId+"-"+buddyId));
        buddyRequestRepository.deleteById(buddyRequest.getNo());
        return buddyListRepository.save(BuddyList.builder()
                .userId(userId)
                .buddyId(buddyId)
                .build()).getUserId();
    }
}
