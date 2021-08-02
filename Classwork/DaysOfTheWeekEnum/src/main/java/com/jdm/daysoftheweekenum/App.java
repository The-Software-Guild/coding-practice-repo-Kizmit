/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.daysoftheweekenum;

import java.util.Scanner;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class App {
    public enum DaysOfTheWeekEnum{
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a day of the week:");
        String day = scanner.nextLine();
        
        DaysOfTheWeekEnum dayEnum = DaysOfTheWeekEnum.valueOf(day.toUpperCase());
        DaysOfTheWeek obj = new DaysOfTheWeek();
        
        obj.daysUntilFriday(dayEnum);
    }
}
