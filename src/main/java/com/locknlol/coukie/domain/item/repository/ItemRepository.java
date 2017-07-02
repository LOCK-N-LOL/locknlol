package com.locknlol.coukie.domain.item.repository;

import com.locknlol.coukie.domain.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kev on 2017. 7. 2.
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
}
