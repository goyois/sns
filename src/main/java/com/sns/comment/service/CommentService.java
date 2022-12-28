package com.sns.comment.service;

import com.sns.board.entity.Board;
import com.sns.comment.entity.Comment;
import com.sns.comment.repository.CommentRepository;
import com.sns.common.exception.BusinessLogicException;
import com.sns.common.exception.ExceptionCode;
import com.sns.member.domain.entity.Member;
import com.sns.member.domain.repository.MemberRepository;
import com.sns.board.repository.BoardRepository;
import com.sns.board.service.BoardService;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Objects;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final BoardRepository boardRepository;

    private final BoardService boardService;


    public CommentService(CommentRepository commentRepository, MemberRepository memberRepository, BoardRepository boardRepository, BoardService boardService) {
        this.commentRepository = commentRepository;
        this.memberRepository = memberRepository;
        this.boardRepository = boardRepository;
        this.boardService = boardService;
    }

    public Comment createComment(String email, Long boardId, Comment comment) {

        Member member = memberRepository.findByEmail(email).orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        Board board = boardService.getBoard(boardId);

        comment.setMember(member);
        comment.setBoard(board);


        return commentRepository.save(comment);

    }


    public Comment updateComment(Comment comment, Long boardId, Principal principal) {

        Board board = boardService.getBoard(boardId);
        Comment findComment = commentRepository.findById(comment.getCommentId()).get();

        verifyUserConfirm(findComment, principal);

        findComment.setComment(comment.getComment());

        Comment saved = commentRepository.save(findComment);
        board.setModifiedAt(saved.getBoard().getModifiedAt());
        return saved;
    }



    public void deleteComment(Long commentId, Long boardId, Principal principal){

        Board board = boardService.getBoard(boardId);
        Comment findComment = commentRepository.findById(commentId).get();

        verifyUserConfirm(findComment, principal);


       commentRepository.delete(findComment);


    }
    public Comment getComment(Long commentId) {

        Comment comment = findVerifiedComment(commentId);
        return comment;
    }


    public Comment findVerifiedComment(long commentId) {
        Optional<Comment> optionalQuestion = commentRepository.findById(commentId);
        return optionalQuestion.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.COMMENT_NOT_FOUND));
    }

    public void verifyUserConfirm(Comment comment, Principal principal) {

        if (!Objects.equals(principal.getName(), comment.getMember().getEmail())) {
            throw new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND);
        }
    }

}
