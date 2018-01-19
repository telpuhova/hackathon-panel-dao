package dao;

import models.Member;

import java.util.List;

public interface MemberDao {
    void add(Member team);

    Member findById(int id);

    List<Member> getAll();

    List<Member> getAllByTeam(int teamId);
}
