package com.locknlol.coukie.adapter.riot.dto.summoner.spells;

import lombok.Data;

import java.util.List;

/**
 * @author jinie@coupang.com
 * @since 2017. 6. 5.
 */
@Data
public class SpellVarsDto {
    private String ranksWith;
    private String dyn;
    private String link;
    private List<Double> coeff;
    private String key;
}
