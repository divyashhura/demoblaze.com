package Pagefactory;


import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignUpPage;

public class ObjectFactory {
    public static SignUpPage signupobj;
    public static LoginPage logobj;
    public static HomePage homeobj;

    public SignUpPage getsignup(){
        if(signupobj==null){
            signupobj=new SignUpPage();
        }
        return signupobj;
    }
    public LoginPage getlogin()
    {
        if (logobj == null)
        {
            logobj = new LoginPage();
        }
        return logobj;
    }
    public HomePage gethomepage()
    {
        if (homeobj == null)
        {
            homeobj = new HomePage();
        }
        return homeobj;
    }
}