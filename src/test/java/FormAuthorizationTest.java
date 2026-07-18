import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FormAuthorizationTest {
    @Test
    void test01LoginSuccess() {
        open("https://the-internet.herokuapp.com/login");
        $("#username").setValue("tomsmith");
        $("#password").setValue("SuperSecretPassword!");
        $("button.radius").click();
        $("#flash")
                .shouldBe(visible)
                .shouldHave(text("You logged into a secure area!"));
    }
    @Test
    void test02() {
        open("https://the-internet.herokuapp.com/login");
        $("#username").setValue("TestTest");
        $("#password").setValue("123456");
        $("button.radius").click();
        $("#flash")
                .shouldBe(visible)
                .shouldHave(text(" Your username is invalid!"));
    }
}
