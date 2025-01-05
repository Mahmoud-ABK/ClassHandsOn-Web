package org.tpwebavancee.spring_mvc.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tpwebavancee.spring_mvc.dao.TeamRepository;
import org.tpwebavancee.spring_mvc.entities.Team;

import java.util.List;
import java.util.Optional;

// Indicates that this class serves as a controller in the Spring MVC framework
@Controller
public class TeamController {

    // Injects the TeamRepository dependency into the controller
    @Autowired
    private TeamRepository teamDao;

    // Before example code
    // Maps HTTP requests with the "/teams/search" URL to this method
//    @RequestMapping(value = "/teams/search")
//    public String search() {
//        // Returns the name of the view to be rendered (e.g., "myteams.html" or "myteams.jsp")
//        return "myteams";
//    }
    //First example code


    /**
     * Handles HTTP GET requests for "/teams/search".
     * Retrieves all teams from the database and adds them to the model.
     *
     * @param model The model object used to pass data to the view.
     * @return The name of the view to be rendered ("myteams").
     */
    /*@RequestMapping(value = "/teams/search")
    public String search(Model model) {
        // Fetches all teams from the database using the repository
        List<Team> teams = teamDao.findAll();

        // Adds the list of teams to the model for use in the view
        model.addAttribute("teams", teams);

        // Returns the logical name of the view (e.g., resolves to myteams.html or myteams.jsp)
        return "myteams";
    }*/
    @RequestMapping(value = "/teams/search")
    // Maps HTTP requests with the URL "/teams/search" to this method.
    public String search(Model model,
                         @RequestParam(name = "motCle", defaultValue = "") String mc) {
        // The "motCle" request parameter is extracted from the HTTP request.
        // If it is not provided, it defaults to an empty string ("").

        List<Team> teams = teamDao.findByName("%" + mc + "%");
        // Uses the `findByName` method from `teamDao` to retrieve a list of teams
        // whose names contain the substring specified in "motCle" (mc).
        // The "%" wildcard is used for pattern matching in SQL (like in a `LIKE` query).

        model.addAttribute("teams", teams);
        // Adds the list of teams to the `Model` object, making it accessible
        // to the view (JSP page) under the attribute name "teams".

        model.addAttribute("motCle", mc);
        // Adds the search keyword ("motCle") to the `Model` object, so it can
        // be displayed back to the user in the search input field on the JSP page.

        return "myteams";
        // Returns the name of the JSP page ("myteams") that should be rendered
        // as the response. The model data will be used by the JSP to display the results.
    }

    //    more action code
    @RequestMapping(value = "/teams/add")
// Maps HTTP requests with the URL "/teams/add" to this method.
    public String add(Model model,
                      @RequestParam(name = "name", defaultValue = "") String name,
                      @RequestParam(name = "budget", defaultValue = "0") float budget) {
        // Extracts "name" and "budget" parameters from the request.
        // Defaults to an empty string for "name" and 0 for "budget" if not provided.

        if (!(name.equals(""))) {
            // Checks if the "name" parameter is not empty.

            model.addAttribute("name", name);
            // Adds the "name" to the model to make it available to the view.

            model.addAttribute("budget", budget);
            // Adds the "budget" to the model to make it available to the view.

            Team t = new Team(name, budget);
            // Creates a new `Team` object with the provided "name" and "budget".

            teamDao.save(t);
            // Saves the newly created team to the database using `teamDao`.
        }
        // personal adding to check adding
        List<Team> teams = teamDao.findAll();
        model.addAttribute("teams", teams);

        return "addTeam";
        // Returns the view name "addTeam", which is the JSP file to render the response.
    }

    @RequestMapping(value = "/teams/delete")
// Maps HTTP requests with the URL "/teams/delete" to this method.

    public String delete(Model model,
                         @RequestParam(name = "ref", defaultValue = "") Long idTeam,
                         @RequestParam(name = "mc", defaultValue = "") String mc) {
        // Retrieves the "ref" (team ID) and "mc" (search keyword) parameters from the request.

        teamDao.deleteById(idTeam);
        // Deletes the team with the given ID from the database.

        return "redirect:/teams/search?motCle=" + mc;
        // Redirects the user to the search page, keeping the search keyword ("mc") in the URL.
    }
    @RequestMapping(value="/teams/edit")
// Maps HTTP requests with the URL "/teams/edit" to this method.

    public String edit(Model model,
                       @RequestParam(name="ref", defaultValue="") Long idTeam,
                       // Retrieves the "ref" (team ID) parameter from the request.

                       @RequestParam(name="name", defaultValue="") String name,
                       // Retrieves the "name" parameter from the request.

                       @RequestParam(name="budget", defaultValue="") Float budget,
                       // Retrieves the "budget" parameter from the request.

                       @RequestParam(name="edit", defaultValue="0") int edit,
                       // Retrieves the "edit" parameter from the request, defaulting to 0.

                       @RequestParam(name="mc", defaultValue="") String mc) {
        // Retrieves the "mc" (search keyword) parameter from the request.

        if (edit == 0) {
            // If "edit" is 0, prepare the form for editing a team.

            model.addAttribute("idTeam", idTeam);
            // Add the team ID to the model for the form.

            model.addAttribute("name", name);
            // Add the team name to the model for the form.

            model.addAttribute("budget", budget);
            // Add the team budget to the model for the form.

            model.addAttribute("motCle", mc);
            // Add the search keyword to the model for context.

            return "editTeam";
            // Return the "editTeam" view to display the form.
        } else {
            // If "edit" is not 0, update the team details.

            Optional<Team> ot = teamDao.findById(idTeam);
            // Retrieve the team by its ID from the database.This returns an Optional.

            Team t = ot.get();
            // Get the Team object from the Optional.

            t.setName(name);
            // Update the team's name.

            t.setBudget(budget);
            // Update the team's budget.

            teamDao.save(t);
            // Save the updated team back to the database.

            return "redirect:/teams/search?motCle=" + mc;
            // Redirect the user to the search page, keeping the search keyword.
        }
    }



}
