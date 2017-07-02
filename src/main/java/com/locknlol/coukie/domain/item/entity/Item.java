package com.locknlol.coukie.domain.item.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Created by kev on 2017. 7. 2.
 */
@Entity
@Getter
@Setter
public class Item {
	//private List<String> tags;
	@Id
	private String id;
	@Lob
	private String sanitizedDescription;
	private String plaintext;
	//private Map<String, Boolean> maps;
	@Lob
	private String description;
	@OneToOne
	private InventoryDataStats stats;
	private String name;
	//private List<Item> into;
	@OneToOne
	private ItemImage image;
	//private String colloq;
	@OneToOne
	private Gold gold;
	//private Boolean hideFromAll;
	//private Boolean inStore;
	//private Integer specialRecipe;
	//private Map<String, String> effect;
	//private String requiredChampion;
	//private List<Item> from;
	//private String group;
	//private Boolean consumeOnFull;
	//private Boolean consumed;
	//private Integer depth;
	//private Integer stacks;
}
