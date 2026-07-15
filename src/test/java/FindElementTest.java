import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FindElementTest {
    @Test
    void test01() {
        open("https://slqamsk.github.io/demo/search-demo/");
        $(By.id("submit-button")).shouldBe(visible);;
        $(By.name("interests")).shouldBe(visible);
        $(By.className("nav-link")).click();
        sleep(1_000);
        $(By.tagName("input")).sendKeys("Екатерина");   //Спросить за ввод в конкретное поле
        sleep(1_000);
        $(By.linkText("Контакты и обратная связь")).click();
        sleep(1_000);
        $(By.partialLinkText("длинный")).click();
        sleep(1_000);
    }
}
