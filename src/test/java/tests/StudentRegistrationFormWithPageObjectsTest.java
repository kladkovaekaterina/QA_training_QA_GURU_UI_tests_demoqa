package tests;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

// demoqa
public class StudentRegistrationFormWithPageObjectsTest extends TestBase {

    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

    // проверка заполнения всех полей
    @Test
    void successfulFillFormTest() {
        // Open form
        studentRegistrationFormPage.openPage()

        // Insert data
                .setFirstName("aaa")
                .setLastName("bbb")
                .setUserEmail("ccc@ddd.ru")
                .setGender("Female")
                .setMobile("1234567890")
                .setDateOfBirth("30", "July", "2008")
                .setSubjects("eng", "English")
                .setSubjects("com", "Computer Science")
                .setHobbies("Music")
                .setPicture("picture.JPG")
                .setCurrentAddress("Ulitsa Pushkina, dom Kolotushkina")
                .setState("Uttar Pradesh")
                .setCity("Agra")
                .submitForm()

        // Check results
                .checkSubmitResultPos("Student Name", "aaa bbb")
                .checkSubmitResultPos("Student Email", "ccc@ddd.ru")
                .checkSubmitResultPos("Gender", "Female")
                .checkSubmitResultPos("Mobile", "1234567890")
                .checkSubmitResultPos("Date of Birth", "30 July,2008")
                .checkSubmitResultPos("Subjects", "English, Computer Science")
                .checkSubmitResultPos("Hobbies", "Music")
                .checkSubmitResultPos("Picture", "picture.JPG")
                .checkSubmitResultPos("Address", "Ulitsa Pushkina, dom Kolotushkina")
                .checkSubmitResultPos("State and City", "Uttar Pradesh Agra");
    }

    // проверка минимального количества данных
    @Test
    void minimumSuccessfulFillFormTest() {
        // Open form
        studentRegistrationFormPage.openPage()

        // Insert data
                .setFirstName("aaa")
                .setLastName("bbb")
                .setGender("Female")
                .setMobile("1234567890")
                .setDateOfBirth("30", "July", "2008")
                .submitForm()

        // Check results
                .checkSubmitResultPos("Student Name", "aaa bbb")
                .checkSubmitResultPos("Gender", "Female")
                .checkSubmitResultPos("Mobile", "1234567890")
                .checkSubmitResultPos("Date of Birth", "30 July,2008");
    }

    // негативная проверка (Mobile not 10 Digits)
    @Test
    void unsuccessfulFillFormTest() {
        // Open form
        studentRegistrationFormPage.openPage()

        // Insert data
                .setFirstName("aaa")
                .setLastName("bbb")
                .setGender("Female")
                .setMobile("123456789")
                .setDateOfBirth("30", "July", "2008")
                .submitForm()

        // Check results
                .checkSubmitResultNeg();
    }

}