import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ExpectationTests {
    @Test
    void test01(){
        open("https://slqa.ru/cases/WaitsSimpleForm/");
        $("#duration_time").setValue("10");
        $x("//*[contains(text(), 'Загрузить динамическое содержимое')]").click();
        $x("//*[contains(text(), 'Динамическое содержимое')]").shouldBe(visible);
    }
}
