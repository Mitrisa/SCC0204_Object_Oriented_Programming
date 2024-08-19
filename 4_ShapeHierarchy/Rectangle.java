// Isabela Guarnier De Mitri 13862264
// Cassiano Della Terra Spessoto 13749653

public class Rectangle extends Shape {
  private double length;
  private double width;

  // Constructor
  public Rectangle(String color, double length, double width) {
    super(color);
    this.length = length;
    this.width = width;
  }

  // Displays the color, length, and width of the rectangle
  @Override
  public void displayInfo() {
    super.displayInfo();
    System.out.println("Length: " + length + "\nWidth: " + width);
  }

  // Checks if two rectangles are equal
  @Override
  public boolean equals(Object object){
    // Check if the object is an instance of the same class
    if (object instanceof Rectangle) {
      Rectangle rectangle = (Rectangle) object;
      // Compare the length and width of the rectangles
      if (rectangle.length == this.length && rectangle.width == this.width) {
        return true;
      } else {
        return false;
      }
    }
    // If the object is not an instance of the same class, return false
    return false;
  }
}
