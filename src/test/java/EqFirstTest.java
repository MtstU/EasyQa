
import com.codeborne.selenide.Configuration;
import com.easyqa.qa.pages.DashboardPage;
import com.easyqa.qa.pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class EqFirstTest {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        //browserCapabilities.setAcceptInsecureCerts(true);
        Configuration.browser = "chrome";
        Configuration.browserSize = "1600x1000";

    }

    @Test
    public void testEqFirstTest() {
        LoginPage loginPage = open("https://app.geteasyqa.com/users/sign_in",LoginPage.class);
        loginPage.enterLogin("me_se@mail.ru");
        loginPage.enterPassword("123456");
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        //close();
    }

}