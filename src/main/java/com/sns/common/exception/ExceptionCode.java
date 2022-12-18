package com.sns.common.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404,"Member Not Found"),
    MEMBER_EXISTS(409,"Member Exists"),
    POST_NOT_FOUND(404,"Post Not Found"),
    COMMENT_NOT_FOUND(404,"Comment Not Found");


    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
