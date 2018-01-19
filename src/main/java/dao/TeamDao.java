package dao;

import models.Member;
import models.Team;

import java.util.List;

public interface TeamDao {
    void add(Team team);

    Team findById(int id);

    List<Team> getAll();
}
