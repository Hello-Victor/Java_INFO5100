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
    static int nTeacherPerDepartment = 5;
    static int nStudentPerDepartment = 200;
    static int nfacultyPerCourse = 2;
    static double nPersonSTDFactor = 0.2;
    static double nCourseAssignRatio = 0.8;
    static int nSelectedCoursePerSemaster = 1;
    static int nSemaster = 4;
    static double studentGraduationRatio = 0.9;
    static int studentGraduationAge = 23;
    static int nEmployerPerCompany = 3;
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
        return (int) (n + random.nextGaussian() * (n * nPersonSTDFactor));
    }

}
