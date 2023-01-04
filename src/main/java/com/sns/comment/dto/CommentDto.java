package com.sns.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CommentDto {

    @Getter
    @AllArgsConstructor
    public static class Post {

        private Long questionId;
        private Long boardId;
        private String comment;

    }

    @Getter
    @AllArgsConstructor
    public static class Patch {

        private Long commentId;
        private String comment;


    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {

        private Long commentId;
        private String comment;
        //private ResponseDto.Response1 member;



    }
}
