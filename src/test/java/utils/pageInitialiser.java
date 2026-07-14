package utils;

import pages.EmployeeSearchPage;
import pages.LoginPage;

public class pageInitialiser {

    public static LoginPage loginPage;
    public static EmployeeSearchPage employeeSearchPage;

    public static void initilizePageObjects() {
        loginPage = new LoginPage();
        employeeSearchPage = new EmployeeSearchPage();
    }


}
