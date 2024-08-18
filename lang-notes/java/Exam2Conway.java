import java.util.Scanner;

public class Exam2Conway {
    static final double MINIMUM_LESSON_TIME = 1.0;
    static final double MAXIMUM_LESSON_TIME = 3.5;

    static final double SILVER_MEMBERSHIP_COST = 56.45;
    static final double GOLD_MEMBERSHIP_COST = 75.85;

    static final int SILVER_FREE_LESSONS = 1;
    static final int GOLD_FREE_LESSONS = 3;

    static final double SILVER_HOURLY_RATE = 18.95;
    static final double GOLD_HOURLY_RATE = 16.75;

    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        String membershipType;
        double membershipCost;
        int membershipFreeLessons;
        double membershipHourlyRate;
        
        // Display the welcome message.        
        System.out.println("Book your Guitar Lessons Today!\n");

        // Retrieve the membership type from the user.
        membershipType = retrieveMembership();            
        
        // Set the membership cost, free lessons, and hourly rate based on the membership type.
        membershipCost = calculateMembershipCost(membershipType);
        membershipFreeLessons = calculateFreeLessons(membershipType);
        membershipHourlyRate = calculateHourlyRate(membershipType);

        // Display the membership details.
        displayMembershipDetails(
            membershipType,
            membershipCost,
            membershipFreeLessons,
            membershipHourlyRate
        );
        
