package pagedriver;


import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;

public class PageDriver extends BaseTest {

    private LoginPage loginPage = null;

    private HomePage homePage = null;

    public LoginPage loginPage(){
        if(null==loginPage){
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public HomePage homePage(){
        if(null==homePage){
            homePage = new HomePage();
        }
        return homePage;
    }
}
