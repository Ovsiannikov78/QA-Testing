package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureArea extends Page {

    private static final By LOGOUT_BUTTON = By.xpath("//div[@id='content']/div/a/i");
    private static final By FLASH_MESSAGES = By.id("flash");

    public SecureArea(WebDriver driver) {
        super(driver);
    }

    public String successfulLoginText() {
        return driver.findElement(FLASH_MESSAGES).getText();
    }

    public LoginPage clickLogout() {
        driver.findElement(LOGOUT_BUTTON).click();
        return new LoginPage(driver);
    }
}
