package com.shanvin.project.controller;

import com.shanvin.project.service.SayHiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayHiController {

    @Autowired
    private SayHiService sayHiService;

    @RequestMapping(value = "/sayhi", method = RequestMethod.GET)
    public String sayHi(@RequestParam("name") String name) {
        return sayHiService.sayHi(name);
    }

}
