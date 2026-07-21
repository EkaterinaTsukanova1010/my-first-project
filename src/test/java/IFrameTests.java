import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class IFrameTests {
    @Test
    void test01(){
        open("https://demoqa.com/frames");
        getWebDriver().manage().window().maximize();
        switchTo().frame(0);
        $("h1").shouldHave(text("This is a sample page"));
        switchTo().defaultContent();
        switchTo().frame(1);
        $("h1").shouldHave(text("This is a sample page"));
        switchTo().defaultContent();




    }
}
