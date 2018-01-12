package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {

    @Test
    public void Team_createObject() throws Exception {
        Team team = new Team("team1");
        assertEquals(true, team instanceof Team);
    }

//    @Test
//    public void getName() {
//    }
//
//    @Test
//    public void getDescription() {
//    }
//
//    @Test
//    public void getMembers() {
//    }
}