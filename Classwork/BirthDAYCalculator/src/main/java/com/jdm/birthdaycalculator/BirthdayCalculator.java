/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.birthdaycalculator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
/*
Tell them the day of the week their origBirthday falls on.
Then tell them the day of the week it falls on this year!
Next tell them what day it is today & the number of days until their next origBirthday...
And how many years old they will be!
*/
public class BirthdayCalculator {
    
    LocalDate origBirthday;
    
    BirthdayCalculator(String birthday) {
        
        this.origBirthday = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    }
    
    public DayOfWeek getBirthdayDayOfWeek(){
        return origBirthday.getDayOfWeek();
    }
     
    public DayOfWeek getBirthdayDayOfWeekThisYear(){
        LocalDate thisBirthday = LocalDate.of(LocalDate.now().getYear(), origBirthday.getMonthValue(), origBirthday.getDayOfMonth());
        return thisBirthday.getDayOfWeek();
    }
    
    public DayOfWeek getTodaysDayOfWeek(){
        return LocalDate.now().getDayOfWeek();
    }
    
    public long daysUntilBirthday(){ //Doesn't function properly if birthday already occured this year
        LocalDate thisBirthday = LocalDate.of(LocalDate.now().getYear(), origBirthday.getMonthValue(), origBirthday.getDayOfMonth());
        return ChronoUnit.DAYS.between(LocalDate.now(), thisBirthday);
    }
    
    public int age(){
        LocalDate thisBirthday = LocalDate.of(LocalDate.now().getYear(), origBirthday.getMonthValue(), origBirthday.getDayOfMonth());
        return Period.between(origBirthday, thisBirthday).getYears();
    }
    
}
