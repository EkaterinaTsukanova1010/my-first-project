package demo.part04;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
public class ModalTests {
    @Test
    void test01SimpleModal() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/modals/");
        $x("//div[@id='popmake-1318']").shouldBe(exist);
        $("#simpleModal").click();
        $x("//div[@id='popmake-1318']").shouldBe(visible);
        $x("//div[@id='popmake-1318']//button").shouldBe(clickable);
        $x("//div[@id='popmake-1318']//button").click();
    }
    @Test
    void test02FormModal() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10_000;
        open("https://practice-automation.com/modals/");
        $x("//div[@id='popmake-674']").shouldBe(exist);
        $("#formModal").shouldBe(visible).click();
        $("#g1051-name")
                .shouldBe(exist)
                .setValue("Ekaterina");
        $("#g1051-email")
                .shouldBe(exist)
                .setValue("test@gmail.com");
        $("#contact-form-comment-g1051-message")
                .shouldBe(exist)
                .setValue("Test test test");
        $x("//*[@class='pushbutton-wide']").click();
        $("h4").shouldHave(text("Thank you for your response."));
        Configuration.timeout = 4_000;
    }
    @Test
    void test03SmallModal() {
        open("https://demoqa.com/modal-dialogs");
        $("#showSmallModal").click();
        $(".modal-body").shouldHave(text("This is a small modal. It has very less content"));
        $("#closeSmallModal").shouldBe(visible).click();
        $(".text-center").shouldHave(text("Modal Dialogs"));
    }
    @Test
    void test04LargeModal() {
        open("https://demoqa.com/modal-dialogs");
        $("#showLargeModal").click();
        $(".modal-body").shouldHave(text("Lorem Ipsum"));
        $("#closeLargeModal").shouldBe(visible).click();
        $(".text-center").shouldHave(text("Modal Dialogs"));
    }
    @Test
    void test05SimpleModalHome() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/modals/");
        $x("//div[@id='popmake-1318']").shouldBe(exist);
        $("#simpleModal").click();
        $x("//a[@href='https://practice-automation.com/']").click();
        $x("//div[@id='popmake-1318']").shouldBe(visible);
        $x("//div[@id='popmake-1318']//button").shouldBe(clickable);
        $x("//div[@id='popmake-1318']//button").click();
    }
    @Test
    void test06SimpleModalHome() {
        Configuration.pageLoadStrategy = "eager";
        open("https://practice-automation.com/modals/");
        $x("//div[@id='popmake-1318']").shouldBe(exist);
        $("#simpleModal").click();
        $x("//div[@id='popmake-1318']").shouldBe(visible);
        $x("//div[@id='popmake-1318']//button").shouldBe(clickable);
        $x("//div[@id='popmake-1318']//button").click();
        $x("//a[@href='https://practice-automation.com/']").click();
    }
}

