package com.locknlol.coukie.adapter.riot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Haylie
 * @since 2017. 6. 5..
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MiniSeriesDto {
    private int wins;
    private int losses;
    private int target;
    private String progress;
}
