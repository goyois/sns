package com.sns.member;

import com.sns.member.domain.entity.Member;
import com.sns.member.domain.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class MemberRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void saveMemberTest() {
        //given
        Member member = new Member();
        member.setName("김주원");
        member.setPassword("1234");
        member.setEmail("komi3391@gmail.com");
        member.setPhone("010-9197-3400");
        member.setNickname("kim");
        member.setAddress("의정부시");
        member.setBirthday("12월 8일");
        member.setProfileImage("프사");

        //when
        Member savedMember = memberRepository.save(member);

        //then
        assertNotNull(savedMember);
        assertTrue(member.getName().equals(savedMember.getName()));
        assertTrue(member.getPassword().equals(savedMember.getPassword()));
        assertTrue(member.getEmail().equals(savedMember.getEmail()));
        assertTrue(member.getPhone().equals(savedMember.getPhone()));
        assertTrue(member.getNickname().equals(savedMember.getNickname()));
        assertTrue(member.getAddress().equals(savedMember.getAddress()));
        assertTrue(member.getBirthday().equals(savedMember.getBirthday()));
        assertTrue(member.getProfileImage().equals(savedMember.getProfileImage()));
    }
}
