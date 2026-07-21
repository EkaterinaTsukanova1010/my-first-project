import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SecondTask {
    @BeforeEach
     void before_each() {
        open("https://slqa.ru/cases/ChatGPTLogin/");
    }
    @Test
    void test01Check() {
        $("#username")
                .shouldBe(exist)
                .shouldBe(visible);
        $("#password")
                .shouldBe(exist)
                .shouldBe(visible);
        $("#loginButton")
                .shouldBe(exist)
                .shouldBe(visible);
    }
    @Test
    void test02Input() {
        $("#username").setValue("locked_out_user");
        $("#password").setValue("secret_sauce");
        $("#loginButton").click();
        $("#message").shouldHave(text("Пользователь заблокирован."));
    }
}
