/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.studentquizgrades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class StudentQuizGrades {
    private HashMap<String, List<Integer>> quizData;
    private UserIO userIO;
    
    StudentQuizGrades(){
        quizData = new HashMap<>();
        userIO = new UserIOImpl();
    }
    
    public void addStudent(List<Integer> grades){
        quizData.put(userIO.readString("What is the name of the student?"), grades);
    }
    
    public void removeStudent(String student){
        quizData.remove(student);
        userIO.print("The student " + student + " was removed");
    }
    
    public void printStudentNames(){
        Set<String> names = quizData.keySet();
        
        userIO.print("Roster: ");
        for(String studentName : names){
            userIO.print(studentName);
        }
    }
   
    public void getStudentScores(String student){
        List<Integer> studentGrades = quizData.get(student);
       
        userIO.print("The student " + student + " has quiz grades:");
        for(Integer grade : studentGrades){
            userIO.print(grade);
        }
    }
    
    public int getStudentScoreAvg(String student){
        List<Integer> studentGrades = quizData.get(student);
        int totalScore = 0;
        int numOfGrades = 0;
        for(Integer grade : studentGrades){
            totalScore += grade;
            numOfGrades++;
        }
        
        return totalScore/numOfGrades;
    }
    
    public void highestScore(){
        Set<String> names = quizData.keySet();
        int highestScore = 0;
        List<String> highestScorersNames = new ArrayList<>();
        
        for(String name : names){
            List<Integer> grades = quizData.get(name);
            for(Integer grade : grades){
                if(grade > highestScore){
                    highestScore = grade;
                    highestScorersNames.clear();
                    highestScorersNames.add(name);
                }
                else if (grade == highestScore){
                    highestScorersNames.add(name);
                }
            }
        }
        userIO.print("The student(s) with the highest score is/are: ");
        for(String student : highestScorersNames){
            userIO.print(student);
        }
        userIO.print("The student(s) got a score of " + highestScore + " on at least one quiz");
    }
    
    public void lowestScore(){
        Set<String> names = quizData.keySet();
        int lowestScore = 100;
        List<String> lowestScorersNames = new ArrayList<>();
        
        for(String name : names){
            List<Integer> grades = quizData.get(name);
            for(Integer grade : grades){
                if(grade < lowestScore){
                    lowestScore = grade;
                    lowestScorersNames.clear();
                    lowestScorersNames.add(name);
                }
                else if (grade == lowestScore){
                    lowestScorersNames.add(name);
                }
            }
        }
        
        userIO.print("The student(s) with the lowest score is/are: ");
        for(String student : lowestScorersNames){
            userIO.print(student);
        }
        userIO.print("The student(s) got a score of " + lowestScore + " on at least one quiz");
    }
    
    public void classAvg(){
        Set<String> students = quizData.keySet();
        int totalScore = 0;
        int totalStudents = 0;
        for(String student : students){
            totalScore += this.getStudentScoreAvg(student);
            totalStudents++;
        }
        
        userIO.print("The class average is a " + totalScore/totalStudents);
    }
    
}
