package com.sns.member.dto;

import com.sns.member.domain.entity.Member;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

public class ResponseDto {
    @Getter
    @AllArgsConstructor
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
        private List<Member> members = new ArrayList<>();
        private Member.StatusRecode statusRecode;
    }


    //추가사항 - 전체 내용 필요없어서 게시물 등록할 때 메일하고 멤버 아이디만 보내는 거 추가

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response1 {

        private long memberId;
        private String email;
    }
}

