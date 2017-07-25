package com.locknlol.coukie.domain.riot.item;

import com.google.common.base.Preconditions;
import com.locknlol.coukie.domain.riot.item.entity.Item;
import com.locknlol.coukie.domain.riot.item.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kev on 2017. 7. 18.
 */
@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	public Item getItem(Long itemId) {
		Item one = itemRepository.findOne(itemId);
		Preconditions.checkNotNull(one, "존재하는 챔피언이 없습니다");
		return one;
	}
}
