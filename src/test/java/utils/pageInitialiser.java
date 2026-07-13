package utils;

import pages.LoginPage;

public class pageInitialiser {

    public static LoginPage loginPage;

    public static void initilizePageObjects() {
        loginPage = new LoginPage();
    }
}
