package com.jdm.statecapitals3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class StateCapitalsApp  {
    public static void main(String[] args) throws Exception{
        HashMap<String, Capital> capitals = new HashMap<>();
        Scanner scanner = new Scanner(new BufferedReader(new FileReader("C:\\Users\\Joe\\Desktop\\Professional\\MThree\\repo\\coding-practice-repo-Kizmit\\Classwork\\StateCapitals3\\MoreStateCapitals.txt")));
        String[] capitalData;
        while(scanner.hasNextLine()){
            String capital = scanner.nextLine();
            capitalData = capital.split("::");
            capitals.put(capitalData[0], new Capital(capitalData[1], Integer.parseInt(capitalData[2]), Double.parseDouble(capitalData[3])));
        }
        scanner.close();
        numberOfCapitals(capitals);
        System.out.println();
        printCapitals(capitals);
        System.out.println();
        printCapitalsLimitedPop(capitals);
        System.out.println();
        printCapitalsLimitedSqMi(capitals);
    }
    
    public static void numberOfCapitals(HashMap<String, Capital> capitals){
        System.out.println("There are " + capitals.size() + " state/capital pairs loaded");
    }
    
    public static void printCapitals(HashMap<String, Capital> capitals){
        Set<String> capitalSet = capitals.keySet();
        for(String capital : capitalSet){
            System.out.println(capital + " - " + capitals.get(capital).name + " | " + "Pop: " + capitals.get(capital).population + 
                    " | " + "Area: " + capitals.get(capital).squareMiles + " sq mi.");
        }
    }
    
    public static void printCapitalsLimitedPop(HashMap<String, Capital> capitals){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a popuation limit to see capitals with more than that population");
        int limit = scanner.nextInt();
        
        Set<String> capitalSet = capitals.keySet();
        System.out.println("LISTING CAPITALS WITH POPULATIONS GREATER THAN " + limit);
        for(String capital : capitalSet){
            if(capitals.get(capital).population > limit) {
                System.out.println(capital + " - " + capitals.get(capital).name + " | " + "Pop: " + capitals.get(capital).population + 
                    " | " + "Area: " + capitals.get(capital).squareMiles + " sq mi.");
            }
        }
    }
    
    public static void printCapitalsLimitedSqMi(HashMap<String, Capital> capitals){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a square mile limit to see capitals with less than that area");
        double limit = scanner.nextDouble();
        
        Set<String> capitalSet = capitals.keySet();
        System.out.println("LISTING CAPITALS WITH AREAS LESS THAN " + limit);
        for(String capital : capitalSet){
            if(capitals.get(capital).squareMiles < limit) {
                System.out.println(capital + " - " + capitals.get(capital).name + " | " + "Pop: " + capitals.get(capital).population + 
                    " | " + "Area: " + capitals.get(capital).squareMiles + " sq mi.");
            }
        }
    }
}
