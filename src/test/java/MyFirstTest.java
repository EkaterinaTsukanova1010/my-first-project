import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class MyFirstTest {
    @Test
    void test01Open() {
        // Добавил комментарий
        Configuration.browser = "chrome";
        Configuration.browserSize = "1500x500";
        Configuration.browserPosition = "100x200";

        open("https://ru.wikipedia.org/wiki/Selenium");
        sleep(5_000);
        getWebDriver().manage().window().maximize();
        sleep(5_000);
        $("body").shouldHave(text("Selenium"));
    }
}