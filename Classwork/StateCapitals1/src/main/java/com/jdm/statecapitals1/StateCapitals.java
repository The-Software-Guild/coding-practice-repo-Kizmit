package com.jdm.statecapitals1;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Joe McAdams
 * @email joedmcadams@gmail.com
 * 
 */
public class StateCapitals {
    public static void main(String[] args){
        HashMap<String, String> stateCapitals = new HashMap<>();
        stateCapitals.put("Texas", "Austin");
        stateCapitals.put("Virginia", "Washington D.C");
        stateCapitals.put("New York", "New York City");
        stateCapitals.put("California", "Sacremento");
        stateCapitals.put("Oregon", "Portland");
        
        Set<String> states = stateCapitals.keySet();
        
        for(String x: states){
            System.out.println(x);
        }
        
        for(String x: states){
            System.out.println(stateCapitals.get(x));
        }
        
        for(String x: states){
            System.out.println(stateCapitals.get(x) + ", " + x);
        }
    }
    
}
