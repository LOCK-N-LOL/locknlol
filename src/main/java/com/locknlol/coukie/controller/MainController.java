package com.locknlol.coukie.controller;

import com.locknlol.coukie.adapter.staticdatav3.StaticDataV3Adapter;
import com.locknlol.coukie.domain.champion.Champion;
import com.locknlol.coukie.domain.champion.ChampionRepository;
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
    private StaticDataV3Adapter staticDataV3Adapter;

    @Autowired
    private ChampionRepository championRepository;

    @RequestMapping("/")
    public String main() {
        saveJax();
        return "index";
    }

    private void saveJax() {
        Champion jax = staticDataV3Adapter.getJaxTest();
        championRepository.save(jax);
    }
}
