/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jdm.mathoperatorenum;

import java.util.Scanner;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class App {
    public enum MathOperator{
        PLUS, MINUS, MULTIPLY, DIVIDE
    }
    
    public static void main(String[] args){
        int operand1, operand2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two math operands");
        operand1 = scanner.nextInt();
        operand2 = scanner.nextInt();
        IntMath obj = new IntMath();
        
        for(MathOperator operator : MathOperator.values()){
            int result = obj.calculate(operator, operand1, operand2);
            System.out.println("result for " + operator + " = "+ result);
        }
        
    }
}
