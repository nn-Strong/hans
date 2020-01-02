package com.xiaoke.model.hans.qt.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ht/")
public class HtController {
    @RequestMapping("index")
    public String Index(){
        return "/hans/ht/index";
    }
}
