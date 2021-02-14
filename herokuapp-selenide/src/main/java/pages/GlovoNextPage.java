package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class GlovoNextPage {

    @FindBy(xpath = "//div[@id='app']/section/section/div/p")
    public SelenideElement confirmationText;

    public SelenideElement successfulRegistration() {
        return confirmationText;
    }

}
