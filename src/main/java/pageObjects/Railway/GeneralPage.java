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
    private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By IblWelcomMessage = By.xpath("//div[@class='account']/strong");


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
    protected WebElement getTabMyTicket() {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(30));
        try {
            // Chờ cho đến khi phần tử có mặt và có thể nhìn thấy
            return wait.until(ExpectedConditions.visibilityOfElementLocated(tabMyTicket));
        } catch (TimeoutException e) {
            System.out.println("Đã hết thời gian chờ khi tìm tab 'My ticket': " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Không tìm thấy tab 'My ticket': " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Một lỗi khác đã xảy ra: " + e.getMessage());
        }
        return null; // Trả về null nếu không tìm thấy phần tử hoặc có lỗi
    }

    // Hàm lấy tab "Change password"
    protected WebElement getTabChangePassword() {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(30));
        try {
            // Chờ cho đến khi phần tử có mặt và có thể nhìn thấy
            return wait.until(ExpectedConditions.visibilityOfElementLocated(tabChangePassword));
        } catch (TimeoutException e) {
            System.out.println("Đã hết thời gian chờ khi tìm tab 'Change password': " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Không tìm thấy tab 'Change password': " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Một lỗi khác đã xảy ra: " + e.getMessage());
        }
        return null; // Trả về null nếu không tìm thấy phần tử hoặc có lỗi
    }
    public boolean isMyTicketTabDisplayed() {
        return getTabMyTicket().isDisplayed();
    }

    // Hàm kiểm tra tab "Change password" có hiển thị không
    public boolean isChangePasswordTabDisplayed() {
        return getTabChangePassword().isDisplayed();
    }

    protected WebElement getTabLogout () {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }
    protected WebElement getLblWelcomeMessage() {
        // Khởi tạo WebDriverWait với thời gian chờ tối đa là 30 giây
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(10));

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
    public String getWelcomeMessage() {
        WebElement welcomeMessageElement = this.getLblWelcomeMessage();
        if (welcomeMessageElement != null) {
            return welcomeMessageElement.getText();
        } else {
            System.out.println("Không thể lấy thông điệp chào mừng.");
            return ""; // Trả về chuỗi rỗng nếu không tìm thấy
        }
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
    public MyTicketPage gotoMyTickePage() {
        this.getTabMyTicket().click();
        return new MyTicketPage();
    }
    public ChangePasswordPage gotoChangePasswordPage() {
        this.getTabChangePassword().click();
        return new ChangePasswordPage();
    }

    public String getCurrentUrl() {
        return Constant.WEBDRIVER.getCurrentUrl();
    }
    public void goBack() {
        Constant.WEBDRIVER.navigate().back();
    }
}