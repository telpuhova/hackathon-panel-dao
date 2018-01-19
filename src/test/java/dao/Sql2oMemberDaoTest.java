package dao;

import models.Member;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oMemberDaoTest {
    private Connection con;
    private Sql2oMemberDao memberDao;

    @Before
    public void setUp() throws Exception {

        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        memberDao = new Sql2oMemberDao(sql2o);

        con = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    @Test
    public void add() {
        Member member = new Member("member1", 1);
        memberDao.add(member);
        assertEquals(1, memberDao.getAll().size());
    }

    @Test
    public void findById() {
        Member member = new Member("member1", 1);
        memberDao.add(member);
        assertEquals(member, memberDao.findById(1));
    }

    @Test
    public void getAll() {
        Member member = new Member("member1", 1);
        Member member2 = new Member("member2", 1);
        Member member3 = new Member("member3", 1);
        memberDao.add(member);
        memberDao.add(member2);
        memberDao.add(member3);
        assertEquals(3, memberDao.getAll().size());
    }

    @Test
    public void getAllByTeam() {
        Member member = new Member("member1", 1);
        Member member2 = new Member("member2", 1);
        Member member3 = new Member("member3", 2);
        memberDao.add(member);
        memberDao.add(member2);
        memberDao.add(member3);
        assertEquals(2, memberDao.getAllByTeam(1).size());
    }

    @Test
    public void update() {
        Member team = new Member("member1", 1);
        memberDao.add(team);
        memberDao.update(1, "new_name", "");
        assertEquals("new_name", memberDao.findById(1).getName());
    }

    @Test
    public void delete() {
        Member team = new Member("member1", 1);
        memberDao.add(team);
        memberDao.deleteById(1);
        assertEquals(0, memberDao.getAll().size());
    }

}