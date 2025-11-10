package game;

public class Player {
    private int health;
    private int supply;

    private int x;
    private int y;

    public Player (int health, int supply)
    {
        this.health = health;
        this.supply = supply;
    }

    public void setPosition(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getHealth()
    {
        return health;
    }

    public int getSupply()
    {
        return supply;
    }

    public void loseHealth(int amount)
    {
        this.health-=amount;
    }

    public void increaseSupply(int amount)
    {
        this.supply+=amount;
    }

    public boolean isAtStart() {
        return x == 0 && y == 0;
    }

    private boolean hasTreasure = false;

    public boolean hasTreasure() {
        return hasTreasure;
    }

    public void setHasTreasure(boolean value) {
        hasTreasure = value;
    }


}
