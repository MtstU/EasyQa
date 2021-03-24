
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    //private boolean acceptNextAlert = true;
    //private final StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        Configuration.browser = "chrome";
    }

    @Test
    public void testLoginPage() throws Exception {
        open("https://app.geteasyqa.com/users/sign_in");
        $(UIMap.login).click();
        $(UIMap.login).clear();
        $(UIMap.login).sendKeys("me_se@mail.ru");

        $(UIMap.password).click();
        $(UIMap.password).clear();
        $(UIMap.password).sendKeys("123456");

        $(UIMap.loginBtn).click();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        //close();
    }

}