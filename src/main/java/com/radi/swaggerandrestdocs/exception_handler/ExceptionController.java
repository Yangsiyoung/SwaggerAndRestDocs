package com.radi.swaggerandrestdocs.exception_handler;

import com.radi.swaggerandrestdocs.exception.Param01EmptyException;
import com.radi.swaggerandrestdocs.exception.Param02EmptyException;
import com.radi.swaggerandrestdocs.vo.response.ResponseVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {Param01EmptyException.class})
    public ResponseEntity<ResponseVO> param01EmptyExceptionHandling() {
        return ResponseEntity.status(400).body(new ResponseVO(-1, "Param01 is Empty"));
    }

    @ExceptionHandler(value = {Param02EmptyException.class})
    public ResponseEntity<ResponseVO> param02EmptyExceptionHandling() {
        return ResponseEntity.status(400).body(new ResponseVO(-2, "Param02 is Empty"));
    }


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ResponseVO> generalExceptionHandling() {
        return ResponseEntity.status(500).body(new ResponseVO(500, "잠시 서버에 문제가 생겼습니다."));
    }
}
