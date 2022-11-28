package com.sns.post.controller;

import com.sns.common.dto.SingleResponseDto;
import com.sns.post.dto.PostDto;
import com.sns.post.entity.Post;
import com.sns.post.mapper.PostMapper;
import com.sns.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/posts") //로그인 시 아이디 넣기
@Validated
@Slf4j
public class PostController {

    private final PostService postService;
    private final PostMapper postMapper;

    //Todo member 받아오기 - 게시글은 로그인 시에만 작성가능

    public PostController(PostService postService, PostMapper postMapper){
        this.postService = postService;
        this.postMapper = postMapper;
    }

    //Todo 인증 토큰받은 email 확인 추가하기
    @PostMapping
    public ResponseEntity postPost(@RequestBody PostDto.Post requestBody) {

        Post post = postMapper.postPostToPost(requestBody);
        Post createPost = postService.createPost(post);
        PostDto.Response response = postMapper.postToPostResponse(createPost);

        return new ResponseEntity<>(
                new SingleResponseDto<>(response),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getPost(@PathVariable("id") @Positive Long id) {

        Post post = postService.findPost(id);

        return new ResponseEntity<>(
                new SingleResponseDto<>(postMapper.postToPostResponse(post)),
                HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable("id") @Positive Long id) {

        postService.deletePost(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
