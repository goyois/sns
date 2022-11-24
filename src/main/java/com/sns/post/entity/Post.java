package com.sns.post.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
//            (nullable = false)
    private String title;

    @Column
//            (nullable = false)
    private String content;

    //멤버와 연관관계 매핑 필요
}
