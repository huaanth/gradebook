import java.util.*;
import java.io.*;


class Main {
  public static void main(String[] args) throws IOException {
    //this portion is for the writing half, where teachers input marks
    //sets up a txt file to write in
    FileWriter file = new FileWriter ("JPCI.txt");
    PrintWriter write = new PrintWriter(file); 

    //sets up a scanner
    Scanner scan = new Scanner (System.in);



    //asks amount of students
    System.out.print("\nEnter the amount of students you want to put in: ");
    int numofstu = scan.nextInt();
    scan.nextLine();
    

    //loop for the amount of students

    for(int i = 0; i<numofstu; i++)
      {
        //asks for student's name
        System.out.println("\nStudent " + (i+1) + "\n");
        System.out.print ("Input Student Name: " );
        String name = scan.nextLine();
        //asks for student's marks
        

        System.out.print("Input Marks: ");
        String marks = scan.nextLine();
        String marks2 = marks.replace(",", " ");
        name = name.trim();
        write.println (name + " " + marks2);
        
      }
    //closes the file you read and write from
    file.close();
    write.close();

    //Reading half
    
    FileWriter ouacfile = new FileWriter("Ouac.txt");
    PrintWriter ouacwriter = new PrintWriter (ouacfile);

    //asks for cutoff
    System.out.println("Enter University Cutoff: ");
    double cut = scan.nextDouble();

    //sets up file reader
    FileReader read = new FileReader("JPCI.txt");
    BufferedReader reader = new BufferedReader (read);
    
    //will read the first line and set it to a variable
    String line = reader.readLine();
    
    //will creater a loop to check if the first line is null
    while(line !=null)
      {
        String ar[];
        
        //will take the grades section of the txt
        String grades = line.substring(line.indexOf(' ')+1);
        
        //will take the names section of the txt. 0 is there since names are at the start
        String names = line.substring(0,line.indexOf(' '));
        //will split up the grade by white spaces
        ar = grades.split("\\s+");

        //set an average variable to zero so it can add up the marks for each individual
        double avg = 0;
      //will add the marks in the jpci txt file and add them to average
        for(int x = 0; x<= ar.length-1; x++)
        {
          avg = avg + Double.parseDouble(ar[x]);
        }
        avg = avg/ar.length;
        //I don't think my averages go into the decimals and are just rounded upwards
        avg = Math.round(avg);

        
        //just letters of acception and rejection if they don't meant the cutoff mark
        ouacwriter.println (names + ": " + avg);
        if(avg > cut)
        {
          ouacwriter.println("Dear " + names + ",\nCongratulations! You have been accepted admission into this prestigious university with your " + avg +"% average." );
          
        }
        else
        {
          ouacwriter.println("Dear " + names + ",\nYou have been rejected by this university. Your " + avg + "% was not good enough, hopefully you can find success elsewhere.");
        }
        ouacwriter.println("\n");
        line = reader.readLine();

        
      }
    //closes the file reader and writer
    ouacfile.close();
    ouacwriter.close();
    read.close();
    reader.close();
    System.out.println("INFO SENT TO FILE");
  }
}