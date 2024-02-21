import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

// demoqa
public class StudentRegistrationFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "firefox";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        // Open form
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        // Insert data
        // Name
        $("#firstName").setValue("aaa");
        $("#lastName").setValue("bbb");
        // Email
        $("#userEmail").setValue("ccc@ddd.ru");
        // Gender
        $("#genterWrapper").$(byText("Female")).click();
        // Mobile
        $("#userNumber").setValue("1234567890");
        // Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("June");
        $(".react-datepicker__year-select").selectOptionContainingText("1992");
        $(".react-datepicker__day--004").click();
        // Subjects
        $(".subjects-auto-complete__value-container").click();
        $("#subjectsInput").press("eng");
        $(byText("English")).click();
        $("#subjectsInput").press("com");
        $(byText("Computer Science")).click();
        // Hobbies
        $("#hobbiesWrapper").$(byText("Music")).click();
        // Picture
        $("#uploadPicture").uploadFromClasspath("picture.JPG");
        // Current Address
        $("#currentAddress").setValue("Ulitsa Pushkina, dom Kolotushkina");
        // State and City
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        // Submit
        $("#submit").click();

        // Check results
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("aaa bbb"));
        $(".table-responsive").shouldHave(text("ccc@ddd.ru"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("04 June,1992"));
        $(".table-responsive").shouldHave(text("English, Computer Science"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("picture.JPG"));
        $(".table-responsive").shouldHave(text("Ulitsa Pushkina, dom Kolotushkina"));
        $(".table-responsive").shouldHave(text("Uttar Pradesh Agra"));
    }
}