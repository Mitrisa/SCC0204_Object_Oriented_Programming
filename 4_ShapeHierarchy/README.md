# Assignment: Shape Hierarchy in Java

## Objective:
To create a Java program that demonstrates the use of inheritance, constructors, and the basic concept of polymorphism through a simple shape hierarchy. This exercise will enhance your understanding of how different objects can share characteristics while possessing their unique properties and behaviors.

## Task Description:

### Shape Class (Base Class):

Define a base class named Shape. It should have one private attribute, color (String), and a constructor that takes color as a parameter. Include a method void displayInfo() that prints the color of the shape.

### Circle Class (Derived Class):

Define a derived class named Circle that extends Shape. It should have one private attribute, radius (double), and a constructor that takes color and radius as parameters. How to set color from a Circle constructor using super()? Override the displayInfo() method to include the radius along with the color.

### Rectangle Class (Derived Class):

Define another derived class named Rectangle that extends Shape. It should have two private attributes, length and width (both doubles), and a constructor that takes color, length, and width as parameters. Override the displayInfo() method to include the length, width, and color.

### Main Class:

In your Main class, create instances of Circle and Rectangle, setting appropriate values for their attributes. Call the displayInfo() method on both instances to demonstrate polymorphism and how it displays different information based on the object type.

### Overriding the equals Method: 
For each derived class (Circle and Rectangle), override the equals(Object obj) method to compare two instances of the same class. 
- Circle: Two Circle objects are considered equal if they have the same radius, regardless of color.
- Rectangle: Two Rectangle objects are considered equal if they have the same length and width, regardless of color.
-
  Remember that equals can receive a null pointer or a shape of a different class. How are you going to test the object class? Is there a method in Object to do that?

Demonstrate the use of equals Method in Main Class: Create two instances of Circle with the same radius but different colors and use the equals method to compare them. Print the result. Repeat the process for the Rectangle class, creating two instances with the same dimensions but different colors and comparing them with equals.
