package controllers;

import java.util.ArrayList;
import java.util.List;
import models.Member;
import models.Trainer;
import models.Assessment;
import play.Logger;
import play.mvc.Controller;

public class AddComment extends Controller {

    public static void index() {
        Logger.info("Rendering Dashboard");
        Member member = Accounts.getLoggedInMember();
        member.getBMI();
        member.bmiAnalytics();
        //member.isIdealBodyWeight();
        List<Assessment> assessments = member.assessments;
        render("dashboard.html", member, assessments);

    }
    public static void addComment(String comment, Long id, Long assessmentid)
    {
        Logger.info("Adding a Comment");
        Assessment assessment = Assessment.findById(id);
        assessment.comment = comment;
        assessment.save();
        Trainer trainer = Accounts.getLoggedInTrainer();
        Member member = Member.findById(id);
        List<Assessment> assessments = member.assessments;
        render("trainermemberdashboard.html", trainer, member, assessments);
    }
}