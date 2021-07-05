/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Faker;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import org.json.*;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import java.util.Iterator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import model.Persona.Person;
import model.College.College;
import model.Department.Department;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Company.Company;
import model.Company.CompanyDirectory;
import model.CourseCatalog.Course;
import model.Persona.AccountDirectory;
import model.Persona.Faculty.FacultyDirectory;
import model.Persona.Faculty.FacultyProfile;
import model.Persona.PersonDirectory;
import model.Persona.StudentDirectory;
import model.Persona.StudentProfile;

import model.University.University;

/**
 *
 * @author aeloyq
 */
public class FakerFactory {

    public static void constructUniversity() {
        Faker faker = FakerUtils.getFaker();
        University university = University.getInstance();
        CompanyDirectory companyDirectory = CompanyDirectory.getInstance();
        PersonDirectory personDirectory = PersonDirectory.getInstance();
        AccountDirectory accountDirectory = AccountDirectory.getInstance();

        JSONObject schemaObj = readSchema();
        Iterator<String> collegeKeys = schemaObj.keys();

        HashMap<FacultyProfile, Double> facultyQuiltyMap = new HashMap<FacultyProfile, Double>();
        HashMap<StudentProfile, Double> studentQuiltyMap = new HashMap<StudentProfile, Double>();
        
        while (collegeKeys.hasNext()) {
            String collegeName = collegeKeys.next();
            College college = university.newCollege(collegeName);
            JSONObject collegeObj = schemaObj.getJSONObject(collegeName);
            Iterator<String> departmentKeys = collegeObj.keys();
            while (departmentKeys.hasNext()) {
                String departmentName = departmentKeys.next();
                JSONArray departmentTuple = (JSONArray) collegeObj.getJSONArray(departmentName);
                String codePrefix = departmentTuple.getString(0);
                JSONArray courses = departmentTuple.getJSONArray(1);
                Department department = college.newDepartment(departmentName, codePrefix);
                for (int i = 0; i < 8; i++) {
                    for (String semester : FakerUtils.Semasters) {
                        department.newCourseSchedule(String.valueOf(FakerUtils.currentYear - i) + semester);
                    }
                }
                StudentDirectory studentDirectory = department.getStudentDirectory();
                FacultyDirectory facultyDirectory = department.getFacultydirectory();
                int nTeacher = FakerUtils.varyCount(FakerUtils.nTeacherPerDepartment);
                for (int i = 0; i < nTeacher; i++) {
                    Person p = personDirectory.newPerson();
                    initializePerson(p, 30, 70);
                    try {
                        facultyDirectory.newFacultyProfile(p, p.getId(), FakerUtils.passwd);
                    } catch (AccountDirectory.AccountNameConflictException ex) {
                    }
                }
                int nStudent = FakerUtils.varyCount(FakerUtils.nStudentPerDepartment);
                for (int i = 0; i < nStudent; i++) {
                    Person p = personDirectory.newPerson();
                    initializePerson(p, FakerUtils.studentGraduationAge - 3, FakerUtils.studentGraduationAge + 5);
                    try {
                        studentDirectory.newStudentProfile(p, p.getId(), FakerUtils.passwd);
                    } catch (AccountDirectory.AccountNameConflictException ex) {
                    }
                }
                HashMap<Course, List<FacultyProfile>> courseFacultyListMap = new HashMap<Course, List<FacultyProfile>>();
                for (int i = 0; i < courses.length(); i++) {
                    String courseName = courses.getString(i);
                    Course course = department.newCourse(courseName, codePrefix + faker.number().digits(4), FakerUtils.credits);
                    for (int j = 0; j < 8; j++) {
                        for (String semester : FakerUtils.Semasters) {
                            if (FakerUtils.getRandom().nextFloat() < FakerUtils.nCourseAssignRatio) {
                                department.getCourseSchedule(String.valueOf(FakerUtils.currentYear - j) + semester).newCourseOffer(course.getCourseNumber());
                            }
                        }
                    }
                }
            }
        }
    }

    public static void constructCompanies() {
        Faker faker = FakerUtils.getFaker();
        HashMap<Company, Double> companyQuiltyMap = new HashMap<Company, Double>();
        CompanyDirectory companyDirectory = CompanyDirectory.getInstance();
        for (String name : FakerUtils.Companies) {
            companyDirectory.newCompany(name, faker.company().profession(), faker.address().streetAddress());
        }
    }

    private static JSONObject readSchema() {
        try {
            File schemaFile = new File(FakerUtils.universitySchemaFile);
            Scanner myReader = new Scanner(schemaFile);
            String schemaText = "";
            while (myReader.hasNextLine()) {
                schemaText += myReader.nextLine();
            }
            myReader.close();
            JSONObject schemaObj = new JSONObject(schemaText);
            return schemaObj;
        } catch (FileNotFoundException e) {
            System.out.println("universitySchemaFile not found.");
            return null;
        } catch (Exception e) {
            System.out.println("failed to parse universitySchemaFile to json object.");
            return null;
        }
    }

    private static void initializePerson(Person person, int minAge, int maxAge) {
        Faker faker = FakerUtils.getFaker();
        person.setAddress(faker.address().streetAddress());
        int age = (int) (minAge + FakerUtils.getRandom().nextInt(1 + maxAge - minAge));
        Date date = faker.date().birthday();
        date.setYear(FakerUtils.currentYear - age);
        person.setBirthDate(date.toString());
        person.setEmail(faker.internet().emailAddress());
        Name name = faker.name();
        person.setFirstname(name.firstName());
        person.setLastname(name.lastName());
        person.setGender(faker.demographic().sex());
        person.setNation(faker.nation().nationality());
        person.setPhoneNumberString(faker.phoneNumber().cellPhone());
        person.setRace(faker.demographic().race());
        person.setSsn(faker.idNumber().ssnValid());

    }
}
