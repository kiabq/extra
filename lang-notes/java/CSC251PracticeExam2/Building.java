public class Building {
   private String address;
   private int size; // in square feet

   Building() {
    this.address = "";
    this.size = 0;
   }

   Building(Building building) {
    this.address = building.address;
    this.size = building.size;
   } 

   Building(String address, int size) {
    this.address = address;
    this.size = size;
   }

   // Getters
   /**
    * Returns the address of the building.
    * @return address of building
    */
   public String getAddress() {
    return this.address;
   }

   /**
    * Returns the size of the building in square feet.
    * @return size of the building
    */
   public int getSize() {
    return this.size;
   }

   // Setters
   /**
    * Sets the address of the building.
    * @param address
    */
   public void setAddress(String address) {
    this.address = address;
   }

   /**
    * Sets the size, in square feet, of the building.
    * @param size
    */
   public void setSize(int size) {
    this.size = size;
   }

   // Methods
   public String toString() {
    return "Building{" +
           "address='" + address + '\'' +
           ", size=" + size + " square feet" +
           '}';
   }
}
