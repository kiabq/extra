/*
This program demonstrates how to properly display a menu and prompt the user for their input.
In this example, the menu gives options for a health club membership and asks the user to make a selection.
The program then asks for the number of months that the membership will last.
Next, it calculates the cost of the membership based on the type of membership and the number of months the membership will last.
The program then asks the user if they wish to calculate another membership cost, and if so, it repeats the steps above.
*/

import java.util.Scanner;//needed in order to be able to use the Scanner class to get the user's input

public class MenuExampleLoopsMethodsClasses
{     
   public static void main(String[] args)
   {
      int choice = 0;//to hold the menu choice
      int numMonths = 0;//to hold the number of months for the membership
      double totalCost = 0.0;//to hold the total cost of the membership 
      double costPerMonth = 0.0;//to hold the total cost of the membership - initialized to 0.0 to avoid compiler message later on
      int numOfMemberships = 0;//to hold the user's input for the number of memberships
      boolean firstMembership = true;//we use this to keep track of whether or noth this is the first membership being purchased
      double cheapestMembership = 0;//we use this variable to keep track of the cheapest membership purchased
      
      Scanner keyboard = new Scanner(System.in);//create a Scanner object to get the user's input
      
      System.out.print("How many health club memberships are being purchased? ");//ask the user to enter the number of memberships
      numOfMemberships = keyboard.nextInt();//read in the user's input for the number of memberships
      
      //Validate the user's input by using a while loop
      while(numOfMemberships < 1)//While the user provides us with invalid input, we want to display an error message and have them re-enter their input
      {
         System.out.print("You must purchase at least 1 membership.  How many health club memberships are being purchased? ");//ask the user to enter the number of memberships
         numOfMemberships = keyboard.nextInt();//read in the user's input for the number of memberships
      }//once this point in the code is reached, we are guaranteed that the user has entered a valid selection from the menu
      
      //Use for loop to ask the user to enter the information for each membership
      for(int membershipNumber = 0; membershipNumber < numOfMemberships; membershipNumber++)
      {
         //Display the Menu
         System.out.println("Health Club Membership Menu");
         System.out.println("1. Standard Adult Membership - $40 per month");
         System.out.println("2. Child Membership - $20 per month");
         System.out.println("3. Senior Citizen Membership - $30 per month");
         
         System.out.print("\nEnter your choice: ");//Ask the user to make a selection from the menu
         choice = keyboard.nextInt();//read in the user's input for the menu selection
         
         //Validate the user's menu choice by using a while loop
         while(choice < 1 || choice > 3)//While the user provides us with invalid input, we want to display an error message and have them re-enter their input
         {
            System.out.print("Invalid selection.  Plase pick a valid option from the menu: ");//display an error message if the user gave us invalid input
            choice = keyboard.nextInt();//read in the user's input for the menu selection
         }//once this point in the code is reached, we are guaranteed that the user has entered a valid selection from the menu
         
         System.out.print("How many months will the membership last? ");//ask the user for the number of months that the membership will last
         numMonths = keyboard.nextInt();//read in the user's input for the number of months
         
         //Validate the user's input by using a while loop
         while(numMonths < 1)//While the user has entered a number of months that is invalid (meaning less than 1 month), we want to display an error message and have them re-enter their input
         {
            System.out.print("You must have the membership for at least 1 month.  How many months will the membership last? ");
            numMonths = keyboard.nextInt();//read in the user's input for the number of months
         }//once this point in the code is reached, we are guaranteed that the user has entered a valid number of months
         
         //instantiate a Membership object by calling the constructor and passing it the correct arguments
         Membership mem = new Membership(choice, numMonths);
         
         //Call the getMembershipCost instance method on our Membership object
         //We do not need to pass it arguments, since it can use the values of its instance fields to calculate the memberhsip cost
         //It will return the total cost of the membership to us, so we make sure to store the value it returns in a variable so that we can use it later on
         totalCost = mem.getMembershipCost(); 
         
         //if this is the first membership being purchased, it is automatically the cheapest membership (since it's the only one purchased so far)
         if(firstMembership)
         {
            cheapestMembership = totalCost;
            firstMembership = false;//now we set firstMembership to false so that in susbequent iterations, we perform the check below
         }
         else
         {
            //we check to see if the current membership being purchased is cheaper than our cheapestMembership
            if(totalCost < cheapestMembership)
               cheapestMembership = totalCost;//if so, we update the value of cheapestMembership
         }
         
         //Call the displayMembershipCost method to have it display the membership cost
         //We pass it a reference to a Membership object
         //Since this method does not return a valyue (it is void) we do not assign it to a variable
         displayMembershipCost(mem);  
         
         System.out.println();//print a blank line to separate the output of each membership
      }//end for loop      
      
      System.out.printf("The cheapest membership purchased is $%.2f\n",cheapestMembership);//display the total cost of the cheapest membership, formatting the output to two decimal places
      
   }//end main
   
   /**
      Display the membership cost
      
      @param memCost The membership
   */
   public static void displayMembershipCost(Membership mem)
   {
      System.out.printf("The cost of the membership is $%.2f\n",mem.getMembershipCost());//display the total cost of the membership, formatting the output to two decimal places
   }
}//end class