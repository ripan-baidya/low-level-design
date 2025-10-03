public class Main {
    static void main() {
        EnemyRegistry registry = new EnemyRegistry();

        // Register some prototypes
        registry.addPrototype("flying", new Enemy(
                "FlyingEnemy", 100, 10, false, "Cannon"));
        registry.addPrototype("basic", new Enemy(
                "BasicEnemy", 50, 5, false, "Machine Gun"));


        // Clone from registry
        Enemy basicEnemy = registry.getPrototype("basic");
        Enemy flyingEnemy = registry.getPrototype("flying");
        flyingEnemy.setHealth(200);

        basicEnemy.showStats();
        flyingEnemy.showStats();
    }
}
