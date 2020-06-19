package com.hibuddy.springboot.service.user;

import com.hibuddy.springboot.domain.user.UserHobbyRepository;
import com.hibuddy.springboot.domain.user.User;
import com.hibuddy.springboot.domain.user.UserRepository;
import com.hibuddy.springboot.web.dto.UserResponseDto;
import com.hibuddy.springboot.web.dto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service //Service는 트랜잭션, 도메인 간 순서 보장의 역할만 함. 비지니스 로직은 Domain에서 처리.
public class UserService {
    private final UserRepository userRepository;
    private final UserHobbyRepository userHobbyRepository;

    public boolean confirmUserId(String userId) {
        return userRepository.findByUserId(userId).isPresent();
    }

    //JPA의 영속성 컨텍스트. 트랜잭션 과정에서 DB에서 데이터를 가져오면, 트랙잭션이 끝나는 시점에 해당 테이블에 변경분을 반영
    //즉, Entity 객체의 값만 변경하면 별로도 Update 쿼리를 날리지 않아도 알아서 해줌.
    @Transactional
    public String save(UserRequestDto requestDto) { //비즈니스 로직 처리
//        User user = userRepository.findByEmail(requestDto.getEmail())
//                .orElseThrow(() -> new IllegalArgumentException("해당 이용자가 없습니다. email=" + requestDto.getEmail()));
//        user.update(requestDto.toUserEntity());
        userRepository.save(requestDto.toUserEntity());
        return userHobbyRepository.save(requestDto.toHobbyEntity()).getUserId();
    }
//    @Transactional
//    public String update(String userId, UserRequestDto requestDto){
//        User user = userRepository.findByUserId(userId)
//                .orElseThrow(()->new IllegalArgumentException("해당 아이디가 없습니다. id="+userId));
//        user.update(requestDto.toUserEntity());
//        UserHobby userHobby = userHobbyRepository.findByUserId(userId)
//                .orElseThrow(()->new IllegalArgumentException("해당 아이디가 없습니다. id="+userId));
//        userHobby.update(requestDto.toHobbyEntity());
//        return userId;
//      }

//    @Transactional
//    public Long update(Long id, PostsUpdateRequestDto requestDto) {
//        Posts posts = postsRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
//        posts.update(requestDto.getTitle(), requestDto.getContent());
//        return id;
//    }//JPA의 영속성 컨텍스트. 트랜잭션 과정에서 DB에서 데이터를 가져오면, 트랙잭션이 끝나는 시점에 해당 테이블에 변경분을 반영
//    //즉, Entity 객체의 값만 변경하면 별로도 Update 쿼리를 날리지 않아도 알아서 해줌.

    //    public PostsResponseDto findById(Long id){
//        Posts entity = postsRepository.findById(id)
//                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
//        return new PostsResponseDto(entity);
//    }
    public UserResponseDto findByUserId(String userId) {
        User entity = userRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다. id=" + userId));
        return new UserResponseDto(entity);
    }


    //    @Transactional(readOnly = true) //트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선됨.
//    public List<PostsListResponseDto> findAllDesc(){
//        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
//    }
//    @Transactional(readOnly = true) //트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선됨.
//    public List<PostsListResponseDto> findAllDesc() {
//        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
//    }
//    @Transactional(readOnly = true) //트랜잭션 범위는 유지하되, 조회 기능만 남겨두어 조회 속도가 개선됨.
//    public UserResponseDto findUserInfo(String userId){
//        userRepository.findByUserId(userId)
//    }
//    @Transactional
//    public void delete(Long id) {
//        Posts posts = postsRepository.findById(id)
//                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
//        postsRepository.delete(posts);//JpaRepository에서 이미 delete 메소드 지원. deleteById를 이용한 삭제도 가능.
//    }
}
