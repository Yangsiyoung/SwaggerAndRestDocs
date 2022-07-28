package com.radi.swaggerandrestdocs.exception_handler;

import com.radi.swaggerandrestdocs.exception.DecryptException;
import com.radi.swaggerandrestdocs.exception.Param01EmptyException;
import com.radi.swaggerandrestdocs.exception.Param02EmptyException;
import com.radi.swaggerandrestdocs.vo.response.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    private Logger log = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(value = {Param01EmptyException.class})
    public ResponseEntity<ResponseVO> param01EmptyExceptionHandling() {
        return ResponseEntity.status(400).body(new ResponseVO(-1, "Param01 is Empty"));
    }

    @ExceptionHandler(value = {Param02EmptyException.class})
    public ResponseEntity<ResponseVO> param02EmptyExceptionHandling() {
        return ResponseEntity.status(400).body(new ResponseVO(-2, "Param02 is Empty"));
    }

    @ExceptionHandler(value = {DecryptException.class})
    public ResponseEntity<ResponseVO>decryptExceptionHandling() {
        return ResponseEntity.status(401).body(new ResponseVO(-3, "올바르지 않은 유저입니다."));
    }


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ResponseVO> generalExceptionHandling(Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(500).body(new ResponseVO(500, "잠시 서버에 문제가 생겼습니다."));
    }
}
