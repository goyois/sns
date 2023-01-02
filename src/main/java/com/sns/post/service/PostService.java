package com.sns.post.service;

import com.sns.common.exception.BusinessLogicException;
import com.sns.common.exception.ExceptionCode;
import com.sns.member.domain.entity.Member;
import com.sns.member.domain.repository.MemberRepository;
import com.sns.post.entity.Post;
import com.sns.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    public PostService(PostRepository postRepository, MemberRepository memberRepository) {
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
    }

    public Post createPost(String email, Post post) {
        Member member = memberRepository.findByEmail(email).orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        post.setMember(member);
        post.setCreatedAt(LocalDateTime.now());
        return postRepository.save(post);
    }

    public Post updatePost(String email, Post post) {

        Optional.ofNullable(post.getTitle()).ifPresent(title -> post.setTitle(title));
        Optional.ofNullable(post.getContent()).ifPresent(content -> post.setContent(content));

        memberRepository.findByEmail(email).orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        return postRepository.save(post);

    }

    public void deletePost(Long postId) {
        Post findPost = findVerifiedPost(postId);
        postRepository.delete(findPost);
    }

    public Post findVerifiedPost(Long postId) {
        Optional<Post> optionalPost =
                postRepository.findById(postId);
        Post findPost = optionalPost.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.POST_NOT_FOUND));

        return findPost;
    }

    public Post findPost(Long postId) {
        return findVerifiedPost(postId);
    }


    public Post getPost(Long postId) {

        Post post = findVerifiedPost(postId);
        postRepository.save(post);

        return postRepository.findByPostId(postId);
    }


  }
