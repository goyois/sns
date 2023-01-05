package snsower.sns.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

