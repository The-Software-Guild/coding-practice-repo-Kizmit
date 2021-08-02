package com.jdm.interestcalculator;

import java.math.BigDecimal;
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
        
        System.out.println("How much do you want to invest? ");
        BigDecimal investment = new BigDecimal(scanner.nextLine());
        System.out.println("How many years are you investing? ");
        BigDecimal years = new BigDecimal(scanner.nextLine());
        System.out.println("What is the annual interest rate % growth? ");
        BigDecimal interest = new BigDecimal(scanner.nextLine());
        
        calculate(investment, interest, years);
    }
    
    static void calculate(BigDecimal investment, BigDecimal interest, BigDecimal years){ //Output does not match sample
        System.out.println("Calculating.......");
        BigDecimal runningTotal, startAmount;
        startAmount = investment;
        runningTotal =  startAmount;
        BigDecimal quarterlyInterest = interest.divide(new BigDecimal("4"));
        quarterlyInterest = quarterlyInterest.divide(new BigDecimal("100"));
        quarterlyInterest = quarterlyInterest.add(new BigDecimal("1"));
        
        int yearsInt = Integer.parseInt(years.toPlainString());
        for(int i = 0; i < yearsInt ; i++)
        {
            System.out.println("Year " + (i+1) + ":");
            System.out.printf("Began with $%.2f\n", runningTotal);
            for(int j = 0; j < 4; j++){
                runningTotal = runningTotal.multiply(quarterlyInterest);
            }
            System.out.printf("Earned $%.2f\n",  (runningTotal.subtract(startAmount)));
            System.out.printf("Ended with $%.2f\n",  (runningTotal));
            startAmount = runningTotal;
        }
    }
}
