package Testcases.Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Railway.BookTicketPage;
import pageObjects.Railway.HomePage;
import pageObjects.Railway.LoginPage;
import Common.Constant.Constant;

import Common.common.Utilities;
import pageObjects.Railway.RegisterPage;

public class LoginTest {
        @BeforeMethod
        public void beforeMethod() {
            System.out.println("Pre-condition");

//            System.setProperty("webdriver.chrome.driver", javax.swing.text.Utilities.getProjectPath()
//                    + "\\Executables\\chromedriver.exe");
            Constant.WEBDRIVER = new ChromeDriver();
            Constant.WEBDRIVER.manage().window().maximize();

        }

        @AfterMethod
        public void afterMethod() {
            System.out.println("Post-condition");

            Constant.WEBDRIVER.quit();
        }

//    @Test
//    public void TC01() {
//        System.out.println("TC01 - User can log into Railway with valid user name and password");
//        HomePage homePage = new HomePage();
//        homePage.open(); // Mở trang chính
//        LoginPage loginPage = homePage.gotoLoginPage(); // Chuyển đến trang đăng nhập
//
//        // Thực hiện đăng nhập
//        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
//        String expectedMsg = "Welcome " + Constant.USERNAME;
//
//        // Kiểm tra thông điệp chào mừng
//        Assert.assertEquals(actualMsg.trim(), expectedMsg.trim(), "Welcome message is not displayed as expected");
//    }

    @Test
    public void TC02() {
        System.out.println("TC02 - User can't login with blank \"Username\" textbox");
        HomePage homePage = new HomePage();
        homePage.open(); // Mở trang chính

        LoginPage loginPage = homePage.gotoLoginPage(); // Chuyển đến trang đăng nhập

        // Thực hiện đăng nhập với username trống
        loginPage.login("", Constant.PASSWORD);

        // Lấy thông báo lỗi
        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        // Kiểm tra thông báo lỗi
        Assert.assertEquals(actualMsg.trim(), expectedMsg.trim(), "Error message is not displayed as expected");
    }
    @Test
    public void TC03() {
        System.out.println("TC03 - User can't login with invalid password");

        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, "invalidPassword");

        // Lấy thông báo lỗi
        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        // Kiểm tra thông báo lỗi
        Assert.assertEquals(actualMsg.trim(), expectedMsg.trim(), "Error message is not displayed as expected");
    }

    @Test
    public void TC04() {
        System.out.println("TC04 - Login page displays when un-logged User clicks on 'Book ticket' tab");

        // Mở trang chính
        HomePage homePage = new HomePage();
        homePage.open();

        // Nhấp vào tab "Book ticket"
        BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();

        // Kiểm tra xem có phải là trang đăng nhập hiển thị không
        String actualUrl = homePage.getCurrentUrl(); // Lấy URL hiện tại
        String expectedUrl = "http://railwayb1.somee.com/Account/Login.cshtml?ReturnUrl=/Page/BookTicketPage.cshtml"; // Thay bằng URL thực tế của trang đăng nhập

        // Kiểm tra URL
        Assert.assertEquals(actualUrl, expectedUrl, "User is not redirected to the login page when clicking on 'Book ticket' tab.");
    }

    @Test

    public void TC05() {
        System.out.println("TC05 - System shows message when user enters wrong password several times");

        HomePage homePage = new HomePage();
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();

        // Thực hiện đăng nhập với mật khẩu sai 4 lần
        for (int i = 0; i < 4; i++) {
            loginPage.login(Constant.USERNAME, "invalidPassword");
        }

        // Lấy thông báo lỗi sau khi thử 4 lần
        String actualMsg = loginPage.getErrorMessage();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        // Kiểm tra thông báo lỗi
        Assert.assertEquals(actualMsg.trim(), expectedMsg.trim(), "Error message is not displayed as expected after multiple failed login attempts.");
    }
    @Test
    public void TC07() {
        System.out.println("TC07 - User can create new account");

        // Mở trang chính
        HomePage homePage = new HomePage();
        homePage.open();

        // Chuyển đến trang đăng ký
        RegisterPage registerPage = homePage.gotoRegisterPage();


        registerPage.register(Constant.USERNAME_REGISTER,Constant.PASSWORD_REGISTER,Constant.PID);
        // Lấy thông báo xác nhận
        String actualMsg = registerPage.getConfirmationMessage();
        String expectedMsg = "Thank you for registering your account.";

        // Kiểm tra thông báo xác nhận
        Assert.assertEquals(actualMsg.trim(), expectedMsg.trim(), "Confirmation message is not displayed as expected.");
    }

}
