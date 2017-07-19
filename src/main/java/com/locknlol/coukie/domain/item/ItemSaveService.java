package com.locknlol.coukie.domain.item;

import com.locknlol.coukie.adapter.riot.dto.items.*;
import com.locknlol.coukie.adapter.staticdatav3.ItemAdapterService;
import com.locknlol.coukie.domain.common.repository.ImageRepository;
import com.locknlol.coukie.domain.item.entity.Gold;
import com.locknlol.coukie.domain.item.entity.Item;
import com.locknlol.coukie.domain.item.entity.ItemImage;
import com.locknlol.coukie.domain.item.repository.GoldRepository;
import com.locknlol.coukie.domain.item.repository.ItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by kev on 2017. 7. 2.
 */
@Service
public class ItemSaveService {

	@Autowired
	private ItemAdapterService itemAdapterService;

	@Autowired
	private GoldRepository goldRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ImageRepository imageRepository;

	public int saveAllItems() {
		ItemListDto allItems = itemAdapterService.getAllItems();
		ArrayList<ItemDto> itemDtos = new ArrayList<>(allItems.getData().values());
		for (ItemDto itemDto : itemDtos) {
			Item item = new Item();
			BeanUtils.copyProperties(itemDto, item);
			//tem.setStats(saveStats(itemDto.getStats()));
			item.setGold(saveGold(itemDto.getGold()));
			item.setImage(saveImage(itemDto.getImage()));
			itemRepository.save(item);
		}
		return itemDtos.size();
	}

	private ItemImage saveImage(ItemImageDto imageDto) {
		ItemImage image = (ItemImage) imageDto.copiedEntity();
		return imageRepository.save(image);
	}

	private Gold saveGold(GoldDto goldDto) {
		Gold gold = new Gold();
		BeanUtils.copyProperties(goldDto, gold);
		return goldRepository.save(gold);
	}

}