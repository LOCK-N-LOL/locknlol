package com.locknlol.coukie.controller;

import com.locknlol.coukie.domain.member.configuration.SessionLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {

    /*
        예제 케이스1
        void 일 때, RequestMapping name hbs 매핑
     */
    @RequestMapping("/greeting")
    @SessionLogin
    public void greeting(Model model) {
        model.addAttribute("name", "fowler");
    }

    /*
        예제 케이스2
        String 을 리턴하면, 문자열에 매칭되는 hbs를 리턴
     */
    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "world");
        return "/greeting";
    }

    /*
        예제 케이스3
        ModelAndView 를 리턴하면, viewName에 매칭되는 hbs를 리턴
     */
    @RequestMapping("/hellow")
    public ModelAndView hellow(Model model) {
        ModelAndView modelAndView = new ModelAndView("/greeting");
        model.addAttribute("name", "world!!");
        return modelAndView;
    }
}