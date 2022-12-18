package com.sns.member.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.*;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

//  Q타입 dto

@Data
public class MemberHistoryDto {
    private Long memberHistoryId;
    private Long postId;
    private Long commentId;
    private String nickname;
    private String content;




    @QueryProjection
    public MemberHistoryDto(Long memberHistoryId, Long postId, Long commentId, String nickname, String content) {
        this.memberHistoryId = memberHistoryId;
        this.postId = postId;
        this.commentId = commentId;
        this.nickname = nickname;
        this.content = content;

    }
}
