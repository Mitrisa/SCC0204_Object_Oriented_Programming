//Isabela Guarnier De Mitri 13862264
//Cassiano Della Terra Spessôto 13749653
import java.io.*;
/*
 * OneRowNim.java
 * The full version of One Row Nim. This version can be CLUIPlayable
 */

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;

class OneRowNimGUI extends JFrame implements ActionListener{
    private OneRowNim game;
    private JTextField inField1;
    private JTextField inField2;
    private JButton takeSticks;
    private JButton resetGame;

    public OneRowNimGUI (String title) {
        setSize(200, 120);
        setLocation(0, 0);
        setTitle(title);
        setVisible(true);

        game = new OneRowNim();
        inField1 = new JTextField(5);
        inField2 = new JTextField(40);
        inField2.setHorizontalAlignment(JTextField.CENTER);
        inField2.setEditable(false);
        takeSticks = new JButton("Take Sticks");
        resetGame = new JButton("Reset Game");
        JPanel inputPanel = new JPanel();


        inputPanel.add(takeSticks);
        inputPanel.add(resetGame);
        inputPanel.add(inField1);
        inputPanel.add(inField2);
        
        Container contentPane = getContentPane(); 
        contentPane.add(inputPanel);

        takeSticks.addActionListener(this);
        resetGame.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // Handle button clicks here
        if (e.getSource() == takeSticks) {
            // Lógica para quando o botão "Take Sticks" for clicado
            int sticks = Integer.parseInt(inField1.getText());
            if (game.takeSticks(sticks)) { // Se a jogada for válida
                game.changePlayer(); // Muda o jogador
                if (!game.gameOver()) {
                    // Atualiza a interface com o estado do jogo
                    inField2.setText(game.reportGameState());
                    inField1.setText("");
                    if (game.getPlayer() == TwoPlayerGame.PLAYER_TWO && game.computer1 != null) {
                        // Fazendo o computador jogar
                        int n = Integer.parseInt(game.computer1.makeAMove(game.getGamePrompt()));
                        //Obtem a jogada do computador
                        game.takeSticks(n);
                        inField2.setText(game.reportGameState());
                    }
                } else {
                    // Exibe o vencedor
                    inField2.setText("Game over! Winner is Player " + game.getWinner() + "\n");
                }
            } else {
                // Se a jogada for inválida
                inField2.setText("Oops. " + sticks + " is an illegal move." + game.getGamePrompt());
            }
        } else if (e.getSource() == resetGame) {
            // Lógica para quando o botão "Reset Game" for clicado
            // Reinicia o jogo
            game = new OneRowNim();
            inField2.setText(""); // Limpa o campo de texto da interface
        }
    }
}

class NimPlayerBad implements IPlayer {
    private OneRowNim game;

    public NimPlayerBad(OneRowNim game) {
        this.game = game;
    }

    public String makeAMove(String prompt) {
        return "" + randomMove();
    }

    private int randomMove() {
        int sticksLeft = game.getSticks();
        return 1 + (int) (Math.random() * Math.min(sticksLeft, game.MAX_PICKUP));
    }

    public String toString() {
        String className = this.getClass().toString(); // returns 'class NimPlayerBad'
        return className.substring(5); // cut off the word 'class'
    }
}

public class OneRowNim extends TwoPlayerGame implements CLUIPlayableGame {
    public static final int MAX_PICKUP = 3;
    public static final int MAX_STICKS = 11;

    private int nSticks = MAX_STICKS;

    public OneRowNim() {
    } // Constructors

    public OneRowNim(int sticks) {
        nSticks = sticks;
    }

    public OneRowNim(int sticks, int starter) {
        nSticks = sticks;
        setPlayer(starter);
    }

    public boolean takeSticks(int num) {
        if (num < 1 || num > MAX_PICKUP || num > nSticks)
            return false; // Error
        else // Valid move
        {
            nSticks = nSticks - num;
            return true;
        } // else
    }

    public int getSticks() {
        return nSticks;
    }

    public String getRules() {
        return "\n*** The Rules of One Row Nim ***\n" +
                "(1) A number of sticks between 7 and " + MAX_STICKS + " is chosen.\n" +
                "(2) Two players alternate making moves.\n" +
                "(3) A move consists of subtracting between 1 and\n\t" +
                MAX_PICKUP + " sticks from the current number of sticks.\n" +
                "(4) A player who cannot leave a positive\n\t" +
                " number of sticks for the other player loses.\n";
    }

    public boolean gameOver() { /** From TwoPlayerGame */
        return (nSticks <= 0);
    }

    public String getWinner() { /** From TwoPlayerGame */
        if (gameOver()) // {
            return "" + getPlayer() + " Nice game.";
        return "The game is not over yet."; // Game is not over
    }

    public String getGamePrompt() {
        return "\nYou can pick up between 1 and " + Math.min(MAX_PICKUP, nSticks) + " : ";
    }

    public String reportGameState() {
        if (!gameOver())
            return ("\nSticks left: " + getSticks() + " Who's turn: Player " + getPlayer());
        else
            return ("\nSticks left: " + getSticks() + " Game over! Winner is Player " + getWinner() + "\n");
    }

    public void setGame(UserInterface ui){
        ui.report(getRules());
        if (computer1 != null)
             ui.report("\nPlayer 1 is a " + computer1.toString());
            if (computer2 != null)
                ui.report("\nPlayer 2 is a " + computer2.toString());
    }

    /** From CLUIPlayableGame interface */
    public void play(UserInterface ui) {
        int sticks = 0;
        setGame(ui);
     
        ui.report(reportGameState()); // The game is now over
    }

