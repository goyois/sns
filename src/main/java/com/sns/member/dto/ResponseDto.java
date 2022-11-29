package com.sns.member.dto;

import com.sns.member.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class ResponseDto {
    @Builder
    @Getter
    @AllArgsConstructor
    public static class Response {
        private long memberId;
        private String name;
        private String password;
        private String email;
        private String phone;
        private String address;
        private String nickname;
        private String birthday;
        private String profileImage;
        private String role;
        private Member.MemberStatus memberStatus;

    }
}
