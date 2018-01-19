package models;

import java.util.ArrayList;
import java.util.Objects;

public class Team {

    private int id;
    private String name;
    private String description;

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(name, team.name) &&
                Objects.equals(description, team.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, description);
    }

    //    private static ArrayList<Team> instances = new ArrayList<Team>();
//    private ArrayList<String> members = new ArrayList<String>();

//    public String getName() {
//        return name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public ArrayList<String> getMembers() {
//        return members;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    // add a team
//    public Team(String name, String description) {
//        this.name = name;
//        this.description = description;
//        instances.add(this);
//        this.id = instances.size();
//    }
//
//    public Team(String name) {
//        this.name = name;
//        instances.add(this);
//        this.id = instances.size();
//    }
//
//    //add a member to a team
//    public void addMember(String memberName){
//        this.members.add(memberName);
//    }
//
//    //update a team
//    public void updateTeam(String name){
//        this.name = name;
//    }
//
//    //static methods:
//
//    public static ArrayList<Team> getInstances() {
//        return instances;
//    }
//
//    public static Team findById(int id){
//        return instances.get(id-1);
//    }
//
//    public static void clearInstances(){
//        instances.clear();
//    }
}
