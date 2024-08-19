# Polymorphism

## Objective: 
To apply object-oriented programming concepts in Java to create a simple two-person game, reinforcing understanding of class definition, object instantiation, and basic input/output using the java.util.Scanner class.

## Instructions:
Consider the definition of the class A. Define a subclass of A named B that overrides method m1() so that it makes m the difference between m and n instead of their sum. Also make the main method print the values shown. Do not change any existing code, just add to it.
```
class A {

     protected int m;
     protected int n;
     public A(int mIn, int nIn) {
         m = mIn;
         n = nIn;
     }
     public void m1() {
         m = m + n;
    }
    ...
}

  public class B ... {
  
  ...

  public static void main(String[] args) {
  
    A a = new A(1, 2);
    A b = new B(1, 2);
    System.out.println(a + " " + b);
    a.m1();
    b.m1();
    System.out.println(a + " " + b);
  }
}
```
Prints:

A = (1, 2) B = (1, 2)

A = (3, 2) B = (-1, 2)
