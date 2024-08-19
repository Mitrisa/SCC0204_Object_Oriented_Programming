# Enhanced Java GUI Application Assignment: Interactive Color Mixer with Detailed Event Handling

## Objective: 
Build a Java GUI application called "Interactive Color Mixer" that allows users to understand Java's event model through the manipulation of RGB (Red, Green, Blue) values using sliders, thereby creating a spectrum of colors. This assignment will specifically focus on the Java event model, emphasizing the use of listeners and event types.

## Assignment Description:
1. Application Setup:

  - Create a Java project named InteractiveColorMixer.
  - Initialize the main window (JFrame) with an appropriate title and size.

2. Interface Components:

- Implement three JSlider components, one for each RGB value, each ranging from 0 to 255.
- Include a JLabel for each slider to display its current value.
- Add a large JPanel to show the mixed color in real-time as the background color. How to set up the background color of a JPanel?

3. Detailed Event Handling:

- Attach a ChangeListener to each RGB slider. Inside the listener, implement the following:
  - Event Information Logging: Print to the console which slider was moved and the new value. This helps understand the firing of events.
  - Dynamic Color Update: Adjust the background color of the display panel based on the slider values.
- Discuss, in the JavaDoc of InteractiveColorMixer class, the event propagation path by explaining how the ChangeEvent is passed from the GUI component to the listener.

4. Reset all sliders:

- Include a JButton to reset all sliders to a predefined position (e.g., 128, to represent a neutral position).
Enhance the GUI by ensuring it is responsive and components resize gracefully when the window is adjusted.

## Learning Outcomes:
- Deep dive into the Java event model: Gain hands-on experience with ChangeListener and understand how components communicate through events.
- Enhanced GUI interaction: Learn to build a responsive and interactive user interface that reacts to user inputs in real time.
## Deliverables:
- Source code for the InteractiveColorMixer application.
