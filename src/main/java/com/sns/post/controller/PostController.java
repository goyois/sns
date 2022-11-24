package com.sns.post.controller;

import com.sns.common.dto.SingleResponseDto;
import com.sns.post.dto.PostDto;
import com.sns.post.entity.Post;
import com.sns.post.mapper.PostMapper;
import com.sns.post.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/posts") //로그인 시 아이디 넣기
public class PostController {

    private final PostService postService;

    private final PostMapper postMapper;

    public PostController(PostService postService, PostMapper postMapper){
        this.postService = postService;
        this.postMapper = postMapper;
    }

    @PostMapping
    public ResponseEntity postPost(@RequestBody PostDto.Post requestBody) {

        Post post = postMapper.postPostToPost(requestBody);
        Post createPost = postService.createPost(post);
        PostDto.Response response = postMapper.postToPostResponse(createPost);

        return new ResponseEntity<>(
                new SingleResponseDto<>(response),
                HttpStatus.CREATED);
    }

}
