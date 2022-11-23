package com.sns.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ResponseDto {
    @Getter
    @AllArgsConstructor
    public static class Response {
        private long memberId;
        private String name;
        private String password;
        private String email;
        private String phone;
        private String address;
        private String profileImage;
        private String role;
    }
}
