/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.classroster.controller;

import com.jdm.classroster.dao.ClassRosterPersistenceException;
import com.jdm.classroster.dto.Student;
import com.jdm.classroster.service.ClassRosterDataValidationException;
import com.jdm.classroster.service.ClassRosterDuplicateIdException;
import com.jdm.classroster.service.ClassRosterServiceLayer;
import com.jdm.classroster.ui.ClassRosterView;

import java.util.List;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class ClassRosterController {
    private ClassRosterView view;
    private ClassRosterServiceLayer service;

    public ClassRosterController(ClassRosterServiceLayer service, ClassRosterView view){
        this.service = service;
        this.view = view;
    }

    
    public void run() {
        int menuSelection;
        boolean keepGoing = true;
        try{
            while(keepGoing){
                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listStudents();
                        break;
                    case 2:
                        createStudent();
                        break;
                    case 3:
                        viewStudent();
                        break;
                    case 4:
                        removeStudent();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        }
        catch(ClassRosterPersistenceException e){
            view.displayErrorMessage(e.getMessage());
        }
        
    }
    
    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }
    
    private void unknownCommand(){
        view.displayUnknownCommandBanner();
    }

    private void exitMessage(){
        view.displayExitBanner();
    }
    
    private void createStudent() throws ClassRosterPersistenceException{
        view.displayCreateStudentBanner();
        boolean hasErrors = false;
        do{
            Student newStudent = view.getNewStudentInfo();
            try{
                service.createStudent(newStudent);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            }
            catch(ClassRosterDuplicateIdException | ClassRosterDataValidationException e){
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        }while(hasErrors);
    }
    
    private void listStudents() throws ClassRosterPersistenceException{
        view.displayDisplayAllBanner();
        List<Student> studentList = service.getAllStudents();
        view.displayStudentList(studentList);
    }
    
    private void viewStudent() throws ClassRosterPersistenceException{
        view.displayDisplayStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student student = service.getStudent(studentId);
        view.displayStudent(student);
    }
    
    private void removeStudent() throws ClassRosterPersistenceException{
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        service.removeStudent(studentId);
        view.displayRemoveSuccessBanner();
    }
    
}

