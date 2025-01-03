package org.tpwebavancee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.tpwebavancee.dao.PlayerRepository;
import org.tpwebavancee.dao.TeamRepository;
import org.tpwebavancee.entities.Player;
import org.tpwebavancee.entities.Team;

import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        // Initialize the Spring application context to run the application
        ApplicationContext ctx = SpringApplication.run(Main.class, args);

        // Retrieve the TeamRepository and PlayerRepository beans from the application context
        TeamRepository teamDao = ctx.getBean(TeamRepository.class);
        PlayerRepository playerDao = ctx.getBean(PlayerRepository.class);

        // Create new Team objects
        Team t1 = new Team("Avenir Sportif de Lala");  // Team 1
        Team t2 = new Team("Club Olympique de Transport");  // Team 2
        Team t3 = new Team("Stir Sportif Jarzouna");  // Team 3

        // Save the created teams to the database using the teamDao (repository)
        teamDao.save(t1);
        teamDao.save(t2);
        teamDao.save(t3);

        // Create new Player objects and associate them with the teams
        playerDao.save(new Player("Tarek Dhieb", t1));  // Player 1 associated with team t1
        playerDao.save(new Player("Zoubeir Baya", t2));  // Player 2 associated with team t2
        playerDao.save(new Player("Hamadi Agrbi", t3));  // Player 3 associated with team t3

        // Query the database for teams whose names contain the word "sportif"
        List<Team> teams = teamDao.getTeamsByName("%sportif%");

        // Iterate over the list of teams and print their names to the console
        for (Team t : teams) {
            System.out.println("Team : " + t.getName());
        }
}
}
