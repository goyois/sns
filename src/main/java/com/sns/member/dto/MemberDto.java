package com.sns.member.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class MemberDto {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String birthday;

    @QueryProjection
    public MemberDto(String name, String email, String phone, String address, String birthday) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
    }
}
