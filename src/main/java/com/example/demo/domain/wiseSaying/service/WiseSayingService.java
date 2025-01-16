package com.example.demo.domain.wiseSaying.service;

import com.example.demo.domain.wiseSaying.entity.WiseSaying;
import com.example.demo.domain.wiseSaying.repository.WiseSayingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WiseSayingService {

    @Autowired
    private WiseSayingRepository wiseSayingRepository;

    private List<WiseSaying> wiseSayingList;
    private int lastId;
    public WiseSayingService() {
        this.wiseSayingList = new ArrayList<>();
        this.lastId = 0;
        WiseSaying w1 = WiseSaying.builder()
                .id(++lastId)
                .content("삶이 있는 한 희망은 있다.2")
                .author("키케로")
                .build();
        WiseSaying w2 = WiseSaying.builder()
                .id(++lastId)
                .content("나의 죽음을 알리지 마라.2")
                .author("이순신")
                .build();
        wiseSayingList.add(w1);
        wiseSayingList.add(w2);
    }

    public Optional<WiseSaying> getItem(int id) {
        return wiseSayingList.stream()
                .filter(item -> item.getId() == id)
                .findFirst();
    }

    public List<WiseSaying> getAllItems() {
        return wiseSayingList;
    }

    public WiseSaying write(String content, String author) {

        WiseSaying wiseSaying = WiseSaying.builder()
                .id(++lastId)
                .content(content)
                .author(author)
                .build();

        wiseSayingList.add(wiseSaying);
        return wiseSaying;
    }

    public boolean deleteId(int id) {
        return wiseSayingList.removeIf(w -> w.getId() == id);
    }

    public WiseSaying modify(int id, String content, String author) {
        Optional<WiseSaying> opWiseSaying = getItem(id);

        if(opWiseSaying.isEmpty()) {
            throw new IllegalArgumentException("해당 id의 명언이 없습니다.");
        }
        WiseSaying wiseSaying = opWiseSaying.get();
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);
        return wiseSaying;

    }
}
