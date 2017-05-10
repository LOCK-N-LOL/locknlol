package com.locknlol.coukie.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jinie@coupang.com
 * @since 2017. 5. 10.
 */
@RestController
public class GreetingController {

    @RequestMapping("/")
    public String greeting() {
        return "greeting";
    }

}