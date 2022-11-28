package com.sns.post.service;

import com.sns.common.exception.BusinessLogicException;
import com.sns.common.exception.ExceptionCode;
import com.sns.post.entity.Post;
import com.sns.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(Post post) {

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
