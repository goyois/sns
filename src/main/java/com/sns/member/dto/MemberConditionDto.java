package com.sns.member.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.sns.member.domain.entity.Member;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//회원 검색조건 Q타입 dto
@Data
public class MemberConditionDto {
    private String email;
    private String name;
    private String phone;
    private String birthday;
    private String role;
    private Integer age;
    private Member.MemberStatus memberStatus;


    @QueryProjection
    public MemberConditionDto(String email, String name, String phone, String birthday, String role, Integer age, Member.MemberStatus memberStatus) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        this.role = role;
        this.age = age;
        this.memberStatus = memberStatus;
    }
}
