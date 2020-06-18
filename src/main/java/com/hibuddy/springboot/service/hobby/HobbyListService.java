package com.hibuddy.springboot.service.hobby;

import com.hibuddy.springboot.domain.hobby.HobbyList;
import com.hibuddy.springboot.domain.hobby.HobbyListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service //Service는 트랜잭션, 도메인 간 순서 보장의 역할만 함. 비지니스 로직은 Domain에서 처리.
public class HobbyListService {
    private final HobbyListRepository hobbyListRepository;

    public List<HobbyList> findAll(){
        return hobbyListRepository.findAll();
    }
}
