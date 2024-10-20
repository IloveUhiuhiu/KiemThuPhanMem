package pageObjects.Railway;
import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;
import java.time.Duration;

public class RegisterPage {

    // Locators
    private final By _txtUsername = By.xpath("//input[@id='email']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _txtconfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By _txtPID = By.xpath("//input[@id='pid']"); // Locator cho trường PID
    private final By _btnRegister = By.xpath("//input[@value='Register']");
    private final By _lblConfirmationMsg = By.xpath("//div[@id='content']/p"); // Locator cho thông báo xác nhận

    // Elements
    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(_txtUsername);
    }

    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(_txtPassword);
    }
    public WebElement getTxtconfirmPassword() {
        return Constant.WEBDRIVER.findElement(_txtconfirmPassword);
    }
    public WebElement getTxtPID() {
        return Constant.WEBDRIVER.findElement(_txtPID);
    }

    public WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(_btnRegister);
    }

    private WebElement getLblConfirmationMsg() {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(30));
        try {
            // Chờ cho đến khi thông báo xác nhận có thể nhìn thấy
            return wait.until(ExpectedConditions.visibilityOfElementLocated(_lblConfirmationMsg));
        } catch (TimeoutException e) {
            System.err.println("Thông báo xác nhận không tìm thấy: " + e.getMessage());
            return null; // Trả về null nếu không tìm thấy thông báo
        } catch (NoSuchElementException e) {
            System.err.println("Không tìm thấy phần tử thông báo xác nhận: " + e.getMessage());
            return null; // Trả về null nếu không tìm thấy phần tử
        }
    }

    public String getConfirmationMessage() {
        return getLblConfirmationMsg().getText();
    }
    // Phương thức để đăng ký
    public void register(String username, String password, String pid) {
        getTxtUsername().sendKeys(username);
        getTxtPassword().sendKeys(password);
        getTxtconfirmPassword().sendKeys(password);
        getTxtPID().sendKeys(pid);
        getBtnRegister().click();
    }
}