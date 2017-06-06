package com.locknlol.coukie.domain.common.repository;

import com.locknlol.coukie.domain.common.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kev on 2017. 6. 6.
 */
public interface ImageRepository extends JpaRepository<Image, Long> {
}
