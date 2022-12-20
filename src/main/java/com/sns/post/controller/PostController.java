package com.sns.post.controller;

import com.sns.comment.dto.CommentDto;
import com.sns.comment.entity.Comment;
import com.sns.comment.mapper.CommentMapper;
import com.sns.comment.service.CommentService;
import com.sns.common.dto.MultiResponseDto;
import com.sns.common.dto.PageInfo;
import com.sns.common.dto.SingleResponseDto;
import com.sns.post.dto.PostDto;
import com.sns.post.dto.PostListDto;
import com.sns.post.entity.Post;
import com.sns.post.mapper.PostMapper;
import com.sns.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;


@RequestMapping("/v1/posts/{email}") //로그인 시 아이디 넣기
@RestController
@Validated
@Slf4j
public class PostController {


    private final PostService postService;
    private final PostMapper postMapper;
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    //Todo member 받아오기 - 게시글은 로그인 시에만 작성가능

    public PostController(PostService postService, PostMapper postMapper, CommentService commentService, CommentMapper commentMapper) {
        this.postService = postService;
        this.postMapper = postMapper;
        this.commentService = commentService;
        this.commentMapper = commentMapper;

    }

    /**
     * 게시물 등록
     */

    //Todo 인증 토큰받은 email 확인 추가하기
    @PostMapping("")
    public ResponseEntity postPost(@PathVariable String email, @RequestBody PostDto.Post requestBody) {

        Post post = postMapper.postPostToPost(requestBody);
        Post createPost = postService.createPost(email, post);
        PostDto.Response response = postMapper.postToPostResponse(createPost);

        return new ResponseEntity<>(
                new SingleResponseDto<>(response),
                HttpStatus.CREATED);
    }

    /**
     * 게시물 수정
     */

    @PatchMapping("/{post-id}")
    public ResponseEntity patchPost(@PathVariable("email") String email,
                                    @PathVariable("post-id") @Positive Long postId,
                                    @RequestBody PostDto.Patch requestBody) {

        Post post = postMapper.postPatchToPost(requestBody);
        Post updatePost = postService.updatePost(email, post);
        PostDto.Response response = postMapper.postToPostResponse(updatePost);

        return new ResponseEntity<>(
                new SingleResponseDto<>(response),
                HttpStatus.OK);
    }

    /**
     * 게시물 조회
     */

    //Todo 전체 게시물 조회 추가하기
    @GetMapping("/list")
    public ResponseEntity getPostList(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                          @RequestParam(name = "size", required = false, defaultValue = "15") int size) {

        Page<Post> postPage = postService.getPostList(page, size);
        PageInfo pageInfo = PageInfo.of(postPage);

        List<PostListDto> list =
                postMapper.postsToPostResponseDto(postPage.getContent());

        return new ResponseEntity<>(new MultiResponseDto<>(list, pageInfo), HttpStatus.OK);
    }




    @GetMapping("/{post-id}")
    public ResponseEntity getPost(@PathVariable("post-id") @Positive Long postId) {

        Post post = postService.findPost(postId);

        return new ResponseEntity<>(
                new SingleResponseDto<>(postMapper.postToPostResponse(post)),
                HttpStatus.OK);
    }


    /**
     * 게시물 삭제
     */

    @DeleteMapping("/{post-id}")
    public ResponseEntity deletePost(@PathVariable("post-id") @Positive Long postId) {

        postService.deletePost(postId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
