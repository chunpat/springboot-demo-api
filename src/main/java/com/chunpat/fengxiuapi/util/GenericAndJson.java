package com.chunpat.fengxiuapi.util;

import com.chunpat.fengxiuapi.exception.ServerInnerException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GenericAndJson {
    private static ObjectMapper mapper;

    @Autowired
    public void setMapper(ObjectMapper mapper) {
        GenericAndJson.mapper = mapper;
    }

    public static <T> String objectToJson(T o){
        try {
            return GenericAndJson.mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerInnerException();
        }
    }

    public static <T> T JsonToList(String s,TypeReference<T> t){
        try {
            if(s == null){
                return null;
            }
            T list = GenericAndJson.mapper.readValue(s, t);
            return list;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerInnerException();
        }
    }
}
