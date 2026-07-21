import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import static com.codeborne.selenide.Selenide.*;

public class AlertsTests {
    @Test
    void test01SimpleAlert() {
        open("https://demoqa.com/alerts");
        $("#alertButton").click();
        switchTo().alert().accept();
    }
    @Test
    void test02() {
        open("https://demoqa.com/alerts");
        Configuration.timeout = 6_000;
        $("#timerAlertButton").click();
        switchTo().alert().accept();
        Configuration.timeout = 4_000;
    }
    @Test
    void test03() {
        open("https://demoqa.com/alerts");
        $("#confirmButton").click();
        switchTo().alert().accept();
    }
    @Test
    void test04() {
        open("https://demoqa.com/alerts");
        $("#confirmButton").click();
        switchTo().alert().dismiss();
    }
    @Test
    void test05() {
        open("https://demoqa.com/alerts");
        sleep(2_000);
        $("#promtButton").click();
        Alert alert = switchTo().alert();
        alert.sendKeys("Екатерина");
        alert.accept();
    }
    @Test
    void test06() {
        open("https://demoqa.com/alerts");
        $("#promtButton").click();
        Alert alert = switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
    }
}



