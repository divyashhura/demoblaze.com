package TestCases;

import Pages.Base;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Test;
import java.io.IOException;

public class LoginTestCase extends Base {
    LoginPage loginobj;

    @Test
    void login() throws IOException, InterruptedException {
       loginobj=new LoginPage();
       loginobj.loginPage();
    }
}
