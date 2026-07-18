import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationTests {

    @BeforeEach
    void openSite() {
        open("https://slqamsk.github.io/cases/slflights/v01/");
    }

    @Test
    void test01LoginSuccess() {
        // Правильный логин и пароль
        $("#username").setValue("standard_user");
        $("#password").setValue("stand_pass1");
        $("#loginButton").click();
        $("#greeting")
                .shouldBe(visible)
                .shouldHave(text("Добро пожаловать, Иванов Иван Иванович!"));
    }
    @Test
    void test02WrongPassword() {
        // Неправильный пароль
        $("#username").setValue("standard_user");
        $("#password").setValue("111111");
        $("#loginButton").click();
        $("#message")
                .shouldBe(visible)
                .shouldHave(text("Неверное имя пользователя или пароль."));
    }
    @Test
    void test03EmptyLogin() {
        // Пустое поле "Логин"
        $("#username").setValue(" ");
        $("#password").setValue("stand_pass1");
        $("#loginButton").click();
        $("#message")
                .shouldBe(visible)
                .shouldHave(text("Username is required."));
    }
    @Test
    void test04PressEnter() {
        // Вместо клика на кнопку "Войти" нажимается Enter
        $("#username").setValue("standard_user");
        $("#password").setValue("stand_pass1");
        $("#loginButton").pressEnter();
        $("#flightForm").shouldBe(visible);
    }

}
