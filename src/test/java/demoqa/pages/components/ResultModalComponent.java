package demoqa.pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModalComponent {
    public void verifyModalAppears(String name){
        $("#example-modal-sizes-title-lg").shouldHave(text(name));
    }

    public void verifyResult(String key, String value){
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
    }
}
