package sis.studentinfo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;


public class CourseSessionTest {
    private CourseSession session;
    private Date startDate;
    private static final int CREDITS = 3;

    @Before public void setUp() {
        startDate = DateUtil.createDate(2003, 1, 6);
        session = createCourseSession();
    }

    @Test public void create() {
        assertEquals("ENGL", session.getDepartment());
        assertEquals("101", session.getNumber());
        assertEquals(0, session.getNumberOfStudents());
        assertEquals(startDate, session.getStartDate());
    }

    @Test public void enrollStudents() {
        Student s1 = new Student("Cain DiVoe");
        session.enroll(s1);
        assertEquals(CREDITS, s1.getCredits());
        assertEquals(1, session.getNumberOfStudents());
        Assert.assertEquals(s1, session.get(0));

        Student s2 = new Student("Mike 123");
        session.enroll(s2);
        assertEquals(CREDITS, s1.getCredits());
        assertEquals(2, session.getNumberOfStudents());
        Assert.assertEquals(s2, session.get(1));
    }

    @Test public void courseDates() {
        CourseSession session = CourseSession.create("ABCD", "200", startDate);
        Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
        assertEquals(sixteenWeeksOut, session.getEndDate());
    }

    @Test public void count() {
        CourseSession.resetCount();
        createCourseSession();
        assertEquals(1, CourseSession.getCount());
        createCourseSession();
        assertEquals(2, CourseSession.getCount());
    }

    private CourseSession createCourseSession() {
        session = CourseSession.create("ENGL", "101", startDate);
        session.setNumberOfCredits(CourseSessionTest.CREDITS);
        return session;
    }

}
