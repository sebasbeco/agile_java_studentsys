package sis.studentinfo;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    @Test public void create() {
        final String studentName1 = "Jana Doe";
        final String studentName2 = "Joe Blow";

        Student student = new Student(studentName1);
        assertEquals(studentName1, student.getName());

        Student student2 = new Student(studentName2);
        assertEquals(studentName2, student2.getName());
    }

    @Test public void studentStatus() {
        Student student = new Student("a");
        assertEquals(0, student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredits(3);
        assertEquals(3, student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredits(8);
        assertEquals(11, student.getCredits());
        assertFalse(student.isFullTime());

        student.addCredits(1);
        assertEquals(
            Student.CREDITS_REQUIRED_FOR_FULL_TIME,
            student.getCredits()
        );
        assertTrue(student.isFullTime());
    }

    @Test public void inState() {
        Student student = new Student("a");
        assertFalse(student.isInState());

        student.setState(Student.IN_STATE);
        assertTrue(student.isInState());

        student.setState("MD");
        assertFalse(student.isInState());
    }

}
