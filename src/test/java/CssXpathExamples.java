import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void сssXpathExamples() {
        //<input id="userEmail">
        $("[id=userEmail]").setValue("lupa@gmail.com");
        $("[#userEmail]").setValue("lupa@gmail.com");
        $("[input#userEmail]").setValue("lupa@gmail.com");
        $x("//*[@id='email']");
        $x("//input[@id='email']");

        $(byName("email")).setValue("lupa@gmail.com");

        //<input class="mr-sm-2 form-control">
        $("[class=mr-sm-2 form-control]").setValue("lupa@gmail.com");
        $("[.mr-sm-2 form-control]").setValue("lupa@gmail.com");
        $("[input.mr-sm-2 form-control]").setValue("lupa@gmail.com");
        $x("//input[@class='mr-sm-2 form-control']");

        //элемент внутри элемента
        $(".inputtext").$(".form-control").setValue("lupa@gmail.com");

        //поиск по тексту
        $x("//div[text()='Hello!']").click();
        $(byText("Hello!"));

        //по куску текста
        $(withText("ello"));

    }
}
