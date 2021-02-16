package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.PhoneNumber;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

public class GlovoRegistrationFormPage {

    @FindBy(xpath = "//div/div/p")
    private SelenideElement dropdown_country;

    @FindBy(id = "countrySpan")
    private ElementsCollection country_elements;


    @FindBy(id = "onetrust-accept-btn-handler")
    SelenideElement cookies;

    @FindBy(xpath = "//div[2]/input")
    private SelenideElement firstNameInputField;

    @FindBy(xpath = "//div[3]/input")
    private SelenideElement lastNameInputField;

    @FindBy(xpath = "//input[@type='email']")
    private SelenideElement emailInputField;

    @FindBy(css = ".multiselect__select")
    private SelenideElement countryPhoneCodeDropdown;

    @FindBy(css = ".multiselect__option")
    private ElementsCollection countryPhoneCodeElements;

    @FindBy(xpath = "//input[@id='phone']")
    private SelenideElement phoneInputField;

    @FindBy(xpath = "//div[6]/div/p")
    private SelenideElement typePlaceSelector;

    @FindBy(css = ".active > li")
    private ElementsCollection typePlaceElement;

    @FindBy(name = "numberBranches")
    private SelenideElement numberBranches;

    @FindBy(css = ".label-icon")
    private SelenideElement check_box;

    @FindBy(css = ".btn-primary")
    private SelenideElement continueButton;


    public void fillCountryDropdown(String country) {
        dropdown_country.click();
        country_elements.findBy(text(country)).click();
    }

    public void acceptCookies() {
        cookies.click();
    }

    public void fillFirstNameField(String firstName) {
        firstNameInputField.setValue(firstName);
    }

    public void fillLastNameField(String lastName) {
        lastNameInputField.setValue(lastName);
    }

    public void fillEmailField(String email) {
        emailInputField.setValue(email);
    }

    public void fillCountryPhoneCodeDropdown(String countryPhoneCode) {
        countryPhoneCodeDropdown.click();
        countryPhoneCodeElements.findBy(text(countryPhoneCode)).click();
    }

    public void fillPhoneField(PhoneNumber phoneNum) {
        phoneInputField.setValue(String.valueOf(phoneNum));
    }

    public void clickTypeOfPlace(String typeOfPlace) {
        typePlaceSelector.click();
        typePlaceElement.findBy(text(typeOfPlace)).click();
    }

    public void inputPlaceQuantity(String placeQuantity) {
        numberBranches.setValue(placeQuantity);
    }

    public void clickCheckBox() {
        check_box.click();
    }

    public GlovoNextPage clickContinueButton() {
        continueButton.click();
        return page(GlovoNextPage.class);
    }
}
