package com.sns.comment.entity;

import com.sns.member.domain.entity.Member;
import com.sns.post.entity.Post;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long commentId;

        @Column
//                (nullable = false)
        private String comment;


        //멤버와 연관관계 매핑 필요 - member email 보이게 하기
        @ManyToOne
        @JoinColumn(name = "member_id")
        private Member member;

        @ManyToOne
        @JoinColumn(name = "post_id")
        private Post post;

//        public void setPost(Post post) {
//                this.post = post;
//        }



}
