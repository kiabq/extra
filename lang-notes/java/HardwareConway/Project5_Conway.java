import java.util.Scanner;

public class Project5_Conway {
    public static void main(String[] args) {
        var keyboard = new Scanner(System.in);

        // Declare and initialize starting variables
        int cpuCoreCount = 0, monitorResolution = 0, computerCount = 0;
        double gpuClockSpeed = 0, cpuClockSpeed = 0, totalPerformanceScore = 0, average = 0;
        String processor = "";
        char isOverclockFriendly = 'n', repeat = 'y';

        final int CORES_LOW_THRESHOLD = 1, 
            CORES_HI_THRESHOLD = 20;

        final double CLOCK_SPEED_GPU_LOW_THRESHOLD = 800, 
            CLOCK_SPEED_GPU_HI_THRESHOLD = 3000;

        final double CLOCK_SPEED_CPU_LOW_THRESHOLD = 1000, 
            CLOCK_SPEED_CPU_HI_THRESHOLD = 5500;

        // Validate repeat character
        do {
            System.out.print("Please enter the type of processor: ");
            processor = keyboard.nextLine();
            
            System.out.print("Please enter the clock speed (in Megahertz) of your graphics card: ");
            gpuClockSpeed = keyboard.nextDouble();
            
            // Validate GPU clock speed
            while (gpuClockSpeed < CLOCK_SPEED_GPU_LOW_THRESHOLD || gpuClockSpeed > CLOCK_SPEED_GPU_HI_THRESHOLD) {
                System.out.printf("The clock speed should be between %.2f and %.2f Megahertz.\n", CLOCK_SPEED_GPU_LOW_THRESHOLD, CLOCK_SPEED_GPU_HI_THRESHOLD);
                System.out.print("Please enter the clock speed (in Megahertz) of your graphics card: ");
                gpuClockSpeed = keyboard.nextDouble();
            }

            System.out.print("Please enter the clock speed (in Megahertz) of your processor: ");
            cpuClockSpeed = keyboard.nextDouble();

            // Validate CPU clock speed
            while (cpuClockSpeed < CLOCK_SPEED_CPU_LOW_THRESHOLD || cpuClockSpeed > CLOCK_SPEED_CPU_HI_THRESHOLD) {
                System.out.printf("The clock speed should be between %.2f and %.2f Megahertz.\n", CLOCK_SPEED_CPU_LOW_THRESHOLD, CLOCK_SPEED_CPU_HI_THRESHOLD);
                System.out.print("Please enter the clock speed (in Megahertz) of your processor: ");
                cpuClockSpeed = keyboard.nextDouble(); 
            }

            System.out.print("Please enter the number of cores of your processor: ");
            cpuCoreCount = keyboard.nextInt();

            // Validate CPU core count
            while (cpuCoreCount < CORES_LOW_THRESHOLD || cpuCoreCount > CORES_HI_THRESHOLD) {
                System.out.printf("The number of cores should be between %d-%d.", CORES_LOW_THRESHOLD, CORES_HI_THRESHOLD);
                System.out.print("Please enter a valid number: ");
                cpuCoreCount = keyboard.nextInt();
            }
            
            keyboard.nextLine();

            System.out.println("Is the hardware overclock-friendly? (Enter y for yes or n for no): ");
            isOverclockFriendly = keyboard.nextLine().toLowerCase().charAt(0);

            // Validate isOverclockFriendly variable
            while (isOverclockFriendly != 'y' && isOverclockFriendly != 'n') {
                System.out.print("Only y for yes or n for no should be entered. Please enter a valid letter");
                isOverclockFriendly = keyboard.nextLine().toLowerCase().charAt(0);
            }   

            System.out.println("What is the resolution of your monitor?");
            System.out.println("\t1. 1280 x 1024");
            System.out.println("\t2. 1366 x 768");
            System.out.println("\t3. 1600 x 900");
            System.out.println("\t4. 1920 x 1080");
            System.out.print("Please select from the options above: "); 
            monitorResolution = keyboard.nextInt();

            // Validate monitor resolution choices
            while(monitorResolution < 1 || monitorResolution > 4) {
                System.out.print("Invalid menu selection. Please select from the options above: "); 
                monitorResolution = keyboard.nextInt();
            }

            // Initialize new HardwareConway object to calculate hardware scores.
            var HardwareConway = new HardwareConway(
                processor,
                gpuClockSpeed,
                cpuClockSpeed,
                cpuCoreCount,
                monitorResolution,
                isOverclockFriendly
            );

            // Display hardware information
            HardwareConway.displayInformation();
            
            // Clear input
            keyboard.nextLine();

            System.out.print("Would you like to enter another computer? y/n: ");
            repeat = keyboard.nextLine().toLowerCase().charAt(0);

            computerCount++;
            totalPerformanceScore += HardwareConway.calculatePerformanceScore();
        } while (repeat == 'y');

        // Calculate and output average score
        average = totalPerformanceScore / computerCount;
        System.out.printf("The average performance score is: %.2f", average);
    }
}