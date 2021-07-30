/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.unittesting.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.tsg.unittesting.arrays.ArrayExerciseC;
/**
 *
 * @author Joe
 */
public class ArrayExerciseCTest {
    
    public ArrayExerciseCTest() {
    }

    @Test
    public void testPositiveArrayOfInts() {
        int[] nums = {1,2,3,4,5,6,7};
        ArrayExerciseC obj =  new ArrayExerciseC();
        
        String result = obj.stringThemTogether(nums);
        
        assert(result.equals("1234567"));
    }
    
    @Test
    public void testLargePositiveValueArrayOfInts() {
        int[] nums = {10000,223145,3123151,41231512,512315123,6125125,712312125};
        ArrayExerciseC obj =  new ArrayExerciseC();
        
        String result = obj.stringThemTogether(nums);
        
        assert(result.equals("100002231453123151412315125123151236125125712312125"));
    }
    
    @Test
    public void testEmptyArrayOfInts() {
        int[] nums = {};
        ArrayExerciseC obj =  new ArrayExerciseC();
        
        String result = obj.stringThemTogether(nums);
        
        assert(result.equals(""));
    }
    
}
