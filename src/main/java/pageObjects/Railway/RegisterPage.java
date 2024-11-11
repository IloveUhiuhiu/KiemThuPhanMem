package pageObjects.Railway;
import Common.Constant.Constant;
import Common.common.Utilities;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {

    // Locators
    private final By _txtUsername = By.xpath("//input[@id='email']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _txtconfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By _txtPID = By.xpath("//input[@id='pid']"); // Locator cho trường PID
    private final By _btnRegister = By.xpath("//input[@value='Register']");
    private final By _lblConfirmationMsg = By.xpath("//div[@id='content']/p"); // Locator cho thông báo xác nhận
    private final By _lblErrorMsg = By.xpath("//p[@class='message error']");
    private final By _lblPasswordErrorMsg = By.xpath("//label[@for='password' and @class='validation-error']");
    private final By _lblPidErrorMsg = By.xpath("//label[@for='pid' and @class='validation-error']");
    // Elements
    public WebElement getTxtUsername() {
        return Utilities.waitForElementToBeClickable(_txtUsername);
    }

    public WebElement getTxtPassword() {
        return Utilities.waitForElementToBeClickable(_txtPassword);
    }

    public WebElement getTxtConfirmPassword() {
        return Utilities.waitForElementToBeClickable(_txtconfirmPassword);
    }

    public WebElement getTxtPID() {
        return Utilities.waitForElementToBeClickable(_txtPID);
    }

    public WebElement getBtnRegister() {
        return Utilities.waitForElementToBeClickable(_btnRegister);
    }

    public WebElement getLblConfirmationMessage() {
        return Utilities.waitForElementToBeVisible(_lblConfirmationMsg);
    }

    private WebElement getLblErrorMsg() {
        return Utilities.waitForElementToBeVisible(_lblErrorMsg);
    }

    private WebElement getLblPasswordErrorMsg() {
        return Utilities.waitForElementToBeVisible(_lblPasswordErrorMsg);
    }

    private WebElement getLblPidErrorMsg() {
        return Utilities.waitForElementToBeVisible(_lblPidErrorMsg);
    }
    public String getErrorMsg() {
        return getLblErrorMsg().getText();
    }
    public String getPasswordErrorMsg() {
        return getLblPasswordErrorMsg().getText();
    }
    public String getPidErrorMsg() {
        return getLblPidErrorMsg().getText();
    }
    private WebElement getLblConfirmationMsg() {
        return Utilities.waitForElementToBeVisible(_lblConfirmationMsg);
    }

    public String getConfirmationMessage() {
        return getLblConfirmationMsg().getText();
    }
    // Phương thức để đăng ký
    public void register(String username, String password,String confirmPassword, String pid) {
        getTxtUsername().sendKeys(username);
        getTxtPassword().sendKeys(password);
        getTxtConfirmPassword().sendKeys(confirmPassword);
        getTxtPID().sendKeys(pid);
        WebElement registerButton = getBtnRegister();
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", registerButton);
        registerButton.click();
    }
}