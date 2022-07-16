package com.radi.swaggerandrestdocs.controller;

import com.radi.swaggerandrestdocs.dtos.MainDTO;
import com.radi.swaggerandrestdocs.dtos.request.RequestDTO;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/main")
@RestController
public class MainController {



    @GetMapping("/get")
    public String getResult() {
        return "Done!!!";
    }

    @GetMapping("/get/dto")
    public MainDTO getMainDTO() {
        return new MainDTO("value01", "value02");
    }

    @ApiOperation(value = "나의 API", notes = "dto를 보내면 200 ok 와 함께 Success!!! 나감")
    @ApiImplicitParams(
            value = {@ApiImplicitParam(name = "param01", value = "value01", required = true),
            @ApiImplicitParam(name = "param02", value = "value02", required = true),
            @ApiImplicitParam(name = "param03", value = "value03", required = true)}
    )
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Success"),
                    @ApiResponse(code = 400, message = "Bad Request!!!"),
                    @ApiResponse(code = 401, message = "Unauthentication!!!"),
                    @ApiResponse(code = 403, message = "Unauthorization!!!"),
                    @ApiResponse(code = 404, message = "Not Found!!!"),
            }
    )

    @PostMapping("/post/dto")
    public ResponseEntity<String> postDTO(@RequestBody RequestDTO requestDTO) {
        return ResponseEntity.ok("Success!!!");
    }
}
