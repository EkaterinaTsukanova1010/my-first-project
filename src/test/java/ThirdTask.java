import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ThirdTask {
    @Test
    void test01() {
        open("https://slqa.ru/cases/xPathSimpleForm/");
        $x("//*[contains(.,'Воронеж')]").shouldHave(text("нет поступлений."));
    }
}
