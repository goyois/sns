package com.sns.post.service;

import com.sns.common.exception.BusinessLogicException;
import com.sns.common.exception.ExceptionCode;
import com.sns.member.domain.entity.Member;
import com.sns.member.domain.repository.MemberRepository;
import com.sns.member.domain.service.MemberService;
import com.sns.post.entity.Post;
import com.sns.post.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class   PostService {

    private final PostRepository postRepository;

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public PostService(PostRepository postRepository, MemberRepository memberRepository, MemberService memberService) {
        this.postRepository = postRepository;
        this.memberRepository = memberRepository;
        this.memberService = memberService;
    }

    public Post createPost(Post post, Principal principal) {

        Member member = memberService.findVerifiedMemberByEmail(principal.getName());


        post.setMember(member);
        post.setCreatedAt(LocalDateTime.now());

        return postRepository.save(post);
    }

    public Post updatePost(Post post, Principal principal) {

        Optional.ofNullable(post.getTitle()).ifPresent(title -> post.setTitle(title));
        Optional.ofNullable(post.getContent()).ifPresent(content -> post.setContent(content));

        Member member = memberService.findVerifiedMemberByEmail(principal.getName());

        post.setMember(member);
        post.setCreatedAt(LocalDateTime.now());

//        memberRepository.findByEmail(email).orElseThrow(() ->
//                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

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

    public void verifyUserConfirm(Post post, Principal principal) {

        if (!Objects.equals(principal.getName(), post.getMember().getEmail())) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
        }
    }


    public Post getPost(Long postId) {

        Post post = findVerifiedPost(postId);
        postRepository.save(post);

        return postRepository.findByPostId(postId);
    }

    public Page<Post> getPostList(int page, int size) {

        Pageable pageable = PageRequest.of(page - 1, size,
                Sort.by("postId").descending());
        return postRepository.findAll(pageable);
    }

  }
