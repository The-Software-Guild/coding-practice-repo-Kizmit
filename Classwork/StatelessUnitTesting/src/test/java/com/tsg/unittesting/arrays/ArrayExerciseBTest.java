/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsg.unittesting.arrays;

import static com.tsg.unittesting.arrays.ArrayExerciseB.multiplyAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
    

/**
 *
 * @author Joe
 */

/**FUNCTION DESCRIPTION
* Given a integer and an array of ints, times each number in the array by the multiplier.
*
* Example Results:
* multiplyAll( 5 , [ 1 , 2 , 3 , 4 , 5 ] ) ->  [ 5 , 10 , 15 , 20 , 25 ]
* multiplyAll( 0 , [ 1 , 1 , 1 , 1 , 1  , 1 , 1 , 1 , 1 ] ) ->  [ 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 ]
* multiplyAll( -1 , [ -2 , 0 , 0 , 1 ] ) ->  [ 2 , 0 , 0 , -1 ]
* 
* @param multiplier
* @param numbers
* @return int[] numbers multiplied
*/

public class ArrayExerciseBTest {
    
    public ArrayExerciseBTest() {
    }

    @Test
    public void testPositiveArrayOfInts() {
        //Arrange
        int[] array = {1,2,3,4,5,6};
        int multiplier = 5;
        
        //Act
        int[] result = multiplyAll(multiplier, array);
        
        //Assert
        int[] expected = {5,10,15,20,25,30};
        for(int i = 0; i < result.length; i++){
            assert(result[i] == expected[i]);
        }
    }
    
    @Test
    public void testNegativeArrayOfInts() {
        //Arrange
        int[] array = {-1,-2,-3,-4,-5,-6};
        int multiplier = 5;
        
        //Act
        int[] result = multiplyAll(multiplier, array);
        
        //Assert
        int[] expected = {-5,-10,-15,-20,-25,-30};
        for(int i = 0; i < result.length; i++){
            assert(result[i] == expected[i]);
        }
    }
    
    @Test
    public void testMixedArrayOfInts() {
        //Arrange
        int[] array = {-1,2,-3,4,-5,6};
        int multiplier = 5;
        
        //Act
        int[] result = multiplyAll(multiplier, array);
        
        //Assert
        int[] expected = {-5,10,-15,20,-25,30};
        for(int i = 0; i < result.length; i++){
            assert(result[i] == expected[i]);
        }
    }
    
}
