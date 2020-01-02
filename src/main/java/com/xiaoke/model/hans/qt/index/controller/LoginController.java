package com.xiaoke.model.hans.qt.index.controller;

import com.xiaoke.model.hans.qt.index.service.LoginService;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/qt")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping("/loginValid")
    public String loginValid(HttpServletRequest request, Map<String, Object> map,
                        @Param("phone") String phone, @Param("upwd") String upwd) throws Exception{
        System.out.println("HomeController.login()");
        /**这里为什么是String类型呢？其实要根据Subject.login(token)时候的token来的，你token定义成的pricipal是啥，这里get的时候就是啥。比如我
         Subject subject = SecurityUtils.getSubject();
         UsernamePasswordToken idEmail = new UsernamePasswordToken(String.valueOf(user.getId()), user.getEmail());
         try {
         idEmail.setRememberMe(true);
         subject.login(idEmail);
         }
         **/
        Subject subject =  SecurityUtils.getSubject();
        //用户名和密码保存到token中
        AuthenticationToken token= new UsernamePasswordToken("1","998");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        try {
            //如果正常登录,表示没有异常.登陆成功
            subject.login(token);
            SecurityUtils.getSubject().getPrincipals();
            return "SUCCESS";
        } catch (Exception e) {
            //如果异常,表示登录失败,重新跳转到登录页面
            e.printStackTrace();


        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
            map.put("msg", msg);
        }
        // 此方法不处理登录成功,由shiro进行处理
        return "login";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /*@RequestMapping("/login")
    public void login(HttpServletResponse response) {
        response.setStatus(302);
        try {
            response.sendRedirect("OPSConstants.OPS_URL_WITH_RETURN");
        } catch (IOException e) {

        }
    }

    @RequestMapping("/afterlogin")
    public void recTicket(String ticket, HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> paramMap = new HashMap<>(1);
        paramMap.put("ticket", ticket);
        String result = HttpHandler.getInstance().usingGetMethod(OPSConstants.OPS_URL_WITH_TICKET, paramMap, null);
        User user = JSON.parseObject(result, User.class);
        loginService.registerOrLogin(user);
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(1000 * 60 * 60);
        session.setAttribute(session.getId(), user);
        try {
            response.sendRedirect("/html/index.ftl");
        } catch (IOException e) {

        }
    }

    @RequestMapping(value = "/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(session.getId());
        String pticket = user.getPticket();
        String url = "OPSConstants.OPS_URL_LOGOUT" + "&pticket=" + pticket;
        response.setStatus(302);
        try {
            response.sendRedirect(url);
        } catch (IOException e) {

        }
    }

    @RequestMapping(value = "/afterlogout")
    public void afterLogout(HttpServletResponse response) {
        //这里一定要使用shiro退出方式，否则session失效
        SecurityUtils.getSubject().logout();
        try {
            response.sendRedirect("OPSConstants.OPS_URL_WITH_RETURN");
        } catch (IOException e) {

        }
    }*/

}
