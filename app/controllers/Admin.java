package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Member;
import models.Trainer;
import models.Assessment;
import play.Logger;
import play.mvc.Controller;

public class Admin extends Controller
{
    public static void index() {
        Logger.info("Rendering Dashboard");
        Member trainer = Accounts.getLoggedInMember();
        List<Trainer> members = Trainer.findAll();
        render ("dashboard.html",members);
    }
    public static void addMembers(String name, int age, String email, String password, String address, String gender, double height, double weight, double bmi, String bmiresult) {
        Member member = new Member(name, age, email, password, address, gender, height, weight, bmi, bmiresult);
        Logger.info("Adding a new member called " + name + "Age:" + age);

        member.save();
        redirect("/dashboard");
    }

    public static void deleteMember(Long id) {
        Member member = Member.findById(id);
        Logger.info("Removing" + member.name);
        member.delete();
        redirect("/dashboard");
    }

}