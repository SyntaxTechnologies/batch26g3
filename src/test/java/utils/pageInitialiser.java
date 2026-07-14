package utils;

import pages.CreateEmployeeLoginPage;
import pages.LoginPage;

public class pageInitialiser {

    public static LoginPage loginPage;
    public  static CreateEmployeeLoginPage createEmployeeLoginPage;

    public static void initilizePageObjects() {
        loginPage = new LoginPage();
        createEmployeeLoginPage = new CreateEmployeeLoginPage();
    }
}
