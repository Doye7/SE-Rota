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
    
    // Shift hours, changing this will directly change the number of shifts and should not break the program
    static String workTime[] = {"|11:00", "|12:00", "|13:00", "|14:00", "|15:00", "|16:00"};
    
    // Creates a blank 2d array of length 7 (number of days in a week)
    //and the length of the worktime array, determined above.
    public static String[][] makeTimetable(){
       String[][] timeTable = new String[7][workTime.length];
       
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
}
