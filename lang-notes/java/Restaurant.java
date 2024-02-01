/*
   Write a program that computes the tax and 
   tip on a restaurant bill. The program 
   should ask the user to enter the charge for 
   the meal. The tax should be 6.75 percent of 
   the meal charge. The tip should be 20 percent
   of the total after adding the tax. 
   Display the meal charge, tax amount, 
   tip amount, and total bill on the screen
*/

import java.util.Scanner;
import java.text.*;

public class Restaurant {
   public static void main(String[] args) {
      // Initialize necessary values.
      Double charge, tax, tip, total, taxRate, tipRate;
      
      // Initialize and declare:
      // - Scanner
      // - Formatting Function
      var Scanner = new Scanner(System.in);
      DecimalFormat df = new DecimalFormat("#.##");
      
      // Declare tax rates.
      taxRate = 0.0675;
      tipRate = 0.2;
      
      System.out.println("Enter the charge for your meal to calculate tip and tax.");
     
      // Receive user input for meal charge.
      charge = Scanner.nextDouble();
      // Perform calculations on charges.
      tax = charge * taxRate;
      tip = (charge + tax) * tipRate;
      total = charge + tax + tip;
      
      // Display tax, tip, and total amounts. 
      System.out.printf("For your meal charge of: $%s.\nThe tax on your meal is $%s.\nThe tip on your meal is $%s.\nThe total charge on your meal is $%s.", df.format(charge), df.format(tax), df.format(tip), df.format(total));   
   }  
}