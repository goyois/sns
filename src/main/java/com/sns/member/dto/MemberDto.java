package com.sns.member.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberDto {
    private Long memberId;
    private Long postId;
    private Long commentId;
    private String email;
    private String nickname;
    private String name;
    private String phone;
    private String address;
    private String birthday;


    @QueryProjection
    public MemberDto(Long memberId, Long postId, Long commentId, String email, String nickname, String name, String phone, String address, String birthday) {
        this.memberId = memberId;
        this.postId = postId;
        this.commentId = commentId;
        this.email = email;
        this.nickname = nickname;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
    }

    @QueryProjection
    public MemberDto(Long memberId, Long postId, String nickname) {
        this.memberId = memberId;
        this.postId = postId;
        this.nickname = nickname;
    }
}


