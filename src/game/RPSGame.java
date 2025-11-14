package game;

import java.util.Random;
import java.util.Scanner;

public class RPSGame {

    private final String[] choices = {"Rock", "Paper", "Scissors"};
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);

    public boolean play() {
        System.out.println("Prasideda Rock Paper Scissors!");
        System.out.print("Pasirink (rock/paper/scissors): ");
        String playerChoice = scanner.nextLine().toLowerCase();

        String computerChoice = choices[random.nextInt(3)].toLowerCase();
        System.out.println("Kompiuteris pasirinko: " + computerChoice);

        if (playerChoice.equals(computerChoice))
        {
            System.out.println("Lygiosios!");
            return false;
        }

        boolean win =
                (playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                        (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                        (playerChoice.equals("scissors") && computerChoice.equals("paper"));

        if (win)
        {
            System.out.println("Laimejai RPS!!!");
        }
        else
        {
            System.out.println("Pralaimejai RPS! :((((");
        }

        return win;
    }
}
