/**
 * @author Isabela Guarnier De Mitri 13862264
 * @author Cassiano Della Terra Spessôto 13749653
 * Nossa aplicação é uma calculadora simples com apenas as quatro operações básicas usando event-drvien programing.
 * O usuário deverá digitar os dois números que deseja operar e após isso escolher a operação, o resultado aparecerá
 * em outra janela e caso a entrada seja inválida (não números ou divisão por zero) uma mensagem de erro será mostrada.
 * O maior desafio encontrado na elaboração do código foi a inicialização das funcionalidades do JFrame. No primeiro
 * momento, achamos que deveriam ser feitas na main, o que não é o caso. Após isso, a implementação dos Listeners e das
 * contas matemáticas foram relativamente mais tranquilas.
 */

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

//public class Calculator which extends JFrame and implements the ActionListener interface
//Calculator class inherits all the properties and methods of JFrame and must provide
//an implementation for the actionPerformed method defined in the ActionListener interface.
public class Calculator extends JFrame implements ActionListener{
  
  private JLabel prompt;

  //field to input the first and second number in the calculator GUI.
  private JTextField inField1;
  private JTextField inField2;

  //operator's button 
  private JButton aButton; //addition
  private JButton sButton; //subtraction
  private JButton mButton; //multiplication
  private JButton dButton; //division

  //Constructor for the Calculator class, used to initialize instances of the class
  public Calculator(String title) {
    setSize(200, 120);
    setLocation(0, 0);
    setTitle(title);
    setVisible(true);

    // Initializing GUI components
    prompt = new JLabel("Enter two numbers");
    inField1 = new JTextField(5);
    inField2 = new JTextField(5);
    aButton = new JButton("+");
    aButton.setBackground(new Color(255,255,0));
    sButton = new JButton("-");
    sButton.setBackground(new Color(255,0,0));
    dButton = new JButton("/");
    dButton.setBackground(new Color(0,255,0));
    mButton = new JButton("*");
    mButton.setBackground(new Color(0,0,255));
    JPanel inputPanel = new JPanel();

  // Adding GUI components to the input panel
    inputPanel.add(prompt);
    inputPanel.add(inField1);
    inputPanel.add(inField2);
    inputPanel.add(aButton);
    inputPanel.add(sButton);
    inputPanel.add(mButton);
    inputPanel.add(dButton);

    //getContentPane() é um método da classe JFrame que retorna o contêiner de conteúdo principal da janela. 
    //Esse contêiner é onde os componentes gráficos da interface do usuário são colocados.
    Container contentPane = getContentPane(); 
    contentPane.add(inputPanel);

//When any of these buttons are clicked, the actionPerformed method of the Calculator class is called.
    aButton.addActionListener(this);
    sButton.addActionListener(this);
    mButton.addActionListener(this);
    dButton.addActionListener(this);
  }

  // This method is called when an action is performed, such as a button click
  public void actionPerformed(ActionEvent op) {
    // Check if the action event is from the addition button
    if (op.getSource() == aButton) { //getsource() retorna o objeto que foi clicado ou que ativou o evento.
        // If the addition button was clicked, call the calculate method with '+' as the operator
        calculate('+');
    } else if (op.getSource() == sButton) {
        calculate('-');
    } else if (op.getSource() == mButton) {
        calculate('*');
    } else if (op.getSource() == dButton) {
        calculate('/');
    }
}
  public void calculate(char operator){
    try {
        // Parsing the input text from the text fields to doubles
        double num1 = Double.parseDouble(inField1.getText());
        double num2 = Double.parseDouble(inField2.getText());
        double result = 0;

        // Performing calculation based on the operator
        switch (operator) {
          case '+':
          result = num1 + num2;
            break;
          case '-':
          result = num1 - num2;
            break;
          case '*':
          result = num1 * num2;
            break;
          case '/':
          // Checking if division by zero is attempted
            if (num2 != 0)
              result = num1 / num2;
            else
            // If division by zero is attempted, show an error message
              JOptionPane.showMessageDialog(this, "Cannot divide by zero","ERROR",JOptionPane.ERROR_MESSAGE);
            break;
        }
        // Displaying the result if the operation is not division by zero
        if((operator != '/') || (num2 != 0))
          JOptionPane.showMessageDialog(this, "Result: " + result);
      } catch (NumberFormatException ex) {
        // Handling invalid input (non-numeric input)
          JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.","ERROR",JOptionPane.ERROR_MESSAGE);
      }
  }

  // Main method to run the calculator
  public static void main(String[] args) {
    // Creating an instance of the Calculator class
    Calculator calculator = new Calculator("Calculator");
    // Setting the default close operation
    calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Adjusting the frame size based on its contents
    calculator.pack();
    // Making the frame visible
    calculator.setVisible(true);

  }
}
