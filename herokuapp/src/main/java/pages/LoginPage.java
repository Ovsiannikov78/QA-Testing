package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {

    private static final String LOGIN_URL = "http://the-internet.herokuapp.com/login";
    private static final By USER_NAME = By.id("username");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.className("radius");
    private static final By FLASH_MESSAGES = By.id("flash");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void goToLoginPage() {
        driver.navigate().to(LOGIN_URL);
    }

    public void insertCredentials(String userNameValue, String passwordValue) {

        driver.findElement(USER_NAME).sendKeys(userNameValue);
        driver.findElement(PASSWORD).sendKeys(passwordValue);
    }

    public SecureArea clickLogin() {
        driver.findElement(LOGIN_BUTTON).click();
        return new SecureArea(driver);
    }

    public String flashMessages() {
        return driver.findElement(FLASH_MESSAGES).getText();
    }
}
