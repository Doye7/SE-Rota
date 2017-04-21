/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insebase;

/**
 *
 * @author Doye
 */
public class Validation {
    // Tests if the incoming string can be converted to an integer, returns bool
    public static boolean integerTest(String input){
        boolean valid = true;
        try{
            Integer.parseInt(input);
        }
        catch(Exception e){
            valid = false;
        }
        
        return valid;
    }
    // Tests if the incoming string is null or empty, used for the Swing inputboxes
    public static boolean emptyStringTest(String input){
        boolean valid = false;
        try{
            if(input != null && !input.isEmpty()) {valid = true;}
        }
        catch(Exception e){
            valid = false;
        }
        return valid;
    }
    
}
