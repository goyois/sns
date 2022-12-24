package com.sns.member.dto;

import com.sns.member.domain.entity.Member;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class ResponseDto {
    @Getter
    @AllArgsConstructor
    public static class Response {
        private String email;
        private String name;
        private String phone;
        private String nickname;
        private Integer age;
        private String birthday;
        private String address;
        private String profileImage;
        private Member.MemberStatus memberStatus;

        public Member.MemberStatus getMemberStatus() {
            return memberStatus;
        }
    }
}