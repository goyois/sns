package com.sns.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class RequestDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        @NotBlank(message = "공백은 포함될 수 없습니다.")
        private String name;
        @NotBlank(message = "비밀번호를 입력해주세요.")
        private String password;
        @NotBlank
        @Email
        private String email;
        @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
                message = "휴대폰번호는 형식에 맞추어 11자리와 -를 포함시켜야합니다.")
        private String phone;
        private String address;
    }

    @Getter @Setter
    @AllArgsConstructor
    public static class Patch {
        private long memberId;
        private String name;
        private String password;
        private String email;
        private String nickname;
        private String birthday;
        private String address;
        private String profileImage;
    }
}