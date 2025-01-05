package org.tpwebavancee.spring_mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.tpwebavancee.spring_mvc.dao.TeamRepository;
import org.tpwebavancee.spring_mvc.entities.Team;

@SpringBootApplication
public class SpringMvcApplication  {

    public static void main(String[] args) {
        // Launch the Spring Boot application
        ApplicationContext ctx = SpringApplication.run(SpringMvcApplication.class, args);

        // Get the TeamRepository bean
       TeamRepository teamDao = ctx.getBean(TeamRepository.class);

        // Save teams to the database
        teamDao.save(new Team("Avenir Sportif de Lala", 45000f));
        teamDao.save(new Team("Club Olympique de Transport", 60000f));
        teamDao.save(new Team("Stir Sportif Jarzouna", 40000f));
        // Add other teams as needed

        // Retrieve and print all team names
        teamDao.findAll().forEach(t -> System.out.println(t.getName()));

    }


}
