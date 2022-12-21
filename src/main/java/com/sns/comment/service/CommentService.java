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

import java.security.Principal;
import java.util.Objects;
import java.util.Optional;

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


    public Comment updateComment(Comment comment, Long postId, Principal principal) {

        Post post = postService.getPost(postId);
        Comment findComment = commentRepository.findById(comment.getCommentId()).get();

        verifyUserConfirm(findComment, principal);

        findComment.setComment(comment.getComment());

        Comment saved = commentRepository.save(findComment);
        post.setModifiedAt(saved.getPost().getModifiedAt());
        return saved;
    }



    public void deleteComment(Long commentId, Long postId, Principal principal){

        Post post = postService.getPost(postId);
        Comment findComment = commentRepository.findById(commentId).get();

        verifyUserConfirm(findComment, principal);


       commentRepository.delete(findComment);


    }
    public Comment getComment(Long commentId) {

        Comment comment = findVerifiedComment(commentId);
        return comment;
    }


    public Comment findVerifiedComment(long commentId) {
        Optional<Comment> optionalQuestion = commentRepository.findById(commentId);
        return optionalQuestion.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
    }

    public void verifyUserConfirm(Comment comment, Principal principal) {

        if (!Objects.equals(principal.getName(), comment.getMember().getEmail())) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
        }
    }

}
