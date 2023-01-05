package snsower.sns.member.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import snsower.sns.member.domain.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}
