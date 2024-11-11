package pageObjects.Railway;

import Common.Constant.Constant;
import Common.common.Utilities;
import org.openqa.selenium.*;

public class ForgotPasswordPage {
    private final By _emailFiend = By.id("email");
    private final By _btnSendInstructions = By.xpath("//input[@value='Send Instructions']");

    public WebElement getEmail() {
        return Utilities.waitForElementToBeClickable(_emailFiend);
    }

    public WebElement getBtnSendInstructions() {
        return Utilities.waitForElementToBeClickable(_btnSendInstructions);
    }
    public void enterEmailAndSendInstructions(String email) {
        getEmail().sendKeys(email);
        WebElement sendInstructionsButton = getBtnSendInstructions();
        ((JavascriptExecutor) Constant.WEBDRIVER).executeScript("arguments[0].scrollIntoView(true);", sendInstructionsButton);
        sendInstructionsButton.click();

    }
}
