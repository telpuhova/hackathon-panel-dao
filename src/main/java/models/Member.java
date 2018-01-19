package models;

import java.util.Objects;

public class Member {

    private int id;
    private String name;
    private String dateOfBirth;
    private int teamId;

    public Member(String name, int teamId) {
        this.name = name;
        this.teamId = teamId;
    }

    public Member(String name, String dateOfBirth, int teamId) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.teamId = teamId;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return teamId == member.teamId &&
                Objects.equals(name, member.name) &&
                Objects.equals(dateOfBirth, member.dateOfBirth);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, dateOfBirth, teamId);
    }
}
