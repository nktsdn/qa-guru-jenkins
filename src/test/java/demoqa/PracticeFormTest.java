package demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static demoqa.utils.RandomUtils.*;
import static io.qameta.allure.Allure.step;

public class PracticeFormTest extends TestBase{


    @Test
    void practiceFormTest() {

        String firstName = randomString(7, true, false),
                lastName = randomString(7, true, false),
                email = randomEmail(7),
                gender = "Male",
                number = randomPhone(),
                day = "01",
                month = "August",
                year = "1995",
                modalResultName = "Thanks for submitting the form";

        step("Open reg form", () -> {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(number)
                .setBirthDate(day, month, year);
        });

        step("Fill form", () -> {
            $("#userForm #subjectsInput").setValue("Computer Science").pressEnter();
            $("#userForm #hobbiesWrapper").$(byText("Music")).click();
            $("#userForm #currentAddress").setValue("Address");
            $("#state").click();
            $("#stateCity-wrapper").$(byText("NCR")).click();
            $("#city").click();
            $("#stateCity-wrapper").$(byText("Delhi")).click();
            $("#userForm #submit").click();
        });

        step("Check form results", () -> {
        registrationPage.verifyNameModal(modalResultName)
                        .verifyResultModal("Student Name", firstName+" "+lastName)
                        .verifyResultModal("Student Email", email)
                        .verifyResultModal("Gender", gender)
                        .verifyResultModal("Mobile", number)
                        .verifyResultModal("Date of Birth", day+" "+month+","+year);
        });
    }

}
