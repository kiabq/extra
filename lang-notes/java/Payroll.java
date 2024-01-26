import java.util.Scanner;

/**
   This program demonstrates the Scanner class.
*/
public class Payroll {
   /**
      The main method for the Payroll class. It will take in user input for their name, pay, and hours worked to calculate their gross pay 
   */
   public static void main(String[] args) {
      String name;     // To hold a name
      int hours;       // Hours worked
      double payRate;  // Hourly rate
      double grossPay; // Total pay (payRate * hours)

      // Create a Scanner object to read input.
      Scanner keyboard = new Scanner(System.in);
      
      // Get the user's name.
      System.out.println("What is your name?");
      name = keyboard.nextLine();
      
      // Get the number of hours worked.
      System.out.println("How many hours did you work?");
      hours = keyboard.nextInt();
      
      // Get the pay rate.
      System.out.println("What is your pay rate (houry wage)?");
      payRate = keyboard.nextDouble();
      
      // Calculate the gross pay.
      grossPay = payRate * hours;
      
      // Display the resulting information.
      System.out.format("Hello, %s\n", name);
      System.out.format("Your gross pay is $" + grossPay);
   }
}