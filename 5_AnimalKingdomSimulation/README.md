# Assignment: Animal Kingdom Simulation

## Objective: 
Develop a simple Java program that models animals in a zoo using interfaces and abstract classes.

## Background: 
Interfaces and abstract classes are crucial for achieving abstraction in Java. An abstract class allows you to define template methods and encapsulate common functionality that subclasses can inherit and further specify. Interfaces enable you to specify a contract for classes to implement, ensuring they provide implementations for all abstract methods defined in the interface.

## Task Description:

### Animal Interface: 
- Define an interface named Animal with the following methods: 
  - String getName(): Returns out the animal name.
  - String getSpecies(): Returns out the species name 
  - void eat(): Prints out an eating action. 
  - void sound(): Print the sound the animal makes.

### Abstract Mammal Class: 
- Create an abstract class named Mammal that implements the Animal interface.
- Implement the eat() method within Mammal to print out "Eats like a mammal."
- Define an abstract method void sound().
- Define an abstract method void habitat(), which subclasses will use to describe their habitat.
- Create a factory method public static Animal get(String name, String species) that returns the named animal.

### Concrete Animal Classes:
- Create two concrete classes, Elephant and Lion, that extend the Mammal class, but are not public.
- Implement the sound() method in each class to print out an appropriate sound for the animal (e.g., "Trumpets" for Elephant, "Roars" for Lion).
- Implement the habitat() method to describe each animal's habitat.

###  Main Class: 
- In your Main class, instantiate objects of Elephant and Lion using the factory method and call each method defined in the Animal interface and the Mammal abstract class on these objects to demonstrate their behavior. Use only reference variables of type Animal.
