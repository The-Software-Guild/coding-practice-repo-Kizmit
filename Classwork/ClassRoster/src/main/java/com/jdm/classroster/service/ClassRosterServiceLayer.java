/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdm.classroster.service;

import com.jdm.classroster.dao.ClassRosterPersistenceException;
import com.jdm.classroster.dto.Student;
import java.util.List;

/**
 *
 * @author Joe
 */
public interface ClassRosterServiceLayer {
    public void createStudent(Student student)throws ClassRosterDuplicateIdException,
    ClassRosterDataValidationException,
    ClassRosterPersistenceException;
    
    List<Student> getAllStudents() throws ClassRosterPersistenceException;
    
    Student getStudent(String studentId) throws ClassRosterPersistenceException;
    
    Student removeStudent(String studentId) throws ClassRosterPersistenceException;   
}

