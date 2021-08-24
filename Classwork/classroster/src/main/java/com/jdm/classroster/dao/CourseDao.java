/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.classroster.dao;

import com.jdm.classroster.entities.Course;
import com.jdm.classroster.entities.Student;
import com.jdm.classroster.entities.Teacher;
import java.util.List;

/**
 *
 * @author Joe
 */
public interface CourseDao {
    Course getCourseById(int id);
    List<Course> getAllCourses();
    Course addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourseById(int id);
    
    List<Course> getCoursesForTeacher(Teacher teacher);
    List<Course> getCoursesForStudent(Student student);
}
