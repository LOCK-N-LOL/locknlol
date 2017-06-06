package com.locknlol.coukie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Haylie
 * @since 2017. 5. 16..
 */

@Controller
public class MainController {

    @RequestMapping("/")
    public String main() {
        return "index";
    }
}
