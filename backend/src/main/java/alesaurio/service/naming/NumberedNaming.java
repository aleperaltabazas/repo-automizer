package alesaurio.service.naming;

import java.util.List;

public class NumberedNaming implements NamingStrategy {
    @Override
    public String apply(String name, Integer number, List<String> members) {
        return String.format("%s-%d", name, number);
    }
}