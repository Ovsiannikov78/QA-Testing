package pages;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.PhoneNumber;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class GlovoRegistrationFormPage {

    @FindBy(xpath = "//p[contains(.,'Страна')]")
    private SelenideElement dropdown_country;

    @FindBy(xpath = "//span[contains(.,'Хорватия')]")
    private SelenideElement dropdown_country_option1;

    @FindBy(css = "li:nth-child(1) #countrySpan")
    private SelenideElement countryOption;

    @FindBy(id = "onetrust-accept-btn-handler")
    SelenideElement cookies;

    @FindBy(xpath = "//div[2]/input")
    private SelenideElement firstNameInputField;

    @FindBy(xpath = "//div[3]/input")
    private SelenideElement lastNameInputField;

    @FindBy(xpath = "//input[@type='email']")
    private SelenideElement emailInputField;

    @FindBy(xpath = "//span[@class='multiselect__single']")
    private SelenideElement countryCodeDropdown;

    @FindBy(xpath = "//div[@id='prefix_cmp']/div/div[3]/ul/li/span/span")
    private SelenideElement countryCode;

    @FindBy(xpath = "//input[@id='phone']")
    private SelenideElement phoneInputField;

    @FindBy(xpath = "//form[@id='form-home']/div/div[6]/div/p")
    private SelenideElement typePlaceSelector;

    @FindBy(xpath = "//span[contains(.,'Ресторан')]")
    private SelenideElement typePlaceOption;

    @FindBy(xpath = "//input[@name='numberBranches']")
    private SelenideElement numberBranches;

    @FindBy(xpath = "//form[@id='form-home']/div/div[8]/div/label/span")
    private SelenideElement check_box;

    @FindBy(xpath = "//button[contains(.,'Продолжить')]")
    private SelenideElement continueButton;


    public void getCountryOptions() {
        dropdown_country.click();
    }

    public void selectDropdownCountryOption() {
        dropdown_country_option1.click();
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

    public void clickCountryCodeDropdown() {
        countryCodeDropdown.click();
    }

    public void selectCountryCode() {
        countryCode.click();
    }

    public void fillPhoneField(PhoneNumber phoneNum) {
        phoneInputField.setValue(String.valueOf(phoneNum));
    }

    public void clickTypeOfPlace() {
        typePlaceSelector.click();
    }

    public void selectOptionOfPlaceType() {
        typePlaceOption.click();
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
