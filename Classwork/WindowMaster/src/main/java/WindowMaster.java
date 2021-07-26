
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joe McAdams
 * email joedmcadams@gmail.com
 * date  07/26/21
 * purpose: String parsing and basic operation practice
 */
public class WindowMaster {
    
    public static void main(String[] args){
        //Variable declaration
        float height, width, areaOfWindow, cost, perimeterOfWindow;
        String stringHeight, stringWidth;
        
        //Create input scanner
        Scanner myScanner = new Scanner(System.in);
        
        //Get input from user
        System.out.println("Please enter the window height: ");
        stringHeight = myScanner.nextLine();
        System.out.println("Please enter the window width: ");
        stringWidth =  myScanner.nextLine();
        
        //Convert string to float
        height = Float.parseFloat(stringHeight);
        width = Float.parseFloat(stringWidth);
        
        //Calculate area and perimiter
        areaOfWindow = height * width;
        perimeterOfWindow = 2 * (height + width);
        
        //Calculate cost
        cost = 3.50f * areaOfWindow + 2.25f * perimeterOfWindow;
        
        //Display results
        System.out.println("Window height = " + stringHeight);
        System.out.println("Window width = " + stringWidth);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        System.out.println("Total cost = " + cost);
    }
}
