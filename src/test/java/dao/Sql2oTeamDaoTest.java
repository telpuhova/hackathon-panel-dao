package dao;

import models.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oTeamDaoTest {

    private Connection con;
    private Sql2oTeamDao teamDao;

    @Before
    public void setUp() throws Exception {

        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        teamDao = new Sql2oTeamDao(sql2o);

        con = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    @Test
    public void add() {
        Team team = new Team("team1");
        teamDao.add(team);
        assertEquals(1, teamDao.getAll().size());
    }

    @Test
    public void findById() {
        Team team = new Team("team1");
        teamDao.add(team);
        assertEquals(team, teamDao.findById(1));
    }

    @Test
    public void getAll() {
        Team team = new Team("team1");
        Team team2 = new Team("team2");
        Team team3 = new Team("team3");
        teamDao.add(team);
        teamDao.add(team2);
        teamDao.add(team3);
        assertEquals(3, teamDao.getAll().size());
    }
}