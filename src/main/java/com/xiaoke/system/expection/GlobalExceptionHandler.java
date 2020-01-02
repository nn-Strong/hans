package com.xiaoke.system.expection;

import com.xiaoke.system.enums.ResponseBO;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseBody
    public ResponseBO jsonExceptionHandler(HttpServletRequest req, Exception e) {
        return new ResponseBO(403, "权限不足！");
    }
//    @ExceptionHandler(value = UnauthorizedException.class)
//    public ModelAndView businessExceptionHandler(){
//        ModelAndView mav = new ModelAndView();
//        mav.setStatus(HttpStatus.UNAUTHORIZED);
//        mav.addObject("message", e.getMessage());
//        mav.setViewName("403");
//        return mav;
//    }
}
