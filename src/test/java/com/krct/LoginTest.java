package com.krct;

import com.krct.pages.LoginPage;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;


public class LoginTest extends BaseTest {

    ConfigReader config =
            new ConfigReader();

    @DataProvider
    public Object[][] loginData() throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader("src/test/Details/details"));
        return csvReader.readAll().toArray(Object[][]::new);
    }

    @Test(dataProvider = "loginData")
    public void LoginTestuser(String username, String password) {
        LoginPage loginPage = new LoginPage(driver, wait);
        driver.get(config.getUrl());
        loginPage.Login(username, password);

        if (password.equals("admin123")) {
            Assert.assertTrue(
                    loginPage.isUserLoggedIn());
        } else {
            Assert.assertEquals(loginPage.isErrorMessageDisplayed(), "Invalid credentials");
        }
    }
    @Test
    public void logoutTest()
    {
        LoginPage loginPage = new LoginPage(driver, wait);
        driver.get(config.getUrl());
        loginPage.Login(config.getUsername(), config.getPassword());
        loginPage.logoutButtonClick();
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @Test
    public void loginTestDummy()
    {
        LoginPage loginPage = new LoginPage(driver, wait);
        driver.get(config.getUrl());
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getRequiredMessage(), "Required");

    }
}
