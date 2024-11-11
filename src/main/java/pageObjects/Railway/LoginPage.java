package pageObjects.Railway;
import Common.Constant.Constant;
import Common.common.Utilities;
import org.openqa.selenium.*;
public class LoginPage
{

    //Locators
    private final By _txtUsername = By.xpath("//input[@id='username']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _btnLogin = By.xpath("//input[@value='login']");
    private final By _IbILoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
    private final By _tabForgotPassword = By.xpath("//a[@href='/Account/ForgotPassword.cshtml']");

    //Elements
    public WebElement getTxtUsername() {
        return Utilities.waitForElementToBeClickable(_txtUsername);
    }

    public WebElement getTxtPassword() {
        return Utilities.waitForElementToBeClickable(_txtPassword);
    }

    public WebElement getBtnLogin() {
        return Utilities.waitForElementToBeClickable(_btnLogin);
    }

    public WebElement getTabForgotPassword() {
        return Utilities.waitForElementToBeClickable(_tabForgotPassword);
    }

    private WebElement getLbLoginErrorMsg() {
        return Utilities.waitForElementToBeVisible(_IbILoginErrorMsg);
    }
    public String getErrorMessage()
    {
        return getLbLoginErrorMsg().getText();
    }

    public void login(String username, String password)
    {
        getTxtUsername().sendKeys(username);
        getTxtPassword().sendKeys(password);
        WebElement btnLogin = getBtnLogin();
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", btnLogin);
        btnLogin.click();

    }

    public ForgotPasswordPage gotoForgotPasswordPage() {
        getTabForgotPassword().click();
        return new ForgotPasswordPage();
    }


}