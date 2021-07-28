package com.jdm.studentquizgrades;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class UserInterface {
    public static void main(String[] args){
        UserIO userIO =  new UserIOImpl();
        Random random = new Random();
        int totalStudents = userIO.readInt("How many students would you like to add to the class?");
        
        StudentQuizGrades gradeBook = new StudentQuizGrades();
        int numOfQuizzes = random.nextInt(20);
        
        //Predefined students for testing
        //Populate gradebook with names and random grades
        for(int i = 0; i < totalStudents; i++){
            List<Integer> grades = new ArrayList<>();
            for(int j = 0; j < numOfQuizzes; j++){
                grades.add(random.nextInt(100));
            }
            gradeBook.addStudent(grades);
        }
        
        //Do some stuff
        gradeBook.printStudentNames();
        //gradeBook.getStudentScores("Jane Doe");
        //gradeBook.getStudentScores("John Doe");
        //userIO.print(gradeBook.getStudentScoreAvg("Jane Doe"));
        gradeBook.highestScore();
        gradeBook.lowestScore();
        gradeBook.classAvg();
    }
}