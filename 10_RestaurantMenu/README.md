# Assignment: Restaurant Menu GUI Application
## Objective: 
Build a Java GUI application where users can construct a meal by selecting items from different menu categories using checkboxes and radio buttons. Your application will use Swing components to offer a visually appealing and user-friendly interface.

## Requirements:

1. Menu Categories with Layouts:

- Main Course: Use checkboxes for selecting items (e.g., Burger, Pizza, Pasta). Place these checkboxes within a JPanel that utilizes a GridLayout to organize items in a grid-like fashion.
- Drink: Use radio buttons for drink selection (e.g., Soda, Coffee, Tea) within a JPanel that uses a FlowLayout to align items horizontally. Only one drink can be selected at a time.
- Use JScrollPane for the panels if the content exceeds the predefined size, ensuring all options are accessible within the GUI without altering its size.
- Use a JPanel and the Graphics class to draw a brand logo for the restaurant (make it simple). Place it prominently.

2. Order Summary: Implement a JTextArea inside a JScrollPane to dynamically display and update the user’s selections as they choose different menu items.

3. Interface Design with Layout Managers:

- Organize the main JFrame using a BorderLayout:
    - Menu categories in the center.
    - Order summary in the east.
    - Submission and cancellation buttons at the south.
- Each section should have clearly defined borders using TitledBorder, which helps visually distinguish between different parts of the application.

4. Action Buttons:

- Include a 'Submit Order' button at the bottom of the window. When clicked, a confirmation message appears in the order summary area, confirming the order.
- Add a 'Cancel' button next to the 'Submit Order' to clear all selections and reset the summary area.
5. Enhancements:

- Consider the usability and aesthetics of the interface, adjusting spacing and padding where necessary to create a clean and organized user experience.
- Optional: Employ custom borders and add icons next to menu items for a visually appealing interface.
