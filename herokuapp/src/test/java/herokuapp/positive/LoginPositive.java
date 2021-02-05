package herokuapp.positive;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.SecureArea;

public class LoginPositive {

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

        Assertions.assertEquals(secureArea.successfulLoginText(), "You logged into a secure area!\n×");
    }

    /*driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.verifyAlertSuccess();
        loginPage.pressLogoutButton();*/
}
