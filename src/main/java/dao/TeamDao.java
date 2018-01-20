package dao;

import models.Team;

import java.util.List;

public interface TeamDao {
    void add(Team team);

    Team findById(int id);

    List<Team> getAll();

    void update(int id, String name);

    void deleteById(int id);
}
