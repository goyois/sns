package com.sns.member.domain.repository;

import com.sns.member.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//MemberRepositoryCustom
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional <Member> findByEmail(String email);
}