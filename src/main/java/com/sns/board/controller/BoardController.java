package com.sns.board.controller;

import com.sns.board.dto.BoardDto;
import com.sns.board.entity.Board;
import com.sns.board.mapper.BoardMapper;
import com.sns.comment.mapper.CommentMapper;
import com.sns.comment.service.CommentService;
import com.sns.common.dto.MultiResponseDto;
import com.sns.common.dto.PageInfo;
import com.sns.common.dto.SingleResponseDto;
import com.sns.board.dto.BoardListDto;
import com.sns.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.security.Principal;
import java.util.List;


@RequestMapping("/v1/boards") //로그인 시 아이디 넣기
@RestController
@Validated
@Slf4j
public class BoardController {


    private final BoardService boardService;
    private final BoardMapper boardMapper;
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    //Todo member 받아오기 - 게시글은 로그인 시에만 작성가능

    public BoardController(BoardService boardService, BoardMapper boardMapper, CommentService commentService, CommentMapper commentMapper) {
        this.boardService = boardService;
        this.boardMapper = boardMapper;
        this.commentService = commentService;
        this.commentMapper = commentMapper;

    }

    /**
     * 게시물 등록
     */

    //Todo 인증 토큰받은 email 확인 추가하기 -member에 추가함
    @PostMapping("")
    public ResponseEntity boardPost(@RequestBody BoardDto.Post requestBody, Principal principal) {

        Board board = boardMapper.boardPostToPost(requestBody);
        Board createBoard = boardService.createPost(board, principal);
        BoardDto.Response response = boardMapper.boardToPostResponse(createBoard);

        return new ResponseEntity<>(
                new SingleResponseDto<>(response),
                HttpStatus.CREATED);
    }

    /**
     * 게시물 수정
     */

    @PatchMapping("/{board-id}")
    public ResponseEntity boardPatch(
            @PathVariable("board-id") @Positive Long boardId,
            @RequestBody BoardDto.Patch requestBody, Principal principal) {

        requestBody.setBoardId(boardId);

        Board board = boardMapper.boardPatchToPost(requestBody);
        Board updateBoard = boardService.updatePost(board, principal);
        BoardDto.Response response = boardMapper.boardToPostResponse(updateBoard);

        return new ResponseEntity<>(
                new SingleResponseDto<>(response),
                HttpStatus.OK);
    }

    /**
     * 전체 게시물 조회
     */

    //Todo 전체 게시물 조회 추가하기
    @GetMapping("/list")
    public ResponseEntity getBoardList(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                          @RequestParam(name = "size", required = false, defaultValue = "15") int size) {

        Page<Board> boardPage = boardService.getBoardList(page, size);
        PageInfo pageInfo = PageInfo.of(boardPage);

        List<BoardListDto> list =
                boardMapper.boardsToPostResponseDto(boardPage.getContent());

        return new ResponseEntity<>(new MultiResponseDto<>(list, pageInfo), HttpStatus.OK);
    }


    /**
     * 게시물 조회
     */

    @GetMapping("/{board-id}")
    public ResponseEntity getBoard(@PathVariable("board-id") @Positive Long boardId) {

        Board board = boardService.findBoard(boardId);

        return new ResponseEntity<>(
                new SingleResponseDto<>(boardMapper.boardToPostResponse(board)),
                HttpStatus.OK);
    }


    /**
     * 게시물 삭제
     */

    @DeleteMapping("/{board-id}")
    public ResponseEntity deleteBoard(@PathVariable("board-id") @Positive Long boardId) {

        boardService.deletePost(boardId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}