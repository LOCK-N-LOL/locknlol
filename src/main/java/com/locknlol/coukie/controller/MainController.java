package com.locknlol.coukie.controller;

import com.locknlol.coukie.adapter.staticdatav3.ChampionInfoAdapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Haylie
 * @since 2017. 5. 16..
 */

@Controller
public class MainController {

    @Autowired
    private ChampionInfoAdapterService championInfoAdapterService;

    @RequestMapping("/")
    public String main() {
        return "index";
    }
}
