package com.locknlol.coukie.domain.riot.champion;

import com.locknlol.coukie.adapter.riot.dto.ImageDto;
import com.locknlol.coukie.adapter.riot.dto.champion.*;
import com.locknlol.coukie.adapter.riot.staticdatav3.ChampionAdapterService;
import com.locknlol.coukie.domain.riot.champion.entity.*;
import com.locknlol.coukie.domain.riot.champion.repository.ChampionInfoRepository;
import com.locknlol.coukie.domain.riot.champion.repository.ChampionPassiveRepository;
import com.locknlol.coukie.domain.riot.champion.repository.ChampionRepository;
import com.locknlol.coukie.domain.riot.champion.repository.ChampionSpellRepository;
import com.locknlol.coukie.domain.common.entity.Image;
import com.locknlol.coukie.domain.common.repository.ImageRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kev on 2017. 6. 5.
 */
@Service
public class ChampionSaveBatchService {

	@Autowired
	private ChampionAdapterService championAdapterService;

	@Autowired
	private ChampionRepository championRepository;

	@Autowired
	private ChampionInfoRepository championInfoRepository;

	@Autowired
	private ChampionPassiveRepository championPassiveRepository;

	@Autowired
	private ChampionSpellRepository championSpellRepository;

	@Autowired
	private ImageRepository imageRepository;


	@Scheduled(fixedDelay = 1000*60*60*12)
	public int saveAllChampions() {
		ChampionListDto allChampion = championAdapterService.getAllChampion();
		List<ChampionDto> allChampionList = new ArrayList<>(allChampion.getChampionMap().values());
		List<Champion> allChamp = new ArrayList<>();
		for (ChampionDto championDto : allChampionList) {
			allChamp.add(saveChampion(championDto));
		}
		return allChamp.size();
	}

	private Champion saveChampion(ChampionDto championDto) {
		Champion champion = new Champion();
		BeanUtils.copyProperties(championDto, champion);

		List<ChampionSpell> spells = new ArrayList<>();
		championDto.getSpells().forEach(championSpellDto ->
			spells.add(saveChampionSpell(championSpellDto)));
		champion.setSpells(spells);
		champion.setInfo(saveChampionInfo(championDto.getInfo()));
		champion.setPassive(saveChampionPassive(championDto.getPassive()));
		champion.setImage((ChampionImage) saveImage(championDto.getImage()));

		return championRepository.save(champion);
	}

	private ChampionSpell saveChampionSpell(ChampionSpellDto championSpellDto) {
		ChampionSpell championSpell = new ChampionSpell();
		BeanUtils.copyProperties(championSpellDto, championSpell);
		championSpell.setImage((ChampionSpellImage) saveImage(championSpellDto.getImage()));
		return championSpellRepository.save(championSpell);
	}


	private ChampionInfo saveChampionInfo(ChampionInfoDto championInfoDto) {
		ChampionInfo championInfo = new ChampionInfo();
		BeanUtils.copyProperties(championInfoDto, championInfo);
		return championInfoRepository.save(championInfo);
	}

	private ChampionPassive saveChampionPassive(ChampionPassiveDto championPassiveDto) {
		ChampionPassive championPassive = new ChampionPassive();
		BeanUtils.copyProperties(championPassiveDto, championPassive);
		championPassive.setImage((ChampionPassiveImage) saveImage(championPassiveDto.getImage()));
		return championPassiveRepository.save(championPassive);
	}

	private Image saveImage(ImageDto imageDto) {
		return imageRepository.save(imageDto.copiedEntity());
	}
}
