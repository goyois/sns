package com.sns.board.mapper;


import com.sns.board.dto.BoardDto;
import com.sns.board.dto.BoardListDto;
import com.sns.board.entity.Board;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BoardMapper {
        Board boardPostToPost(BoardDto.Post requestBody);
        Board boardPatchToPost(BoardDto.Patch requestBody);
        BoardDto.Response boardToPostResponse(Board board);

        default List<BoardListDto> boardsToPostResponseDto(List<Board> boardList) {
                return boardList.stream()
                        .map(board -> BoardListDto
                        .builder()
                                .boardId(board.getBoardId()).
                                title(board.getTitle())
                                .content(board.getContent())
                                .createdAt(board.getCreatedAt())
                                .modifiedAt(board.getModifiedAt())
                                .email(board.getMember().getEmail())
                                .build())
                                .collect(Collectors.toList());

        };


}
