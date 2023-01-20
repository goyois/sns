package com.sns.member.dto;


import com.sns.member.domain.entity.Member;
import lombok.*;


public class ResponseDto {
    @Getter
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
        private Member.StatusRecode statusRecode;

        public Member.StatusRecode getStatusRecode() {
            return statusRecode;
        }
    }
}

