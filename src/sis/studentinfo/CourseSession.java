package sis.studentinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CourseSession {
    private String department;
    private String number;
    private ArrayList<Student> students = new ArrayList<>();
    private Date startDate;
    private int numberOfCredits;

    private static int count;

    public static CourseSession create(
            String department,
            String number,
            Date startDate) {
        incrementCount();
        return new CourseSession(department, number, startDate);
    }

    static int getCount() {
        return count;
    }

    static void resetCount() {
        count = 0;
    }

    String getDepartment() {
        return department;
    }

    String getNumber() {
        return number;
    }

    int getNumberOfStudents() {
        return students.size();
    }

    public void enroll(Student student) {
        student.addCredits(numberOfCredits);
        students.add(student);
    }

    Student get(int index) {
        return students.get(index);
    }

    Date getEndDate() {
        final int sessionWeeks = 16;
        final int daysInWeek = 7;
        final int daysFromFridayToMonday = 3;
        int duration = sessionWeeks * daysInWeek - daysFromFridayToMonday;

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_YEAR, duration);

        return calendar.getTime();
    }

    Date getStartDate() {
        return startDate;
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    private CourseSession(String department, String number, Date startDate) {
        this.department = department;
        this.number = number;
        this.startDate = startDate;
    }

    private static void incrementCount() {
        count ++;
    }

    void setNumberOfCredits(int numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }
}
