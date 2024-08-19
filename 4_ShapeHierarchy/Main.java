// Isabela Guarnier De Mitri 13862264
// Cassiano Della Terra Spessoto 13749653

public class Main {
  public static void main(String[] args) {

     // Create two Circle objects and two Rectangle objects
    Circle circle1 = new Circle("red", 5);
    Circle circle2 = new Circle("blue", 5);
    Rectangle rectangle1 = new Rectangle("red", 5.0, 10.0);
    Rectangle rectangle2 = new Rectangle("blue", 5.0, 10.0);

    // Display information for each object
    circle1.displayInfo();
    rectangle1.displayInfo();

    // Check if the two objects are equal
    System.out.println(circle1.equals(circle2));
    System.out.println(rectangle1.equals(rectangle2));

    
  }
}