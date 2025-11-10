package game;

import java.util.Scanner;

public class Game {
    private Map map;
    private Player player;
    private boolean gameOver = false;
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println("Lobiu sala!");
        map = new Map(3, 3);
        player = new Player(5, 0);

        while (!gameOver) {
            map.display(player);
            System.out.println("Gyvybės ❤️: " + player.getHealth() + " | Atsargos 🎒: " + player.getSupply());
            System.out.println("Pozicija 📍: (" + player.getX() + ", " + player.getY() + ")");
            System.out.print("Pasirink kryptį (W/A/S/D): ");
            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("EXIT")) {
                System.out.println("Isejai is Zaidimo. IKI");
                break;
            }

            if (map.movePlayer(player, input)) {
                Sector current = map.getSector(player.getX(), player.getY());
                current.triggerEvent(player);

                if (player.getHealth() <= 0) {
                    System.out.println("Tu mirei! Zaidimas baigtas.");
                    gameOver = true;
                }

                if (current.hasTreasure()) {
                    System.out.println("Radai lobi $$$. Dabar grizk i pradžią, kad laimetum!");
                    player.setHasTreasure(true);
                }

                if (player.isAtStart() && player.hasTreasure()) {
                    System.out.println("🏆 Tu grizai su lobiu gyvas! Laimėjai!");
                    gameOver = true;
                }

            }
        }
        System.out.println("Zaidimas baigtas!");
    }
}
