package com.sns.member.dto;

import com.sns.member.domain.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ResponseDto {
    @Getter @Setter
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
        private Integer age;
        private String role;
        private List<Member> members = new ArrayList<>();
        private Member.MemberStatus memberStatus;

    }
}
