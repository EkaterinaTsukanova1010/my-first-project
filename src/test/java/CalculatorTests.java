import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
public class CalculatorTests {
    @BeforeEach
    void open_site() {
        open("https://slqamsk.github.io/cases/loan-calc/v01/");
    }
    @Test
    void test01_Lowest_Level() {
        $("#amount")
                .shouldBe(exist)
                .shouldBe(visible)
                .setValue("2000000");
        $("#term")
                .shouldBe(exist)
                .shouldBe(visible)
                .setValue("24");
        $("#rate")
                .shouldBe(exist)
                .shouldBe(visible)
                .setValue("16");
        $("input[value='annuity']").shouldBe(selected);
        $("input[value='diff']").shouldNotBe(selected);
        $("#calculate-btn").click();
    }
    @Test
    void test02_Low_Level() {
        Configuration.timeout = 10_000;
        $("#amount")
                .shouldBe(exist)
                .shouldBe(visible)
                .setValue("3000000");
        $("#term")
                .shouldBe(exist)
                .shouldBe(visible)
                .setValue("36");
        $("#rate")
                .shouldBe(exist)
                .shouldBe(visible)
                .setValue("16");
        $("input[value='annuity']").shouldBe(selected);
        $("input[value='diff']").shouldNotBe(selected);
        $("#calculate-btn").click();
        $x("//h2").shouldHave(text("Результаты расчёта"))
                .shouldBe(exist)
                .shouldBe(visible);;
        $("#result-amount").shouldHave(text("3000000.00"));
        $("#result-term").shouldHave(text("36"));
        $("#result-rate").shouldHave(text("16"));
        $("#result-payment-type").shouldHave(text("Аннуитетный"));
        $("#monthly-payment").shouldHave(text("105471"));
        $("#overpayment").shouldHave(text("796959.57"));
        $("#total-payment").shouldHave(text("3796959.57"));
        Configuration.timeout = 4_000;
    }
    @Test
    void test03_Middle_Level() {
        $("#amount")
                .shouldBe(exist)
                .shouldBe(visible)
                .setValue("500000");
        $("#term")
                .shouldBe(exist)
                .shouldBe(visible)
                .setValue("24");
        $("#rate")
                .shouldBe(exist)
                .shouldBe(visible)
                .setValue("16");
        $("input[value='annuity']").shouldBe(selected);
        $("input[value='diff']").shouldNotBe(selected);
        $("#calculate-btn").click();
        Configuration.timeout = 10_000;
        $x("//h2[text()='Результаты расчёта']")
                .shouldBe(exist)
                .shouldBe(visible);
        $("#result-amount").shouldHave(text("500000.00"));
        $("#result-term").shouldHave(text("24"));
        $("#result-rate").shouldHave(text("16"));
        $("#result-payment-type").shouldHave(text("Аннуитетный"));
        $("#monthly-payment").shouldHave(text("24481.56"));
        $("#overpayment").shouldHave(text("87557.33"));
        $("#total-payment").shouldHave(text("587557.33"));
        $("#show-schedule-btn").click();
        switchTo().window(1);
        sleep(4_000);
        $x("//h2[text()='График платежей']")
                .shouldBe(exist)
                .shouldBe(visible);
        $x("span@class='result-value'[0]=500000");
        $x("span@class='result-value'[1]=24");
        $x("span@class='result-value'[2]=16");
        $x("span@class='result-value'[3]=Аннуитетный");
        Configuration.timeout = 4_000;
    }
}
