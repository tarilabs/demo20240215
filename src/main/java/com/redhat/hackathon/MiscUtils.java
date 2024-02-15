package com.redhat.hackathon;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MiscUtils {

    @Inject
    ObjectMapper mapper;
    
    public static List<String> purgeIff(List<String> anniversary) {
        return anniversary.stream()
            .map(s -> s.trim())
            .filter(s -> !s.equals("") && !s.equals("---") && !s.toLowerCase().startsWith("of course") && !s.toLowerCase().startsWith("certainly") && !s.toLowerCase().startsWith("sure") && !s.toLowerCase().startsWith("hello"))
            .toList();
    }

    public void println(Object jsonValue) {
        try {
            System.out.println(mapper.writeValueAsString(jsonValue));
        } catch (JsonProcessingException e) {
            // do nothing.
        }
    }
}
