package com.hrms.testcases;

import com.hrms.pages.DashboardPage;
import com.hrms.pages.LoginPage;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import org.testng.annotations.Test;

public class LoginTest extends CommonMethods {

    @Test(priority = 0)
    public void adminLogin() {
        LoginPage login = new LoginPage();
        sendText(login.usernameBox, ConfigsReader.getPropertyValue("username"));
        sendText(login.passwordBox, ConfigsReader.getPropertyValue("password"));
        click(login.loginBtn);

        DashboardPage dashboardPage = new DashboardPage();
        String welcomeText=dashboardPage.welcomeMessage.getText();
        System.out.println(welcomeText);


    }


}


