package com.mabo.controller;

import com.mabo.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class TestController {
    //浏览器输入
    //http://localhost:8081/event
    @Autowired
    private Event event;
    @RequestMapping("event")
    public String request(){
        String event = this.event.event("测试数据");
        return event;
    }
}
