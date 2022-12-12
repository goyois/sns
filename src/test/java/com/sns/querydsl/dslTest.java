package com.sns.querydsl;

import com.sns.member.domain.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@SpringBootTest
@Transactional
public class dslTest {

    @Autowired
    EntityManager em;

    @Test
    public void testEntity() {
        MemberHistory h1 = new MemberHistory("h1");
        MemberHistory h2 = new MemberHistory("h2");
        em.persist(h1);
        em.persist(h2);

        Member member1 = new Member("member1",10,"mem");
        Member member2 = new Member("member2",20,"mem");

        Member member3 = new Member("member3",30,"meb");
        Member member4 = new Member("member4",40,"meb");
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        em.flush();
        em.clear();

        List<Member> members = em.createQuery("select m from Member m", Member.class)
                .getResultList();

        for (Member member : members) {
            System.out.println("member = " + member);
            System.out.println("-> member.memberHistory" + member.getMemberHistory());
        }
    }
}
