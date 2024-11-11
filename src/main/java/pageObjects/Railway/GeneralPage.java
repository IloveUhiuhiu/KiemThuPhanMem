package pageObjects.Railway;

import Common.common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import Common.Constant.Constant;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GeneralPage {
    //Locators

    private final By tabLogin = By.xpath ("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath ("//div[@id='menu']//a[@href='/Account/Logout.cshtml']");
    private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By IblWelcomMessage = By.xpath("//div[@class='account']/strong");
    private final By tabTimetable = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabRegister = By.xpath ("//div[@id='menu']//a[@href='/Account/Register.cshtml']");

    protected WebElement getTabLogin() {
        return Utilities.waitForElementToBeClickable(tabLogin);
    }

    protected WebElement getTabRegister() {
        return Utilities.waitForElementToBeClickable(tabRegister);
    }

    protected WebElement getTabBookTicket() {
        return Utilities.waitForElementToBeClickable(tabBookTicket);
    }

    protected WebElement getTabMyTicket() {
        return Utilities.waitForElementToBeClickable(tabMyTicket);
    }

    protected WebElement getTabTimetable() {
        return Utilities.waitForElementToBeClickable(tabTimetable);
    }

    protected WebElement getTabChangePassword() {
        return Utilities.waitForElementToBeClickable(tabChangePassword);
    }
    public boolean isMyTicketTabDisplayed() {
        return getTabMyTicket().isDisplayed();
    }

    // Hàm kiểm tra tab "Change password" có hiển thị không
    public boolean isChangePasswordTabDisplayed() {
        return getTabChangePassword().isDisplayed();
    }

    protected WebElement getTabLogout () {
        return Utilities.waitForElementToBeClickable(tabLogout);
    }
    protected WebElement getLblWelcomeMessage() {
        return Utilities.waitForElementToBeVisible(IblWelcomMessage);
    }

    public LoginPage gotoLoginPage()
    {
        getTabLogin().click();
        return new LoginPage ();
    }
    public BookTicketPage gotoBookTicketPage()
    {
        getTabBookTicket().click();
        return new BookTicketPage();
    }
    public RegisterPage gotoRegisterPage(){
        getTabRegister().click();
        return new RegisterPage();
    }
    public MyTicketPage gotoMyTicketPage() {
        getTabMyTicket().click();
        return new MyTicketPage();
    }
    public ChangePasswordPage gotoChangePasswordPage() {
        getTabChangePassword().click();
        return new ChangePasswordPage();
    }
    public TimetablePage gotoTimetablePage() {
        getTabTimetable().click();
        return new TimetablePage();
    }
    public String getWelcomeMessage() {
        return getLblWelcomeMessage().getText().trim();
    }
    public String getCurrentUrl() {
        return Constant.WEBDRIVER.getCurrentUrl();
    }
    public void goBack() {
        Constant.WEBDRIVER.navigate().back();
    }
}