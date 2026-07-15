import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class FeeCalculationTests {
    @Test
    void test01Open() {
        open("https://slqa.ru/cases/fc/v01/");
        sleep(1_000);
        //Первый расчет
        $(By.name("sum")).sendKeys("1111");
        $(By.name("submit")).click();
        $(By.name("sum")).clear();
        //Второй расчет
        $(By.name("sum")).setValue("2222");
        $(By.name("submit")).click();
        sleep(3_000);
        $(By.name("sum")).clear();
        //Третий расчет
        $(By.name("sum")).type("3333");
        $(By.name("submit")).click();
        sleep(3_000);
        $(By.name("sum")).clear();
        //Четвертый расчет
        $(By.name("sum")).setValue("4444");
        $(By.name("submit")).click();
        sleep(3_000);
        $(By.name("sum")).clear();
    }
}