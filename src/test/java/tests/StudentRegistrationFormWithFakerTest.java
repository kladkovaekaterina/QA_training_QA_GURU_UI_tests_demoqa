package tests;

import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;
import utils.RandomUtils;

// demoqa
public class StudentRegistrationFormWithFakerTest extends TestBase {

    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();
    RandomUtils randomUtils = new RandomUtils();

    // проверка заполнения всех полей
    @Test
    void successfulFillFormTest() {

        // Open form
        studentRegistrationFormPage.openPage()

        // Insert data
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setUserEmail(randomUtils.userEmail)
                .setGender(randomUtils.gender)
                .setMobile(randomUtils.mobile)
                .setDateOfBirth(randomUtils.birthDay, randomUtils.birthMonth, randomUtils.birthYear)
                .setSubjects(randomUtils.subject)
                .setHobbies(randomUtils.hobbies)
                .setPicture(randomUtils.picture)
                .setCurrentAddress(randomUtils.currentAddress)
                .setState(randomUtils.state)
                .setCity(randomUtils.city)
                .submitForm()

        // Check results
                .checkSubmitResultPos("Student Name", randomUtils.firstName + ' ' + randomUtils.lastName)
                .checkSubmitResultPos("Student Email", randomUtils.userEmail)
                .checkSubmitResultPos("Gender", randomUtils.gender)
                .checkSubmitResultPos("Mobile", randomUtils.mobile)
                .checkSubmitResultPos("Date of Birth", randomUtils.birthDay + ' ' + randomUtils.birthMonth + ',' + randomUtils.birthYear)
                .checkSubmitResultPos("Subjects", randomUtils.subject)
                .checkSubmitResultPos("Hobbies", randomUtils.hobbies)
                .checkSubmitResultPos("Picture", randomUtils.picture)
                .checkSubmitResultPos("Address", randomUtils.currentAddress)
                .checkSubmitResultPos("State and City", randomUtils.state + ' ' + randomUtils.city);
    }

    // проверка минимального количества данных
    @Test
    void minimumSuccessfulFillFormTest() {
        // Open form
        studentRegistrationFormPage.openPage()

        // Insert data
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setGender(randomUtils.gender)
                .setMobile(randomUtils.mobile)
                .setDateOfBirth(randomUtils.birthDay, randomUtils.birthMonth, randomUtils.birthYear)
                .submitForm()

        // Check results
                .checkSubmitResultPos("Student Name", randomUtils.firstName + ' ' + randomUtils.lastName)
                .checkSubmitResultPos("Gender", randomUtils.gender)
                .checkSubmitResultPos("Mobile", randomUtils.mobile)
                .checkSubmitResultPos("Date of Birth", randomUtils.birthDay + ' ' + randomUtils.birthMonth + ',' + randomUtils.birthYear);
    }

    // негативная проверка (Mobile not 10 Digits)
    @Test
    void unsuccessfulFillFormTest() {
        // Open form
        studentRegistrationFormPage.openPage()

        // Insert data
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setGender(randomUtils.gender)
                .setMobile(randomUtils.mobile.substring(0,9))
                .setDateOfBirth(randomUtils.birthDay, randomUtils.birthMonth, randomUtils.birthYear)
                .submitForm()

        // Check results
                .checkSubmitResultNeg();
    }

}