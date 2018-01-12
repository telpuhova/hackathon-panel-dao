package models;

import java.util.ArrayList;

public class Team {

    private String name;
    private String description;
    private ArrayList<String> members = new ArrayList<String>();
    private static ArrayList<Team> instances = new ArrayList<Team>();
    private int id;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public int getId() {
        return id;
    }

    // add a team
    public Team(String name, String description) {
        this.name = name;
        this.description = description;
        instances.add(this);
        this.id = instances.size();
    }

    public Team(String name) {
        this.name = name;
        instances.add(this);
        this.id = instances.size();
    }

    //add a member to a team
    public void addMember(String memberName){
        this.members.add(memberName);
    }

    //update a team
    public void updateTeam(String name){
        this.name = name;
    }

    //static methods:

    public static ArrayList<Team> getInstances() {
        return instances;
    }

    public static Team findById(int id){
        return instances.get(id-1);
    }

    public static void clearInstances(){
        instances.clear();
    }
}
