// Isabela Guarnier De Mitri 13862264
// Cassiano Della Terra Spessoto 13749653

public class Shape {
  private String color;

  // Constructor
  public Shape(String color) {
    this.color = color;
  }

  // Displays the color of the shape
  public void displayInfo() {
    System.out.println("Color: " + color);
  }

  // Checks if two shapes are equal
  public boolean equals(Object object) {
      // Check if the object is an instance of the same class
      if (object instanceof Shape) {
          Shape shape = (Shape) object;
          // Compare the color of the shapes
          if (shape.color.equals(this.color)) {
              return true;
          } else {
              return false;
          }
      }
      // If the object is not an instance of the same class, return false
      return false;
  }
  
}
