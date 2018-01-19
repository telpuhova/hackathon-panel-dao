import dao.Sql2oMemberDao;
import dao.Sql2oTeamDao;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        //initial teams to see how it looks
        Team team1 = new Team("Trojan Horses", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.");
        Team team2 = new Team("Did It All for the Cookies", "Non sodales neque sodales ut etiam sit amet nisl purus.");
        Team team3 = new Team("Reboot Rebels", "Volutpat consequat mauris nunc congue nisi vitae.");
        Team team4 = new Team("Cyber Creepers", "Felis eget nunc lobortis mattis aliquam faucibus.");

        staticFileLocation("/public");

        String connectionString = "jdbc:h2:~/standup3.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");

        Sql2oTeamDao teamDao = new Sql2oTeamDao(sql2o);
        Sql2oMemberDao memberDao = new Sql2oMemberDao(sql2o);

        //home page with details
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //list of teams
        get("/teams", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            model.put("teams", teamDao.getAll());

            return new ModelAndView(model, "teams.hbs");
        }, new HandlebarsTemplateEngine());


        //add team
        get("/add_team", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "add_team.hbs");
        }, new HandlebarsTemplateEngine());


        post("/add_team", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            Team team = new Team(req.queryParams("name"), req.queryParams("description"));
            teamDao.add(team);
//            model.put("team", team);

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        //update team
        get("/teams/update/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            Team team = teamDao.findById(Integer.parseInt(req.params("id")));
            model.put("team", team);

            return new ModelAndView(model, "update_team.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/update/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            Team team = teamDao.findById(Integer.parseInt(req.params("id")));
            teamDao.update(Integer.parseInt(req.params("id")), req.queryParams("newName"));
            model.put("team", team);

            return new ModelAndView(model, "success2.hbs");
        }, new HandlebarsTemplateEngine());

        //add team member
        get("/teams/add_member/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            Team team = teamDao.findById(Integer.parseInt(req.params("id")));
            model.put("team", team);

            return new ModelAndView(model, "add_member.hbs");
        }, new HandlebarsTemplateEngine());

        post("teams/add_member/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            int teamId = Integer.parseInt(req.params("id"));
            Team team = teamDao.findById(teamId);
            Member member = new Member(req.queryParams("memberName"), req.queryParams("dateOfBirth"), teamId);
            memberDao.add(member);

            model.put("team", team);

            return new ModelAndView(model, "success2.hbs");
        }, new HandlebarsTemplateEngine());

        //each team's details
        get("/teams/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            int teamId = Integer.parseInt(req.params("id"));
            model.put("members", memberDao.getAllByTeam(teamId));
            model.put("team", teamDao.findById(teamId));

            return new ModelAndView(model, "team.hbs");
        }, new HandlebarsTemplateEngine());

        get("/member/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            int memberId = Integer.parseInt(req.params("id"));
            Member member = memberDao.findById(memberId);
            model.put("member", member);
            model.put("team", teamDao.findById(member.getTeamId()));

            return new ModelAndView(model, "member.hbs");
        }, new HandlebarsTemplateEngine());

        get("/member/update/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            Member member = memberDao.findById(Integer.parseInt(req.params("id")));
            model.put("member", member);

            return new ModelAndView(model, "update_member.hbs");
        }, new HandlebarsTemplateEngine());

        post("/member/update/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            Member member = memberDao.findById(Integer.parseInt(req.params("id")));
            memberDao.update(Integer.parseInt(req.params("id")), req.queryParams("name"), req.queryParams("dateOfBirth"));
            model.put("member", member);

            Team team = teamDao.findById(member.getTeamId());
            model.put("team", team);

            return new ModelAndView(model, "success2.hbs");
        }, new HandlebarsTemplateEngine());

        get("/member/delete/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            Member member = memberDao.findById(Integer.parseInt(req.params("id")));
            memberDao.deleteById(Integer.parseInt(req.params("id")));
//            model.put("member", member);

            Team team = teamDao.findById(member.getTeamId());
            model.put("team", team);

            return new ModelAndView(model, "success2.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/delete/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            int teamId = Integer.parseInt(req.params("id"));

//            List<Member> members = memberDao.getAllByTeam(teamId);
//            for (int i = 0; i<members.size(); i++){
//                int j = members.get(i).getId();
//                memberDao.deleteById(j);
//            }
            teamDao.deleteById(teamId);

            Team team = teamDao.findById(teamId);
            model.put("team", team);

            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
