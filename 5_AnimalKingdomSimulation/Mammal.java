// Isabela Guarnier De Mitri 13862264
// Cassiano Della Terra Spessoto 13749653

// parent class Mammal
abstract class Mammal implements Animal {
  String name;
  String species;

  // constructor: initializate the name and species
  public Mammal(String name, String species) {
    this.name = name;
    this.species = species;
  }

  // get method: return the name
  public String getName() {
    return this.name;
  }

  // get method: return the species
  public String getSpecies() {
    return this.species;
  }

  // method: print how the animal eats
  public void eat() {
    System.out.println("Eats like a mammal.");
  }

  // abstract method habitat
  abstract void habitat();

  // factory: create an animal
  public static Animal get(String name, String species) {
    // if the species is Lion, creates a Lion
    if (species.equals("Lion")) {
      return new Lion(name, species);
    }
    // if the species is Elephant, creates a Elephant
    else if (species.equals("Elephant")) {
      return new Elephant(name, species);
    }
    // if the species is not Lion or Elephant, returns null
    else {
      return null;
    }
  }
}