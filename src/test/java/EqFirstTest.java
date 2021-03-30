
import com.codeborne.selenide.Configuration;
import com.easyqa.qa.pages.*;
import com.easyqa.qa.pages.util.CardData;
import com.easyqa.qa.pages.util.PageAddressData;
import com.easyqa.qa.pages.util.UserData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;

public class EqFirstTest {
    PageAddressData pageAddressData = new PageAddressData("https://app.geteasyqa.com/users/sign_in");
    UserData theUser = new UserData("me_se@mail.ru", "123456");
    CardData issue = new CardData("test2", "issue description");

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        browser = "chrome";
        Configuration.browserSize = "1600x1000";

    }

    @Test
    public void loginAsRegisteredUser() {
        LoginPage loginPage = open(pageAddressData.getPageAddress(),LoginPage.class);
        loginPage.enterLogin(theUser.getUserEmail());
        loginPage.enterPassword(theUser.getUserPassword());
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
    }

    @Test
    public void openProjects() {
        LoginPage loginPage = open(pageAddressData.getPageAddress(),LoginPage.class);
        loginPage.enterLogin(theUser.getUserEmail());
        loginPage.enterPassword(theUser.getUserPassword());
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
        ProjectsPage projectsPage = dashboardPage.openMyProjects();
        projectsPage.checkProjectsPage();
    }

    @Test
    public void createCard() {
        //CardData issue = new CardData("test2", "issue description");
        //UserData theUser = new UserData("me_se@mail.ru", "123456");
        //LoginPage loginPage = open("https://app.geteasyqa.com/users/sign_in", LoginPage.class);
        LoginPage loginPage = open(pageAddressData.getPageAddress(),LoginPage.class);
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

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        closeWebDriver();
    }

}