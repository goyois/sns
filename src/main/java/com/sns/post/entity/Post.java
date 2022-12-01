package com.sns.post.entity;

import com.sns.common.BaseEntity;

import com.sns.member.domain.entity.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
//            (nullable = false)
    private String title;

    @Column
//            (nullable = false)
    private String content;

    //멤버와 연관관계 매핑 필요 - member email 보이게 하기
    @ManyToOne
    @JoinColumn(name = "email")
    private Member member;


}
