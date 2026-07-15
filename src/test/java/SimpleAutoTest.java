import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;


public class SimpleAutoTest {
    @Test
    void test01Git() {
        open("https://slqa.ru/AT/articles/how-to-install-git.html");
        sleep(2_000);
        $(By.tagName("html")).shouldHave(text("Git"));
    }
    @Test
    void test02Mercurial() {
        open("https://slqa.ru/AT/articles/how-to-install-git.html");
        sleep(2_000);
        $(By.tagName("html")).shouldHave(text("Mercurial"));
    }
}
