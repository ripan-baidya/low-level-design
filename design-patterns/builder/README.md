# Builder Pattern

## What is the Builder Pattern?
The Builder Pattern is a **creational design pattern** that separates the construction of a complex object from its representation. It allows you to construct objects step-by-step, produce different types and representations of an object using the same construction code.

## When to Use Builder Pattern?
1. When an object has **many optional parameters**
2. When you want to create **immutable objects**
3. When you need to **construct complex objects**
4. When you want to **avoid telescoping constructors** (constructors with many parameters)

## Key Components
1. **Product** - The complex object to be created
2. **Builder** - Abstract interface for creating parts of the product
3. **ConcreteBuilder** - Constructs and assembles parts
4. **Director** - Constructs object using Builder interface (optional)
5. **Client** - Uses the builder to create objects

## Example: Creating a Pizza Order System

### Step 1: The Product (Pizza)
```java
public class Pizza {
    // Required parameters
    private final String dough;
    private final String sauce;
    
    // Optional parameters
    private final String cheese;
    private final List<String> toppings;
    private final boolean extraCheese;
    private final boolean spicy;
    
    // Private constructor
    private Pizza(PizzaBuilder builder) {
        this.dough = builder.dough;
        this.sauce = builder.sauce;
        this.cheese = builder.cheese;
        this.toppings = builder.toppings;
        this.extraCheese = builder.extraCheese;
        this.spicy = builder.spicy;
    }
    
    // Getters
    public String getDough() { return dough; }
    public String getSauce() { return sauce; }
    public String getCheese() { return cheese; }
    public List<String> getToppings() { return toppings; }
    public boolean hasExtraCheese() { return extraCheese; }
    public boolean isSpicy() { return spicy; }
    
    @Override
    public String toString() {
        return "Pizza [dough=" + dough + ", sauce=" + sauce + ", cheese=" + cheese +
               ", toppings=" + toppings + ", extraCheese=" + extraCheese + 
               ", spicy=" + spicy + "]";
    }
    
    // Builder class
    public static class PizzaBuilder {
        // Required parameters
        private final String dough;
        private final String sauce;
        
        // Optional parameters - initialized to default values
        private String cheese = "Mozzarella";
        private List<String> toppings = new ArrayList<>();
        private boolean extraCheese = false;
        private boolean spicy = false;
        
        public PizzaBuilder(String dough, String sauce) {
            this.dough = dough;
            this.sauce = sauce;
        }
        
        public PizzaBuilder cheese(String cheese) {
            this.cheese = cheese;
            return this;
        }
        
        public PizzaBuilder addTopping(String topping) {
            this.toppings.add(topping);
            return this;
        }
        
        public PizzaBuilder extraCheese(boolean extraCheese) {
            this.extraCheese = extraCheese;
            return this;
        }
        
        public PizzaBuilder spicy(boolean spicy) {
            this.spicy = spicy;
            return this;
        }
        
        public Pizza build() {
            return new Pizza(this);
        }
    }
}
```

### Step 2: Using the Builder (Client Code)
```java
public class BuilderPatternDemo {
    public static void main(String[] args) {
        // Creating different types of pizzas using builder
        
        // 1. Simple Margherita Pizza
        Pizza margherita = new Pizza.PizzaBuilder("Thin Crust", "Tomato")
            .cheese("Mozzarella")
            .addTopping("Basil")
            .build();
        
        System.out.println("Margherita Pizza: " + margherita);
        
        // 2. Custom Pizza with multiple toppings
        Pizza customPizza = new Pizza.PizzaBuilder("Pan", "BBQ")
            .cheese("Cheddar")
            .addTopping("Chicken")
            .addTopping("Onions")
            .addTopping("Bell Peppers")
            .extraCheese(true)
            .spicy(true)
            .build();
        
        System.out.println("\nCustom Pizza: " + customPizza);
        
        // 3. Vegetarian Pizza
        Pizza vegPizza = new Pizza.PizzaBuilder("Whole Wheat", "Pesto")
            .addTopping("Mushrooms")
            .addTopping("Olives")
            .addTopping("Spinach")
            .spicy(false)
            .build();
        
        System.out.println("\nVegetarian Pizza: " + vegPizza);
        
        // 4. Minimal Pizza (only required parameters)
        Pizza minimalPizza = new Pizza.PizzaBuilder("Regular", "Marinara")
            .build();
        
        System.out.println("\nMinimal Pizza: " + minimalPizza);
    }
}
```

