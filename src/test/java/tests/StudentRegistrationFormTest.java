package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

// demoqa
public class StudentRegistrationFormTest extends TestBase {

    // проверка заполнения всех полей
    @Test
    void successfulFillFormTest() {
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
        $("#uploadPicture").uploadFromClasspath("picture0.JPG");
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
        $(".table-responsive").shouldHave(text("picture0.JPG"));
        $(".table-responsive").shouldHave(text("Ulitsa Pushkina, dom Kolotushkina"));
        $(".table-responsive").shouldHave(text("Uttar Pradesh Agra"));
    }

    // проверка минимального количества данных
    @Test
    void minimumSuccessfulFillFormTest() {
        // Open form
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        // Insert data
        // Name
        $("#firstName").setValue("aaa");
        $("#lastName").setValue("bbb");
        // Gender
        $("#genterWrapper").$(byText("Female")).click();
        // Mobile
        $("#userNumber").setValue("1234567890");
        // Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("June");
        $(".react-datepicker__year-select").selectOptionContainingText("1992");
        $(".react-datepicker__day--004").click();
        // Submit
        $("#submit").click();

        // Check results
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("aaa bbb"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("04 June,1992"));
    }

    // негативная проверка (Mobile not 10 Digits)
    @Test
    void unsuccessfulFillFormTest() {
        // Open form
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        // Insert data
        // Name
        $("#firstName").setValue("aaa");
        $("#lastName").setValue("bbb");
        // Gender
        $("#genterWrapper").$(byText("Female")).click();
        // Mobile
        $("#userNumber").setValue("123456789");
        // Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("June");
        $(".react-datepicker__year-select").selectOptionContainingText("1992");
        $(".react-datepicker__day--004").click();
        // Submit
        $("#submit").click();

        // Check results
        $("[class]").shouldNotHave((text("Thanks for submitting the form")));
    }

}