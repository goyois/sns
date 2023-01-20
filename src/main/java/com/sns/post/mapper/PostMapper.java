package com.sns.post.mapper;


import com.sns.post.dto.PostDto;
import com.sns.post.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
        Post postPostToPost(PostDto.Post requestBody);
        Post postPatchToPost(PostDto.Patch requestBody);
        PostDto.Response postToPostResponse(Post post);

//        List<PostDto> postsToPostResponseDto(List<Post> posts);


}