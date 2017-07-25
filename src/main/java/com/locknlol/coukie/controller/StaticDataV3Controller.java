package com.locknlol.coukie.controller;

import com.locknlol.coukie.adapter.riot.dto.champion.ChampionDto;
import com.locknlol.coukie.adapter.riot.dto.champion.ChampionListDto;
import com.locknlol.coukie.adapter.riot.dto.items.ItemDto;
import com.locknlol.coukie.adapter.riot.dto.items.ItemListDto;
import com.locknlol.coukie.adapter.riot.dto.summoner.spells.SummonerSpellDto;
import com.locknlol.coukie.adapter.riot.staticdatav3.ChampionAdapterService;
import com.locknlol.coukie.adapter.riot.staticdatav3.ItemAdapterService;
import com.locknlol.coukie.adapter.riot.staticdatav3.SummonerSpellInfoAdapterService;
import com.locknlol.coukie.domain.riot.champion.entity.Champion;
import com.locknlol.coukie.domain.riot.champion.repository.ChampionRepository;
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

	private final ChampionAdapterService championAdapterService;
	private final ItemAdapterService itemAdapterService;
	private final SummonerSpellInfoAdapterService summonerSpellInfoAdapterService;
	private final ChampionRepository championRepository;

	@Autowired
	public StaticDataV3Controller(ChampionAdapterService championAdapterService,
		ItemAdapterService itemAdapterService,
		SummonerSpellInfoAdapterService summonerSpellInfoAdapterService,
		ChampionRepository championRepository) {
		this.championAdapterService = championAdapterService;
		this.itemAdapterService = itemAdapterService;
		this.summonerSpellInfoAdapterService = summonerSpellInfoAdapterService;
		this.championRepository = championRepository;
	}

	@ResponseBody
	@RequestMapping("/champions")
	private List<ChampionDto> getAllChamp() {
		ChampionListDto allChampion = championAdapterService.getAllChampion();
		Map<String, ChampionDto> championDtoMap = allChampion.getChampionMap();
		return new ArrayList<>(championDtoMap.values());
	}

	@RequestMapping("/getChampionImage")
	@ResponseBody
	private String getChampionImage(String id) {
		Champion one = championRepository.findOne(Long.parseLong(id));
		return one.getImage().getImgUrl();
	}

	@ResponseBody
	@RequestMapping("/items")
	private Map<String, ItemDto> getAllItems() {
		ItemListDto allItems = itemAdapterService.getAllItems();
		return allItems.getData();
	}

	@ResponseBody
	@RequestMapping("/summonerSpells/{id}")
	private SummonerSpellDto getSummonerSpellsById(@PathVariable int id) {
		return summonerSpellInfoAdapterService.getSummonerSpellById(id);

	}

}
