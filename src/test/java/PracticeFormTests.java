import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
        $("[id=genterWrapper]").$(byText("Male")).click(); //Gender
        $("[id=userNumber]").setValue("9578786765"); //Mobile
        $("#dateOfBirthInput").click(); //Date of Birth
        $(".react-datepicker__month-dropdown-container").$(byText("March")).click();
        $(".react-datepicker__year-dropdown-container").$(byText("1980")).click();
        $(".react-datepicker__month-container").$(byText("13")).click();
        $("#subjectsInput").setValue("English").pressEnter(); //Subjects
        $("[id=hobbiesWrapper]").$(byText("Sports")).click(); //Hobbies
        $("[id=hobbiesWrapper]").$(byText("Music")).click(); //Hobbies
        $("#uploadPicture").uploadFromClasspath("smudge-the-viral-cat.jpg");//Picture
        $("[id=currentAddress]").setValue("rus - address 1"); //Current Address
        $("#state").click(); //State
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click(); //City
        $("#stateCity-wrapper").$(byText("Agra")).click();

        $("[id=submit]").click();

        $("[class=modal-content]").shouldHave(text("pupa"),
                text("lupa@gmail.com"),
                text("lupa"),
                text("Male"),
                text("9578786765"),
                text("March"),
                text("Sports"),
                text("Music"),
                text("Uttar Pradesh"),
                text("Agra"));
    }
}