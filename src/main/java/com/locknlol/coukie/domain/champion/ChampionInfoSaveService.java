package com.locknlol.coukie.domain.champion;

import com.google.common.base.Preconditions;
import com.locknlol.coukie.adapter.riot.dto.ImageDto;
import com.locknlol.coukie.adapter.riot.dto.champion.*;
import com.locknlol.coukie.adapter.staticdatav3.ChampionAdapterService;
import com.locknlol.coukie.domain.champion.entity.*;
import com.locknlol.coukie.domain.champion.repository.*;
import com.locknlol.coukie.domain.common.entity.Image;
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
			spells.add(saveChampionSpell(championSpellDto))
		);
		champion.setSpells(spells);
		champion.setTags(saveChampionTags(championDto.getTags()));
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

	private List<ChampionTags> saveChampionTags(List<String> tags) {
		List<ChampionTags> championTagsList = new ArrayList<>();
		for (String tag : tags) {
			ChampionTags championTags = new ChampionTags();
			championTags.setName(tag);
			championTagsList.add(championTagsRepository.save(championTags));
		}
		return championTagsList;
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
		Image image = null;
		if (imageDto instanceof ChampionImageDto) {
			image = new ChampionImage();
		} else if (imageDto instanceof ChampionSpellImageDto) {
			image = new ChampionSpellImage();
		} else if (imageDto instanceof ChampionPassiveImageDto) {
			image = new ChampionPassiveImage();
		}
		Preconditions.checkNotNull(image, "이미지를 저장하는데 실패하였습니다.");
		BeanUtils.copyProperties(imageDto, image);
		return imageRepository.save(image);
	}
}
