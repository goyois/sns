package com.sns.member.dto;

import com.sns.member.domain.entity.Member;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class ResponseDto {
    @Getter @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private long memberId;
        private String email;
        private String password;
        private String name;
        private String phone;
        private String nickname;
        private Integer age;
        private String birthday;
        private String address;
        private String profileImage;
    }
}
