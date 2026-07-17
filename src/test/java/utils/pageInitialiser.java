package utils;

import pages.*;

public class pageInitialiser {

    public static LoginPage loginPage;
    public static AddEmployeePage addEmployeePage;
    public static EditContactDetailsPage editContactDetailsPage;
    public static EmployeeSearchPage employeeSearchPage;
    public static addDependentsPage addDependentsPage;
    public static profilePicUploadPage profilePicUploadPage;


    public static void initializePageObjects() {

        loginPage = new LoginPage();
        addEmployeePage=new AddEmployeePage();
        editContactDetailsPage=new EditContactDetailsPage();
        employeeSearchPage = new EmployeeSearchPage();
        addDependentsPage= new addDependentsPage();
        profilePicUploadPage = new profilePicUploadPage();


    }


}
