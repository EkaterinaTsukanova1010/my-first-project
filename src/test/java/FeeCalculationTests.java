import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class FeeCalculationTests {
    @Test
    void test01() {
        open("https://slqa.ru/cases/fc/v01/");
        $x("//*[@name='sum']").setValue("1111");
        $x("//*[@name='submit']").click();
        // Добавить проверки
        $("input[name=sum]").setValue("500");
        $("[name=submit]").click();
        sleep(3_000);


    }
}