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
    
    static String workTime[] = {"|12:00", "|13:00", "|14:00", "|15:00", "|16:00"};
    
    public static String[][] makeTimetable(){
       String[][] timeTable = new String[7][workTime.length];
       
       return timeTable;
    }
    
    private static String printLine(String[][] timeTable, int tableRow){
        String catString = "";
        for(int i = 0; i < 7; i++){
            catString = catString + "| " + timeTable[i][tableRow] + " ";
    }
        catString = catString + "|";
        return catString;
    }
    
    public static void printTable(String[][] timeTable){
        System.out.println("-------------------------------------------------");
        System.out.println("|     | Mon | Tue | Wed | Thu | Fri | Sat | Sun |");
        for (int i = 0; i < workTime.length; i++){
            System.out.println(workTime[i] + printLine(timeTable, i));
        }
        System.out.println("-------------------------------------------------");
        
    }
}
