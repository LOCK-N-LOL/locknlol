package com.locknlol.coukie.controller;

import com.locknlol.coukie.adapter.riot.dto.champion.ChampionDto;
import com.locknlol.coukie.adapter.riot.dto.champion.ChampionListDto;
import com.locknlol.coukie.adapter.staticdatav3.ChampionInfoAdapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @ResponseBody
    @RequestMapping("/getJax")
    private ChampionDto saveJax() throws Exception {
        return championInfoAdapterService.getChampionById(24);

    }

    @ResponseBody
    @RequestMapping("/getAllChamp")
    private List<ChampionDto> getAllChamp() throws Exception {
        ChampionListDto allChampion = championInfoAdapterService.getAllChampion();
        Map<String, ChampionDto> championDtoMap = allChampion.getChampionMap();
        List<ChampionDto> championList = new ArrayList<>(championDtoMap.values());
        return championList;
    }
}
