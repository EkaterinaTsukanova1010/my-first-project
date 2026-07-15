import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationTests {
    @Test
    void test01LoginSuccess() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $("#username").sendKeys("standard_user");
        $("#password").sendKeys("stand_pass1");
        $("#loginButton").click();
        $("#greeting")
                .shouldBe(visible)
                .shouldHave(text("Добро пожаловать, Иванов Иван Иванович!"));
    }
    @Test
    void test02LoginWrongPassword() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
        $("#username").sendKeys("standard_user");
        $("#password").sendKeys("111111");
        $("#loginButton").click();
        $("#message")
                .shouldBe(visible)
                .shouldHave(text("Неверное имя пользователя или пароль."));
    }

}
