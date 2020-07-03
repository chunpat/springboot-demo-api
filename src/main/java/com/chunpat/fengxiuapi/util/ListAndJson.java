package com.chunpat.fengxiuapi.util;

import com.chunpat.fengxiuapi.exception.ServerInnerException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Converter
//AttributeConverter<Map<String,Object>,String：   Map=》实体 <String,Object>=》数据库字段
public class ListAndJson implements AttributeConverter<List<Object>,String> {
    @Autowired
    private ObjectMapper mapper;

    @Override
    public String convertToDatabaseColumn(List<Object> objects) {
        try {
            return mapper.writeValueAsString(objects);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerInnerException();
        }
    }

    @Override
    public List<Object> convertToEntityAttribute(String s) {
        try {
            if(s == null){
                return null;
            }
            return mapper.readValue(s, List.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new ServerInnerException();
        }
    }
}
