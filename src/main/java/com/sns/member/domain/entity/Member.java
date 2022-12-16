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
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String phone;
    private String address;
    private String birthday;
    private String profileImage;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 20, nullable = false)
    private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVE;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    public Member(String name, String email, String password, String nickname, String phone, String address, String birthday, String profileImage) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.profileImage = profileImage;
    }

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
}