## Advanced Example: With Director Pattern

```java
// Director class that defines the construction process
class PizzaDirector {
    public Pizza createMargherita() {
        return new Pizza.PizzaBuilder("Thin Crust", "Tomato")
            .cheese("Mozzarella")
            .addTopping("Basil")
            .build();
    }
    
    public Pizza createPepperoni() {
        return new Pizza.PizzaBuilder("Pan", "Tomato")
            .cheese("Mozzarella")
            .addTopping("Pepperoni")
            .extraCheese(true)
            .spicy(false)
            .build();
    }
    
    public Pizza createHawaiian() {
        return new Pizza.PizzaBuilder("Regular", "Tomato")
            .cheese("Mozzarella")
            .addTopping("Ham")
            .addTopping("Pineapple")
            .build();
    }
}

// Client using Director
public class PizzaRestaurant {
    public static void main(String[] args) {
        PizzaDirector director = new PizzaDirector();
        
        Pizza margherita = director.createMargherita();
        Pizza pepperoni = director.createPepperoni();
        Pizza hawaiian = director.createHawaiian();
        
        System.out.println("Menu Pizzas:");
        System.out.println("1. " + margherita);
        System.out.println("2. " + pepperoni);
        System.out.println("3. " + hawaiian);
    }
}
```

## Advantages of Builder Pattern

1. **Encapsulation**: Construction logic is encapsulated
2. **Flexibility**: Can create different representations
3. **Immutability**: Objects can be made immutable
4. **Readability**: Client code is more readable
5. **Parameter Validation**: Can validate parameters before object creation

## Enhanced Builder with Validation

```java
public class Pizza {
    // ... existing code ...
    
    public static class PizzaBuilder {
        // ... existing code ...
        
        public Pizza build() {
            validate();
            return new Pizza(this);
        }
        
        private void validate() {
            if (dough == null || dough.trim().isEmpty()) {
                throw new IllegalArgumentException("Dough type is required");
            }
            if (sauce == null || sauce.trim().isEmpty()) {
                throw new IllegalArgumentException("Sauce type is required");
            }
            if (toppings.size() > 5) {
                throw new IllegalArgumentException("Maximum 5 toppings allowed");
            }
        }
    }
}

// Usage with validation
try {
    Pizza invalidPizza = new Pizza.PizzaBuilder("", "Tomato").build();
} catch (IllegalArgumentException e) {
    System.out.println("Validation failed: " + e.getMessage());
}
```

## Common Use Cases in Real World

1. **Document Builders**: HTML, XML, PDF documents
2. **Query Builders**: SQL, MongoDB queries
3. **Configuration Objects**: Server configurations, API clients
4. **UI Components**: Complex UI element creation
5. **Email Builders**: Building emails with attachments, CC, BCC, etc.

## Builder Pattern vs. Constructor vs. Setters

| Aspect | Constructor | Setters | Builder Pattern |
|--------|-------------|---------|-----------------|
| Immutability | Good | Poor | Excellent |
| Readability | Poor (many params) | Good | Excellent |
| Validation | At construction | After construction | Before final build |
| Object State | Complete at creation | Can be incomplete | Complete at build |
| Flexibility | Low | High | High |

## Best Practices

1. Make the product class constructor **private**
2. Builder should be a **static inner class**
3. Use **fluent interface** (method chaining)
4. Include **parameter validation** in build() method
5. Consider making the product **immutable**

The Builder Pattern is especially useful in Java for creating complex, immutable objects with many optional parameters, providing both readability and flexibility in object creation.