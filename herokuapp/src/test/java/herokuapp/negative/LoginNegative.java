package herokuapp.negative;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SecureArea;

public class LoginNegative {

    LoginPage loginPage;
    SecureArea secureArea;
    private ChromeDriver driver;

    @BeforeEach
    public void initPageObjects() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        secureArea = new SecureArea(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void invalidUsername() {
        loginPage.goToLoginPage();
        loginPage.insertCredentials("tom", "SuperSecretPassword!");
        loginPage.clickLogin();

        Assertions.assertEquals(loginPage.flashMessages(), "Your username is invalid!\n×");
    }

    @Test
    public void invalidPassword() {
        loginPage.goToLoginPage();
        loginPage.insertCredentials("tomsmith", "abc");
        loginPage.clickLogin();

        Assertions.assertEquals(loginPage.flashMessages(), "Your password is invalid!\n×");
    }
}
