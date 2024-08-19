// Isabela Guarnier De Mitri 13862264
// Cassiano Della Terra Spessoto 13749653

// Main class
public class Main {
  public static void main(String[] args) {
    // creates a Lion named Simba
    Animal animal1 = Mammal.get("Simba", "Lion");
    // Prints the name and the species of the Lion
    System.out.println(animal1.getName());
    System.out.println(animal1.getSpecies());
    // Prints the diet and the sound of the Lion
    animal1.eat();
    animal1.sound();
    // Prints the habitat of the Lion using type casting
    ((Mammal) animal1).habitat();

    // creates a Elephant named Dumbo
    Animal animal2 = Mammal.get("Dumbo", "Elephant");
    // Prints the name and the species of the Elephant
    System.out.println(animal2.getName());
    System.out.println(animal2.getSpecies());
    // Prints the diet and the sound of the Elephant
    animal2.eat();
    animal2.sound();
    // Prints the habitat of the Elephant using type casting
    ((Mammal) animal2).habitat();
    
  }
}