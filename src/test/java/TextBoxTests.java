import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
   @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = System.getProperty("browser", "safari");
    }
    @Test
    void fillFormTest() {
        open("/text-box");
        $("[id=userName]").setValue("pupa");
        $("[id=userEmail]").setValue("lupa@gmail.com");
        $("[id=currentAddress]").setValue("rus - address 1");
        $("[id=permanentAddress]").setValue("usa - address 2");
        $("[id=submit]").click();

        $("#output").shouldHave(text("pupa"),
                text("lupa@gmail.com"),
                text("rus - address 1"),
                text("usa - address 2"));
    }
}
