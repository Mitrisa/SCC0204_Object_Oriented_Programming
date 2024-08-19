// Isabela Guarnier De Mitri 13862264
// Cassiano Della Terra Spessoto 13749653

// Lion Subclassed from Mammal
class Lion extends Mammal{
  // constructor
  public Lion(String name, String species){
    super(name, species);
  }
  // sound method
  public void sound(){
    System.out.println("Roars");
  }
  // habitat method
  public void habitat(){
    System.out.println("Lives in the savannah.");
  }
}