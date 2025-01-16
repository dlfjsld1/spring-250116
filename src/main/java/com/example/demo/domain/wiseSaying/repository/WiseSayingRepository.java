package com.example.demo.domain.wiseSaying.repository;

import com.example.demo.domain.wiseSaying.entity.WiseSaying;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class WiseSayingRepository {
    private List<WiseSaying> wiseSayingList;
    private int lastId;
    public WiseSayingRepository() {
        lastId = 0;
        wiseSayingList = new ArrayList<>();
    }
    public WiseSaying save(WiseSaying wiseSaying) {
        if(wiseSaying.getId() == 0) {
            wiseSaying.setId(++lastId);
        }
        wiseSayingList.add(wiseSaying);
        return wiseSaying;
    }
    public Optional<WiseSaying> findById(int id) {
        return wiseSayingList.stream()
                .filter(w -> w.getId() == id)
                .findFirst();
    }
    public List<WiseSaying> findAll() {
        return wiseSayingList;
    }
    public boolean deleteById(int id) {
        return wiseSayingList.removeIf(
                w -> w.getId() == id
        );
    }
}