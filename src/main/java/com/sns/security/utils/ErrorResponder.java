package com.sns.security.utils;

import com.google.gson.Gson;
import com.sns.common.advice.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//error response를 출력 스트림으로 생성하는 역할
public class ErrorResponder {
    public static void sendErrorResponse(HttpServletResponse response, HttpStatus status) throws IOException {
        Gson gson = new Gson();
        ErrorResponse errorResponse = ErrorResponse.of(status);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(status.value());
        response.getWriter().write(gson.toJson(errorResponse, ErrorResponse.class));
    }
}
