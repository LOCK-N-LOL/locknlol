package com.locknlol.coukie.domain.champion;

import com.locknlol.coukie.adapter.riot.dto.champion.ChampionDto;
import com.locknlol.coukie.adapter.riot.dto.champion.ChampionListDto;
import com.locknlol.coukie.adapter.riot.dto.champion.ChampionSpellDto;
import com.locknlol.coukie.adapter.staticdatav3.ChampionAdapterService;
import com.locknlol.coukie.domain.champion.entity.*;
import com.locknlol.coukie.domain.champion.repository.*;
import com.locknlol.coukie.domain.common.repository.ImageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kev on 2017. 6. 5.
 */
@Service
public class ChampionInfoSaveService {


	@Autowired
	private ChampionAdapterService championAdapterService;

	@Autowired
	private ChampionRepository championRepository;

	@Autowired
	private ChampionInfoRepository championInfoRepository;

	@Autowired
	private ChampionPassiveRepository championPassiveRepository;

	@Autowired
	private ChampionTagsRepository championTagsRepository;

	@Autowired
	private ChampionSpellRepository championSpellRepository;

	@Autowired
	private ImageRepository imageRepository;


	public int saveAllChampions() {
		ChampionListDto allChampion = championAdapterService.getAllChampion();
		List<ChampionDto> allChampionList = new ArrayList<>(allChampion.getChampionMap().values());
		for(ChampionDto championDto : allChampionList) {
			Champion champion = new Champion();
			BeanUtils.copyProperties(championDto, champion);
			champion.setSpells(new ArrayList<>());
			for(ChampionSpellDto spell : championDto.getSpells()) {
				ChampionSpell championSpell = new ChampionSpell();
				BeanUtils.copyProperties(spell, championSpell);
				championSpell.setImage(new ChampionSpellImage());
				BeanUtils.copyProperties(spell.getImage(), championSpell.getImage());
				imageRepository.save(championSpell.getImage());
				championSpellRepository.save(championSpell);
				champion.getSpells().add(championSpell);
			}
			champion.setTags(new ArrayList<>());
			for(String tags : championDto.getTags()) {
				ChampionTags championTags = new ChampionTags();
				championTags.setName(tags);
				championTagsRepository.save(championTags);
				champion.getTags().add(championTags);
			}

			champion.setImage(new ChampionImage());
			BeanUtils.copyProperties(championDto.getImage(), champion.getImage());
			imageRepository.save(champion.getImage());

			champion.setInfo(new ChampionInfo());
			BeanUtils.copyProperties(championDto.getInfo(), champion.getInfo());
			championInfoRepository.save(champion.getInfo());

			champion.setPassive(new ChampionPassive());
			BeanUtils.copyProperties(championDto.getPassive(), champion.getPassive());
			champion.getPassive().setImage(new ChampionPassiveImage());
			BeanUtils.copyProperties(championDto.getPassive().getImage(), champion.getPassive().getImage());
			imageRepository.save(champion.getPassive().getImage());
			championPassiveRepository.save(champion.getPassive());

			championRepository.save(champion);
		}
		return allChampionList.size();

	}
}
