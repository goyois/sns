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
}