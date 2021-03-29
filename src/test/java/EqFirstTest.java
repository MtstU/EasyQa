
import com.codeborne.selenide.Configuration;
import com.easyqa.qa.pages.*;
import org.testng.annotations.AfterClass;
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
/*
    @Test
    public void loginAsRegisteredUser() {
        LoginPage loginPage = open("https://app.geteasyqa.com/users/sign_in",LoginPage.class);
        loginPage.enterLogin("me_se@mail.ru");
        loginPage.enterPassword("123456");
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
    }

    @Test
    public void openProjects() {
        LoginPage loginPage = open("https://app.geteasyqa.com/users/sign_in",LoginPage.class);
        loginPage.enterLogin("me_se@mail.ru");
        loginPage.enterPassword("123456");
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
        ProjectsPage projectsPage = dashboardPage.openMyProjects();
        projectsPage.checkProjectsPage();
    }
*/
    @Test
    public void createCard() {
        LoginPage loginPage = open("https://app.geteasyqa.com/users/sign_in", LoginPage.class);
        loginPage.enterLogin("me_se@mail.ru");
        loginPage.enterPassword("123456");
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
        ProjectsPage projectsPage = dashboardPage.openMyProjects();
        projectsPage.checkProjectsPage();
        ProjectDashboardPage projectDashboardPage = projectsPage.openProject();
        projectDashboardPage.checkProjectDashboardPage();
        IssuesPage issuesPage = projectDashboardPage.openIssues();
        issuesPage.checkIssuesPage();
        issuesPage.clickAddNewIssue();
        issuesPage.AddNewIssue("test1", "issue description");
        issuesPage.checkIssueAdded("test1");

    }

    @AfterMethod
    public void tearDown() {
        closeWebDriver();
    }

}