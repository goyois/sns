package com.sns.member.domain.entity;

import com.sns.common.BaseEntity;
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
    private String nickname;
    private String phone;
    private String address;
    private String birthday;
    private String profileImage;
    @Enumerated(value = EnumType.STRING)
    @Column(length = 20, nullable = false)
    private StatusRecode statusRecode;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();


    public enum StatusRecode {
        SUCCESS("정상적으로 회원가입되었습니다."),
        UPDATE("입력정보가 수정되었습니다."),
        DELETE("더 이상 회원이 아닙니다.");

        @Getter
        private String memberStatus;

        StatusRecode(String memberStatus) {
            this.memberStatus = memberStatus;
        }
    }
}