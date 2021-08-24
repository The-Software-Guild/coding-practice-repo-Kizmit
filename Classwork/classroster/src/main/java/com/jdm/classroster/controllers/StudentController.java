/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.classroster.controllers;

import com.jdm.classroster.dao.CourseDao;
import com.jdm.classroster.dao.StudentDao;
import com.jdm.classroster.dao.TeacherDao;
import com.jdm.classroster.entities.Student;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
@Controller
public class StudentController {

   @Autowired
   TeacherDao teacherDao;

   @Autowired
   StudentDao studentDao;

   @Autowired
   CourseDao courseDao;
   
    @GetMapping("students")
    public String displayStudents(Model model) {
        List<Student> students = studentDao.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }
    
    @PostMapping("addStudent")
    public String addStudent(String firstName, String lastName) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        studentDao.addStudent(student);
        
        return "redirect:/students";
    }
    
    @GetMapping("deleteStudent")
    public String deleteStudent(Integer id) {
        studentDao.deleteStudentById(id);
        return "redirect:/students";
    }
    
    @GetMapping("editStudent")
    public String editStudent(Integer id, Model model) {
        Student student = studentDao.getStudentById(id);
        model.addAttribute("student", student);
        return "editStudent";
    }
    
    @PostMapping("editStudent")
    public String performEditStudent(Student student) {
        studentDao.updateStudent(student);
        return "redirect:/students";
    }
}
