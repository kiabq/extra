public class Parcel {
   enum ZoningType {
      None,
      Residential,
      Commercial,
   }

   private int idNumber;
   private double size; // in acres
   private ZoningType zone;
   private Building building;

   Parcel() {
      this.idNumber = 0;
      this.size = 0;
      this.zone = ZoningType.None;
      this.building = new Building();
   }
   
   Parcel(int idNumber, double size, ZoningType zone, Building building) {
      this.idNumber = idNumber;
      this.size = size;
      this.zone = zone;
      this.building = new Building(building);
   }

   // Getters
   /**
    * Returns the Id number of the parcel.
    * @return parcel id number
    */
   public int getId() {
      return this.idNumber;
   }

   /**
    * Returns the parcel size.
    * @return size of parcel in acres
    */
   public double getSize() {
      return this.size;
   } 

   /**
    * Returns the zoning type of the parcel.
    * @return zoning type of parcel
    */
   public ZoningType getZone() {
      return this.zone;
   }
   
   // Setters
   /**
    * Sets the id number of the parcel.
    * @param idNumber 
    */
   public void setId(int idNumber) {
      this.idNumber = idNumber;
   }

   /**
    * Sets the size (in acres) of the parcel.
    * @param size
    */
   public void setSize(double size) {
      this.size = size;
   }

   /**
    * Sets the zone of the parcel.
    * @param zone
    */
   public void setZone(ZoningType zone) {
      this.zone = zone;
   }

   // Methods
   public double CalculatePropertyTax() {
     int buildingSize = this.building.getSize();
     int baseCost = 0;
     double additionalCostMultiplier = 0;
      
     switch (this.zone) {
      case None:
         return 0;
      case Residential:
         baseCost = 500;

         if (buildingSize < 2000) {
            additionalCostMultiplier = 0.5;
         } else {
            additionalCostMultiplier = 0.75;
         }
         break;
      case Commercial:
         baseCost = 2000;

         if (buildingSize < 4000) {
            additionalCostMultiplier = 1.0;
         } else {
            additionalCostMultiplier = 1.50;
         }
         break;
     }

     return (this.size * baseCost) + (buildingSize * additionalCostMultiplier);
   }

   public String toString() {
      return "Parcel{" +
             "idNumber=" + idNumber +
             ", size=" + size + " acres" +
             ", zone=" + zone +
             ", building=" + building +
             '}';
   }
}
