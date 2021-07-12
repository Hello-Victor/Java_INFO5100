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
    static int yearsToTrack = 5;
    static int nTeacherPerDepartment = 6;
    static int nStudentPerDepartment = 300;
    static int nfacultyPerCourse = 2;
    static double nSTDFactor = 0.2;
    static double dSTDFactor = 0.2;
    static double nCourseAssignRatio = 0.8;
    static int nSelectedCoursePerSemaster = 2;
    static int nSemaster = 4;
    static double studentGraduationRatio = 0.66666;
    static int studentGraduationAge = 25;
    static int nEmployerPerCompany = 3;
    static double meanQuilty = 0.6;
    static double stdQuilty = 0.15;
    static double relatedCourseRatio = 0.3;
    static double promotionRatio = 0.625;
    static double jobHopRatio = 0.3;
    static double salaryRaisingRatio = 0.2;
    static double feedbackRatio = 0.8;
    static int baseSalary = 180000;
    static int nCourseRelated = 3;
    static String[] Semasters = {"Spring", "Fall"};
    static String[] Companies = {"Amazon", "Google", "Facebook", "Linkedin"};
    static String[] Titles = {"Junior Staff", "Senior Staff", "Manager", "Senior Manager", "Director", "Vice President", "Senior Vice President", "Chief Technology Officer"};

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

    public static int getRandomBaseSalary(double sQuality, double cQuality) {
        int salary = (int) (baseSalary * Double.max((sQuality * 6 + cQuality * 3 + random.nextGaussian() * 1) / 5, 0.3));
        salary /= 100;
        salary *= 100;
        return salary;
    }

    public static int getPromotionSalary(int previousSalary, double sQuality, double cQuality) {
        int salary = (int) (previousSalary * Double.max(1+salaryRaisingRatio * (sQuality * 7 + cQuality * 2 + random.nextGaussian() * 1) / 6, 1));
        salary /= 100;
        salary *= 100;
        return salary;
    }

}
