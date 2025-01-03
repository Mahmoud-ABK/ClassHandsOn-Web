package dao;

import org.horizonefele.entities.Team;

import java.util.List;

public interface ITeamDao {
    void save(Team team);
    List<Team> findAll();
    List<Team> findByName(String name);
    Team findOne(Long idTeam);
    void update(Team team);
    void remove(Long idTeam);
}