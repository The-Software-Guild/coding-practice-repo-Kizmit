/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.unittesting.arrays;

import static com.tsg.unittesting.arrays.ArrayExerciseA.maxOfArray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Joe
 */
public class ArrayExerciseATest {
    
    public ArrayExerciseATest() {
    }

    @Test
    public void testMixedArrayOfInts() {
        //arrange
        int[] numbers = {1000, 23, 42, 125, 32, 32, -120, -124, -1251};
        
        //act
        int result = maxOfArray(numbers);
        
        //assert
        assert(result == 1000);
    }
    
    @Test
    public void testPositiveArrayOfInts(){
        //arrange
        int[] numbers = {1000, 23, 42, 125, 32, 32, 120, 124, 1251};
        
        //act
        int result = maxOfArray(numbers);
        
        //assert
        assert(result == 1251);
    }
    
      @Test
    public void testNegativeArrayOfInts(){
        //arrange
        int[] numbers = {-1000, -23, -42, -125, -32, -32, -120, -124, -1251};
        
        //act
        int result = maxOfArray(numbers);
        
        //assert
        assert(result == -23);
    }
    
}
