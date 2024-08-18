import java.util.Scanner;  

public class Project4_Conway {
    /**
     * @param args the command line arguments
     */
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        // Declare input variables
        String processor;
        char overclock, repeat;
        double gpuClockSpeed, cpuClockSpeed;
        int cpuCoreNumber, monitorResolution;
        
        
        // Program Restrictions
        final double CLOCK_SPEED_GPU_LOW_THRESHOLD = 800;
        final double CLOCK_SPEED_GPU_HI_THRESHOLD = 2000;
        final double CLOCK_SPEED_CPU_LOW_THRESHOLD = 1000;
        final double CLOCK_SPEED_CPU_HI_THRESHOLD = 5500;
        final int CORES_LOW_THRESHOLD = 1;
        final int CORES_HI_THRESHOLD = 20;

        // Program variable
        int computerNum = 0;
        double multiplier, performanceScore;
        // Display the title of the program
        displayTitle();
        do {
            // Get the user's choice of processor
            System.out.println("Please enter the processor you are using: ");
            processor = keyboard.nextLine();

            // Get the clock speed of the GPU
            do {
                System.out.println("Please enter the clock speed (in Megahertz) of your GPU: ");
                while (!keyboard.hasNextDouble()) {
                    System.out.println("Please enter a valid number: ");
                    keyboard.next();
                }

                gpuClockSpeed = keyboard.nextDouble();

                if (gpuClockSpeed < CLOCK_SPEED_GPU_LOW_THRESHOLD || gpuClockSpeed > CLOCK_SPEED_GPU_HI_THRESHOLD) {
                    System.out.printf("The clock speed of the GPU must be between %.2f and %.2f.\n", CLOCK_SPEED_GPU_LOW_THRESHOLD, CLOCK_SPEED_GPU_HI_THRESHOLD);
                }
            } while (gpuClockSpeed < CLOCK_SPEED_GPU_LOW_THRESHOLD || gpuClockSpeed > CLOCK_SPEED_GPU_HI_THRESHOLD);

            // Get the clock speed of the CPU
            do {
                System.out.println("Please enter the clock speed (in Megahertz) of your CPU: ");
                while (!keyboard.hasNextDouble()) {
                    System.out.println("Please enter a valid number: ");
                    keyboard.next();
                }

                cpuClockSpeed = keyboard.nextDouble();

                if (cpuClockSpeed < CLOCK_SPEED_CPU_LOW_THRESHOLD  || cpuClockSpeed > CLOCK_SPEED_CPU_HI_THRESHOLD ) {
                    System.out.printf("The clock speed of the CPU must be between %.2f and %.2f.\n", CLOCK_SPEED_CPU_LOW_THRESHOLD, CLOCK_SPEED_CPU_HI_THRESHOLD);
                }
            } while (cpuClockSpeed < CLOCK_SPEED_CPU_LOW_THRESHOLD || cpuClockSpeed > CLOCK_SPEED_CPU_HI_THRESHOLD );

            // Get the number of cores in the CPU
            do {
                System.out.println("Please enter the number of cores in your CPU: ");
                while (!keyboard.hasNextInt()) {
                    System.out.println("Please enter a valid number: ");
                    keyboard.next();
                }

                cpuCoreNumber = keyboard.nextInt();

                if (cpuCoreNumber < CORES_LOW_THRESHOLD || cpuCoreNumber > CORES_HI_THRESHOLD) {
                    System.out.printf("The number of cores in the CPU must be between %d and %d.\n", CORES_LOW_THRESHOLD, CORES_HI_THRESHOLD);
                }
            } while (cpuCoreNumber < CORES_LOW_THRESHOLD || cpuCoreNumber > CORES_HI_THRESHOLD);

            // Determine if hardware is overclock-friendly
            System.out.println("Is your hardware overclock-friendly? (Y/N): ");
            do {
                overclock = keyboard.next().charAt(0);
                if (overclock != 'Y' && overclock != 'N' && overclock != 'y' && overclock != 'n') {
                    System.out.println("Please enter a valid choice (Y/N): ");
                }
            } while (overclock != 'Y' && overclock != 'N' && overclock != 'y' && overclock != 'n');
        
        } while (overclock == 'N' || overclock == 'n');
    }
    public static String displayTitle() {
        String title = "Graphics Quality Recommendation Tool";
        return title;
    }

    public static void getMenuChoice(int monitorResolution) {
        // Display user choices
        System.out.println("What is the resolution of your monitor?");
        System.out.println("1. 1280 x 720");
        System.out.println("2. 1920 x 1080");
        System.out.println("3. 2560 x 1440");
        System.out.println("4. 3840 x 2160");
        System.out.println("Please seelect from the options above (1, 2, 3, 4)");

        // Validate user input for monitor resolution
        do {
            while (!keyboard.hasNextInt()) {
                System.out.println("Please enter a valid number: ");
                keyboard.next();
            }

            monitorResolution = keyboard.nextInt();

            if (monitorResolution < 1 || monitorResolution > 4) {
                System.out.println("Please enter a valid choice (1, 2, 3, 4): ");
            }
        } while (monitorResolution < 1 || monitorResolution > 4);
    }


    public static double getMultiplierValue(int monitorResolution) {
        final int RESOLUTION_1280_720 = 1;
        final int RESOLUTION_1920_1080 = 2;
        final int RESOLUTION_2560_1440 = 3;
        final int RESOLUTION_3840_2160 = 4;
        
        final double MULTIPLIER_1280_720 = 1.0;
        final double MULTIPLER_1920_1080 = 0.75;
        final double MULTIPLIER_2560_1440 = 0.55;
        final double MULTIPLIER_3840_2160 = 0.35;
        double multiplier = 0.0;
        
        // Determine multiplier based on monitor resolution
        if (monitorResolution == RESOLUTION_1280_720) {
            multiplier = MULTIPLIER_1280_720;
        } else if (monitorResolution == RESOLUTION_1920_1080) {
            multiplier = MULTIPLER_1920_1080;
        } else if (monitorResolution == RESOLUTION_2560_1440) {
            multiplier = MULTIPLIER_2560_1440;
        } else {
            multiplier = MULTIPLIER_3840_2160;
        }

        return multiplier;
    }

    public static String getResolutionString(int monitorResolution) {
        final int RESOLUTION_1280_720 = 1;
        final int RESOLUTION_1920_1080 = 2;
        final int RESOLUTION_2560_1440 = 3;
        final int RESOLUTION_3840_2160 = 4; 

        String monitorResolutionAsString;

        // Convert monitor resolution to string
        if (monitorResolution == RESOLUTION_1280_720) {
            monitorResolutionAsString = "1280 x 720";
        } else if (monitorResolution == RESOLUTION_1920_1080) {
            monitorResolutionAsString = "1920 x 1080";
        } else if (monitorResolution == RESOLUTION_2560_1440) {
            monitorResolutionAsString = "2560 x 1440";
        } else {
            monitorResolutionAsString = "3840 x 2160";
        }

        return monitorResolutionAsString;
    }

    public static int calculatePerformanceScore(
            double gpuClockSpeed, 
            double cpuClockSpeed, 
            int cpuCoreNumber, 
            double multiplier
        ) {
        final int ATTRIBUTE = 6;

        return ATTRIBUTE * gpuClockSpeed * (cpuCoreNumber * cpuClockSpeed) * multiplier;
    }

    public static String getRecommendedQuality(double performanceScore) {
        final double PERFORMANCE_THRESHOLD_HD_PLUS = 17000;
        final double PERFORMANCE_THRESHOLD_HD = 15000;
        final double PERFORMANCE_THRESHOLD_FHD = 13000;
        final double PERFORMANCE_THRESHOLD_WUXGA = 11000;

        String recommendedQuality;

        // Determine recommended quality based on performance score
        if (performanceScore >= PERFORMANCE_THRESHOLD_HD_PLUS) {
            recommendedQuality = "Ultra";
        } else if (performanceScore >= PERFORMANCE_THRESHOLD_HD) {
            recommendedQuality = "High";
        } else if (performanceScore >= PERFORMANCE_THRESHOLD_FHD) {
            recommendedQuality = "Medium";
        } else if (performanceScore >= PERFORMANCE_THRESHOLD_WUXGA) {
            recommendedQuality = "Low";
        } else {
            recommendedQuality = "Unable to play";
        }

        return recommendedQuality;
    }

    public static void displayInformation(
        String processor, 
        String monitorResolutionAsString, 
        double gpuClockSpeed,
        double cpuClockSpeed,
        int cpuCoreNumber,
        double performanceScore,
        String recommendedQuality,
        char overclock
        ) {
        // Output overall information
        System.out.println("Resolution: " + monitorResolutionAsString);
        System.out.println("GPU Clock Speed: " + gpuClockSpeed + " MHz");
        System.out.println("CPU Clock Speed: " + cpuClockSpeed + " MHz");
        System.out.println("Number of Cores: " + cpuCoreNumber);
        System.out.println("Performance Score: " + performanceScore);
        System.out.println("Recommended Quality: " + recommendedQuality);
        if (overclock == 'N' || overclock == 'n') {
            System.out.println("Warning, your cooling system may work harder. Consider upgrading to overclock-friendly components.");
        }
        return;
    } 
}