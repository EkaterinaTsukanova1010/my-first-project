import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
public class PizzeriaTests {
    @Test
    void test01(){
        open("https://slqamsk.github.io/cases/pizza/v08/");
        $x("//h3[.='Маргарита']/../button")
                .shouldBe(exist)
                .shouldBe(visible)
                .click();
        $x("//h3[.='Четыре сыра']/../button").click();

        $x("//*[contains(text(), 'Корзина')]")
                .shouldBe(exist)
                .shouldBe(visible)
                .click();
        $x("//*[contains(text(), 'Маргарита')]")
                .shouldBe(exist)
                .shouldBe(visible);
        $x("//*[contains(text(), 'Четыре сыра')]")
                .shouldBe(exist)
                .shouldBe(visible);
        $("#place-order").click();

        $x("//input[@type='text']").setValue("Тест Тест");
        $x("//input[@type='email']").setValue("test@mail.ru");
        $("#confirm-order").click();
        //$x("//div[.='order-info']/h3").shouldBe(exist).shouldBe(visible);








    }
}
