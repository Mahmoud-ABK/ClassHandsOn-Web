package org.horizonefele;

import dao.ITeamDao;
import org.horizonefele.entities.Team;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Handon1Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Handon1Application.class, args);

        // Access the TeamDao bean from the Spring context
        ITeamDao teamDao = ctx.getBean(ITeamDao.class);

        // Save new Team entities
        teamDao.save(new Team("Avenir Sportif de Lala"));
        teamDao.save(new Team("Club Olympique de Transport"));
        teamDao.save(new Team("Stir Sportif Jarzouna"));

        // Retrieve and print all teams with 'sportif' in their name
        List<Team> teams = teamDao.findAll();
        for (Team t : teams) {
            System.out.println("Team: " + t.getName());
        }
    }
}

