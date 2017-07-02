package com.locknlol.coukie.adapter.staticdatav3;

import com.locknlol.coukie.adapter.RiotAdapter;
import com.locknlol.coukie.adapter.riot.RiotApiUrl;
import com.locknlol.coukie.adapter.riot.RiotRequests;
import com.locknlol.coukie.adapter.riot.dto.items.ItemDto;
import com.locknlol.coukie.adapter.riot.dto.items.ItemListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author jinie@coupang.com
 * @since 2017. 6. 5.
 */
@Service
public class ItemAdapterService {

	private final RiotAdapter riotAdapter;

	@Autowired
	public ItemAdapterService(RiotAdapter riotAdapter) {
		this.riotAdapter = riotAdapter;
	}

	public ItemDto getItemById(int id) {
		try {
			return riotAdapter.get(RiotRequests.ITEM_BY_ID, Collections.singletonMap("id", id));
		} catch (Exception e) {
			throw new DataRetrievalFailureException("Cannot find a item: itemId="+id, e);
		}
	}

	public ItemListDto getAllItems() {
		try {
			return riotAdapter.get(RiotRequests.ITEMS);
		} catch (Exception e) {
			throw new DataRetrievalFailureException("Cannot find items", e);
		}
	}


}
