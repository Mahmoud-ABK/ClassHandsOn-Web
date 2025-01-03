package org.tpwebavancee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tpwebavancee.entities.Team;

import java.util.List;

// Define an interface for the Team repository, extending JpaRepository
public interface TeamRepository extends JpaRepository<Team, Long> {

    // Define a custom query using the @Query annotation
    // This query retrieves teams from the 'Team' entity where the name matches a given pattern.
    // The ':x' is a placeholder for the parameter that will be passed into the query.
    @Query("SELECT t FROM Team t WHERE t.name LIKE :x")
    List<Team> getTeamsByName(@Param("x") String name); // This method takes a string 'name' as a parameter

    // Note: The rest of the CRUD functions (like save, findAll, delete, etc.) are automatically handled
    // by Spring Data JPA because JpaRepository provides these methods out of the box.
}