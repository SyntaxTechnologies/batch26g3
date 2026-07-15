package utils;

import pages.AddEmployeePage;
import pages.EditContactDetailsPage;
import pages.LoginPage;

public class pageInitialiser {

    public static LoginPage loginPage;
    public static AddEmployeePage addEmployeePage;
    public static EditContactDetailsPage editContactDetailsPage;

    public static void initilizePageObjects() {

        loginPage = new LoginPage();
        addEmployeePage=new AddEmployeePage();
        editContactDetailsPage=new EditContactDetailsPage();
    }
}
