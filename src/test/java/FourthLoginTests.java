import com.codeborne.selenide.Condition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FourthLoginTests {

    @ParameterizedTest
    @ValueSource(strings = {"100", "500", "1000", "100000", "100001"})
    public void testCommissionCalculator(String amount) {
        open("https://slqa.ru/cases/fc/v01/");
        $("input").setValue(amount);
        $("input[type='submit']").click();
        $(withText("Комиссия")).shouldBe(Condition.visible);
    }
}
