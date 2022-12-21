package com.sns.comment.dto;

import com.sns.member.dto.ResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

public class CommentDto {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Post {

        private Long postId;
        private String comment;

    }

    @Getter
    @Setter
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
        private ResponseDto.Response1 member;

        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;

    }
}
