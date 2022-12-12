package com.sns.member.domain.repository;

import com.sns.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
//MemberRepositoryCustom
public interface MemberRepository extends JpaRepository<Member, Long>  {
    Optional <Member> findByEmail(String email);
}
