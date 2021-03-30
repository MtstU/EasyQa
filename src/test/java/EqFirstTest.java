
import com.codeborne.selenide.Configuration;
import com.easyqa.qa.pages.*;
import com.easyqa.qa.pages.util.CardData;
import com.easyqa.qa.pages.util.UserData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;

public class EqFirstTest {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        //browserCapabilities.setAcceptInsecureCerts(true);
        browser = "chrome";
        Configuration.browserSize = "1600x1000";
    }

    @Test
    public void loginAsRegisteredUser() {
        UserData theUser = new UserData("me_se@mail.ru", "123456");
        LoginPage loginPage = open("https://app.geteasyqa.com/users/sign_in",LoginPage.class);
        loginPage.enterLogin(theUser.getUserEmail());
        loginPage.enterPassword(theUser.getUserPassword());
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
    }

    @Test
    public void openProjects() {
        UserData theUser = new UserData("me_se@mail.ru", "123456");
        LoginPage loginPage = open("https://app.geteasyqa.com/users/sign_in",LoginPage.class);
        loginPage.enterLogin(theUser.getUserEmail());
        loginPage.enterPassword(theUser.getUserPassword());
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
        ProjectsPage projectsPage = dashboardPage.openMyProjects();
        projectsPage.checkProjectsPage();
    }

    @Test
    public void createCard() {
        CardData issue = new CardData("test2", "issue description");
        UserData theUser = new UserData("me_se@mail.ru", "123456");
        LoginPage loginPage = open("https://app.geteasyqa.com/users/sign_in", LoginPage.class);
        loginPage.enterLogin(theUser.getUserEmail());
        loginPage.enterPassword(theUser.getUserPassword());
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
        ProjectsPage projectsPage = dashboardPage.openMyProjects();
        projectsPage.checkProjectsPage();
        ProjectDashboardPage projectDashboardPage = projectsPage.openProject();
        projectDashboardPage.checkProjectDashboardPage();
        IssuesPage issuesPage = projectDashboardPage.openIssues();
        issuesPage.checkIssuesPage();
        issuesPage.clickAddNewIssue();
        issuesPage.AddNewIssue(issue.getCardName(), issue.getCardDescription());
        issuesPage.checkIssueAdded(issue.getCardName());

    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }

}