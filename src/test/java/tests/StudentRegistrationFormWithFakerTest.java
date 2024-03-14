package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.StudentRegistrationFormPage;
import utils.RandomUtils;

import static io.qameta.allure.Allure.step;

@Tag("demoqa")
@DisplayName("Проверка заполнения формы automation-practice-form")
public class StudentRegistrationFormWithFakerTest extends TestBase {

    StudentRegistrationFormPage studentRegistrationFormPage = new StudentRegistrationFormPage();
    RandomUtils randomUtils = new RandomUtils();

    @Test
    @DisplayName("Проверка заполнения всех полей")
    void successfulFillFormTest() {
        step("Open form", () -> {
            studentRegistrationFormPage.openPage();
        });
        step("Insert data", () -> {
            studentRegistrationFormPage.setFirstName(randomUtils.firstName)
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
                    .submitForm();
        });
        step("Check results", () -> {
            studentRegistrationFormPage.checkSubmitResultPos("Student Name", randomUtils.firstName + ' ' + randomUtils.lastName)
                    .checkSubmitResultPos("Student Email", randomUtils.userEmail)
                    .checkSubmitResultPos("Gender", randomUtils.gender)
                    .checkSubmitResultPos("Mobile", randomUtils.mobile)
                    .checkSubmitResultPos("Date of Birth", randomUtils.birthDay + ' ' + randomUtils.birthMonth + ',' + randomUtils.birthYear)
                    .checkSubmitResultPos("Subjects", randomUtils.subject)
                    .checkSubmitResultPos("Hobbies", randomUtils.hobbies)
                    .checkSubmitResultPos("Picture", randomUtils.picture)
                    .checkSubmitResultPos("Address", randomUtils.currentAddress)
                    .checkSubmitResultPos("State and City", randomUtils.state + ' ' + randomUtils.city);
        });
    }

    @Test
    @DisplayName("Проверка заполнения минимального количества полей")
    void minimumSuccessfulFillFormTest() {
        step("Open form", () -> {
            studentRegistrationFormPage.openPage();
        });
        step("Insert data", () -> {
            studentRegistrationFormPage.setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setGender(randomUtils.gender)
                .setMobile(randomUtils.mobile)
                .setDateOfBirth(randomUtils.birthDay, randomUtils.birthMonth, randomUtils.birthYear)
                .submitForm();
        });
        step("Check results", () -> {
            studentRegistrationFormPage.checkSubmitResultPos("Student Name", randomUtils.firstName + ' ' + randomUtils.lastName)
                .checkSubmitResultPos("Gender", randomUtils.gender)
                .checkSubmitResultPos("Mobile", randomUtils.mobile)
                .checkSubmitResultPos("Date of Birth", randomUtils.birthDay + ' ' + randomUtils.birthMonth + ',' + randomUtils.birthYear);
        });
    }

    @Test
    @DisplayName("Негативная проверка (Mobile not 10 Digits)")
    void unsuccessfulFillFormTest() {
        step("Open form", () -> {
            studentRegistrationFormPage.openPage();
        });
        step("Insert data", () -> {
            studentRegistrationFormPage.setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setGender(randomUtils.gender)
                .setMobile(randomUtils.mobile.substring(0,9))
                .setDateOfBirth(randomUtils.birthDay, randomUtils.birthMonth, randomUtils.birthYear)
                .submitForm();
        });
        step("Check results", () -> {
            studentRegistrationFormPage.checkSubmitResultNeg();
        });
    }

}