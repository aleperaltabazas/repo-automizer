package com.despegar.jav.service.naming;

import java.util.List;

public class AlphabeticNaming implements NamingStrategy {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public String apply(String name, Integer number, List<String> members) {
        return String.format("%s-%s", name, ALPHABET.charAt(number));
    }
}