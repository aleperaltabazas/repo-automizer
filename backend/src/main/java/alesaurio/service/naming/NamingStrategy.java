package alesaurio.service.naming;

import java.util.List;

public interface NamingStrategy {
    static NamingStrategy parse(String strategy) {
        switch (strategy) {
            case "alpha":
                return new AlphabeticNaming();
            case "number":
                return new NumberedNaming();
            case "group":
                return new GroupNaming();
            default:
                throw new RuntimeException("Unknown naming strategy: " + strategy);
        }
    }

    String apply(String name, Integer number, List<String> members);
}