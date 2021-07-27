package com.jdm.factorizer;

import java.util.Scanner;

/**
 *
 * @author Joe McAdams
 * email joedmcadams@gmail.com
 * date  7/26/21
 *
 */
public class Factorizer {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter a number to factor: ");
        int input = Integer.parseInt(scanner.nextLine());
        
        factor(input);
    }
    
    static void factor(int inputVal)
    {
        int[] factors = new int[inputVal];
        int numOfFactors = 0;
        
        for(int i = 1; i <= inputVal ; i++){
            if(inputVal % i == 0) {
                factors[numOfFactors++] = i;
            }
        }
        
        System.out.println("The factors of " + inputVal + " are: " );
        int sumOfFactors = 0;
        for(int i = 0; i < numOfFactors; i++){
            System.out.print(factors[i] + " ");
            sumOfFactors += factors[i];
        }
        
        System.out.println();
        System.out.println(inputVal + " has " + numOfFactors + " factors");
        
        if(sumOfFactors - inputVal == inputVal){
            System.out.println(inputVal + " is a perfect number.");
        }
        else{
            System.out.println(inputVal + " is not a perfect number.");
        }
        
        if(sumOfFactors == inputVal + 1){
            System.out.println(inputVal + " is a prime number");
        }
        else{
            System.out.println(inputVal + " is not a prime number.");
        }
        
        
    }
}
