package com.sns.comment.mapper;

import com.sns.comment.dto.CommentDto;
import com.sns.comment.entity.Comment;
import com.sns.post.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper {

    default Comment commentPostToPost(CommentDto.Post requestBody, Post post) {

        Comment comment = new Comment();
        comment.setComment(requestBody.getComment());
        comment.setPost(post);

        return comment;
    }

//    Comment commentPostToPost(CommentDto.Post requestBody);
    Comment commentPatchToPost(CommentDto.Patch requestBody);
    CommentDto.Response commentToPostResponse(Comment comment);

    List<CommentDto.Response> commentToResponse(List<Comment> comment);

}