    public String submitUserMove(String theMove) {
        int sticks = Integer.parseInt(theMove);
        if (takeSticks(sticks)) {
            changePlayer();
            if (gameOver()) {
                return reportGameState() + "\nGame won by player" + getWinner() + "\n";
            } else {
                return reportGameState() + getGamePrompt();
            }
        }
        return "\nOops. " + sticks + " is an illegal move." + getGamePrompt();
    }


    /**
     * A OneRowNim Keyboard Application Program
     */
    public static void main(String args[]) {
        KeyboardReader kb = new KeyboardReader();
        CLUIPlayableGame game = new OneRowNim();

        OneRowNimGUI oneRowNimGUI = new OneRowNimGUI("One Row Nim");
        oneRowNimGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Adjusting the frame size based on its contents
        oneRowNimGUI.pack();
        // Making the frame visible
        oneRowNimGUI.setVisible(true);

        kb.prompt("How many computers are playing, 0, 1, or 2? ");
        int m = kb.getKeyboardInteger();
        for (int k = 0; k < m; k++) {
            IPlayer computer = new NimPlayerBad((OneRowNim) game);
            ((TwoPlayerGame) game).addComputerPlayer(computer);
        }
        
        game.play(kb);
    }
}

interface IPlayer {
    /**
     * makeAMove() defines how a move is made. It is meant
     * to be implemented by any object that plays the game.
     *
     * @param prompt is a String that prompts the player for a move.
     * @return a String that describes the player's move
     */
    public String makeAMove(String prompt);
}

interface IGame {
    String getGamePrompt();
    String reportGameState();
}

interface UserInterface {
    public String getUserInput();
    public void report(String s);
    public void prompt(String s);
}

interface CLUIPlayableGame extends IGame {
    /**
     * play() implements the play loop for a game that
     * interfaces to a UserInterface. It is meant to
     * be implented by games that support a command-line
     * interface.
     */
    public abstract void play(UserInterface ui);
}

abstract class TwoPlayerGame {
    public static final int PLAYER_ONE = 1; // Class constants
    public static final int PLAYER_TWO = 2;

    protected boolean onePlaysNext = true; // Player 1 plays next
    protected int nComputers = 0; // How many computer players
    protected IPlayer computer1, computer2; // Computers are IPlayers

    /**
     * setPlayer() sets which player makes the first move.
     *
     * @param starter, an int representing PLAYER_ONE or PLAYER_TWOI
     */
    public void setPlayer(int starter) {
        if (starter == PLAYER_TWO)
            onePlaysNext = false;
        else
            onePlaysNext = true;
    }

    /**
     * getPlayer() returns an int representing whose turn it it.
     *
     * @return an int representing PLAYER_ONE or PLAYER_TWO.
     */
    public int getPlayer() {
        if (onePlaysNext)
            return PLAYER_ONE;
        else
            return PLAYER_TWO;
    }

    /**
     * changePlayer() toggles between PLAYER_ONE or PLAYER_TWO.
     */
    public void changePlayer() {
        onePlaysNext = !onePlaysNext;
    }

    /**
     * getNComputers() returns the number of computers playing
     *
     * @return an int representing the number of computer players
     */
    public int getNComputers() {
        return nComputers;
    }

    /**
     * getRules() returns a String describing the rules of the game.
     *
     * @return a String giving the game's rules.
     */
    public String getRules() {
        return "The rules of this game are: ";
    }

    /**
     * addComputerPlayer() adds to the number of computer players.
     *
     * @param player is an IPlayer
     */
    public void addComputerPlayer(IPlayer player) {
        if (nComputers == 0)
            computer2 = player;
        else if (nComputers == 1)
            computer1 = player;
        else
            return; // No more than 2 players
        ++nComputers;
    }

    /**
     * gameOver() defines when the game is over. It is meant to be
     * implemented in subclasses.
     */
    public abstract boolean gameOver(); // Abstract Methods

    /**
     * getWinner() defines who wins the game. It is meant to be
     * implemented in subclasses.
     */
    public abstract String getWinner();
}

class KeyboardReader implements UserInterface {
    private BufferedReader reader;

    /**
     * KeyboardReader() constructor creates a BufferedReader that
     * is used for command-line and console I/O.
     */
    public KeyboardReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * getKeyboardInput() returns input read from the keyboard.
     */
    public String getKeyboardInput() {
        return readKeyboard();
    }

    /**
     * getKeyboardInput() returns an integer read from the keyboard.
     */
    public int getKeyboardInteger() {
        return Integer.parseInt(readKeyboard());
    }

    /**
     * getKeyboardInput() returns a double value read from the keyboard.
     */
    public double getKeyboardDouble() {
        return Double.parseDouble(readKeyboard());
    }

    /**
     * getUserInput() is a method of the UserInterface class. It
     * returns input read from the keyboard.
     */
    public String getUserInput() {
        return getKeyboardInput();
    }

    /**
     * prompt() is a method of the UserInterface class. It
     * prints its parameter.
     *
     * @param s is the String prompt
     */
    public void prompt(String s) {
        System.out.print(s);
    }

    /**
     * prompt() is a method of the UserInterface class. It
     * prints its parameter.
     *
     * @param s is a String representing the state of the game.
     */
    public void report(String s) {
        System.out.print(s);
    }

    /**
     * display() prints its parameter.
     */
    public void display(String s) {
        System.out.print(s);
    }

    /**
     * readKeyboard() reads a line of input from the keyboard
     * where reader is a BufferedReader.
     *
     * @return a String storing a line read from the keyboard.
     */
    private String readKeyboard() {
        String line = "";
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}