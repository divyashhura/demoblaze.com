package TestCases;

import Pages.Base;
import Pages.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends Base {
    HomePage homePageobj;

    @Test
    void monitor(){
        homePageobj=new HomePage();
        homePageobj.Monitor();
    }
}
