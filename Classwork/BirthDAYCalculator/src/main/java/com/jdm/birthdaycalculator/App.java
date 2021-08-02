/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.birthdaycalculator;

import java.util.Scanner;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your birthday mm/dd/yyyy");
        String birthday = scanner.nextLine();
        
        BirthdayCalculator obj = new BirthdayCalculator(birthday);
        System.out.println("Your birthday was on " + obj.getBirthdayDayOfWeek());
        
        System.out.println("Your birthday is on " + obj.getBirthdayDayOfWeekThisYear() + " this year.");
        
        System.out.println("Today is " + obj.getTodaysDayOfWeek() + " and your birthday is in " + obj.daysUntilBirthday() + " days");
        
        System.out.println("You will be " + obj.age() + " years old this year.");
    }
}
