// Isabela Guarnier De Mitri 13862264
// Cassiano Della Terra Spessôto 13749653

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener, ItemListener {

    // Declaring JComponents
    JCheckBox[] food;
    JRadioButton[] drink;
    JTextArea order;
    JButton submit, cancel;
    ButtonGroup drinkGroup;
    JPanel foodPanel, drinkPanel, itemPanel, buttonPanel, logoPanel;

    /**
     * The usage of another class is necessary for the logo to be placed in a JPanel since the .add
     * method only accepts JComponents as parameters
     */

    // Painting the logo using a nested class
    public static class MyGraphics extends JComponent {

        //Constructor
        public MyGraphics() {
            // Setting the size of the logo
            setPreferredSize(new Dimension(50, 50));
        }

        // Painting the logo
        @Override//Overriding the superclass method
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.green);
            g.fillRoundRect(0, 0, 50, 50, 25, 25);
            g.setColor(Color.yellow);
            g.fillOval(7, 7, 36, 36);
            g.setColor(Color.blue);
            g.fillOval(17, 17, 16, 16);

        }
    }

    //GUI
    public void createGUI() {

        // Setting up the Frame
        setLocation(500, 300);
        setTitle("Restaurant Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Adding the logo to a JPanel
        logoPanel = new JPanel();
        logoPanel.add(new MyGraphics());

        // Creating the foods Panel
        foodPanel = new JPanel();
        foodPanel.setLayout(new GridLayout(3, 3));
        food = new JCheckBox[9];
        food[0] = new JCheckBox("Pizza");
        food[1] = new JCheckBox("Burger");
        food[2] = new JCheckBox("Pasta");
        food[3] = new JCheckBox("Fries");
        food[4] = new JCheckBox("Salad");
        food[5] = new JCheckBox("Ice Cream");
        food[6] = new JCheckBox("Bread");
        food[7] = new JCheckBox("Roast Chicken");
        food[8] = new JCheckBox("Hot Dog");


        for (JCheckBox option : food) {
            foodPanel.add(option);
            option.addItemListener(this);
        }

        // Creating the drinks Panel
        drinkPanel = new JPanel();
        drinkPanel.setLayout(new FlowLayout());
        drink = new JRadioButton[5];
        drink[0] = new JRadioButton("Soda");
        drink[1] = new JRadioButton("Tea");
        drink[2] = new JRadioButton("Coffee");
        drink[3] = new JRadioButton("Juice");
        drink[4] = new JRadioButton("Water");
        drinkGroup = new ButtonGroup(); // ButtonGroup only allows one Button to be active at a time
        for (JRadioButton option : drink) {
            drinkGroup.add(option);
            drinkPanel.add(option);
            option.addItemListener(this);
        }

        // Including both Panels into another Panel to place them into the center of the Frame without overwriting
        itemPanel = new JPanel();
        itemPanel.add(foodPanel);
        itemPanel.add(drinkPanel);
        itemPanel.setLayout(new FlowLayout());

        // Creating the buttons
        submit = new JButton("Submit");
        cancel = new JButton("Cancel");
        // Including both Buttons into a Panel to place them into the bottom of the Frame without overwriting
        buttonPanel = new JPanel();
        buttonPanel.add(submit);
        buttonPanel.add(cancel);
        buttonPanel.setLayout(new FlowLayout());

        // Adding ActionListeners to the Buttons
        submit.addActionListener(this);
        cancel.addActionListener(this);

        // Creating a textArea for displaying the order
        order = new JTextArea(1, 10);

        // Adding a scroll bar to the itemPanel and the textArea
        JScrollPane scrollPanePanel = new JScrollPane(itemPanel);
        JScrollPane scrollPaneOrder = new JScrollPane(order);

        // Creating the main Frame
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(scrollPanePanel, "Center");
        contentPane.add(scrollPaneOrder, "East");
        contentPane.add(buttonPanel, "South");
        contentPane.add(logoPanel, "West");

        // Adding borders to the Panels
        itemPanel.setBorder(BorderFactory.createTitledBorder("Menu"));
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Options"));
        }

        // ActionPerformed
        public void actionPerformed(ActionEvent op) {
            // Submit Button
            if (op.getSource() == submit) {
                order.append("Order submitted successfully!\n");
            }
            // Cancel Button
            else if (op.getSource() == cancel) {
                // Unchecks all Checkboxes
                for (JCheckBox option : food) {
                    option.setSelected(false);
                }
                // Unchecks all RadioButtons
                drinkGroup.clearSelection();
                // Clears the textArea
                order.setText("");
            }
        }

        // ItemStateChanged
        public void itemStateChanged(ItemEvent e) {
            //Checkbox
            if (e.getSource() instanceof JCheckBox source) {
                // Selected
                if (source.isSelected()) {
                    order.append("Selected: " + source.getText() + "\n");
                    // Deselected
                } else {
                    order.append("Deselected: " + source.getText() + "\n");
                }
                //RadioButton
            } else if (e.getSource() instanceof JRadioButton source) {
                if (source.isSelected()) {
                    order.append("Selected: " + source.getText() + "\n");
                }
            }
        }

        // Main
        public static void main(String[] args) {
            Menu GUI = new Menu();
            GUI.createGUI();
            GUI.pack();

        }
    }
