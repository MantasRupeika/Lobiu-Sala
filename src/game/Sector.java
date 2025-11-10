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

        if (hasRPS) {
            RPSGame rps = new RPSGame();
            boolean win = rps.play();
            if (!win) {
                player.loseHealth(1);
                System.out.println("⚔Pralaimėjai RPS kovą: netenki 1 gyvybės!");
            }
            return;
        }


        if(hasTreasure)
        {
            System.out.println("Radai lobi, grizk atgal saugiai ir laimesi zaidima!");
            player.setHasTreasure(true);
        }
        else if (hasTrap)
        {
            System.out.println("Pateikai i spasutus prarandi viena gyvybe");
            player.loseHealth(1);
        }
        else if (random.nextInt(100)<30)
        {
            System.out.println("Radote maisto! +1 supply");
            player.increaseSupply(1);
        }
        else if (hasRPS)
        {
            System.out.println("Jus prigavo sargybinis, zaiskite RPS, kad istrukti");
        }
        else
        {
            System.out.println("Tuscias sektorius");
        }

    }
}
