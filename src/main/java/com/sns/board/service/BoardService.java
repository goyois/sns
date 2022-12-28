package com.sns.board.service;

import com.sns.board.entity.Board;
import com.sns.common.exception.BusinessLogicException;
import com.sns.common.exception.ExceptionCode;
import com.sns.member.domain.entity.Member;
import com.sns.member.domain.repository.MemberRepository;
import com.sns.member.domain.service.MemberService;
import com.sns.board.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public BoardService(BoardRepository boardRepository, MemberRepository memberRepository, MemberService memberService) {
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
        this.memberService = memberService;
    }

    public Board createPost(Board board, Principal principal) {

        Member member = memberService.findVerifiedMemberByEmail(principal.getName());


        board.setMember(member);
        board.setCreatedAt(LocalDateTime.now());

        return boardRepository.save(board);
    }

    public Board updatePost(Board board, Principal principal) {

        Optional.ofNullable(board.getTitle()).ifPresent(title -> board.setTitle(title));
        Optional.ofNullable(board.getContent()).ifPresent(content -> board.setContent(content));

        Member member = memberService.findVerifiedMemberByEmail(principal.getName());

        board.setMember(member);
        board.setCreatedAt(LocalDateTime.now());

//        memberRepository.findByEmail(email).orElseThrow(() ->
//                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        return boardRepository.save(board);

    }

    public void deletePost(Long boardId) {
        Board findBoard = findVerifiedPost(boardId);
        boardRepository.delete(findBoard);
    }

    public Board findVerifiedPost(Long boardId) {
        Optional<Board> optionalPost =
                boardRepository.findById(boardId);
        Board findBoard = optionalPost.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.BOARD_NOT_FOUND));

        return findBoard;
    }

    public Board findBoard(Long boardId) {
        return findVerifiedPost(boardId);
    }

    public void verifyUserConfirm(Board board, Principal principal) {

        if (!Objects.equals(principal.getName(), board.getMember().getEmail())) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
        }
    }


    public Board getBoard(Long boardId) {

        Board board = findVerifiedPost(boardId);
        boardRepository.save(board);

        return boardRepository.findByBoardId(boardId);
    }

    public Page<Board> getBoardList(int page, int size) {

        Pageable pageable = PageRequest.of(page - 1, size,
                Sort.by("postId").descending());
        return boardRepository.findAll(pageable);
    }

  }
