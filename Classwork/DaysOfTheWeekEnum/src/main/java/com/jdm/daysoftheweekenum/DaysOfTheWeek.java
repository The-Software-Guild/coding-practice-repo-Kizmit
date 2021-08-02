/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.daysoftheweekenum;

import com.jdm.daysoftheweekenum.App.DaysOfTheWeekEnum;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class DaysOfTheWeek {
    
    void daysUntilFriday(DaysOfTheWeekEnum day) {
       switch(day){
           case MONDAY:
               System.out.println("4 days until Friday!");
               break;
           case TUESDAY:
               System.out.println("3 days until Friday!");
               break;
           case WEDNESDAY:
               System.out.println("2 days until Friday!");
               break;
           case THURSDAY:
               System.out.println("1 days until Friday!");
               break;
           case FRIDAY:
               System.out.println("0 days until Friday!");
               break;
           case SATURDAY:
               System.out.println("6 days until Friday!");
               break;
           case SUNDAY:
               System.out.println("5 days until Friday!");
               break;
       }
    }

}
