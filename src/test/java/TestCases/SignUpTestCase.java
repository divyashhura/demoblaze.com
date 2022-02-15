package TestCases;

import Pages.Base;
import Pages.SignUpPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.io.IOException;

public class SignUpTestCase extends Base {
    SignUpPage signupobj;

    @BeforeSuite
    void launchBrowser(){
        launch();
        signupobj=new SignUpPage();
    }
    @Test
    void userSignUp() throws IOException {
       signupobj.enterDetails();
    }
    @AfterSuite
    void closeBrowser(){
        driver.close();
    }
}