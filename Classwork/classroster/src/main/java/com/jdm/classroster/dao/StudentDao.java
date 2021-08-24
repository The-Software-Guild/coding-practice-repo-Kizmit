/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.classroster.dao;

import com.jdm.classroster.entities.Student;
import java.util.List;

/**
 *
 * @author Joe
 */
public interface StudentDao {
    Student getStudentById(int id);
    List<Student> getAllStudents();
    Student addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentById(int id);   
}
