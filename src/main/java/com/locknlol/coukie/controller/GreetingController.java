package com.locknlol.coukie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jinie@coupang.com
 * @since 2017. 5. 10.
 */
@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public void greeting(Model model) {
        model.addAttribute("name", "fowler");
    }

}