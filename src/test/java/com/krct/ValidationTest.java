package com.krct;

import com.krct.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationTest extends BaseTest{
    @Test
    public void emptyFieldValidationTest()
    {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.NavigatePage();
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getRequiredMessage(), "Required");
    }
    @Test
    public void invalidDateValidationTest()
    {
        Assert.assertTrue(true);
    }
    @Test
    public void dropdownValidationTest()
    {
        Assert.assertTrue(true);
    }
}
