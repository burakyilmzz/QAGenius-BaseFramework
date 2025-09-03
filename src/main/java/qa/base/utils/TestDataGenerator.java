package qa.base.utils;

import com.github.javafaker.Faker;
import java.util.Random;
import java.util.UUID;

public class TestDataGenerator {
    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static String generateEmail() {
        return faker.internet().emailAddress();
    }

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static String generatePhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateAddress() {
        return faker.address().fullAddress();
    }

    public static String generateCompanyName() {
        return faker.company().name();
    }

    public static String generateRandomString(int length) {
        return UUID.randomUUID().toString().substring(0, length);
    }

    public static int generateRandomInt(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    public static String generateRandomPassword() {
        return faker.internet().password(8, 16, true, true, true);
    }
}
