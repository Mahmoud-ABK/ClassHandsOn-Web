package org.tpwebavancee.spring_mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.tpwebavancee.spring_mvc.entities.Team;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
//    this is for the 2nd example
    @Query("select t from Team t where t.name like :x")
    public List<Team> findByName(@Param("x") String mc);
}
