package com.locknlol.coukie.controller;

import com.locknlol.coukie.adapter.riot.dto.champion.ChampionDto;
import com.locknlol.coukie.adapter.riot.dto.champion.ChampionListDto;
import com.locknlol.coukie.adapter.riot.dto.items.ItemDto;
import com.locknlol.coukie.adapter.riot.dto.items.ItemListDto;
import com.locknlol.coukie.adapter.riot.dto.summoner.spells.SummonerSpellDto;
import com.locknlol.coukie.adapter.riot.dto.summoner.spells.SummonerSpellListDto;
import com.locknlol.coukie.adapter.staticdatav3.ChampionInfoAdapterService;
import com.locknlol.coukie.adapter.staticdatav3.ItemInfoAdapterService;
import com.locknlol.coukie.adapter.staticdatav3.SummonerSpellInfoAdapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/staticDataV3")
public class StaticDataV3Controller {

    private final ChampionInfoAdapterService championInfoAdapterService;
    private final ItemInfoAdapterService itemInfoAdapterService;
    private final SummonerSpellInfoAdapterService summonerSpellInfoAdapterService;

    @Autowired
    public StaticDataV3Controller(ChampionInfoAdapterService championInfoAdapterService,
                                  ItemInfoAdapterService itemInfoAdapterService,
                                  SummonerSpellInfoAdapterService summonerSpellInfoAdapterService) {
        this.championInfoAdapterService = championInfoAdapterService;
        this.itemInfoAdapterService = itemInfoAdapterService;
        this.summonerSpellInfoAdapterService = summonerSpellInfoAdapterService;
    }

    @ResponseBody
    @RequestMapping("/champions/{id}")
    private ChampionDto getChampById(@PathVariable int id) {
        return championInfoAdapterService.getChampionById(id);

    }

    @ResponseBody
    @RequestMapping("/champions")
    private List<ChampionDto> getAllChamp() {
        ChampionListDto allChampion = championInfoAdapterService.getAllChampion();
        Map<String, ChampionDto> championDtoMap = allChampion.getChampionMap();
        return new ArrayList<>(championDtoMap.values());
    }

    @ResponseBody
    @RequestMapping("/items/{id}")
    private ItemDto getItemById(@PathVariable int id) {
        return itemInfoAdapterService.getItemById(id);

    }

    @ResponseBody
    @RequestMapping("/items")
    private Map<String, ItemDto> getAllItems() {
        ItemListDto allItems = itemInfoAdapterService.getAllItems();
        return allItems.getData();
    }

    @ResponseBody
    @RequestMapping("/summonerSpells/{id}")
    private SummonerSpellDto getSummonerSpellsById(@PathVariable int id) {
        return summonerSpellInfoAdapterService.getSummonerSpellById(id);

    }

    @ResponseBody
    @RequestMapping("/summonerSpells")
    private Map<String, SummonerSpellDto> getAllSummonerSpells() {
        SummonerSpellListDto allItems = summonerSpellInfoAdapterService.getAllSummonerSpells();
        return allItems.getData();
    }
}
