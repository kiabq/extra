/**
   This class represents a health club membership
*/
public class Membership
{
   private int membershipType;
   private int membershipMonths;
   
   /**
      Constructor that accepts arguments
      @param type The type of membership
      @param months The number of months the membership is for
   */
   public Membership(int type, int months)
   {
      membershipType = type;
      membershipMonths = months;
   }
   
   /**
      No-arg constructor that explicitly initializes all isntance fields.
      Defaults to Standard Membership for 1 month
   */
   public Membership()
   {
      membershipType = 1;
      membershipMonths = 1;
   }
   
   /**
      Types of memberships:
         1 - Standard
         2 - Child
         3 - Senior
      @param type The type of membership
   */
   public void setMembershipType(int type)
   {
      membershipType = type;
   }
   
   /**
      @param months The number of months the membership is for
   */
   public void setMembershipMonths(int months)
   {
      membershipMonths = months;
   }
   
   /**
      Types of memberships:
         1 - Standard
         2 - Child
         3 - Senior
      @return The type of membership
   */
   public int setMembershipType()
   {
      return membershipType;
   }
   
   /**
      @return The number of months the membership is for
   */
   public int setMembershipMonths()
   {
      return membershipMonths;
   }
   
   /**
      Calculates the membership cost
      @return The cost of the membership
   */
   public double getMembershipCost()
   {
      //constants to hold the cost of the membership types
      final double ADULT_COST = 40.0;
      final double CHILD_COST = 20.0;
      final double SENIOR_COST = 30.0;
         
      //constants to represent the menu options
      final int ADULT = 1;
      final int CHILD = 2;
      final int SENIOR = 3;
   
      double costPerMonth = 0.0, totalCost = 0.0;
      //Use if/else if statement to appropriately handle the user's selection
      //assign the correct value to our costPerMonth variable based on the user's selection
      if(membershipType == ADULT)
      {
         costPerMonth = ADULT_COST;       
      }
      else if(membershipType == CHILD)
      {
         costPerMonth = CHILD_COST;
      }
      else
      {
         costPerMonth = SENIOR_COST;
      }
      
      /*
      //Since there is only a single statement that we want to conditionally execute  in the body of each if-statement,
      //we can optionally omit the curly braces to make the code shorter as shown below.
      //
      //Be aware that this only works when you want to conditionally execute a SINGLE statement.
      //If you have multiple statements that you want to execute, you MUST include them in curly braces
      //
      //To test this, you can comment out the if-else-if statements above and use the code below instead:
      if(choice == ADULT)
        costPerMonth= ADULT_COST;       
      else if(choice == CHILD)
        costPerMonth = CHILD_COST;
      else       
        costPerMonth = SENIOR_COST;
      */
         
      totalCost = costPerMonth * membershipMonths; //calculate the total cost using the correct cost per month assigned above
         
      return totalCost;//we return the total cost of the membership
   }
}