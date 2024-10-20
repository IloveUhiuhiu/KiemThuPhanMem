package pageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.Constant.Constant;

public class GeneralPage {
    //Locators
    private final By tabLogin = By.xpath ("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath ("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By IblWelcomMessage = By.xpath ("//div[@class='account']/strong");
    //Element
    protected WebElement getTabLogin (){
        return Constant.WEBDRIVER.findElement(tabLogin);
    }
    protected WebElement getTabLogout () {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getLblWelcomeMessage () {
        return Constant.WEBDRIVER.findElement(IblWelcomMessage);
    }
    //Methods
    public String getWelcomeMessage()
    {
        return this.getLblWelcomeMessage().getText();
    }
    public LoginPage gotoLoginPage()
    {
        this.getTabLogin().click();
        return new LoginPage ();
    }
}
