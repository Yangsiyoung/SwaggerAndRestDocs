package com.radi.swaggerandrestdocs.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.radi.swaggerandrestdocs.exception.Param01EmptyException;
import com.radi.swaggerandrestdocs.exception.Param02EmptyException;
import com.radi.swaggerandrestdocs.service.SampleService;
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

@RequestMapping("/sample")
@RestController
class SampleController {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final SampleService sampleService;
    private Logger log = LoggerFactory.getLogger(SampleController.class);

    public SampleController(SampleService sampleService) {
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
    public ResponseEntity<ResponseVO> processData(@RequestBody RequestVO requestVO) throws JsonProcessingException {
        requestVO.checkField();
        sampleService.save(requestVO);
        return ResponseEntity.ok(new ResponseVO(200, "success"));
    }
}