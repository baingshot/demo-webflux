package ru.eda.demowebflux.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @ApiOperation(value = "Get backend status state")
    @GetMapping("/status")
    public String getStatus(){
        return "OK";
    }
}
