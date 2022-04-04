package com.triscit.data.controller;


import com.triscit.data.vo.DataRequest;
import com.triscit.data.vo.DataResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


/**
 * 请求
 * @Description
 * @author YX
 * @Date 2022/4/4 23:43
 */
@RestController
@RequestMapping("/api")
@Tag(name = "data-controller", description = "测试")
public class DataController {

    private Logger log = LoggerFactory.getLogger(DataController.class);

    @Operation(summary = "swagger_data")
    @PostMapping("/data")
    public DataResponse data(@RequestBody @Valid DataRequest request) {
        String name = request.getName();
        DataResponse response = new DataResponse();
        response.setName(name + "_" + LocalDateTime.now());
        return response;
    }
}

