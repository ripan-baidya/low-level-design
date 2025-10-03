# Prototype Pattern

The Prototype Design Pattern is a creational design pattern that lets you create new objects by cloning existing ones, 
instead of instantiating them from scratch.

### It’s particularly useful in situations where:

- Creating a new object is expensive, time-consuming, or resource-intensive.
- You want to avoid duplicating complex initialization logic.
- You need many similar objects with only slight differences.

The Prototype Pattern allows you to create new instances by cloning a pre-configured prototype object, ensuring consistency while reducing boilerplate and complexity.

## The Challenge of Cloning Objects
Imagine you have an object in your system, and you want to create an exact copy of it. How would you do it?

Your first instinct might be to:

1. Create a new object of the same class.
2. Manually copy each field from the original object to the new one.
Simple enough, right?

Well, not quite.

### Problem 1: Encapsulation Gets in the Way
This approach assumes that all fields of the object are publicly accessible. But in a well-designed system, many fields are private
and hidden behind encapsulation. That means your cloning logic can’t access them directly.

Unless you break encapsulation (which defeats the purpose of object-oriented design), you can’t reliably copy the object this way.

### Problem 2: Class-Level Dependency
Even if you could access all the fields, you'd still need to know the concrete class of the object to instantiate a copy.

This tightly couples your cloning logic to the object's class, which introduces problems:

- It violates the Open/Closed Principle. 
- It reduces flexibility if the object's implementation changes.
- It becomes harder to scale when you work with polymorphism.

### Problem 3: Interface-Only Contexts
In many cases, your code doesn’t work with concrete classes at all—it works with interfaces.

For example:
```java
public void processClone(Shape shape) {
    Shape cloned = ???; // we only know it implements Shape
}  
```
Here, you know the object implements a certain interface (Shape), but you don’t know what class it is, let alone how to create a new
instance of it. You’re stuck unless the object knows how to clone itself.


## The Better Way: Let the Object Clone Itself
This is where the Prototype Design Pattern comes in.

Instead of having external code copy or recreate the object, the object itself knows how to create its clone. It exposes a clone() or
copy() method that returns a new instance with the same data.

This:

- Preserves encapsulation
- Eliminates the need to know the concrete class
- Makes the system more flexible and extensible
Let’s walk through a real-world example to see how we can apply the Prototype Pattern to build a more efficient and maintainable object
- creation workflow.


# **Prototype Design Pattern: Spawning Enemies in a Game**

## **Problem**

In a 2D shooting game, you frequently spawn enemies with distinct attributes:

| Enemy Type   | Health | Speed  | Armor | Weapon |
| ------------ | ------ | ------ | ----- | ------ |
| BasicEnemy   | Low    | Slow   | No    | Laser  |
| ArmoredEnemy | High   | Medium | Yes   | Cannon |
| FlyingEnemy  | Medium | Fast   | No    | Laser  |

Naively, you might write:

```java
Enemy flying1 = new Enemy("FlyingEnemy", 100, 12.0, false, "Laser");
Enemy flying2 = new Enemy("FlyingEnemy", 100, 12.0, false, "Laser");
```

**Problems with this approach:**

* **Repetitive code**: Same instantiation repeated.
* **Scattered defaults**: If default values change, you must update all instances.
* **Error-prone**: Easy to forget a property.
* **Cluttered codebase**: Game loop gets bloated.

---

## **Solution: Prototype Design Pattern**

The **Prototype pattern** lets you:

1. Create **pre-configured prototype instances**.
2. Spawn new objects by **cloning the prototype**, not by re-instantiating.
3. Modify the clone if needed without affecting the original.

---

## **Step 1: Define the Prototype Interface**

```java
interface EnemyPrototype {
    EnemyPrototype clone();  // Every cloneable enemy must implement this
}
```

---

## **Step 2: Create Concrete Prototype Class**

We define an `Enemy` class that implements `EnemyPrototype` and uses a **copy constructor for cloning**:

```java
class Enemy implements EnemyPrototype {
    private String type;
    private int health;
    private double speed;
    private boolean armored;
    private String weapon;

    public Enemy(String type, int health, double speed, boolean armored, String weapon) {
        this.type = type;
        this.health = health;
        this.speed = speed;
        this.armored = armored;
        this.weapon = weapon;
    }

    // Clone method using copy constructor
    @Override
    public Enemy clone() {
        return new Enemy(type, health, speed, armored, weapon);
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void printStats() {
        System.out.println(type + " [Health: " + health +
                           ", Speed: " + speed +
                           ", Armored: " + armored +
                           ", Weapon: " + weapon + "]");
    }
}
```

> **Note on cloning:**
>
> * Shallow copy is fine for primitives or immutable objects (`String`).
> * If `Enemy` had mutable fields like `List<Item> inventory`, use **deep copy** in the clone.

---

## **Step 3: Create a Prototype Registry**

A registry stores all pre-configured prototypes, so clients can request clones by key.

```java
import java.util.HashMap;
import java.util.Map;

class EnemyRegistry {
    private Map<String, Enemy> prototypes = new HashMap<>();

    // Register a new prototype
    public void register(String key, Enemy prototype) {
        prototypes.put(key, prototype);
    }

    // Get a clone safely
    public Enemy get(String key) {
        Enemy prototype = prototypes.get(key);
        if (prototype != null) {
            return prototype.clone();
        }
        throw new IllegalArgumentException("No prototype registered for: " + key);
    }
}
```

---

## **Step 4: Using the Prototype in the Game**

```java
public class Game {
    public static void main(String[] args) {
        EnemyRegistry registry = new EnemyRegistry();

        // Register prototype enemies
        registry.register("flying", new Enemy("FlyingEnemy", 100, 12.0, false, "Laser"));
        registry.register("armored", new Enemy("ArmoredEnemy", 300, 6.0, true, "Cannon"));

        // Clone from registry
        Enemy e1 = registry.get("flying");
        Enemy e2 = registry.get("flying");
        e2.setHealth(80); // This clone can be modified independently

        Enemy e3 = registry.get("armored");

        // Print stats
        e1.printStats();
        e2.printStats();
        e3.printStats();
    }
}
```

**Output:**

```
FlyingEnemy [Health: 100, Speed: 12.0, Armored: false, Weapon: Laser]
FlyingEnemy [Health: 80, Speed: 12.0, Armored: false, Weapon: Laser]
ArmoredEnemy [Health: 300, Speed: 6.0, Armored: true, Weapon: Cannon]
```

---

## **Benefits of This Approach**

1. **Centralized defaults**: All default values are stored in the registry.
2. **Reusable clones**: Spawn as many enemies as needed without repeating code.
3. **Safe modifications**: Each clone can be customized without affecting the original.
4. **Easily extendable**: Add new enemy types by registering new prototypes.





