import models.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

//        //initial teams to see how it looks
//        Team team1 = new Team("Trojan Horses", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
//        Team team2 = new Team("Did It All for the Cookies", "Non sodales neque sodales ut etiam sit amet nisl purus.");
//        Team team3 = new Team("Reboot Rebels", "Volutpat consequat mauris nunc congue nisi vitae.");
//        Team team4 = new Team("Cyber Creepers", "Felis eget nunc lobortis mattis aliquam faucibus.");
//
////        team1.addMember("Mike");
////        team1.addMember("Jane");
////        team1.addMember("Chris");
//
//        staticFileLocation("/public");
//
//        //home page with details
//        get("/", (req, res) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//
//            return new ModelAndView(model, "index.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        //list of teams
//        get("/teams", (req, res) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//
//            model.put("teams", Team.getInstances());
//
//            return new ModelAndView(model, "teams.hbs");
//        }, new HandlebarsTemplateEngine());
//
//
//        //add team
//        get("/add_team", (req, res) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//            return new ModelAndView(model, "add_team.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        post("/add_team", (req, res) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//
//            Team team = new Team(req.queryParams("name"), req.queryParams("description"));
//            model.put("team", team);
//
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());
//
//
//        //update team
//        get("/teams/update/:id", (req, res) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//
//            Team team = Team.findById(Integer.parseInt(req.params("id")));
//            model.put("team", team);
//
//            return new ModelAndView(model, "update_team.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        post("/teams/update/:id", (req, res) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//
//            Team team = Team.findById(Integer.parseInt(req.params("id")));
//            team.updateTeam(req.queryParams("newName"));
//            model.put("team", team);
//
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        //add team member
//        get("/teams/add_member/:id", (req, res) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//
//            Team team = Team.findById(Integer.parseInt(req.params("id")));
//            model.put("team", team);
//
//            return new ModelAndView(model, "add_member.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        post("teams/add_member/:id", (req, res) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//
//
//            Team team = Team.findById(Integer.parseInt(req.params("id")));
//            team.addMember(req.queryParams("memberName"));
//
//            model.put("team", team);
//
//            return new ModelAndView(model, "success2.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        //each team's details
//        get("/teams/:id", (req, res) -> {
//            Map<String, Object> model = new HashMap<String, Object>();
//
//            model.put("team", Team.findById(Integer.parseInt(req.params("id"))));
//
//            return new ModelAndView(model, "team.hbs");
//        }, new HandlebarsTemplateEngine());
    }
}
