import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.$;


public class MySecondTest {

    @Test
    void test01WebDriver() {
        open("https://ru.wikipedia.org/wiki/Selenium");
        //sleep(2_000);
        $(By.tagName("body")).shouldHave(text("WebDriver"));
    }
    @Test
    void test02Selenide() {
        open("https://ru.wikipedia.org/wiki/Selenium");
        $(By.tagName("body")).shouldHave(text("Selenide"));
    }
}
