package dao;

//import models.Team;
import models.Member;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oMemberDao implements MemberDao{

    private final Sql2o sql2o;

    public Sql2oMemberDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Member member){
        String sql = "INSERT INTO members (name, dateOfBirth, teamId) VALUES (:name, :dateOfBirth, :teamId)";
        try (Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql)
                    .bind(member)
                    .executeUpdate()
                    .getKey();
            member.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public Member findById(int id){
        String sql = "SELECT * FROM members WHERE id = :id";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Member.class);
        }
    }

    @Override
    public List<Member> getAll(){
        String sql = "SELECT * FROM members";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Member.class);
        }
    }

    @Override
    public List<Member> getAllByTeam(int teamId){
        String sql = "SELECT * FROM members WHERE teamId = :teamId";
        try (Connection con = sql2o.open()){
            return con.createQuery(sql)
                    .addParameter("teamId", teamId)
                    .executeAndFetch(Member.class);
        }
    }

    @Override
    public void update(int id, String name, String dateOfBirth){
        String sql = "UPDATE members SET name = :name, dateOfBirth = :dateOfBirth WHERE id=:id";

        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", name)
                    .addParameter("dateOfBirth", dateOfBirth)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id){
        String sql = "DELETE FROM members WHERE id = :id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
