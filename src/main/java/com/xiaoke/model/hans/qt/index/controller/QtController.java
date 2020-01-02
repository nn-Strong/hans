package com.xiaoke.model.hans.qt.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qt/")
public class QtController {

    @RequestMapping("index")
    public String Index(){
        return "/hans/qt/index";
    }


}
