/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package file.access.ca;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//Adam Canavan
//SBA22485
/**
 *
 * @author Adam Canavan
 */
public class FileAccessCA {

    /**
     * @param args the command line arguments
     */
    //Code must read data from file
    //Ensure all info is valid
    //Output error message if invalid
    //Upload data to new file if valid
    
    public static void main(String[] args)throws IOException {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        //Take input from file and verify it to be correct
        try {
            Scanner scanner = new Scanner(new File("C:\\Users\\Adam Canavan\\Downloads\\student.txt")); //Reading from this file
            int counter = 0;
            String student = "N/A";
            String lastName = "N/A";
            String classes = "N/A";
            String workload = "N/A";
            String studentNumber = "N/A";
            try {  //Try catch ro ensure all info given meets requirements
                FileWriter myfile = new FileWriter("C:\\Users\\Adam Canavan\\Desktop\\Student info\\status.txt"); //creating and uploading info to new file
                while (scanner.hasNextLine()) {
                    if (counter == 0) {
                        student = scanner.nextLine();
                        if (student.matches("[a-zA-Z]+\\s[a-zA-Z]+[0-9]*")) { //Students first name must all all letters and last name can include letters
                            String[] studentSplit = student.split("\\s+"); //splitting the users name into two inputs so only last name is uploaded to file
                            lastName = studentSplit[1];
                            System.out.println("Student Name is valid."); //Meets all requirements!
                        } else {
                            System.out.println("Your name does not match the requirements, please try again."); //Gives error message if info is invalid
                            throw new Exception();
                        }
                        counter++; //implementing counter
                    }
                    if (counter == 1) {
                        classes = scanner.nextLine();
                        if (classes.matches("[1-8]")) { //input must be between 1-8 inclusive
                            System.out.println("Student Class Number is valid."); 
                            if (classes.matches("[1]")) {
                                workload = "Very light"; //Classes input determines workload
                            } else if (classes.matches("[2]")) {
                                workload = "Light";
                            } else if (classes.matches("[3-5]")) {
                                workload = "Part time";
                            } else if (classes.matches("[6-8]")) {
                                workload = "Full time";
                            }
                        } else {
                            System.out.println("Your number of classes is incorrect try again.");
                            throw new Exception();
                        }
                        counter++;
                    }
                    if (counter == 2) {
                        studentNumber = scanner.nextLine();
                        if (studentNumber.matches("[0-9]{2}[a-zA-Z]{2}[a-zA-Z]*[0-9]*")) { //Student number must have 2 numbers 2/3 letters then numbers after
                            System.out.println("Student number ID is valid.");
                        } else {
                            System.out.println("Your Student number ID is incorrect please try again.");
                            throw new Exception();
                        }
                        counter = 0; //Restarts counter at beginning for next student
                    }
                    myfile.write(studentNumber + "-" + lastName + "\n" + workload + "\n");
                }
                scanner.close();
                myfile.close();
            }
            catch (FileNotFoundException ex) {
                System.out.println("Error!"); //incorrect stops info being written
            }
        } catch (Exception e) {
            System.out.println("Error!"); //incorrect info kills programme
        }
 
 
 
    }}
