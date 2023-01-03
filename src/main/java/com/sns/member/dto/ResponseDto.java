package com.sns.member.dto;

import com.sns.member.enums.MemberStatus;
import lombok.*;


public class ResponseDto {
    @Getter @Setter
    @AllArgsConstructor
    public static class Response {
        private Long memberId;
        private String email;
        private String password;
        private String name;
        private String phone;
        private String nickname;
        private String birthday;
        private String address;
        private String profileImage;
        private MemberStatus memberStatus;
    }
}