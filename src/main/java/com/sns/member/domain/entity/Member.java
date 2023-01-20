package com.sns.member.domain.entity;

import com.sns.comment.entity.Comment;
import com.sns.common.BaseEntity;
import com.sns.post.entity.Post;
import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "members")
@Getter @Setter
@NoArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Enumerated(value = EnumType.STRING)
    private StatusRecode statusRecode = StatusRecode.SUCCESS;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();


    @Builder
    public Member(long memberId, String email, String password, String name, String phone, String nickname, Integer age, String birthday, String address, String profileImage, StatusRecode statusRecode, List<String> roles) {
        this.memberId = memberId;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.nickname = nickname;
        this.age = age;
        this.birthday = birthday;
        this.address = address;
        this.profileImage = profileImage;
        this.statusRecode = statusRecode;
        this.roles = roles;
    }

    public enum StatusRecode {
        SUCCESS("정상적으로 회원가입되었습니다."),
        UPDATE("입력정보가 수정되었습니다."),
        DELETE("더 이상 회원이 아닙니다.");

        @Getter
        private String status;

        StatusRecode(String status) {
            this.status = status;
        }
    }
}