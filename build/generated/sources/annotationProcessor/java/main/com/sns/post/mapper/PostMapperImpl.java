package com.sns.post.mapper;

import com.sns.member.domain.entity.Member;
import com.sns.member.dto.ResponseDto.Response1;
import com.sns.member.dto.ResponseDto.Response1.Response1Builder;
import com.sns.post.dto.PostDto.Patch;
import com.sns.post.dto.PostDto.Response;
import com.sns.post.dto.PostDto.Response.ResponseBuilder;
import com.sns.post.entity.Post;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-21T01:10:13+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Override
    public Post postPostToPost(com.sns.post.dto.PostDto.Post requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Post post = new Post();

        post.setTitle( requestBody.getTitle() );
        post.setContent( requestBody.getContent() );

        return post;
    }

    @Override
    public Post postPatchToPost(Patch requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Post post = new Post();

        post.setTitle( requestBody.getTitle() );
        post.setContent( requestBody.getContent() );

        return post;
    }

    @Override
    public Response postToPostResponse(Post post) {
        if ( post == null ) {
            return null;
        }

        ResponseBuilder response = Response.builder();

        response.title( post.getTitle() );
        response.content( post.getContent() );
        response.member( memberToResponse1( post.getMember() ) );
        response.createdAt( post.getCreatedAt() );
        response.modifiedAt( post.getModifiedAt() );

        return response.build();
    }

    protected Response1 memberToResponse1(Member member) {
        if ( member == null ) {
            return null;
        }

        Response1Builder response1 = Response1.builder();

        response1.memberId( member.getMemberId() );
        response1.email( member.getEmail() );

        return response1.build();
    }
}
