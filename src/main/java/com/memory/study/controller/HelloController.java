package com.memory.study.controller;

import com.memory.study.utils.LoginRequired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * created by memory
 * on 2019/8/27 15 53
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger("HelloController,class");


    @RequestMapping(path = {"/say", "/sayHello"}, method = RequestMethod.GET)
    @ResponseBody
    @LoginRequired
    public String sayHello() {
        return "hello";
    }

    @RequestMapping(path = "/name", method = RequestMethod.GET)
    @ResponseBody
    public String storedName() {
        String name = "xiao";
        logger.info("logger name:" + name);
        return "my name is " + name;
    }
}
