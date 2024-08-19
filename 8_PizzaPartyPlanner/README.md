# Computer Science Assignment: "Pizza Party Planner"
## Objective:
Create a Java GUI application that allows users to plan a pizza party. This application will integrate basic GUI components and event handling to manage the order details.

## Assignment Details:
Task: Develop a "Pizza Party Planner" application using Java's Swing library. The application should allow users to input the number of guests and select pizza options. Based on the input, the application will calculate the total cost of the pizzas.

## Requirements:

1. GUI Components:

   - Use JFrame to create the main window.
   - Include JTextField for entering the number of guests.
   - Use JComboBox to allow the user to select from three pizza sizes: Small, Medium, and Large.
   - JButton to submit the order.
   - JLabel to display the total cost and any other messages to the user.

     
2. Event Handling:

    - Add action listeners to the combo box and button to handle user interactions.

3. Calculation Logic:

    - The cost of pizzas depends on their size: Small = $10, Medium = $15, Large = $20.
    - Calculate the total cost based on the number of guests and the selected pizza size. Assume each guest eats one pizza.

4. Output:

    - Display the total cost and a confirmation message like "Your order has been placed!" after the user submits the order.
    - Try to create a GUI that looks nice. You may use icons and emojis.

## Instructions:
  1. Setup: Create a new Java project and setup a JFrame with the necessary components.
  2. Layout: Arrange the components on the JFrame using a simple layout like FlowLayout.
  3. Implementation:
      - Implement the action listeners to handle the selection of pizza size and the calculation upon clicking the order button.
      - Ensure the input from the text field is validated (e.g., non-negative integers).