        // Ask the user if they would like to book a guitar lesson.
        bookLesson(membershipType, membershipFreeLessons, membershipHourlyRate);
    }

    public static String retrieveMembership() {
        String membershipType;

        // Validate the membership type entered by the user.
        do {
            System.out.print("Enter your membership type: 'Silver' or 'Gold': ");
            membershipType = keyboard.nextLine();
            if (!membershipType.equals("Silver") && !membershipType.equals("Gold")) {
                System.out.println("ERROR: Invalid membership entered. Try Again. ");
            }
        } while (!membershipType.equals("Silver") && !membershipType.equals("Gold"));

        return membershipType;
    }

    public static double calculateMembershipCost(String membershipType) {
        if (membershipType.equals("Silver")) {
            return SILVER_MEMBERSHIP_COST;
        } else if (membershipType.equals("Gold")) {
            return GOLD_MEMBERSHIP_COST;
        } else {
            return 0;
        }
    }

    public static int calculateFreeLessons(String membershipType) {
        if (membershipType.equals("Silver")) {
            return SILVER_FREE_LESSONS;
        } else if (membershipType.equals("Gold")) {
            return GOLD_FREE_LESSONS;
        } else {
            return 0;
        }
    }

    public static double calculateHourlyRate(String membershipType) {
        if (membershipType.equals("Silver")) {
            return SILVER_HOURLY_RATE;
        } else if (membershipType.equals("Gold")) {
            return GOLD_HOURLY_RATE;
        } else {
            return 0;
        }
    }

    public static void bookLesson(String membershipType, int remainingFreeSessions, double hourlyRate) {
        String willBookLesson = null;
        double bookedLessonTime;
        double individualLessonCharge;
        double membershipCost = 0;
        double lessonCharges = 0;
        double lessonTime = 0;
        int lessonsBooked = 0;

        do {
            // Ask the user if they would like to book a guitar lesson and output message based off remaining free lessons
            if ((membershipType.equals("Silver") && remainingFreeSessions == SILVER_FREE_LESSONS) || (membershipType.equals("Gold") && remainingFreeSessions == GOLD_FREE_LESSONS)) {
                System.out.print("Enter y or yes to book a guitar lesson. Enter no or n to stop and process your invoice: ");
            } else {
                System.out.print("Enter y or yes to book another guitar lesson. Enter no or n to stop and process your invoice: ");
            }
            
            willBookLesson = keyboard.nextLine();

            // Check if the user wants to book a lesson
            if (willBookLesson.equals("y") || willBookLesson.equals("yes")) {
                if (remainingFreeSessions > 0) {
                    System.out.println("\nNOTE: You have " + remainingFreeSessions + " remaining free guitar lessons with your " + membershipType + " membership. You will be charged at a rate of $" + hourlyRate + " per hour for guitar lessons if you exceed the free lessons.");
                } else {
                    System.out.println("\nNOTE: You do not have any free guitar lessons remaining with your " + membershipType + " membership. You will be charged at a rate of $" + hourlyRate + " per hour for guitar lessons.");
                }
                
                // Ask the user how many hours they would like to book for the guitar lesson
                System.out.print("How many hours are you looking to book for this guitar lesson? (min: " + MINIMUM_LESSON_TIME + " hours, max: " + MAXIMUM_LESSON_TIME + " hours): ");
                bookedLessonTime = keyboard.nextDouble();
                System.out.println();
                
                // Validate the lesson time entered by the user.
                do {
                    keyboard.nextLine();
                    if (bookedLessonTime < MINIMUM_LESSON_TIME || bookedLessonTime > MAXIMUM_LESSON_TIME) {
                        System.out.print("ERROR: Invalid lesson time entered. Try Again. ");
                        bookedLessonTime = keyboard.nextDouble();
                    } else {
                        individualLessonCharge = calculateIndividualLessonCharges(remainingFreeSessions, bookedLessonTime, hourlyRate);
                        lessonTime += bookedLessonTime;
                        lessonCharges += individualLessonCharge;
                        lessonsBooked++;

                        System.out.printf("Guitar Lesson Charge: $%.2f\n", individualLessonCharge);

                        remainingFreeSessions--;
                    }
                } while ((bookedLessonTime < MINIMUM_LESSON_TIME) || (bookedLessonTime > MAXIMUM_LESSON_TIME));
            } else if (willBookLesson.equals("n") || willBookLesson.equals("no")) {
                // Exit the loop if the user does not want to book a lesson
                break;
            } else {
                // Display an error message if the user enters an invalid input
                System.out.println("ERROR: Invalid input entered. Try Again.");
            }
        } while (!willBookLesson.equals("y") || !willBookLesson.equals("yes"));

        if (membershipType.equals("Silver")) {
            membershipCost = SILVER_MEMBERSHIP_COST;
        } else if (membershipType.equals("Gold")) {
            membershipCost = GOLD_MEMBERSHIP_COST;
        }

        displayFinalInvoice(membershipCost, lessonsBooked, lessonTime, lessonCharges);
    }

    public static void displayMembershipDetails(String membershipType, double membershipCost, int freeLessons, double hourlyRate) {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Membership Type: " + membershipType);
        System.out.println("Free Guitar Lessons Included: " + freeLessons);
        System.out.println("Hourly Rate for Guitar Lessons: $" + hourlyRate + " per session");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(membershipType + " Membership Base Cost: $" + membershipCost);
        System.out.println("----------------------------------------------------------------------\n");
    }

    public static double displayFinalInvoice(double membershipCost, int totalLessonsBooked, double sumOfLessonTime, double totalLessonCharges) {
        double totalCharges = membershipCost + totalLessonCharges;
        System.out.println("\n     *******Invoice*******     ");
        System.out.printf("Membership Base Cost: $%.2f\n", membershipCost);
        System.out.println("Number of Guitar Lessons: " + totalLessonsBooked);
        System.out.printf("Total Hours of Guitar Lessons: %.2f hours\n", sumOfLessonTime);
        System.out.printf("-----------------------------\n");
        System.out.printf("Guitar Lesson Charges: $%.2f\n", totalLessonCharges);
        System.out.printf("Total Charges: $%.2f\n", totalCharges);
        return 0;
    }

    public static double calculateIndividualLessonCharges(int remainingFreeSessions, double lessonTime, double hourlyRate) {
        if (remainingFreeSessions > 0) {
            return 0;
        } else {
            return lessonTime * hourlyRate;
        }
    }
}