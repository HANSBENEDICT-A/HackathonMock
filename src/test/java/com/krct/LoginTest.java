package com.krct;

import com.krct.pages.LoginPage;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;


public class LoginTest extends BaseTest {

    @DataProvider
    public Object[][] loginData() throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader("src/test/Details/details"));
        return csvReader.readAll().toArray(Object[][]::new);
    }

    @Test(dataProvider = "loginData")
    public void LoginTest(String username, String password)
    {
        LoginPage loginPage = new LoginPage(driver,wait);
        loginPage.NavigatePage();
        loginPage.Login(username,password);
        
    }
}
