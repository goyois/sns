package com.sns.member.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sns.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory queryFactory;


    @Override
    public List<MemberDto> getMemberByBoardId(Long boardId) {
        return null;
    }

    @Override
    public List<MemberDto> getMemberByCommentId(Long CommentId) {
        return null;
    }
}
