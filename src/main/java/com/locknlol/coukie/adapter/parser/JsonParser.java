package com.locknlol.coukie.adapter.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Oscar on 2017. 5. 26..
 */
@Component
public class JsonParser implements Parser {
    private ObjectMapper mapper;

    public JsonParser(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public <T> T parse(String targetData, Class<T> targetClazz) throws IOException{
        T obj = mapper.readValue(targetData, targetClazz);
        return obj;
    }
}
