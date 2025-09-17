package com.bofa.circuitbreakerapi.controllers;

import com.bofa.circuitbreakerapi.services.CBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cbs")
public class CBController {

    @Autowired
    private CBService service;


    @GetMapping("/v1.0")
    public String fetchData(){
        return service.getData();
    }

}
