//package com.sns.member.domain.repository;
//
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import com.sns.member.domain.entity.QMember;
//import com.sns.member.dto.MemberConditionDto;
//import com.sns.member.dto.MemberDto;
//import com.sns.member.dto.QMemberDto;
//import lombok.RequiredArgsConstructor;
//import org.hibernate.annotations.common.reflection.XMember;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//import static com.sns.member.domain.entity.QMember.member;
//
//@RequiredArgsConstructor
//public class MemberRepositoryCustomImpl implements MemberRepositoryCustom{
//
//    private final JPAQueryFactory queryFactory;
//
//
//
//    @Override
//    public List<MemberDto> searchMember(MemberConditionDto conditionDto) {
//        return queryFactory
//                .select(new QMemberDto())
//                .from(member)
//                .where()
//
//    }
//
//    @Override
//    public Page<MemberDto> searchPageSimple(MemberConditionDto condition, Pageable pageable) {
//        return null;
//    }
//}
