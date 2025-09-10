package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.CalendarComponent;
import demoqa.pages.components.ResultModalComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultModalComponent resultModalComponent = new ResultModalComponent();

    private final SelenideElement
            firstNameInput = $("#userForm #firstName"),
            lastNameInput = $("#userForm #lastName"),
            emailInput = $("#userForm #userEmail"),
            genderInput = $("#userForm #genterWrapper"),
            numberInput = $("#userForm #userNumber"),
            birthDateInput = $("#userForm #dateOfBirthInput");

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value){
        genderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setNumber(String value){
        numberInput.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year){
        birthDateInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyNameModal(String name) {
        resultModalComponent.verifyModalAppears(name);
        return this;
    }

    public RegistrationPage verifyResultModal(String key, String value) {
        resultModalComponent.verifyResult(key, value);
        return this;
    }
}
