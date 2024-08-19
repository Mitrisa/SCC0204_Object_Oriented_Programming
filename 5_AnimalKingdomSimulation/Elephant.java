// Isabela Guarnier De Mitri 13862264
// Cassiano Della Terra Spessoto 13749653

// Elephant Subclassed from Mammal
 class Elephant extends Mammal{
  // constructor
  public Elephant(String name, String species){
    super(name, species);
  }
  // sound method
  public void sound(){
    System.out.println("Trumpets");
  }
  // habitat method
  public void habitat(){
    System.out.println("Lives in the savannah.");
  }
}