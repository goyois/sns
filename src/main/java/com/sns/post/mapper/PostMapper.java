package com.sns.post.mapper;


import com.sns.post.dto.PostDto;
import com.sns.post.dto.PostListDto;
import com.sns.post.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
        Post postPostToPost(PostDto.Post requestBody);
        Post postPatchToPost(PostDto.Patch requestBody);
        PostDto.Response postToPostResponse(Post post);

        default List<PostListDto> postsToPostResponseDto(List<Post> postList) {
                return postList.stream()
                        .map(post -> PostListDto
                        .builder()
                                .postId(post.getPostId()).
                                title(post.getTitle())
                                .content(post.getContent())
                                .createdAt(post.getCreatedAt())
                                .modifiedAt(post.getModifiedAt())
                                .email(post.getMember().getEmail())
                                .build())
                                .collect(Collectors.toList());

        };


}
