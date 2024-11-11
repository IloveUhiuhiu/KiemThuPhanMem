package Common.common;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utilities {
    // Phương thức chung để chờ cho phần tử có thể nhấp được
    public static WebElement waitForElementToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(30));
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            System.err.println("Đã hết thời gian chờ khi tìm phần tử: " + locator + " - " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.err.println("Không tìm thấy phần tử: " + locator + " - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Một lỗi khác đã xảy ra: " + e.getMessage());
        }
        return null; // Trả về null nếu không tìm thấy phần tử hoặc có lỗi
    }

    // Phương thức chung để chờ cho phần tử có thể nhìn thấy
    public static WebElement waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, Duration.ofSeconds(30));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            System.err.println("Đã hết thời gian chờ khi tìm phần tử: " + locator + " - " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.err.println("Không tìm thấy phần tử: " + locator + " - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Một lỗi khác đã xảy ra: " + e.getMessage());
        }
        return null; // Trả về null nếu không tìm thấy phần tử hoặc có lỗi
    }
}
