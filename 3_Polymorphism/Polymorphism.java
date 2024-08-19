//Isabela Guarnier De Mitri 13862264

import java.util.Scanner;

//define a classe A
class A {
        //atributos protegidos, podem ser acessados por subclasses 
         protected int m;
         protected int n;
         //construtor da classe A
         public A(int mIn, int nIn) {
             m = mIn;//inicializa o atributo m com o valor fornecido
             n = nIn;//inicializa o atributo n com o valor fornecido
         }
        
         public void m1() {
             m = m + n;//incrementa m com o valor de n
        }
        
        //Sobescreve o método toString para retornar uma apresentação da instância da classe A no formato (m,n) 
        public String toString() {
        return "(" + m + "," + n + ")";
    }
}

//B como subclasse de A
public class B extends A {
    //construtor da classe B
     public B (int mIn, int nIn) {
            super(mIn, nIn);//chama o construtor da superclasse A
         }
    //subtrai m de n
    public void m1 (){
        m = m-n;
    }
    
    public static void main(String[] args) {
    //cria uma instância da classe A com os valores 1 e 2
      A a = new A(1, 2);
      //cria uma instância da classe B com os valores 1 e 2
      A b = new B(1, 2);
     //imprime os objetos a e b utilizando o método sobescrito
      System.out.println("A =" + a + " B =" + b);
      a.m1();//chama o método m1 para o objeto a
      b.m1();//chama o método m1 para o objeto b
      System.out.println("A =" + a + " B =" + b);
   }
}  