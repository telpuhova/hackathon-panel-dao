package models;

import java.util.ArrayList;

public class Team {

    private String name;
    private String description;
    private ArrayList<String> members = new ArrayList<String>();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public Team(String name) {
        this.name = name;
    }
}
