package com.sns.member.domain.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sns.member.dto.MemberConditionDto;
import com.sns.member.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom{

    private final JPAQueryFactory queryFactory;




    @Override
    public List<MemberDto> searchMember(MemberConditionDto conditionDto) {
        return null;
    }

    @Override
    public Page<MemberDto> searchPageSimple(MemberConditionDto condition, Pageable pageable) {
        return null;
    }
}
