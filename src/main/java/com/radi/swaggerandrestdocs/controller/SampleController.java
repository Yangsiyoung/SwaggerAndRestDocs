package com.radi.swaggerandrestdocs.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radi.swaggerandrestdocs.service.SampleService;
import com.radi.swaggerandrestdocs.utils.AES256Util;
import com.radi.swaggerandrestdocs.vo.request.MultipartVO;
import com.radi.swaggerandrestdocs.vo.request.RequestVO;
import com.radi.swaggerandrestdocs.vo.response.ResponseVO;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

@RequestMapping("/sample")
@RestController
class SampleController {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final SampleService sampleService;
    private final AES256Util aes256Util = new AES256Util();
    private Logger log = LoggerFactory.getLogger(SampleController.class);

    public SampleController(SampleService sampleService) throws UnsupportedEncodingException {
        this.sampleService = sampleService;
    }

    @PostConstruct
    public void init() throws JsonProcessingException {
        RequestVO requestVO = new RequestVO(
                "value01",
                "value02",
                "value03",
                "value04",
                "value05"

        );
        log.info(objectMapper.writeValueAsString(requestVO));
    }

    @ApiOperation(value = "Sample API", notes = "VO 저장")
    @ApiImplicitParams(
            value = {@ApiImplicitParam(name = "param01", value = "value01", required = true),
                    @ApiImplicitParam(name = "param02", value = "value02", required = true),
                    @ApiImplicitParam(name = "param03", value = "value03", required = true),
                    @ApiImplicitParam(name = "param04", value = "value04", required = true),
                    @ApiImplicitParam(name = "param05", value = "value05", required = true),
            }
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success"),
                    @ApiResponse(code = 400, message = "Param01 is Empty"),
                    @ApiResponse(code = 400, message = "Param02 is Empty")
            }
    )
    @PostMapping("/data")
    public ResponseEntity<ResponseVO> processData(@RequestBody RequestVO requestVO, HttpServletRequest request) throws JsonProcessingException, UnsupportedEncodingException, GeneralSecurityException {
        String key = request.getHeader("key");
        aes256Util.verifyKey(key);
        requestVO.checkField();
        sampleService.save(requestVO);
        return ResponseEntity.ok(new ResponseVO(200, "success"));
    }

    @PostMapping("/multipart")
    public ResponseEntity<ResponseVO> processMultipartData(MultipartVO multipartVO, HttpServletRequest request) {
        String key = request.getHeader("key");
        aes256Util.verifyKey(key);
        sampleService.saveFile(multipartVO);
        return ResponseEntity.ok(new ResponseVO(200, "success"));
    }

}