package com.sns.comment.controller;

import com.sns.comment.dto.CommentDto;
import com.sns.comment.entity.Comment;
import com.sns.comment.mapper.CommentMapper;
import com.sns.comment.service.CommentService;
import com.sns.common.dto.SingleResponseDto;
import com.sns.post.dto.PostDto;
import com.sns.post.entity.Post;
import com.sns.post.mapper.PostMapper;
import com.sns.post.repository.PostRepository;
import com.sns.post.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.security.Principal;

@RestController
@RequestMapping("/v1/posts/{email}") //로그인 시 아이디 넣기
@Validated
@Slf4j
public class CommentController {

    private final PostRepository postRepository;
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    //Todo member 받아오기 - 게시글은 로그인 시에만 작성가능

    public CommentController(CommentService commentService, CommentMapper commentMapper, PostRepository postRepository ) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
        this.postRepository = postRepository;
    }


        @PostMapping("{post-id}/comments")
        public ResponseEntity commentPost(@PathVariable("email") String email, @PathVariable("post-id") Long postId, @RequestBody CommentDto.Post requestBody) {

            Post post = postRepository.findByPostId(postId);

            Comment comment = commentService.createComment(email,postId, commentMapper.commentPostToPost(requestBody, post));

//            Comment comment = commentMapper.commentPostToPost(requestBody, post);
//            Comment createPost = commentService.createComment(email, postId, comment);
            CommentDto.Response response = commentMapper.commentToPostResponse(comment);

            return new ResponseEntity<>(
                    new SingleResponseDto<>(response),
                    HttpStatus.CREATED);

        }
//            @PatchMapping("{post-id}/comments/update")
//        public ResponseEntity commentPatch(@PathVariable("post-id") Long postId, @RequestBody CommentDto.Patch requestBody, Principal principal) {
//
//
//            Comment comment = commentService.updateComment(commentMapper.commentPatchToPost(requestBody), postId, principal);
//
//            CommentDto.Response response = commentMapper.commentToPostResponse(comment);
//
//            return new ResponseEntity<>(
//                    new SingleResponseDto<>(response),
//                    HttpStatus.OK);
//        }



        @DeleteMapping("{post-id}/comments/{comment-id}")
        public ResponseEntity deleteComment(@PathVariable("post-id") Long postId, @PathVariable("comment-id") Long commentId, Principal principal)
        {
            commentService.deleteComment(commentId, postId, principal);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT); //204
        }

}
