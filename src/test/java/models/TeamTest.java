package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {

    @Test
    public void Team_createObject() throws Exception {
        Team team = new Team("team1");
        assertEquals(true, team instanceof Team);
    }

    @Test
    public void getName() {
        Team team = new Team("team1", "");
        assertEquals("team1", team.getName());
    }

    @Test
    public void getDescription() {
        Team team = new Team("team1", "description1");
        assertEquals("description1", team.getDescription());
    }

//    @Test
//    public void addMember() {
//        Team team = new Team("team1");
//        team.addMember("Jane Doe");
//        team.addMember("John Doe");
//        assertEquals(2, team.getMembers().size());
//    }

//    @Test
//    public void updateTeam() {
//        Team team = new Team("team1");
//        team.updateTeam("newTeam1");
//        assertEquals("newTeam1", team.getName());
//    }

//    @Test
//    public void getInstances() {
//        Team.clearInstances();
//        Team team1 = new Team("team1");
//        Team team2 = new Team("team2");
//        assertEquals(2, Team.getInstances().size());
//    }

//    @Test
//    public void findById() {
//        Team.clearInstances();
//        Team team1 = new Team("team1");
//        Team team2 = new Team("team2");
//        Team team3 = new Team("team3");
//        assertEquals(team2, Team.findById(2));
//    }
}