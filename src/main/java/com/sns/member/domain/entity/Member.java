package com.sns.member.domain.entity;

import com.sns.common.BaseEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity {
    private long memberId;
    private String name;
    private String email;
    private String password;
    private String nickname;
    private String phone;
    private String address;
    private String birthday;
    private String profileImage;
    private String role;


    @Builder
    public Member(String name, String email, String password, String nickname, String phone, String address, String birthday, String profileImage, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.profileImage = profileImage;
        this.role = role;
    }
}
