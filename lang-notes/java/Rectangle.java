/**
 * Rectangle Class
 */
public class Rectangle {
    private double length, width;
    
    /**
     * setLength method stores a value in the length field.
     * @param len The value to store in length.
     */
    public void setLength(double len) {
        length = len;
    }

    /**
     * setWidth method stores a value in the width field.
     * @param wid The value to store in width.
     */
    public void setWidth(double wid) {
        width = wid;
    }

    /**
     * getLength method returns the stored length value.
     * @return The value in the length field. 
     */
    public double getLength() {
        return length;
    }

    /**
     * getWidth method returns the stored width value.
     * @return The value in the width field.
     */
    public double getWidth() {
        return width;
    } 

    /**
     * getArea method returns the length value multiplied by the width value.
     * @return Area of the rectangle: Length * Width
     */
    public double getArea() {
        return length * width;
    }
}