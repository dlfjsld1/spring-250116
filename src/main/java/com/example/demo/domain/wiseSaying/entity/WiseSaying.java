package com.example.demo.domain.wiseSaying.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WiseSaying {
    private int id;
    private String content;
    private String author;
}
