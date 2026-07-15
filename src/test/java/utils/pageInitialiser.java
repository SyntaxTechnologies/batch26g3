package utils;

import pages.AddEmployeePage;
import pages.EditContactDetailsPage;
import pages.EmployeeSearchPage;
import pages.CreateEmployeeLoginPage;
import pages.LoginPage;

public class pageInitialiser {

    public static LoginPage loginPage;
    public  static CreateEmployeeLoginPage createEmployeeLoginPage;
    public static AddEmployeePage addEmployeePage;
    public static EditContactDetailsPage editContactDetailsPage;
    public static EmployeeSearchPage employeeSearchPage;

    public static void initilizePageObjects() {
        loginPage = new LoginPage();
        addEmployeePage=new AddEmployeePage();
        editContactDetailsPage=new EditContactDetailsPage();
        employeeSearchPage = new EmployeeSearchPage();
        createEmployeeLoginPage = new CreateEmployeeLoginPage();
    }
}
