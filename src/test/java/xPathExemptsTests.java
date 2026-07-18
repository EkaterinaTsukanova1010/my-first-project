import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class xPathExemptsTests {
    @Test
    void testTextSearch() {
        open("https://slqa.ru/cases/xPathSimpleForm/");
        $x("//div[contains(text(),'Москва')]").shouldHave(text("250 единиц"));
        $x("//div[contains(., 'Москва')]").shouldHave(text("180 единиц"));
        $x("//div[contains(text(),'Питер')]").shouldHave(text("180 единиц"));
        $x("//*[starts-with(.,'Казахстан')]").shouldHave(text("площадь 2 724 902"));
    }
}
