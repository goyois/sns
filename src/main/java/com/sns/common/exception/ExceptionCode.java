package com.sns.common.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404,"Member Not Found"),
    MEMBER_EXISTS(409,"Member Exists"),
    POST_NOT_FOUND(404,"Post Not Found"),
    COMMENT_NOT_FOUND(404,"Comment Not Found"),
    INVALID_TOKEN(401, "Token is expired"),
    UNAUTHORIZED_NOT_USER(401, "You must be logged."),
    EXPIRED_TOKEN(401, "Token is expired"),
    UNAUTHORIZED(401, "Unauthorized"),
    EMPTY_TOKEN(401, "Access Token is empty"),
    BOARD_NOT_FOUND(404,"Board Not Found");


    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
