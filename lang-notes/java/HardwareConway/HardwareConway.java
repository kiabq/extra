/**
 * This class will display, set, and retrieve information about given hardware.
 */
public class HardwareConway {
   private String processor;
   private double gpuClockSpeed;
   private double cpuClockSpeed;
   private int coreCount;
   private int monitorResolution;
   private char overclock;

   private final int RESOLUTION_1280_1024 = 1, 
      RESOLUTION_1366_768 = 2, 
      RESOLUTION_1600_900 = 3, 
      RESOLUTION_1920_1080 = 4;

   private final double MULTIPLIER_1280_1024 = 1.0, 
      MULTIPLIER_1366_768 = 0.75, 
      MULTIPLIER_1600_900 = 0.55, 
      MULTIPLIER_1920_1080 = 0.35;

   /**
    * No-arg constructor
    */
   public HardwareConway() {
      processor = "R7 5800X3D";
      gpuClockSpeed = 2145;
      cpuClockSpeed = 3400;
      coreCount = 8;
      monitorResolution = 1;
      overclock = 'y';
   }

   /**
    * @param processor - Type of processor
    * @param gpuClockSpeed - The clock speed of the GPU
    * @param cpuClockSpeed - The clock speed of the processor
    * @param coreCount - The core count of the processor
    * @param monitorResolution - The resolution of the monitor (int/enum value)
    * @param overclock - Status of overclockability
    */
   public HardwareConway(
      String processor,
      double gpuClockSpeed,
      double cpuClockSpeed,
      int coreCount,
      int monitorResolution,
      char overclock
   ) {
      setProcessorType(processor);
      setGpuClockSpeed(gpuClockSpeed);
      setCpuClockSpeed(cpuClockSpeed);
      setCpuCoreCount(coreCount);
      setMonitorResolution(monitorResolution);
      setOverclock(overclock);
   }
   
   // Setters
   /**
    * @param pArg - The processor
    */
   public void setProcessorType(String pArg) {
      processor = pArg;
   }

   /**
    * @param clockSpeedArg - GPU Clock speed
    */
   public void setGpuClockSpeed(double clockSpeedArg) {
      gpuClockSpeed = clockSpeedArg;
   }
   
   /**
    * @param clockSpeedArg - processor Clock speed
    */
   public void setCpuClockSpeed(double clockSpeedArg) {
      cpuClockSpeed = clockSpeedArg;
   }

   /**
    * @param count - Core count of the processor
    */
   public void setCpuCoreCount(int count) {
      coreCount = count;
   }

   /**
    * @param resolution - Resolution of the monitor as int/enum.
    */
   public void setMonitorResolution(int resolution) {
      monitorResolution = resolution;
   }

   /**
    * @param isOverclock - Overclockability of the system
    */
   public void setOverclock(char isOverclock) {
      overclock = isOverclock;
   }

   // Getters
   /**
    * @return - The type of processor
    */
   public String getProcessorType() { 
      return processor;
   }

   /**
    * @return - The resolution string of the monitor
    */
   public String getResolutionString() { 
      switch(monitorResolution) {
         case RESOLUTION_1280_1024:
            return "1280 x 1024";
         case RESOLUTION_1366_768:
            return "1366 x 768";
         case RESOLUTION_1600_900:
            return "1600 x 900";
         default:
            return "1920 x 1080";
      }
   }
   
   /**
    * This is determined by the resolution of the monitor.
    * @return - The multiplier value
    */
   public double getMultiplierValue() { 
      switch(monitorResolution) {
         case RESOLUTION_1280_1024:
            return MULTIPLIER_1280_1024;
         case RESOLUTION_1366_768:
            return MULTIPLIER_1366_768;
         case RESOLUTION_1600_900:
            return MULTIPLIER_1600_900;
         default:
            return MULTIPLIER_1920_1080;
      }
   }

   /**
    * @return - GPU Clock speed
    */
   public double getGpuClockSpeed() { 
      return gpuClockSpeed;
   }
   
   /**
    * @return - CPU Clock Speed
    */
   public double getCpuClockSpeed() {
      return cpuClockSpeed;
   }

   /**
    * This is calculated by various factors, including;
    * GPU Clock Speed
    * CPU Clock Speed
    * CPU Core Count
    * Multipler
    * Attribute (Arbitrary value)
    * @return - The performance score of a system.
    */
   public double calculatePerformanceScore() { 
      final double MULTIPLIER = getMultiplierValue();
      final int ATTRIBUTE = 6;

      return (ATTRIBUTE * gpuClockSpeed + (coreCount * cpuClockSpeed)) * MULTIPLIER;
   }
   
   /**
    * @return - CPU Core count
    */
   public int getCoreCount() { 
      return coreCount;
   }
   
   /**
    * @return - Recommended graphics quality based off system specifications.
    */
   public String getRecommendedQuality() {
      final double PERFORMANCE_SCORE = calculatePerformanceScore();
      final double PERFORMANCE_THRESHOLD_HD_PLUS = 17000, 
         PERFORMANCE_THRESHOLD_HD = 15000, 
         PERFORMANCE_THRESHOLD_FHD = 13000,
         PERFORMANCE_THRESHOLD_WUXGA = 11000;

      if (PERFORMANCE_SCORE > PERFORMANCE_THRESHOLD_HD_PLUS) {
         return "Ultra Extended";
      } else if (PERFORMANCE_SCORE > PERFORMANCE_THRESHOLD_HD) {
         return "Ultra";
      } else if (PERFORMANCE_SCORE > PERFORMANCE_THRESHOLD_FHD) {
         return "Medium";
      } else if (PERFORMANCE_SCORE > PERFORMANCE_THRESHOLD_WUXGA) {
         return "Low";
      } else {
         return "Unable to Play";
      }
    }

   /**
    * @return - The overclockability of a system.
    */
   public char getOverclockChoice() { 
      return overclock;
   }

   /**
    * Displays the title of the application
    */
   public void displayTitle() {
      System.out.println("Graphics Quality Recommendation Tool");
   }

   /**
    * Displays the information of the system and the output of the program.
    */
   public void displayInformation() {
      final String PROCESSOR = getProcessorType();
      final String RESOLUTION = getResolutionString();
      final String RECOMMENDED_QUALITY = getRecommendedQuality();
      final double GPU_CLOCK_SPEED = getGpuClockSpeed();
      final double CPU_CLOCK_SPEED = getCpuClockSpeed();
      final double PERFORMANCE_SCORE = calculatePerformanceScore();
      final int CPU_CORE_COUNT = getCoreCount();

      System.out.printf("Processor Type: %s\n", PROCESSOR);
      System.out.printf("Monitor Resolution: %s\n", RESOLUTION);
      System.out.printf("GPU Clock Speed: %.2f\n", GPU_CLOCK_SPEED);
      System.out.printf("CPU Clock Speed: %.2f\n", CPU_CLOCK_SPEED);
      System.out.printf("Number of Cores: %d\n", CPU_CORE_COUNT);
      System.out.printf("Performance Score: %.3f\n", PERFORMANCE_SCORE);
      System.out.printf("Recommended Graphics Quality: %s\n", RECOMMENDED_QUALITY);
   }
}