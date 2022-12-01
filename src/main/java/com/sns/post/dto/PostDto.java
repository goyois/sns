package com.sns.post.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

//@Data 검색해보기
public class PostDto {

    @Getter
    @AllArgsConstructor
    public static class Post {

        private String title;
        private String content;


    }

    @Getter
    @AllArgsConstructor
    public static class Patch {

        private String title;
        private String content;


    }
    @Getter
    @AllArgsConstructor
    public static class Response {

        private String title;
        private String content;
//        private String email;


    }


}
