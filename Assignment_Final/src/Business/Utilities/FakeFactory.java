/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Utilities;

import Business.Employee.Person;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.DrbgParameters;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import org.json.JSONArray;

/**
 *
 * @author aeloyq
 */
public class FakeFactory {

    static Locale locale = new Locale("en-US");
    static Random random = new Random(8888);
    static Faker faker = new Faker(locale, random);
    static String passwd = "12345";
    static double nSTDFactor = 0.2;
    static double dSTDFactor = 0.2;
    static double meanQuilty = 0.6;
    static double stdQuilty = 0.15;
    static int currentYear = 2021;
    static int currentAddressCount = -1;
    static int currentFeedbackCount = -1;
    static int currentMessageCount = -1;
    static JSONArray addresses;
    static JSONArray feedbacks;
    static JSONArray messages;

    public static void init() {
        try {
            File schemaFile = new File("./src/res/data/fake_address.json");
            Scanner myReader = new Scanner(schemaFile);
            String schemaText = "";
            while (myReader.hasNextLine()) {
                schemaText += myReader.nextLine();
            }
            myReader.close();
            addresses = new JSONArray(schemaText);
        } catch (FileNotFoundException e) {
            System.out.println("universitySchemaFile not found.");
        } catch (Exception e) {
            System.out.println("failed to parse universitySchemaFile to json object.");
        }
        try {
            File schemaFile = new File("./src/res/data/feedback.json");
            Scanner myReader = new Scanner(schemaFile);
            String schemaText = "";
            while (myReader.hasNextLine()) {
                schemaText += myReader.nextLine();
            }
            myReader.close();
            feedbacks = new JSONArray(schemaText);
        } catch (FileNotFoundException e) {
            System.out.println("universitySchemaFile not found.");
        } catch (Exception e) {
            System.out.println("failed to parse universitySchemaFile to json object.");
        }
//        try {
//            File schemaFile = new File("./src/res/data/message.json");
//            Scanner myReader = new Scanner(schemaFile);
//            String schemaText = "";
//            while (myReader.hasNextLine()) {
//                schemaText += myReader.nextLine();
//            }
//            myReader.close();
//            messages = new JSONArray(schemaText);
//        } catch (FileNotFoundException e) {
//            System.out.println("universitySchemaFile not found.");
//        } catch (Exception e) {
//            System.out.println("failed to parse universitySchemaFile to json object.");
//        }
    }

    public static Faker getFaker() {
        return faker;
    }

    public static Random getRandom() {
        return random;
    }

    public static int varyCount(int n) {
        return (int) (n + random.nextGaussian() * (n * nSTDFactor));
    }

    public static double varyDist(double n) {
        return n + random.nextGaussian() * (n * dSTDFactor);
    }

    public static double getRandomQulity() {
        return Double.max(Double.min(random.nextGaussian() * stdQuilty + meanQuilty, 0.99), 0.01);
    }

    public static double getRandomQulity(double std) {
        return Double.max(Double.min(random.nextGaussian() * std + meanQuilty, 0.99), 0.01);
    }

    public static double getRandomQulity(double mean, double std) {
        return Double.max(Double.min(random.nextGaussian() * std + mean, 0.99), 0.01);
    }

    public static double getRandomGrade(double quality) {
        return Double.min(Double.max(2.1 + quality * 2 + random.nextGaussian() * 0.2, 1.0), 4.0);
    }

    public static int getRandomFeedback(double quality, double facultyQuality) {
        return (int) Double.min(Double.max(2.0 + quality * 3 + facultyQuality + random.nextGaussian() * 0.2, 1.0), 5.0);
    }

    public static Date getRandomDate(Date date, double offset) {
        Date newDate = new Date();
        newDate.setTime(date.getTime() + (int) (offset * 3600 * 24 * 1000));
        return newDate;
    }

    public static String getRandomaddress() {
        currentAddressCount++;
        String res;
        try {
            res = addresses.getString(currentAddressCount);
        } catch (Exception ex) {
            currentAddressCount = 0;
            res = addresses.getString(currentAddressCount);
        }
        return res;
    }

    public static String getRandomfeedback() {
        currentFeedbackCount++;
        String res;
        try {
            res = feedbacks.getString(currentFeedbackCount);
        } catch (Exception ex) {
            currentFeedbackCount = 0;
            res = feedbacks.getString(currentFeedbackCount);
        }
        return res;
    }

    public static String getRandommessage() {
        currentMessageCount++;
        String res;
        try {
            res = messages.getString(currentMessageCount);
        } catch (Exception ex) {
            currentMessageCount = 0;
            res = messages.getString(currentMessageCount);
        }
        return res;
    }

    public static Person getRandomPerson() {
        int maxAge = 60;
        int minAge = 18;
        Person person = new Person();
        person.setAddress(faker.address().streetAddress());
        int age = (int) (minAge + random.nextInt(1 + maxAge - minAge));
        Date date = faker.date().birthday();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, currentYear - age);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        person.setBirthDate(calendar.getTime());
        person.setEmail(faker.internet().emailAddress());
        Name name = faker.name();
        person.setFirstname(name.firstName());
        person.setLastname(name.lastName());
        person.setGender(faker.demographic().sex());
        person.setNation(faker.nation().nationality());
        person.setPhoneNumberString(faker.phoneNumber().cellPhone());
        person.setRace(faker.demographic().race());
        person.setSsn(faker.idNumber().ssnValid());
        return person;
    }
}
