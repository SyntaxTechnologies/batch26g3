package utils;

import pages.*;

public class pageInitialiser {

    public static LoginPage loginPage;
    public  static CreateEmployeeLoginPage createEmployeeLoginPage;
    public static AddEmployeePage addEmployeePage;
    public static EditContactDetailsPage editContactDetailsPage;
    public static EmployeeSearchPage employeeSearchPage;
    public static EditPersonalDetailsPage editPersonalDetailsPage;
    public static addDependentsPage addDependentsPage;
    public static profilePicUploadPage profilePicUploadPage;

    public static void initilizePageObjects() {

        loginPage = new LoginPage();
        addEmployeePage=new AddEmployeePage();
        editContactDetailsPage=new EditContactDetailsPage();
        employeeSearchPage = new EmployeeSearchPage();
        createEmployeeLoginPage = new CreateEmployeeLoginPage();
        editPersonalDetailsPage = new EditPersonalDetailsPage();
        addDependentsPage= new addDependentsPage();
        profilePicUploadPage = new profilePicUploadPage();


    }


}
