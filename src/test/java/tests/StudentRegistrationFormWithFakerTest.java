package tests;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;

import static utils.RandomUtils.*;

// demoqa
public class StudentRegistrationFormWithFakerTest extends TestBase {

    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();

    // проверка заполнения всех полей
    @Test
    void successfulFillFormTest() {

        // Open form
        studentRegistrationFormPage.openPage()

        // Insert data
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setMobile(mobile)
                .setDateOfBirth(birthDay, birthMonth, birthYear)
                .setSubjects(subject)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submitForm()

        // Check results
                .checkSubmitResultPos("Student Name", firstName + ' ' + lastName)
                .checkSubmitResultPos("Student Email", userEmail)
                .checkSubmitResultPos("Gender", gender)
                .checkSubmitResultPos("Mobile", mobile)
                .checkSubmitResultPos("Date of Birth", birthDay + ' ' + birthMonth + ',' + birthYear)
                .checkSubmitResultPos("Subjects", subject)
                .checkSubmitResultPos("Hobbies", hobbies)
                .checkSubmitResultPos("Picture", picture)
                .checkSubmitResultPos("Address", currentAddress)
                .checkSubmitResultPos("State and City", state + ' ' + city);
    }

    // проверка минимального количества данных
    @Test
    void minimumSuccessfulFillFormTest() {
        // Open form
        studentRegistrationFormPage.openPage()

        // Insert data
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setMobile(mobile)
                .setDateOfBirth(birthDay, birthMonth, birthYear)
                .submitForm()

        // Check results
                .checkSubmitResultPos("Student Name", firstName + ' ' + lastName)
                .checkSubmitResultPos("Gender", gender)
                .checkSubmitResultPos("Mobile", mobile)
                .checkSubmitResultPos("Date of Birth", birthDay + ' ' + birthMonth + ',' + birthYear);
    }

    // негативная проверка (Mobile not 10 Digits)
    @Test
    void unsuccessfulFillFormTest() {
        // Open form
        studentRegistrationFormPage.openPage()

        // Insert data
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setMobile(mobile.substring(0,9))
                .setDateOfBirth(birthDay, birthMonth, birthYear)
                .submitForm()

        // Check results
                .checkSubmitResultNeg();
    }

}