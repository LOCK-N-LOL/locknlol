package com.locknlol.coukie.domain.riot.item.repository;

import com.locknlol.coukie.domain.riot.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kev on 2017. 7. 2.
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
}
