/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package insebase;
// Importing array lists and file handling
import java.io.*;
import java.util.*;
/**
 *
 * @author Doye
 */
public class INSEBase {
    //Random for the generating of time table
   static Random rng = new Random();
// -----------------------------------------------------------------------------
//* Data is currently saved to C:/data/ and consists of one file named
//employee.ser. Run once then save to generate the file if a read fails.
//------------------------------------------------------------------------------
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Initialise Arraylist to contain the employees. Arraylist chosen for
        //its auto resizing.
        ArrayList<Person> empList = loadFileToList();
        
//      Test data adding employees to the list
//      empList.add(new Person("Dave Jones", "DAJ", 20, 1));
//      empList.add(new Person("Will Smith", "WSM", 20, 2));
//      empList.add(new Person("Jane Doe", "JDO", 20,3));
//      empList.add(new Person("Matt Harris", "MAH", 20, 4));
 //     empList.add(new Person("Alice Williams", "ALW", 20, 5));
 
 boolean exit = true;
 Scanner input = new Scanner(System.in);
 
 
 // Menu system
 while(exit){
        System.out.println("|------------------------|");
        System.out.println("|Please choose an option:|");
        System.out.println("|------------------------|");
        System.out.println("|1|    Show employees    |");
        System.out.println("|2|   Add new employee   |");
        System.out.println("|3|    Show timetable    |");
        System.out.println("|------------------------|");
        System.out.println("|S|     Save changes     |");
        System.out.println("|X|         Exit         |");
        System.out.println("|------------------------|");
        
        String choice = input.next();
        
        switch (choice){
            case "1": printList(empList);
                 break;
            case "2": addNewEmployee(empList);
                 break;
                 // Create and populate the timetable, creates a new timetable
                 //and fills each location with a randomly assigned employee
                 //from the employee list
            case "3": 
                randomiser(empList);
            break;
            case "S": saveListToFile(empList);
            break;
            case "X": exit = false;
            break;            
        }
        
        
        if(exit){ 
            System.out.println("Type Y to continue");
            input.next();
        }
 }
 
 
//        String[][] singleTable = Timetable.makeTimetable();
//        for(int i = 0; i < singleTable[0].length; i++){
//            for(int q = 0; q < singleTable.length; q++){
//                singleTable[q][i] = empList.get(rng.nextInt(empList.size())).getShortName();
//            }
//            
//        }
//        
//
//
////         Calls the print method
//        printList(empList);
//       saveListToFile(empList);
//       Timetable.printTable(singleTable); 
    }
    private static void addNewEmployee(ArrayList<Person> empList){
        Scanner empInput = new Scanner(System.in);
        String name, sName;
        int hours, id;
        //boolean table[][];
        
        System.out.println();
        System.out.println("Please enter the employee name:");
        name = empInput.next();
        name = name + " " + empInput.next();
        System.out.println("Please enter the Shorthand name:");
        sName = empInput.next();
        System.out.println("Please enter the maximum hours:");
        hours = empInput.nextInt();
        System.out.println("Please enter an id:");
        id = empInput.nextInt();
        
        //table = Timetable.makeBoolTimetable();        
        
        empList.add(new Person(name, sName, hours, id, randomPreference()));
    }
    // Prints the employees in the list
    private static void printList(ArrayList<Person> empList){
                for(int i = 0; i < empList.size(); i++){
            System.out.println("---------------");
            System.out.println(empList.get(i).getFullName());
            System.out.println(empList.get(i).getShortName());
            System.out.println(empList.get(i).getMaxHours());
            System.out.println(empList.get(i).getIdNumber());
            Timetable.printBoolTable(empList.get(i).getAble());
        }
        // Formatting line
        System.out.println("---------------");
    }
    private static void saveListToFile(ArrayList<Person> empList){
        String dirname = "/data";
        File path = new File(dirname);
      
        // Create directory now.
        path.mkdirs();
        try {
            // Prep the file
            FileOutputStream fileOut = new FileOutputStream("/data/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // Write the arraylist to the file
            out.writeObject(empList);
            // Close write and file
            out.close();
            fileOut.close();
            // Confirmation message
            System.out.println("Save complete");
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    private static ArrayList<Person> loadFileToList(){
        // Create a temporary, empty, ArrayList
        ArrayList<Person> temp = new ArrayList();
        try{
            // Begin file opening
            FileInputStream fileIn = new FileInputStream("/data/employee.ser");
            // Open next object
            ObjectInputStream in = new ObjectInputStream(fileIn);
            // The temporary array becomes what was read
            temp = (ArrayList<Person>) in.readObject();
            // Close file
            in.close();
            fileIn.close();
            // Confirmation message
            System.out.println("Loaded");
            //Catch exceptions
        }catch(IOException e){
            e.printStackTrace();
            
        }catch(ClassNotFoundException e2){
            System.out.println("Not Found");
            e2.printStackTrace();
        }
        // Return either an empty Arraylist<Person> or the loaded one
        return temp;
    }
    
    private static void randomiser(ArrayList<Person> empList){
        String[][] singleTable = Timetable.makeTimetable();
        for(int i = 0; i < singleTable[0].length; i++){
            for(int q = 0; q < singleTable.length; q++){
                singleTable[q][i] = empList.get(rng.nextInt(empList.size())).getShortName();
            }

        }
        Timetable.printTable(singleTable);
    }
    
    private static boolean[][] randomPreference(){
        boolean able;
        boolean[][] singleTable = Timetable.makeBoolTimetable();
        for(int i = 0; i < singleTable[0].length; i++){
            for(int q = 0; q < singleTable.length; q++){
                able = true;
                if(rng.nextInt(100) > 70){
                    able = false;
                }
                singleTable[q][i] = able;
            }
        }
        return singleTable;
    }
    
    
}
