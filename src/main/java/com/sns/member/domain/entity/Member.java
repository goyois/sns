package com.sns.member.domain.entity;

import com.sns.common.BaseEntity;
import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;
    @Column(nullable = false, updatable = false, unique = true)
    private String email;
    private String password;
    private String name;
    private Integer age;
    private String nickname;
    private String phone;
    private String address;
    private String birthday;
    private String role;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 20, nullable = false)
    private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVE;



    public enum MemberStatus {
        MEMBER_ACTIVE("활동중"),
        MEMBER_SLEEP("휴면 상태"),
        MEMBER_QUIT("탈퇴 상태");

        @Getter
        private String memberStatus;

        MemberStatus(String memberStatus) {
            this.memberStatus = memberStatus;
        }
    }

    public Member(String nickname, Integer age, String role) {
        this.nickname = nickname;
        this.age = age;
        this.role = role;
    }
}

