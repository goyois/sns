package com.sns.member.dto;

import lombok.Data;

//회원 검색조건
@Data
public class MemberConditionDto {
    private String email;
    private String name;
    private String nickname;
    private String phone;
}
