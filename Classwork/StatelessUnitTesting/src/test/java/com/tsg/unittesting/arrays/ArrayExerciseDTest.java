/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.unittesting.arrays;

import static com.tsg.unittesting.arrays.ArrayExerciseD.pointFree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Joe
 */

    
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
public class ArrayExerciseDTest {
    
    public ArrayExerciseDTest() {
    }

    @Test
    public void testArrayWithLeadingIntgers() {
        double[] nums = {1.1, 1.2, 23.54, 123.5};
        
        int result = pointFree(nums);
        
        assert(result == 2354);
    }
    
    @Test
    public void testArrayWithoutLeadingIntgers() {
        double[] nums = {.1, .2, .54, .505, .12453};
        
        int result = pointFree(nums);
        
        assert(result == 12453);
    }
    
    @Test
    public void testArrayWithLeadingZeros() {
        double[] nums = {.01, .002, .0054, .0505, .0101253};
        
        int result = pointFree(nums);
        
        assert(result == 101253);
    }
    
}
