package com.hibuddy.springboot.domain.buddy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

//요청 리스트에서 선택해서 친구 리스트에 업데이트 하고 요청 리스트에 지워짐
@RunWith(SpringRunner.class)
@SpringBootTest //@SpringbootApplication 찾아 모든 빈 등록. application.properties를 읽고 mysql 사용
public class BuddyListRepositoryTest {
    private Long no;//BuddyRequest 튜플을 구분 짓는 pk
    @Autowired
    BuddyListRepository buddyListRepository;
    @Autowired
    BuddyRequestRepository buddyRequestRepository;

    @Test
    public void 요청목록에서_수락하여_친구목록에_추가() {
        //given
        List<BuddyRequest> reqList = buddyRequestRepository.findAll();
        BuddyRequest bReq = reqList.get(0);
        no=bReq.getNo();
        String uId = bReq.getUserId();
        String rId = bReq.getRequestedId();

        buddyListRepository.save(BuddyList.builder()
                .userId(uId)
                .buddyId(rId)
                .build());

        //when
        List<BuddyList> blList = buddyListRepository.findAll();

        //then
        BuddyList buddyList = blList.get(blList.size()-1);
        assertThat(buddyList.getUserId()).isEqualTo(uId);
        assertThat(buddyList.getBuddyId()).isEqualTo(rId);

        buddyRequestRepository.deleteById(no);//요청 목록에서 삭제
        Optional<BuddyRequest> buddyRequest = buddyRequestRepository.findById(no);
        assertThat(buddyRequest).isEmpty();
    }
}
