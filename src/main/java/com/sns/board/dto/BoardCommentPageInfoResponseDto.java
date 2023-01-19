package com.sns.board.dto;

import com.sns.comment.dto.CommentDto;
import com.sns.common.dto.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class BoardCommentPageInfoResponseDto<T> {

    private T data;

    private List<CommentDto.Response> comments;

    private PageInfo pageInfo;

//    public BoardCommentPageInfoResponseDto(T data, Page page, List<CommentDto.Response> comments)
//        this.data = data;
}
