package com.musinsa.shop.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* 400 BAD_REQUEST */
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),

    /* 404 NOT_FOUND */
    POSTS_NOT_FOUND(HttpStatus.NOT_FOUND, "페이지를 찾을 수 없습니다."),

    /* 405 METHOD_NOT_ALLOWED: 허용되지 않은 Request Method 호출 */
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "허용되지 않은 메서드입니다."),

    /* 500 INTERNAL_SERVER_ERROR: 내부 서버 오류 */
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류입니다."),

    TARGET_NOT_FOUND(HttpStatus.NOT_FOUND, "조회되지 않는 대상입니다."),

    CONFLICT_GOODS(HttpStatus.CONFLICT, "이미 존재하는 상품 번호 입니다.")
    ;

    private final HttpStatus status;
    private final String message;


}
