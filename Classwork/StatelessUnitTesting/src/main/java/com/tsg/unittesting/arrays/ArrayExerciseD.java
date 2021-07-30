/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package com.tsg.unittesting.arrays;

/**
 *
 * @author ahill
 */
public class ArrayExerciseD {
    
    /**
     * Given an array of doubles, return the biggest number of the lot, as if the decimal had gone missing!
     *
     * 
     * pointFree( [1.1, .22]  ) ->  22
     * pointFree( [ .039 , 20 , .005005 ]  ) ->  5005
     * pointFree( [ -9.9 , -700 , -.5  ]  ) ->  -5
     * 
     * @param numbers
     * @return
     */
    public static int pointFree(double[] numbers){
        int stringAsInt, result;
        if(numbers.length == 0) return 0;
        
        String numAsString = Double.toString(numbers[0]).replace(".", "");
        result = Integer.parseInt(numAsString);
        
        for(double x : numbers){
            numAsString = Double.toString(x).replace(".", "");
            stringAsInt = Integer.parseInt(numAsString);
            if(stringAsInt > result) {
                result = stringAsInt;
            }
        }
        return result;
    }
}
    
