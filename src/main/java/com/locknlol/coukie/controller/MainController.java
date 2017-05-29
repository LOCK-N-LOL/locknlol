package com.locknlol.coukie.controller;

import com.locknlol.coukie.adapter.riot.dto.champion.ChampionDto;
import com.locknlol.coukie.adapter.staticdatav3.StaticDataV3Adapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Haylie
 * @since 2017. 5. 16..
 */

@Controller
public class MainController {

    @Autowired
    private StaticDataV3Adapter staticDataV3Adapter;

    @RequestMapping("/")
    public String main() {
        return "index";
    }

    @ResponseBody()
    @RequestMapping("/getJax")
    private ChampionDto saveJax() throws Exception {
        return staticDataV3Adapter.getJaxTest();

    }
}
