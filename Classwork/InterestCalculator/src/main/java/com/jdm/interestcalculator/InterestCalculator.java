package com.jdm.interestcalculator;

import java.util.Scanner;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * @date  7/26/21
 */
public class InterestCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int years; 
        float interest, investment;
        
        System.out.println("How much do you want to invest? ");
        investment = Integer.parseInt(scanner.nextLine());
        System.out.println("How many years are you investing? ");
        years = Integer.parseInt(scanner.nextLine());
        System.out.println("What is the annual interest rate % growth? ");
        interest = Integer.parseInt(scanner.nextLine());
        
        calculate(investment, interest, years);
    }
    
    static void calculate(float investment, float interest, int years){ //Output does not match sample
        System.out.println("Calculating.......");
        float runningTotal, startAmount;
        startAmount = investment;
        runningTotal =  startAmount;
        
        for(int i = 0; i < years; i++)
        {
            System.out.println("Year " + (i+1) + ":");
            System.out.printf("Began with $ %.2f\n", runningTotal);
            for(int j = 0; j < 4; j++){
                runningTotal *= (1+(interest/4)/100);
            }
            System.out.printf("Earned $%.2f\n",  (runningTotal - startAmount));
            System.out.printf("Ended with $%.2f\n",  (runningTotal));
            startAmount = runningTotal;
        }
    }
}
