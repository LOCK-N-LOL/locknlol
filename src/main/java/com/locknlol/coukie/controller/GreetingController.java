package com.locknlol.coukie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author jinie@coupang.com
 * @since 2017. 5. 10.
 */
@Controller
public class GreetingController {

    @RequestMapping("/")
    public String greeting() {
        return "greeting";
    }

}