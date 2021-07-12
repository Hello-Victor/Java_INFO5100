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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
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
import model.CourseCatalog.Feedback;
import model.CourseSchedule.CourseLoad;
import model.CourseSchedule.CourseOffer;
import model.CourseSchedule.CourseSchedule;
import model.CourseSchedule.SeatAssignment;
import model.Employer.EmployerDirectory;
import model.Employer.EmployerProfile;
import model.Employment.Employment;
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

    static HashMap<FacultyProfile, Double> facultyQuiltyMap = new HashMap<FacultyProfile, Double>();
    static HashMap<Company, Double> companyQuiltyMap = new HashMap<Company, Double>();
    static HashMap<StudentProfile, Double> studentQuiltyMap = new HashMap<StudentProfile, Double>();
    static HashMap<Course, Double> courseQuiltyMap = new HashMap<Course, Double>();
    static HashMap<Course, ArrayList<Double>> courseRateMap = new HashMap<Course, ArrayList<Double>>();
    static HashMap<Course, List<FacultyProfile>> courseFacultyListMap = new HashMap<Course, List<FacultyProfile>>();
    static ArrayList<Company> companies = new ArrayList<Company>();

    public static void generateFakeData() {
        constructUniversity();
        constructCompanies();
        constructCareer();
    }

    private static void constructUniversity() {
        Faker faker = FakerUtils.getFaker();
        Random random = FakerUtils.getRandom();
        University university = University.getInstance();
        CompanyDirectory companyDirectory = CompanyDirectory.getInstance();
        PersonDirectory personDirectory = PersonDirectory.getInstance();
        AccountDirectory accountDirectory = AccountDirectory.getInstance();
        Course fakeCourse = new Course("", "", 0);
        FacultyProfile fakeFacultyProfile = new FacultyProfile(new Person(), null);

        // add colleges
        JSONObject schemaObj = readSchema();
        Iterator<String> collegeKeys = schemaObj.keys();
        while (collegeKeys.hasNext()) {
            String collegeName = collegeKeys.next();
            College college;
            try {
                college = university.newCollege(collegeName);
                // add departments
                JSONObject collegeObj = schemaObj.getJSONObject(collegeName);
                Iterator<String> departmentKeys = collegeObj.keys();
                while (departmentKeys.hasNext()) {
                    String departmentName = departmentKeys.next();
                    JSONArray departmentTuple = (JSONArray) collegeObj.getJSONArray(departmentName);
                    String codePrefix = departmentTuple.getString(0);
                    JSONArray courses = departmentTuple.getJSONArray(1);
                    Department department = college.newDepartment(departmentName, codePrefix);
                    StudentDirectory studentDirectory = department.getStudentdirectory();
                    FacultyDirectory facultyDirectory = department.getFacultydirectory();
                    ArrayList<Course> courselist = new ArrayList<Course>();
                    ArrayList<FacultyProfile> facultylist = new ArrayList<FacultyProfile>();
                    ArrayList<StudentProfile> studentlist = new ArrayList<StudentProfile>();

                    // add courses
                    for (int i = 0; i < courses.length(); i++) {
                        String courseName = courses.getString(i);
                        Course course = department.newCourse(courseName, codePrefix + faker.number().digits(4), FakerUtils.credits);
                        double quality = FakerUtils.getRandomQulity(0.2);
                        courseQuiltyMap.put(course, quality);
                        courselist.add(course);
                        courseRateMap.put(course, new ArrayList<Double>());
                        courseRateMap.get(course).add(FakerUtils.varyDist(quality));
                        courseRateMap.get(course).add(FakerUtils.varyDist(quality));
                        courseRateMap.get(course).add(FakerUtils.varyDist(quality));
                    }
                    Collections.sort(courselist, Comparator.comparing(courseQuiltyMap::get));

                    // add faculties
                    int nTeacher = FakerUtils.varyCount(FakerUtils.nTeacherPerDepartment);
                    for (int i = 0; i < nTeacher; i++) {
                        Person p = personDirectory.newPerson();
                        initializePerson(p, 30, 70);
                        try {
                            FacultyProfile fp = facultyDirectory.newFacultyProfile(p, p.getId(), FakerUtils.passwd);
                            double quality = FakerUtils.getRandomQulity(0.08);
                            facultyQuiltyMap.put(fp, quality);
                            // assign faculty to courses
                            int nAssignedCourses = random.nextInt(6) + 2;
                            double factor = FakerUtils.varyDist(quality);
                            courseQuiltyMap.put(fakeCourse, factor);
                            int index = Math.abs(Collections.binarySearch(courselist, fakeCourse, Comparator.comparing(courseQuiltyMap::get)));
                            index = Integer.max(index - nAssignedCourses / 2, 0);
                            for (int j = 0; j < nAssignedCourses; j++) {
                                Course selectedCourse = courselist.get((index + j) % courselist.size());
                                if (!courseFacultyListMap.containsKey(selectedCourse)) {
                                    courseFacultyListMap.put(selectedCourse, new ArrayList<FacultyProfile>());
                                }
                                courseFacultyListMap.get(selectedCourse).add(fp);
                            }
                            facultylist.add(fp);
                        } catch (AccountDirectory.AccountNameConflictException ex) {
                        }
                    }
                    Collections.sort(facultylist, Comparator.comparing(facultyQuiltyMap::get));

                    // register semesters
                    for (int i = FakerUtils.yearsToTrack + 2; i >= 0; i--) {
                        if (i == FakerUtils.yearsToTrack + 2) {
                            department.newCourseSchedule(String.valueOf(FakerUtils.currentYear - i) + "Fall");
                        } else {
                            for (String semester : FakerUtils.Semasters) {
                                department.newCourseSchedule(String.valueOf(FakerUtils.currentYear - i) + semester);
                            }
                        }
                    }

                    // register courses to each semesters
                    for (Course course : courselist) {
                        if (!courseFacultyListMap.containsKey(course)) {
                            courseFacultyListMap.put(course, new ArrayList<FacultyProfile>());
                            Double quality = courseQuiltyMap.get(course);
                            double factor = FakerUtils.varyDist(quality);
                            facultyQuiltyMap.put(fakeFacultyProfile, factor);
                            int index = Math.abs(Collections.binarySearch(facultylist, fakeFacultyProfile, Comparator.comparing(facultyQuiltyMap::get)));
                            if (index >= facultylist.size()) {
                                index = facultylist.size() - 1;
                            }
                            courseFacultyListMap.get(course).add(facultylist.get(index));
                        }
                        for (int j = FakerUtils.yearsToTrack + 2; j >= 0; j--) {
                            for (String semester : FakerUtils.Semasters) {
                                if (FakerUtils.getRandom().nextFloat() < FakerUtils.nCourseAssignRatio) {
                                    CourseSchedule cs = department.getCourseSchedule(String.valueOf(FakerUtils.currentYear - j) + semester);
                                    if (cs == null) {
                                        continue;
                                    }
                                    CourseOffer co = cs.newCourseOffer(course.getCourseNumber());
                                    ArrayList<FacultyProfile> teacherCands = (ArrayList<FacultyProfile>) courseFacultyListMap.get(course);
                                    int index = random.nextInt(teacherCands.size());
                                    co.assignAsTeacher(teacherCands.get(index));
                                    co.generatSeats(100); // low num of seats may cause dead loop
                                }
                            }
                        }
                    }

                    // add students
                    int nStudent = FakerUtils.varyCount(FakerUtils.nStudentPerDepartment);
                    for (int i = 0; i < nStudent; i++) {
                        Person p = personDirectory.newPerson();
                        if (random.nextDouble() < FakerUtils.studentGraduationRatio) {
                            initializePerson(p, FakerUtils.studentGraduationAge, FakerUtils.studentGraduationAge + 5);
                        } else {
                            initializePerson(p, FakerUtils.studentGraduationAge - 1, FakerUtils.studentGraduationAge - 1);
                        }
                        try {
                            StudentProfile sp = studentDirectory.newStudentProfile(p, p.getId(), FakerUtils.passwd);
                            studentQuiltyMap.put(sp, FakerUtils.getRandomQulity());
                            studentlist.add(sp);
                            double quality = FakerUtils.getRandomQulity();
                            studentQuiltyMap.put(sp, quality);
                            int nYears = 2 - Integer.min(Integer.max(FakerUtils.studentGraduationAge - p.getAge(), 0), 2);
                            int nCourses = nYears * FakerUtils.Semasters.length * FakerUtils.nSelectedCoursePerSemaster;
                            double factor = FakerUtils.varyDist(quality);
                            courseQuiltyMap.put(fakeCourse, factor);
                            int index = Math.abs(Collections.binarySearch(courselist, fakeCourse, Comparator.comparing(courseQuiltyMap::get)));
                            index = Integer.max(index - nCourses / 2, 0);
                            int first_year = FakerUtils.currentYear - (p.getAge() - FakerUtils.studentGraduationAge + 2);
                            int last_year = Integer.min(FakerUtils.currentYear, first_year + 2);
                            for (int year = first_year; year <= last_year; year++) {
                                for (String season : FakerUtils.Semasters) {
                                    if (year == first_year && (!season.equals("Fall"))) {
                                        continue;
                                    }
                                    if (year == last_year && (!season.equals("Spring"))) {
                                        continue;
                                    }
                                    String semester = String.valueOf(year) + season;
                                    CourseLoad cl = sp.newCourseLoad(semester);
                                    for (int j = 0; j < FakerUtils.nSelectedCoursePerSemaster; j++) {
                                        Course courseToSelect = null;
                                        CourseOffer co = null;
                                        while (co == null || sp.getTranscript().isCourseSelected(courseToSelect)) {
                                            courseToSelect = courselist.get(index % courselist.size());
                                            co = department.getCourseSchedule(semester).getCourseOfferByNumber(courseToSelect.getCourseNumber());
                                            index++;
                                        }
                                        SeatAssignment sa = co.assignEmptySeat(cl);
                                        if (sa == null) {
                                            index++;
                                            j--;
                                            continue;
                                        }
                                        double facultyQuality = facultyQuiltyMap.get(co.getFacultyProfile());
                                        sa.getSeat().setGrade(FakerUtils.getRandomGrade(quality));
                                        if (random.nextDouble() < FakerUtils.feedbackRatio) {
                                            sa.getSeat().setFeedback(FakerUtils.getRandomFeedback(courseRateMap.get(courseToSelect).get(0), facultyQuality),
                                                    FakerUtils.getRandomFeedback(courseRateMap.get(courseToSelect).get(1), facultyQuality),
                                                    FakerUtils.getRandomFeedback(courseRateMap.get(courseToSelect).get(2), facultyQuality));
                                        }
                                    }
                                }
                            }
                            if (FakerUtils.studentGraduationAge - p.getAge() > 0) {
                                int selected = 0;
                                int shouldSelect = random.nextInt(FakerUtils.nSelectedCoursePerSemaster + 1);
                                String semester = String.valueOf(FakerUtils.currentYear) + "Fall";
                                CourseLoad cl = sp.newCourseLoad(semester);
                                while (selected < shouldSelect) {
                                    Course courseToSelect = null;
                                    CourseOffer co = null;
                                    while (co == null || sp.getTranscript().isCourseSelected(courseToSelect)) {
                                        courseToSelect = courselist.get(index % courselist.size());
                                        co = department.getCourseSchedule(semester).getCourseOfferByNumber(courseToSelect.getCourseNumber());
                                        index++;
                                    }
                                    SeatAssignment sa = co.assignEmptySeat(cl);
                                    if (sa == null) {
                                        index++;
                                        continue;
                                    }
                                    selected++;
                                }
                            }
                        } catch (AccountDirectory.AccountNameConflictException ex) {
                        }
                    }
                    Collections.sort(studentlist, Comparator.comparing(studentQuiltyMap::get));
                }
            } catch (Exception ex) {
            }

        }
    }

    private static void constructCompanies() {
        Faker faker = FakerUtils.getFaker();
        CompanyDirectory companyDirectory = CompanyDirectory.getInstance();
        PersonDirectory personDirectory = PersonDirectory.getInstance();
        AccountDirectory accountDirectory = AccountDirectory.getInstance();
        for (String name : FakerUtils.Companies) {
            Company cmp = companyDirectory.newCompany(name, faker.company().profession(), faker.address().streetAddress());
            EmployerDirectory ed = cmp.getEmployerDirectory();
            int nEmployer = FakerUtils.varyCount(FakerUtils.nEmployerPerCompany);
            double quality = FakerUtils.getRandomQulity(0.08);
            companyQuiltyMap.put(cmp, quality);
            companies.add(cmp);
            for (int i = 0; i < nEmployer; i++) {
                Person p = personDirectory.newPerson();
                initializePerson(p, 30, 70);
                try {
                    EmployerProfile ep = ed.newEmployerProfile(p, p.getId(), FakerUtils.passwd);
                } catch (Exception ex) {
                }
            }
        }
        Collections.sort(companies, Comparator.comparing(companyQuiltyMap::get));
    }

    private static void constructCareer() {
        Faker faker = FakerUtils.getFaker();
        Random random = FakerUtils.getRandom();
        University university = University.getInstance();
        CompanyDirectory companyDirectory = CompanyDirectory.getInstance();
        PersonDirectory personDirectory = PersonDirectory.getInstance();
        AccountDirectory accountDirectory = AccountDirectory.getInstance();
        Company fakeCompany = new Company();
        Course fakeCourse = new Course("", "", 0);
        for (College clg : university.getColleges().values()) {
            for (Department dpt : clg.getDepartments().values()) {
                for (StudentProfile sp : dpt.getStudentdirectory().getStudentMap().values()) {
                    ArrayList<Course> courselist = new ArrayList<Course>();
                    HashMap<Course, CourseOffer> courseoffermap = new HashMap<Course, CourseOffer>();
                    for (CourseLoad cllll : sp.getTranscript().getCourseloadlist().values()) {
                        for (SeatAssignment sa : cllll.getSeatassignments()) {
                            CourseOffer coooo = sa.getSeat().getCourseoffer();
                            courselist.add(coooo.getCourse());
                            courseoffermap.put(coooo.getCourse(), coooo);
                        }
                    }
                    double sQuality = studentQuiltyMap.get(sp);
                    double sFactor = FakerUtils.varyDist(sQuality);
                    companyQuiltyMap.put(fakeCompany, sFactor);
                    int index = Math.abs(Collections.binarySearch(companies, fakeCompany, Comparator.comparing(companyQuiltyMap::get)));
                    index = Integer.min(Integer.max(index - 1, 0), companies.size() - 1);
                    Company co = companies.get(index);
                    Company cco = co;
                    int sage = sp.getPerson().getAge();
                    int previousSalary = FakerUtils.getRandomBaseSalary(sQuality, companyQuiltyMap.get(co));
                    int previousTitle = 0;
                    EmployerProfile ep = (EmployerProfile) co.getEmployerDirectory().getEmployerMap().values().toArray()[random.nextInt(co.getEmployerDirectory().getEmployerMap().size())];
                    int first_year = FakerUtils.currentYear - (sage - FakerUtils.studentGraduationAge);
                    if (first_year <= FakerUtils.currentYear) {
                        sp.setFirstEmployment(ep, first_year, FakerUtils.Titles[previousTitle], previousSalary);
                        Employment e = sp.getEmploymenthistory().getEmployments().last().getLastPosition();
                        int nRelatedCourse = FakerUtils.varyCount(FakerUtils.nCourseRelated);
                        double factor = FakerUtils.varyDist((sQuality + companyQuiltyMap.get(cco)) / 2);
                        courseQuiltyMap.put(fakeCourse, factor);
                        int cindex = Math.abs(Collections.binarySearch(courselist, fakeCourse, Comparator.comparing(courseQuiltyMap::get)));
                        cindex = Integer.max(index - nRelatedCourse / 2, 0);
                        for (int iii = cindex; iii < cindex + nRelatedCourse; iii++) {
                            e.addRelevantcourseoffer(courseoffermap.get(courselist.get(iii % courselist.size())));
                        }
                    }
                    for (int year = first_year + 1; year <= FakerUtils.currentYear; year++) {
                        if (random.nextDouble() < FakerUtils.promotionRatio * sQuality * sQuality * sQuality * companyQuiltyMap.get(cco)) {
                            if (random.nextDouble() < FakerUtils.jobHopRatio) {
                                sFactor = FakerUtils.varyDist(sQuality * 1.3);
                                companyQuiltyMap.put(fakeCompany, sFactor);
                                index = Math.abs(Collections.binarySearch(companies, fakeCompany, Comparator.comparing(companyQuiltyMap::get)));
                                index = Integer.min(Integer.max(index - 1, 0), companies.size() - 1);
                                cco = companies.get(index);
                            }
                            for (int x = 0; x < (random.nextInt(2) + 1) * 0.6; x++) {
                                previousSalary = FakerUtils.getPromotionSalary(previousSalary, sQuality, companyQuiltyMap.get(co));
                                previousTitle++;
                            }
                            if (cco == co) {
                                sp.getEmploymenthistory().promote(year, FakerUtils.Titles[previousTitle], previousSalary);
                            } else {
                                co = cco;
                                ep = (EmployerProfile) co.getEmployerDirectory().getEmployerMap().values().toArray()[random.nextInt(co.getEmployerDirectory().getEmployerMap().size())];
                                sp.getEmploymenthistory().jobHop(ep, year, FakerUtils.Titles[previousTitle], previousSalary);
                            }
                            Employment e = sp.getEmploymenthistory().getEmployments().last().getLastPosition();
                            int nRelatedCourse = FakerUtils.varyCount(FakerUtils.nCourseRelated);
                            double factor = FakerUtils.varyDist((sQuality + companyQuiltyMap.get(cco)) / 2);
                            courseQuiltyMap.put(fakeCourse, factor);
                            int cindex = Math.abs(Collections.binarySearch(courselist, fakeCourse, Comparator.comparing(courseQuiltyMap::get)));
                            cindex = Integer.max(index - nRelatedCourse / 2, 0);
                            for (int iii = cindex; iii < cindex + nRelatedCourse; iii++) {
                                e.addRelevantcourseoffer(courseoffermap.get(courselist.get(iii % courselist.size())));
                            }
                        }
                    }
                }
            }
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
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, FakerUtils.currentYear - age);
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
    }
}
