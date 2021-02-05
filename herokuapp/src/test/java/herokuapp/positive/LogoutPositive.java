package herokuapp.positive;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SecureArea;

import java.util.concurrent.TimeUnit;

public class LogoutPositive {

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
    public void successfulLogin() {
        loginPage.goToLoginPage();
        loginPage.insertCredentials("tomsmith", "SuperSecretPassword!");
        loginPage.clickLogin();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        secureArea.clickLogout();

        Assertions.assertEquals(loginPage.flashMessages(), "You logged out of the secure area!\n×");
    }
}
