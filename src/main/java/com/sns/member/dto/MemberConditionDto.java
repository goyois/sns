package com.sns.member.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.sns.member.domain.entity.Member;
import lombok.Data;

//회원 검색조건 Q타입 dto
@Data
public class MemberConditionDto {
    private String email;
    private String name;
    private String phone;
    private String birthday;
    private Integer age;
    private Member.StatusRecode statusRecode;


    @QueryProjection
    public MemberConditionDto(String email, String name, String phone, String birthday, Integer age) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        this.age = age;
    }
}
