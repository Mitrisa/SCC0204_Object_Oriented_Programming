import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.JComboBox;

public class Pizza extends JFrame implements ActionListener {
   // Declaração de variáveis de instância
   JTextField textFieldNumberGuests; // Campo de texto para o número de convidados
   JComboBox<String> comboBoxPizzaSize; // ComboBox para selecionar o tamanho da pizza
   JLabel labelTotalCost; // Label para exibir o custo total
   JLabel labelFeedbackMessage; // Label para exibir mensagens de feedback

   //Construtor da classe Pizza
   public Pizza() {

      this.setSize(300, 150);
      this.setTitle("Pizza Party Planner");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Criação do painel principal
      JPanel panelMain = new JPanel(new GridLayout(3, 2)); // Cria um JPanel com layout de grade 3x2
      panelMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));// Adiciona uma borda ao painel com margens

      // Criação dos componentes gráficos
      JLabel labelGuests = new JLabel("Number of Guests:"); // Label para "Number of Guests"
      this.textFieldNumberGuests = new JTextField(5);// Campo de texto para o número de convidados
      JLabel labelPizzaSize = new JLabel("Pizza Size:");// Label para "Pizza Size"
      this.comboBoxPizzaSize = new JComboBox<>(new String[]{"Small", "Medium", "Large"});// ComboBox com opções de tamanho de pizza
      JButton buttonSubmit = new JButton("Submit");// Botão para submeter o pedido
      buttonSubmit.addActionListener(this);//Adiciona um ouvinte de ação ao botão

      // Inicializa as labels de total e mensagem
      this.labelTotalCost = new JLabel("");// Label para exibir o custo total
      this.labelFeedbackMessage = new JLabel(""); // Label para exibir mensagens de feedback

      // Adiciona os componentes ao painel
      panelMain.add(labelGuests); // Adiciona a label "Number of Guests" ao painel
      panelMain.add(this.textFieldNumberGuests); // Adiciona o campo de texto ao painel
      panelMain.add(labelPizzaSize); // Adiciona a label "Pizza Size" ao painel
      panelMain.add(this.comboBoxPizzaSize); // Adiciona o ComboBox ao painel
      panelMain.add(buttonSubmit); // Adiciona o botão "Submit" ao painel
      panelMain.add(this.labelTotalCost); // Adiciona a label de total ao painel

      // Adiciona o painel principal à janela no centro e a label de mensagem na parte inferior
      this.add(panelMain, BorderLayout.CENTER);
      this.add(this.labelFeedbackMessage, BorderLayout.SOUTH);
   }

   // Método actionPerformed para lidar com eventos de ação
   public void actionPerformed(ActionEvent event) {
      // Verifica se o evento ocorreu no botão "Submit"
      if (event.getActionCommand().equals("Submit")) {
         int numGuests; // Número de convidados
         try {
            // Tenta converter o texto do campo de número de convidados para um número inteiro
            numGuests = Integer.parseInt(this.textFieldNumberGuests.getText());
            // Verifica se o número de convidados é negativo
            if (numGuests < 0) {
               throw new NumberFormatException(); // Lança uma exceção se for negativo
            }
         } catch (NumberFormatException e) {
            // Captura a exceção e exibe uma mensagem de erro
            this.labelFeedbackMessage.setText("Invalid input for number of guests.");
            return; // Sai do método actionPerformed
         }
         // Calcula o custo da pizza com base no tamanho selecionado
         int pizzaCost;
         switch (this.comboBoxPizzaSize.getSelectedIndex()) {
            case 0:
               pizzaCost = 10;
               break;
            case 1:
               pizzaCost = 15;
               break;
            case 2:
               pizzaCost = 20;
               break;
            default:
               pizzaCost = 0;
         }

         // Calcula o custo total multiplicando o número de convidados pelo custo da pizza
         int totalCost = numGuests * pizzaCost;
         // Atualiza a label de total com o valor calculado
         this.labelTotalCost.setText("Total Cost: $" + totalCost);
         // Exibe uma mensagem de confirmação na label de mensagem
         this.labelFeedbackMessage.setText("Your order has been placed!");
      }
   }

   public static void main(String[] args) {
      Pizza pizza = new Pizza(); // Cria uma instância da classe Pizza
      pizza.setVisible(true);// Torna a janela visível
   }
}
