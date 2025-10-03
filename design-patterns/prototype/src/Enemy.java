/**
 * This is the actual class that we want to clone. It implements the EnemyPrototype interface and defines the
 * cloning behavior using a copy constructor, which is a clear and reliable way to clone objects in Java.
 */
public class Enemy implements EnemyPrototype {
    // Properties of the enemy
    private String type;
    private int health;
    private double speed;
    private boolean armored;
    private String weapon;

    // Constructor
    public Enemy(String type, int health, double speed, boolean armored, String weapon) {
        this.type = type;
        this.health = health;
        this.speed = speed;
        this.armored = armored;
        this.weapon = weapon;
    }

    // Clone method to create a copy of the enemy
    @Override
    public Enemy clone() {
        return new Enemy(type, health, speed, armored, weapon);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void showStats() {
        System.out.println(type + " [Health: " + health +
                ", Speed: " + speed +
                ", Armored: " + armored +
                ", Weapon: " + weapon + "]");
    }
}
