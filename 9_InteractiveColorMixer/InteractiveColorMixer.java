//Isabela Guarnier De Mitri 13862264

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

// Classe principal que estende JFrame e implementa ChangeListener e ActionListener
public class InteractiveColorMixer extends JFrame implements ChangeListener, ActionListener{

    //Componentes da GUI
    private JSlider redSlider, greenSlider, blueSlider;
    private JLabel redLabel, greenLabel, blueLabel;
    private JPanel mixedColor;
    private JButton reset;

    //construtor da classe
    public InteractiveColorMixer(){
        setTitle("Interactive Color Mixer");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//Centraliza a janela
        setVisible(true);

        //Inicializa os sliders definindo o intervalo 
        blueSlider = new JSlider(0, 255);;
        redSlider = new JSlider(0,225);
        greenSlider = new JSlider(0,225);

        //rótulos para exibir os valores das cores
        blueLabel = new JLabel("Blue: 128");
        redLabel = new JLabel("Red: 128");
        greenLabel = new JLabel("Green: 128");

        //inicializa o botão reset
        reset = new JButton("Reset");

        //painel para a cor misturada
        mixedColor = new JPanel();
        mixedColor.setPreferredSize(new Dimension(300,200));

        //cria o painel e adiciona as componentes
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Adiciona padding ao painel de entrada
        inputPanel.add(blueLabel);
        inputPanel.add(blueSlider);
        inputPanel.add(redLabel);
        inputPanel.add(redSlider);
        inputPanel.add(greenLabel);
        inputPanel.add(greenSlider);
        inputPanel.add(new JLabel("Mixed Color:"));
        inputPanel.add(mixedColor);
        inputPanel.add(reset);

        //o inputPanel é responsável por conter os componentes relacionados à entrada de dados
        //o mainPanel contém o inputPanel e organiza a disposição dos componentes na interface gráfica
        
        //configurando o painel principal
        JPanel mainPanel = new JPanel(new BorderLayout()); // Painel principal para conter inputPanel e buttonPanel
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(reset, BorderLayout.SOUTH);

        Container contentPane = getContentPane(); //obtém o contêiner de conteúdo da janela principal
        contentPane.add(mainPanel);//o painel principal é adicionado ao contêiner

        // Adiciona listeners para os sliders e botão reset
        redSlider.addChangeListener(this);
        greenSlider.addChangeListener(this);
        blueSlider.addChangeListener(this);
        reset.addActionListener(this);
    }

    // Método para lidar com a ação do botão Reset
    public void actionPerformed(ActionEvent op){
        if (op.getSource() == reset){
            // Resetar os sliders para o valor padrão
            redSlider.setValue(128);
            greenSlider.setValue(128);
            blueSlider.setValue(128);

            // Atualizar os rótulos de cor
            redLabel.setText("Red: 128");
            greenLabel.setText("Green: 128");
            blueLabel.setText("Blue: 128");

            // Atualizar a cor do painel misto
            mixedColor.setBackground(new Color(128, 128, 128));
        } 
   }

    // Método para lidar com a mudança nos sliders de cor
    public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
    
        if (source == redSlider) {
            int redValue = redSlider.getValue();
            redLabel.setText("Red: " + redValue);
        } else if (source == greenSlider) {
            int greenValue = greenSlider.getValue();
            greenLabel.setText("Green: " + greenValue);
        } else if (source == blueSlider) {
            int blueValue = blueSlider.getValue();
            blueLabel.setText("Blue: " + blueValue);
        }
    
        // Obtém os valores atuais dos sliders
        int redValue = redSlider.getValue();
        int greenValue = greenSlider.getValue();
        int blueValue = blueSlider.getValue();
    
         // Atualiza a cor do painel misto com base nos valores dos sliders
        mixedColor.setBackground(new Color(redValue, greenValue, blueValue));
    }
    
    public static void main(String[] args) {
        // Cria e exibe a interface gráfica na EDT
        SwingUtilities.invokeLater(InteractiveColorMixer::new);
    }
}

//SwingUtilities é uma classe Do Java Swing que fornece várias utilidades para trabalhar com a GUI
//invokeLater é um método desta classe que executa o código fornecido 
//de forma assíncrona na thread de despacho de eventos Swing, também conhecida como Event Dispatch Thread (EDT).
//A EDT (Event Dispatch Thread) é uma thread especial em aplicativos Swing que é responsável por processar 
//eventos de entrada do usuário e atualizar a interface gráfica do usuário (GUI).