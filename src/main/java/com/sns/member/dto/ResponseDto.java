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


    //추가사항 - 전체 내용 필요없어서 게시물 등록할 때 메일하고 멤버 아이디만 보내는 거 추가

    @Builder
    @Getter
    @AllArgsConstructor
    public static class Response1 {

        private long memberId;
        private String email;
    }
}
