// Isabela Guarnier De Mitri 13862264
// Cassiano Della Terra Spessoto 13749653

public class Circle extends Shape {
  private double radius;

  // Constructor
  public Circle(String color, double radius) {
    super(color);
    this.radius = radius;
  }

  // Displays the color and radius of the circle
  @Override
  public void displayInfo() {
    super.displayInfo();// Call the displayInfo method of the superclass
    System.out.println("Radius: " + radius);
  }

  // Checks if two circles are equal
  @Override
  public boolean equals(Object object){
    // Check if the object is an instance of the same class
    if (object instanceof Circle) {
      Circle circle = (Circle) object;
      // Compare the radius of the circles
      if (circle.radius == this.radius) {
        return true;
      } else {
        return false;
      }
    }
    // If the object is not an instance of the same class, return false
    return false;
  }
}