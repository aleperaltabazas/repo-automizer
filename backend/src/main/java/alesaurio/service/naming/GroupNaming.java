package alesaurio.service.naming;

import java.util.List;

public class GroupNaming implements NamingStrategy {
    @Override
    public String apply(String name, Integer number, List<String> members) {
        StringBuilder sb = new StringBuilder(name);
        members.forEach(member -> sb.append("-").append(member));
        return sb.toString();
    }
}