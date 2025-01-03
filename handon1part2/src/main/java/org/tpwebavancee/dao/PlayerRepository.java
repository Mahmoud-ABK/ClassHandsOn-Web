package org.tpwebavancee.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.tpwebavancee.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
