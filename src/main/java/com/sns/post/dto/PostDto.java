package com.sns.post.dto;

import com.sns.member.dto.ResponseDto;
import lombok.*;

import java.time.LocalDateTime;

//@Data 검색해보기
public class PostDto {

    @Getter
    @AllArgsConstructor
    public static class Post {

        private String title;
        private String content;


    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Patch {

        private String title;
        private String content;


    }
    @Getter
    @Builder
    @AllArgsConstructor
    public static class Response {

        private String title;
        private String content;


        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;


    }


}
