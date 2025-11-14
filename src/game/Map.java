package game;

import java.util.Random;

public class Map {
    private Sector[][] sectors;
    private int width, height;
    private Random random = new Random();

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        sectors = new Sector[height][width];
        generate();
    }

    private void generate() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                boolean hasTreasure = (x == width - 1 && y == height - 1); // paskutinis sektorius
                boolean hasTrap = false;
                boolean hasRPSGame = false;

                if (!hasTreasure) {
                    hasTrap = random.nextInt(100) < 15; // 15% sansas trapui
                    hasRPSGame = random.nextInt(100) < 20; // 20% sansas RPS
                }

                if (hasTreasure) {
                    System.out.println("DEBUG: lobis yra -> (" + x + "," + y + ")");
                }


                sectors[y][x] = new Sector(x, y, hasTreasure, hasTrap, hasRPSGame);
            }
        }
    }

    public Sector getSector(int x, int y) {
        return sectors[y][x];
    }

    public boolean movePlayer(Player player, String direction) {
        int x = player.getX();
        int y = player.getY();

        switch (direction)
        {
            case "W" -> y--;
            case "S" -> y++;
            case "A" -> x--;
            case "D" -> x++;
            default ->
            {
                System.out.println("!Netinkamas pasirinkimas!");
                return false;
            }
        }

        if (x < 0 || y < 0 || x >= width || y >= height)
        {
            System.out.println("!Negali eiti uz salos ribu!");
            return false;
        }

        player.setPosition(x, y);
        return true;
    }

    public void display(Player player) {
        System.out.println("\n=== ZEMELAPIS ===");
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (x == player.getX() && y == player.getY()) System.out.print("🧍 ");
                else System.out.print("⬜ ");
            }
            System.out.println();
        }
        System.out.println("=================\n");
    }
}
