package Droid;

//import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.paint.Color;

public class Droid {
    protected int health;
    protected int damage;
    protected int speed;
    protected String name;
    protected int size;
    protected int x;
    protected int y;
    protected String type;
    protected boolean win;

    public Droid(String name, int health, int damage, int speed, int size) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.size = size;
        this.x = x;
        this.y = y;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public int getDamage() {
        return damage;
    }

    public void takeDamage(int damage) {
        health -= (int) (damage * (1 + Math.random()));//зміна пошкодження 0-100 відсотків

    }

    public String getType() {
        return this.type;
    }


    public void setHealth(int health) {
        this.health = health;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return this.size;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Droid{" +
                "health=" + health +
                ", damage=" + damage +
                ", speed=" + speed +
                ", name='" + name + '\'' +
                '}';
    }

    public void stepUp() {
        y -= speed;
    }

    public void stepDown() {
        y += speed;
    }

    public void stepLeft() {
        x -= speed;
    }

    public void stepRight() {
        x += speed;
    }
  /*  public void draw(GraphicsContext gc) {
        gc.setFill(Color.rgb(150,12,12));
        gc.fillRect(getX(), getY(), getSize(), getSize());
    }*/
}