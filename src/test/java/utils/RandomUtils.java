package utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class RandomUtils {
    private static Faker faker = new Faker(new Locale("en"));
    private static SimpleDateFormat sdfDay = new SimpleDateFormat("d");
    private static SimpleDateFormat sdfMonth = new SimpleDateFormat("MMMM", new Locale("en"));
    private static SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

    public static String firstName = generateRandomFirstName(),
            lastName = generateRandomLastName(),
            userEmail = generateRandomUserEmail(),
            gender = generateRandomGender(),
            mobile = generateRandomMobile(),
            birthDay = generateRandomBirthDay(),
            birthMonth = generateRandomBirthMonth(),
            birthYear = generateRandomBirthYear(),
            subject = generateRandomSubject1(),
            hobbies = generateRandomHobbies(),
            picture = generateRandomPicture(),
            currentAddress = generateRandomCurrentAddress(),
            state = generateRandomState(),
            city = generateRandomCity();

    public static String generateRandomFirstName() {
        firstName = faker.name().firstName();

        return firstName;
    }

    public static String generateRandomLastName() {
        lastName = faker.name().lastName();

        return lastName;
    }

    public static String generateRandomUserEmail() {
        userEmail = faker.internet().emailAddress();

        return userEmail;
    }

    public static String generateRandomGender() {
        gender = faker.options().option("Male", "Female", "Other");

        return gender;
    }

    public static String generateRandomMobile() {
        mobile = faker.phoneNumber().subscriberNumber(10);

        return mobile;
    }

    public static String generateRandomBirthDay() {
        birthDay = sdfDay.format(faker.date().birthday());

        return birthDay;
    }

    public static String generateRandomBirthMonth() {
        birthMonth = sdfMonth.format(faker.date().birthday());

        return birthMonth;
    }

    public static String generateRandomBirthYear() {
        birthYear = sdfYear.format(faker.date().birthday());

        return birthYear;
    }

    public static String generateRandomSubject1() {
        subject = faker.options().option("Accounting", "Arts", "Biology", "Chemistry", "Civics", "Commerce", "Computer Science", "Economics", "English", "Hindi", "History", "Maths", "Physics", "Social Studies");

        return subject;
    }

    public static String generateRandomHobbies() {
        hobbies = faker.options().option("Sports", "Reading", "Music");

        return hobbies;
    }

    public static String generateRandomPicture() {
        picture = faker.options().option("picture0.JPG", "picture1.JPG", "picture2.JPG");

        return picture;
    }

    public static String generateRandomCurrentAddress() {
        currentAddress = faker.address().fullAddress();

        return currentAddress;
    }

    public static String generateRandomState() {
        state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

        return state;
    }

    public static String generateRandomCity() {
        if (state.equals("NCR"))
            city = faker.options().option("Delhi", "Gurgaon", "Noida");
        else if (state.equals("Uttar Pradesh"))
            city = faker.options().option("Agra", "Lucknow", "Merrut");
        else if (state.equals("Haryana"))
            city = faker.options().option("Karnal", "Panipat");
        else if (state.equals("Rajasthan"))
            city = faker.options().option("Jaipur", "Jaiselmer");

        return city;
    }

}