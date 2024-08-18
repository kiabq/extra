class LengthDemo {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();

        rect.setLength(50.0);
        rect.setWidth(50.0);

        System.out.printf("Rectangle length is: %.2f\n", rect.getLength());
        System.out.printf("Rectangle width is: %.2f\n", rect.getWidth());
        System.out.printf("Rectangle area is: %.2f\n", rect.getArea());
    }
}