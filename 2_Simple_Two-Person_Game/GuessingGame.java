//Isabela Guarnier De Mitri 13862264
//Cassiano Della Terra Spessoto 13749653
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    int count = 0;
    int randomNumber;
    int userNumber;
    
    //escolhe um número aleatório e começa o jogo
    private void SetGame() {
        Random random = new Random();
        randomNumber = random.nextInt(101);
        System.out.println("Number chosen by the game: "+randomNumber);//número escolhido pelo jogo
    } 
    
    //guarda a entrada do usuário
    private void UserGuess() {
        Scanner scanner = new Scanner(System.in);
        userNumber = scanner.nextInt();
    }
    
    //conta as tentativas e compara os números para dar o feedback
    private void Feedback(int userNumber, int randomNumber){
         
            count++;
            System.out.println("This is your "+count+" guess");
            if(userNumber < randomNumber)
            System.out.println("Your guess was lower than the number");
            if(userNumber > randomNumber)
            System.out.println("Your guess was higher than the number");
    }
    
    public static void main(String args[]) {
        GuessingGame game = new GuessingGame(); //criando um objeto da classe GuessingGame
        game.SetGame(); //inicializando o jogo
        //enquanto o while se repete o usuário não acertou o número
        while(game.userNumber != game.randomNumber){
            game.UserGuess(); //obtendo o palpite do usuário
            game.Feedback(game.userNumber, game.randomNumber);
        }
        System.out.println("Correct number");
        
    }
}