import java.util.ArrayList;
import java.util.Scanner;

public class CookieDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Cookie> batches = new ArrayList<>();
        
        final int MIN_BATCHES = 1, MAX_BATCHES = 15;
        final int MIN_COOKIES_IN_BATCH = 12, MAX_COOKIES_IN_BATCH = 300;
        int numBatches = 0;
        int totalCookies = 0;
        double totalSugar = 0, totalButter = 0, totalFlour = 0, totalChocolateChips = 0;

        // Input validation for number of batches
        do {
            System.out.printf("Enter the number of batches of chocolate chip cookies (min: %d - max: %d\n): ", MIN_BATCHES, MAX_BATCHES);
            while (!input.hasNextInt()) {
                input.next();
            }
            numBatches = input.nextInt();

            if (numBatches < MIN_BATCHES || numBatches > MAX_BATCHES) {
                System.out.printf("Invalid input. Please enter a number between %d and %d.\n", MIN_BATCHES, MAX_BATCHES);
            }
        } while (numBatches < MIN_BATCHES || numBatches > MAX_BATCHES);

        for (int i = 1; i <= numBatches; i++) {
            int numCookies = 0;

            do {
                System.out.printf("How many cookies are in batch #%d? (min: %d - max: %d): ", i, MIN_COOKIES_IN_BATCH, MAX_COOKIES_IN_BATCH);
                while (!input.hasNextInt()) {
                    System.out.printf("Invalid input. Please enter a number between %d and %d.\n", MIN_COOKIES_IN_BATCH, MAX_COOKIES_IN_BATCH);
                    input.next();
                }
                numCookies = input.nextInt();

                if (numCookies < MIN_COOKIES_IN_BATCH || numCookies > MAX_COOKIES_IN_BATCH) {
                    System.out.printf("Invalid input. Please enter a number between %d and %d.\n", MIN_COOKIES_IN_BATCH, MAX_COOKIES_IN_BATCH); 
                } 
            } while (numCookies < MIN_COOKIES_IN_BATCH || numCookies > MAX_COOKIES_IN_BATCH);

            Cookie cookie = new Cookie(numCookies);
            batches.add(cookie);

            totalCookies += numCookies;
            totalSugar += cookie.getCupsSugar();
            totalButter += cookie.getCupsButter();
            totalFlour += cookie.getCupsFlour();
            totalChocolateChips += cookie.getCupsChocolateChips();
        }

        input.close();

        System.out.println("\n--- Chocolate Chip Cookie Batches ---");
        for (int i = 0; i < batches.size(); i++) {
            System.out.println(batches.get(i).toString());
        }
        // Display the total amounts for all batches
        System.out.printf("Batches of Cookies: %d\n", numBatches);
        System.out.printf("Total Cookies: %d\n", totalCookies);
        System.out.printf("Total Cups of Sugar: %.2f\n", totalSugar);
        System.out.printf("Total Cups of Butter: %.2f\n", totalButter);
        System.out.printf("Total Cups of Flour: %.2f\n", totalFlour);
        System.out.printf("Total Cups of Chocolate Chips: %.2f\n", totalChocolateChips);
    }
}