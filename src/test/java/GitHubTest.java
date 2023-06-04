import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        //Configuration.browser = System.getProperty("browser", "safari");
    }
    @Test
    void searchSelenideTest() {
        // Откройте страницу Selenide в Github
        open("https://github.com/");
        $("[placeholder='Search GitHub']").setValue("selenide").pressEnter();
        $("[href='/selenide/selenide']").click();
        // Перейдите в раздел Wiki проекта
        $("[href='/selenide/selenide/wiki']").click();
        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("[id=wiki-body]").shouldHave(text("Soft assertions"));
        // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(byText("Soft assertions")).click();
        $("[class=markdown-body]").shouldHave(text("Using JUnit5"));

        sleep(3000);
    }
}
