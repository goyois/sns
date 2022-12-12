package com.sns.member.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

//  Q타입 dto
@Data
public class MemberDto {
    private long memberId;
    private String email;
    private String password;
    private String name;
    private Integer age;
    private String nickname;
    private String phone;
    private String address;
    private String birthday;
    private String role;



    @QueryProjection
    public MemberDto(long memberId, String email, String password, String name, Integer age, String nickname, String phone, String address, String birthday, String role) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.nickname = nickname;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.role = role;

    }
}
