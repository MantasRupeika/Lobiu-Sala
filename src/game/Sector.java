package game;

import java.util.Random;

public class Sector {
    private int x;
    private int y;
    boolean hasTreasure;
    boolean hasTrap;
    boolean hasRPS;
    private Random random = new Random();

    public Sector(int x, int y, boolean hasTreasure, boolean hasTrap, boolean hasRPS)
    {
        this.x = x;
        this.y = y;
        this.hasTreasure = hasTreasure;
        this.hasTrap = hasTrap;
        this.hasRPS = hasRPS;
    }

    public boolean hasTreasure() {
        return hasTreasure;
    }


    public void triggerEvent(Player player)
    {
        if (hasTreasure) {
            System.out.println("💰 Radai lobi! Dabar grizk į pradzia.");
            player.setHasTreasure(true);
            return;
        }
        if (hasRPS) {
            RPSGame rps = new RPSGame();
            boolean win = rps.play();
            if (!win) {
                player.loseHealth(1);
                System.out.println("Pralaimejai RPS kova: netenki 1 gyvybes!");
            }
            return;
        }
        if (hasTrap) {
            System.out.println("💀 Patekai i spastus! Netenki 1 gyvybes.");
            player.loseHealth(1);
            return;
        }
        if (random.nextInt(100) < 30) {
            System.out.println("🍗 Radote maisto! +1 supply");
            player.increaseSupply(1);
            return;
        }
        System.out.println("🌴 Tuscias sektorius");
    }

}
