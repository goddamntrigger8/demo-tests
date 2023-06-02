import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
    void cssXpathExamples() {
        //поиск по <input id="userEmail">
        $("[id=userEmail]").setValue("lupa@gmail.com");
        $("[#userEmail]").setValue("lupa@gmail.com"); // можно id заменять на #
        $("[input#userEmail]").setValue("lupa@gmail.com");
        $x("//*[@id='email']");
        $x("//input[@id='email']");

        $(byName("email")).setValue("lupa@gmail.com");

        //поиск по <input class="mr-sm-2 form-control">
        $("[class=mr-sm-2 form-control]").setValue("lupa@gmail.com");
        $("[.mr-sm-2 form-control]").setValue("lupa@gmail.com"); // можно class заменять на .
        $("[input.mr-sm-2 form-control]").setValue("lupa@gmail.com");
        $x("//input[@class='mr-sm-2 form-control']");

        //элемент внутри элемента
        $(".inputtext").$(".form-control").setValue("lupa@gmail.com");

        //поиск по тексту
        $x("//div[text()='Hello!']").click();
        $(byText("Hello!"));

        //по куску текста
        $(withText("ello"));

        //поиск родительского элемента
        $("").parent();

        //поиск родителя родителя
        $("").parent().parent();

        //поиск ближайшего элемента
        $("").closest("");

        //поиск родственного элемента
        $("").closest("").sibling(0);

        //поиск ребенка элемента
        $("div div"); //любой ребенок div, берется самый первый в дереве с таким названием
        $("div>div"); //первый ребенок div с таким названием


    }
}
