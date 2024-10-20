package pageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import Common.Constant.Constant;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralPage {
    //Locators

    private final By tabLogin = By.xpath ("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath ("//div[@id='menu']//a[@href='/Account/Logout.cshtml']");
    private final By IblWelcomMessage = By.xpath ("//div[@class='account']/strong");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabRegister = By.xpath ("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    protected WebElement getTabLogin() {
        // Định nghĩa chờ tối đa 30 giây
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(30));

        try {
            // Chờ cho đến khi phần tử có thể nhấp được
            return wait.until(ExpectedConditions.elementToBeClickable(tabLogin));
        } catch (TimeoutException e) {
            System.out.println("Đã hết thời gian chờ khi tìm tab đăng nhập: " + e.getMessage());
            return null; // Trả về null nếu không tìm thấy phần tử
        } catch (NoSuchElementException e) {
            System.out.println("Không tìm thấy tab đăng nhập: " + e.getMessage());
            return null; // Trả về null nếu không tìm thấy phần tử
        }
    }
    protected WebElement getTabRegister() {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(30));

        try {
            // Chờ cho đến khi phần tử "Register" có mặt và có thể nhấp được
            return wait.until(ExpectedConditions.elementToBeClickable(tabRegister)); // Thay đổi XPath nếu cần
        } catch (TimeoutException e) {
            System.out.println("Đã hết thời gian chờ khi tìm tab 'Register': " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Không tìm thấy tab 'Register': " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Một lỗi khác đã xảy ra: " + e.getMessage());
        }
        return null; // Trả về null nếu không tìm thấy phần tử hoặc có lỗi
    }
    protected WebElement getTabBookTicket() {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(30));

        try {
            // Chờ cho đến khi phần tử có mặt và có thể nhìn thấy
            return wait.until(ExpectedConditions.visibilityOfElementLocated(tabBookTicket));
        } catch (TimeoutException e) {
            System.out.println("Đã hết thời gian chờ khi tìm tab 'Book Ticket': " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Không tìm thấy tab 'Book Ticket': " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Một lỗi khác đã xảy ra: " + e.getMessage());
        }
        return null; // Trả về null nếu không tìm thấy phần tử hoặc có lỗi
    }
    protected WebElement getTabLogout () {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getLblWelcomeMessage() {
        // Khởi tạo WebDriverWait với thời gian chờ tối đa là 30 giây
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(30));

        try {
            // Chờ cho đến khi phần tử có mặt và có thể nhìn thấy
            return wait.until(ExpectedConditions.visibilityOfElementLocated(IblWelcomMessage));
        } catch (TimeoutException e) {
            System.out.println("Đã hết thời gian chờ khi tìm thông điệp chào mừng: " + e.getMessage());
            return null; // Trả về null nếu không tìm thấy phần tử
        } catch (NoSuchElementException e) {
            System.out.println("Không tìm thấy thông điệp chào mừng: " + e.getMessage());
            return null; // Trả về null nếu không tìm thấy phần tử
        }
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
    public BookTicketPage gotoBookTicketPage()
    {
        this.getTabBookTicket().click();
        return new BookTicketPage();
    }
    public RegisterPage gotoRegisterPage(){
        this.getTabRegister().click();
        return new RegisterPage();
    }
    public String getCurrentUrl() {
        return Constant.WEBDRIVER.getCurrentUrl();
    }
}