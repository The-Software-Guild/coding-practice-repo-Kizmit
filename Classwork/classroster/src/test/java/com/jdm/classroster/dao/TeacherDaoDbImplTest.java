/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.classroster.dao;

import com.jdm.classroster.dao.CourseDao;
import com.jdm.classroster.dao.StudentDao;
import com.jdm.classroster.dao.TeacherDao;
import com.jdm.classroster.entities.Course;
import com.jdm.classroster.entities.Student;
import com.jdm.classroster.entities.Teacher;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
@SpringBootTest
public class TeacherDaoDbImplTest {
    @Autowired
    TeacherDao teacherDao;
    
    @Autowired
    StudentDao studentDao;
    
    @Autowired
    CourseDao courseDao;
    
    
    public TeacherDaoDbImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach 
    public void setUp() {
        List<Teacher> teachers = teacherDao.getAllTeachers();
        for(Teacher teacher : teachers) {
            teacherDao.deleteTeacherById(teacher.getId());
        }
        
        List<Student> students = studentDao.getAllStudents();
        for(Student student : students) {
            studentDao.deleteStudentById(student.getId());
        }
        
        List<Course> courses = courseDao.getAllCourses();
        for(Course course : courses) {
            courseDao.deleteCourseById(course.getId());
        }
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void testAddAndGetTeacher() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Test First");
        teacher.setLastName("Test Last");
        teacher.setSpecialty("Test Specialty");
        teacher = teacherDao.addTeacher(teacher);
        
        Teacher fromDao = teacherDao.getTeacherById(teacher.getId());
        
        assertEquals(teacher, fromDao);
    }

    @Test
    public void testGetAllTeachers() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Test First");
        teacher.setLastName("Test Last");
        teacher.setSpecialty("Test Specialty");
        teacher = teacherDao.addTeacher(teacher);
        
        Teacher teacher2 = new Teacher();
        teacher2.setFirstName("Test First 2");
        teacher2.setLastName("Test Last 2");
        teacher2.setSpecialty("Test Specialty 2");
        teacher2 = teacherDao.addTeacher(teacher2);
        
        List<Teacher> teachers = teacherDao.getAllTeachers();
        
        assertEquals(2, teachers.size());
        assertTrue(teachers.contains(teacher));
        assertTrue(teachers.contains(teacher2));
    }

    @Test
    public void testUpdateTeacher() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Test First");
        teacher.setLastName("Test Last");
        teacher.setSpecialty("Test Specialty");
        teacher = teacherDao.addTeacher(teacher);
        
        Teacher fromDao = teacherDao.getTeacherById(teacher.getId());
        assertEquals(teacher, fromDao);
        
        teacher.setFirstName("New Test First");
        teacherDao.updateTeacher(teacher);
        
        assertNotEquals(teacher, fromDao);
        
        fromDao = teacherDao.getTeacherById(teacher.getId());
        
        assertEquals(teacher, fromDao);
    }

    @Test
    public void testDeleteTeacherById() {
        Teacher teacher = new Teacher();
        teacher.setFirstName("Test First");
        teacher.setLastName("Test Last");
        teacher.setSpecialty("Test Specialty");
        teacher = teacherDao.addTeacher(teacher);
        
        Student student = new Student();
        student.setFirstName("Test Student First");
        student.setLastName("Test Student Last");
        student = studentDao.addStudent(student);
        List<Student> students = new ArrayList<>();
        students.add(student);
        
        Course course = new Course();
        course.setName("Test Course");
        course.setTeacher(teacher);
        course.setStudents(students);
        course = courseDao.addCourse(course);
        
        Teacher fromDao = teacherDao.getTeacherById(teacher.getId());
        assertEquals(teacher, fromDao);
        
        teacherDao.deleteTeacherById(teacher.getId());
        
        fromDao = teacherDao.getTeacherById(teacher.getId());
        assertNull(fromDao);
    }
}
