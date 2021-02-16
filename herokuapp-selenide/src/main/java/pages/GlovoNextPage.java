package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class GlovoNextPage {

    @FindBy(className = "title")
    public SelenideElement confirmationText;

    public SelenideElement successfulRegistration() {
        return confirmationText;
    }

}
