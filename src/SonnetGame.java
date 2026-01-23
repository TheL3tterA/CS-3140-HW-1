import java.util.Arrays;
import java.util.Random;

public class SonnetGame {
    private int userCorrect = 0;
    private int userWrong = 0;
    private final String[] words;
    private Random rand = new Random();

    public SonnetGame(String[] sonnet) {
        this.words = sonnet;
    }

    public void playRound(String userGuess, int correctWord) {
        if (words[correctWord].equals(userGuess)){
            userCorrect++;
            IO.println("Correct");
        }
        else {
            userWrong++;
            IO.println("Wrong");
        }
    }

    public int returnCorrectWordIndex() {
        return rand.nextInt(words.length);
    }

    public void printSonnet(int randomNum) {
        // copy the array to a new sliced array then join every word together
        String[] copyOfSonnet = Arrays.copyOfRange(words, 0, randomNum);
        String sonnetToPrint = String.join(" ", copyOfSonnet);
        IO.println(sonnetToPrint);

        IO.println("_".repeat(words[randomNum].length()));
        IO.println("What is the missing word?");
    }

    public boolean isGameOver() {
        return userCorrect == 3 || userWrong == 3;
    }

    public void printGameOver() {
        if (userCorrect >= 3) {
            IO.println("You won! Thanks for playing!");
        }
        else {
            IO.println("You lost! Thanks for playing!");
        }
    }
}
