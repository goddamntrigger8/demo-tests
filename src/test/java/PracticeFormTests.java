import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.Thread.sleep;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = System.getProperty("browser", "safari");
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("pupa"); //First Name
        $("[id=lastName]").setValue("lupa"); //Last Name
        $("[id=userEmail]").setValue("lupa@gmail.com"); // Email
        //$(By.className("col-md-9 col-sm-12")).selectRadio("Male");//Gender TODO
        $("[id=userNumber]").setValue("9578786765"); //Mobile
        //Date of Birth TODO
        //$("[id=subjectsContainer]").setValue("lupa@gmail.com"); //Subjects - не работает пока TODO
        //Hobbies TODO
        //Picture TODO
        $("[id=currentAddress]").setValue("rus - address 1"); //Current Address TODO
        //State TODO
        //City TODO

        $("[id=submit]").click();

        $("#output").shouldHave(text("pupa"),
                text("lupa@gmail.com"),
                text("rus - address 1"),
                text("usa - address 2"));
    }
}