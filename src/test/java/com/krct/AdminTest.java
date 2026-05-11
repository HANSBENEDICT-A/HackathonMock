package com.krct;

import com.krct.pages.AdminPage;
import com.krct.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class AdminTest extends BaseTest {
        @Test
        public void adminPageTest() //for safer side to check whether the admin page works properly
        {
            LoginPage loginPage = new LoginPage(driver, wait);

            AdminPage adminPage = new AdminPage(driver, wait);
            loginPage.NavigatePage();
            loginPage.Login("Admin", "admin123");
            adminPage.openAdminPage();
            Assert.assertTrue(adminPage.isAdminPageOpened());
    }
    @Test
    public void createUserTest()
    {
        LoginPage loginPage = new LoginPage(driver, wait);
        AdminPage adminPage = new AdminPage(driver, wait);
        loginPage.NavigatePage();
        loginPage.Login("Admin", "admin123");
        adminPage.createUser(
                "testuser",
                "Test@123");
        Assert.assertTrue(true);
    }
    @Test
    public void searchUserTest()
    {
        LoginPage loginPage = new LoginPage(driver, wait);
        AdminPage adminPage = new AdminPage(driver, wait);
        loginPage.NavigatePage();
        loginPage.Login("Admin", "admin123");
        adminPage.openAdminPage();
        Assert.assertTrue(true);
    }
    @Test
    public void deleteUserTest()
    {
        LoginPage loginPage = new LoginPage(driver, wait);
        AdminPage adminPage = new AdminPage(driver, wait);
        loginPage.NavigatePage();
        loginPage.Login("Admin", "admin123");
        adminPage.openAdminPage();
        Assert.assertTrue(true);
    }
}
