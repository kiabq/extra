/*
   Write a program that asks the user to enter “air”, “water”, 
   or “steel”, and the distance that a sound wave will travel 
   in the medium. The program should then display theamount 
   of time it will take. 
*/

import java.util.Scanner;
import java.text.*;

public class Speedofsound {
   public static void main(String[] args) {
      // Initial values for each medium's propagation speed. 
      final double air = 1100.0, water = 4900.0, steel = 16400.0;
      // Declare user variables.
      double mediumDistance = 0;
      double timeToTravel = 0;
      String mediumChoice = "";
      
      // Initialize standard library helper methods.
      var Scanner = new Scanner(System.in);
      DecimalFormat df = new DecimalFormat("#.##");

      System.out.println("This program will calculate the time for sound to travel depending on the medium and its distance chosen.\nEnter one of these three mediums (air, steel, water):");
      mediumChoice = Scanner.nextLine().toLowerCase();
      
      // Determine if choice is valid, if not, return from function.
      boolean validChoice = (mediumChoice.equals("air") || mediumChoice.equals("water") || mediumChoice.equals("steel"));
      if (!validChoice) {
         System.out.println("Invalid choice of medium. Only air, water, or steel can be calculated.");
         return;
      }
      
      System.out.println("What distance (in feet) do you want to calculate?:");
      mediumDistance = Scanner.nextDouble();
      
      // Determine if distance is valid, if not, return from function.
      if (mediumDistance < 0) {
         System.out.println("Cannot calculate negative travel distance.");
         return;
      }
      
      // Handle logic for calculating speed of sound depending on the chosen medium.
      switch (mediumChoice) {
         case "air":
            timeToTravel = calculateTime(mediumDistance, air);
            break;
         case "water":
            timeToTravel = calculateTime(mediumDistance, water);
            break;
         case "steel":
            timeToTravel = calculateTime(mediumDistance, steel);
            break; 
      }
         
      System.out.printf("It will take %s second(s) to travel %s feet in %s.", df.format(timeToTravel), df.format(mediumDistance), mediumChoice);
   }
   
   // Calculates time based off t = d/s.
   public static double calculateTime(double distance, double mediumPropagation) {
      return distance / mediumPropagation;
   }
}