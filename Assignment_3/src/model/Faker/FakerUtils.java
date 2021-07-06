/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Faker;

import com.github.javafaker.Faker;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 *
 * @author aeloyq
 */
public class FakerUtils {

    static Locale locale = new Locale("en-US");
    static Random random = new Random(8888);
    static Faker faker = new Faker(locale, random);
    static String universitySchemaFile = "./res/UniversitySchema.json";
    static String passwd = "12345";
    static int currentYear = 2021;
    static int nTeacherPerDepartment = 6;
    static int nStudentPerDepartment = 300;
    static int nfacultyPerCourse = 2;
    static double nSTDFactor = 0.2;
    static double dSTDFactor = 0.2;
    static double nCourseAssignRatio = 0.8;
    static int nSelectedCoursePerSemaster = 2;
    static int nSemaster = 4;
    static double studentGraduationRatio = 0.9;
    static int studentGraduationAge = 23;
    static int nEmployerPerCompany = 3;
    static double meanQuilty = 0.6;
    static double stdQuilty = 0.3;
    static double relatedCourseRatio = 0.3;
    static double promotionRatio = 0.1;
    static double salaryRaisingRatio = 0.3;
    static double feedbackRatio = 0.8;
    static int baseSalary = 80000;
    static String[] Semasters = {"Fall", "Spring"};
    static String[] Companies = {"Amazon", "Google"};

    static int credits = 4;

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

    public static double getRandomGrade(double quality) {
        return Double.min(Double.max(2.1 + quality * 2 + random.nextGaussian() * 0.2, 1.0), 4.0);
    }

    public static int getRandomFeedback(double quality, double facultyQuality) {
        return (int) Double.min(Double.max(1.0 + quality * 3 + facultyQuality + random.nextGaussian() * 0.2, 1.0), 5.0);
    }

}
