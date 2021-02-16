package glovoapp;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.GlovoRegistrationFormPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.open;
import static pages.Commons.BASE_URL_GLOVOAPP;


public class RegistrationFormTest {
    GlovoRegistrationFormPage registrationPage;
    Faker faker = new Faker();

    @BeforeEach
    public void acceptCookies() {
        registrationPage = open(BASE_URL_GLOVOAPP + "/Partners", GlovoRegistrationFormPage.class);
        registrationPage.acceptCookies();

    }

    @Test
    public void registrationFormTest() {

        PhoneNumber phone = faker.phoneNumber();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String placeQuаntity = faker.numerify("2");

        registrationPage.fillCountryDropdown("Хорватия");

        registrationPage.fillFirstNameField(firstName);
        registrationPage.fillLastNameField(lastName);
        registrationPage.fillEmailField(email);
        registrationPage.fillCountryPhoneCodeDropdown("+93");

        registrationPage.fillPhoneField(phone);
        registrationPage.clickTypeOfPlace("Ресторан");

        registrationPage.inputPlaceQuantity(placeQuаntity);
        registrationPage.clickCheckBox();

        registrationPage.clickContinueButton().successfulRegistration().should(exist);
    }
}
