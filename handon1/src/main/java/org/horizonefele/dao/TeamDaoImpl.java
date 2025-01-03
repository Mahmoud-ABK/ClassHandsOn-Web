package org.horizonefele.dao;

import dao.ITeam;
import dao.ITeamDao;
import org.horizonefele.entities.Team;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.*;
import java.util.List;

@Repository  // Marks the class as a Spring Data Access Object (DAO)
@Transactional  // Ensures that methods in this class are executed within a transactional context
public class TeamDaoImpl implements ITeamDao {

    @PersistenceContext  // Injects the EntityManager for database interactions
    private EntityManager entityManager;

    // Saves a new Team entity to the database
    @Override
    public void save(Team t) {
        entityManager.persist(t);  // Persist the Team entity to the database
    }

    // Retrieves a Team entity by its ID
    @Override
    public Team findOne(Long idTeam) {
        return entityManager.find(Team.class, idTeam);  // Finds and returns the Team by its primary key (idTeam)
    }

    // Retrieves all Team entities from the database
    @Override
    public List<Team> findAll() {
        // Creates a JPQL query to select all Team entities
        Query query = entityManager.createQuery("SELECT t FROM Team t");
        return query.getResultList();  // Executes the query and returns the result as a List of Teams
    }

    // Retrieves all Team entities that match the given name (case-insensitive)
    @Override
    public List<Team> findByName(String name) {
        // Creates a JPQL query to find Teams with names that match the given pattern
        Query query = entityManager.createQuery("SELECT t FROM Team t WHERE t.name LIKE :name");
        query.setParameter("name", "%" + name + "%");  // Sets the 'name' parameter with the like pattern
        return query.getResultList();  // Executes the query and returns the result as a List of Teams
    }

    // Deletes a Team entity by its ID if it exists
    @Override
    public void remove(Long idTeam) {
        Team t = entityManager.find(Team.class, idTeam);  // Finds the Team by its ID
        if (t != null) {
            entityManager.remove(t);  // Removes the Team entity fsrom the database
        }
    }

    // Updates an existing Team entity in the database
    @Override
    public void update(Team t) {
        entityManager.merge(t);  // Merges the Team entity to update it in the database
    }


}
