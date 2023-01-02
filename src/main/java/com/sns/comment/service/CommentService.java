package com.sns.comment.service;

import com.sns.comment.entity.Comment;
import com.sns.comment.repository.CommentRepository;
import com.sns.common.exception.BusinessLogicException;
import com.sns.common.exception.ExceptionCode;
import com.sns.member.domain.entity.Member;
import com.sns.member.domain.repository.MemberRepository;
import com.sns.post.entity.Post;
import com.sns.post.repository.PostRepository;
import com.sns.post.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    private final PostService postService;


    public CommentService(CommentRepository commentRepository, MemberRepository memberRepository, PostRepository postRepository, PostService postService) {
        this.commentRepository = commentRepository;
        this.memberRepository = memberRepository;
        this.postRepository = postRepository;
        this.postService = postService;
    }

    public Comment createComment(String email, Long postId, Comment comment) {

        Member member = memberRepository.findByEmail(email).orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        Post post = postService.getPost(postId);

        comment.setMember(member);
        comment.setPost(post);


        return commentRepository.save(comment);

    }
}

//    public void deleteComment()
//
// }
