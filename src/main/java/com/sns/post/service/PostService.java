package com.sns.post.service;

import com.sns.common.exception.BusinessLogicException;
import com.sns.common.exception.ExceptionCode;
import com.sns.member.domain.repository.MemberRepository;
import com.sns.post.entity.Post;
import com.sns.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

        memberRepository.findByEmail(email).orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        return postRepository.save(post);
    }

    public Post updatePost(String email, Post post) {

        Optional.ofNullable(post.getTitle()).ifPresent(title -> post.setTitle(title));
        Optional.ofNullable(post.getContent()).ifPresent(content -> post.setContent(content));

        memberRepository.findByEmail(email).orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        return postRepository.save(post);

    }

    public void deletePost(Long id) {
        Post findPost = findVerifiedPost(id);
        postRepository.delete(findPost);
    }

    public Post findVerifiedPost(Long id) {
        Optional<Post> optionalPost =
                postRepository.findById(id);
        Post findPost = optionalPost.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.POST_NOT_FOUND));

        return findPost;
    }

    public Post findPost(Long id) {
        return findVerifiedPost(id);
    }

  }
