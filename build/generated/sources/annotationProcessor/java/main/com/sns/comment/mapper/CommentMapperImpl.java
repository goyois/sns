package com.sns.comment.mapper;

import com.sns.comment.dto.CommentDto.Patch;
import com.sns.comment.dto.CommentDto.Response;
import com.sns.comment.entity.Comment;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-21T01:10:13+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 11.0.16.1 (Amazon.com Inc.)"
)
@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public Comment commentPatchToPost(Patch requestBody) {
        if ( requestBody == null ) {
            return null;
        }

        Comment comment = new Comment();

        comment.setCommentId( requestBody.getCommentId() );
        comment.setComment( requestBody.getComment() );

        return comment;
    }

    @Override
    public Response commentToPostResponse(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        Response response = new Response();

        response.setCommentId( comment.getCommentId() );
        response.setComment( comment.getComment() );

        return response;
    }
}
