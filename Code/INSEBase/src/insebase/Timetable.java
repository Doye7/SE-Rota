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
public class Timetable {
    
    // Shift hours, changing this will directly change the number of shifts and should not break the program, save data must be cleared however
    static String workTime[] = {"|11:00", "|12:00", "|13:00", "|14:00", "|15:00", "|16:00"};
    
    // Creates a blank 2d array of length 7 (number of days in a week)
    //and the length of the worktime array, determined above.
    //Y is the length of worktime, X is the days of the week (or 7)
    public static String[][] makeTimetable(){
       String[][] timeTable = new String[7][workTime.length];
       
       return timeTable;
    }
     public static boolean[][] makeBoolTimetable(){
       boolean[][] timeTable = new boolean[7][workTime.length];
       
       return timeTable;
    }
     public static int[][] makeIntTimetable(){
       int[][] timeTable = new int[7][workTime.length];
       
       return timeTable;
     }
    
    //Method to print a line of the time table, called by printTable multiple times to display the time table
    private static String printLine(String[][] timeTable, int tableRow){
        String catString = "";
        for(int i = 0; i < 7; i++){
            catString = catString + "| " + timeTable[i][tableRow] + " ";
    }
        catString = catString + "|";
        return catString;
    }
    
    // Method to print the entire table, prints the header and end of the
    //time table and calls printLine as many times as there are shifts
    public static void printTable(String[][] timeTable){
        System.out.println("-------------------------------------------------");        
        System.out.println("|     | Mon | Tue | Wed | Thu | Fri | Sat | Sun |");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < workTime.length; i++){
            System.out.println(workTime[i] + printLine(timeTable, i));
        }
        System.out.println("-------------------------------------------------");
        
    }
        
    //Method to print a line of the time table, called by printTable multiple times to display the time table
    private static String printBoolLine(boolean[][] timeTable, int tableRow){
        String catString = "";
        String tempString = "";
        for(int i = 0; i < 7; i++){
            if(timeTable[i][tableRow]){
                tempString = " T ";
            }
            else{
                    tempString = "FFF";  
                }
                
            
            catString = catString + "| " + tempString + " ";
    }
        catString = catString + "|";
        return catString;
    }
    
    // Method to print the entire table, prints the header and end of the
    //time table and calls printLine as many times as there are shifts
    public static void printBoolTable(boolean[][] timeTable){
        System.out.println("-------------------------------------------------");        
        System.out.println("|     | Mon | Tue | Wed | Thu | Fri | Sat | Sun |");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < workTime.length; i++){
            System.out.println(workTime[i] + printBoolLine(timeTable, i));
        }
        System.out.println("-------------------------------------------------");
        
    }
    
        private static String printIntLine(int[][] timeTable, int tableRow){
        String catString = "";
        for(int i = 0; i < 7; i++){
            catString = catString + "|  " + timeTable[i][tableRow] + "  ";
    }
        catString = catString + "|";
        return catString;
    }
    
    // Method to print the entire table, prints the header and end of the
    //time table and calls printLine as many times as there are shifts
    public static void printIntTable(int[][] timeTable){
        System.out.println("-------------------------------------------------");        
        System.out.println("|     | Mon | Tue | Wed | Thu | Fri | Sat | Sun |");
        System.out.println("-------------------------------------------------");
        for (int i = 0; i < workTime.length; i++){
            System.out.println(workTime[i] + printIntLine(timeTable, i));
        }
        System.out.println("-------------------------------------------------");
        
    }
    
}