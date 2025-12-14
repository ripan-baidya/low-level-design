public class Main {
    public static void main(String[] args) {
        // Creating different types of builder using builder pattern

        // 1. Creating Margherita Pizza
        Pizza margherita = new Pizza.PizzaBuilder("Thin Crust", "Tomato")
                .cheese("Mozzarella")
                .addTopping("Basil")
                .build();

        // 2. Custom pizza with multiple toppings
        Pizza customPizza = new Pizza.PizzaBuilder("Pan", "BBQ")
                .cheese("Cheddar")
                .addTopping("Chicken")
                .addTopping("Onions")
                .addTopping("Bell Peppers")
                .extraCheese(true)
                .spicy(true)
                .build();

        // 3. Vegetarian Pizza
        Pizza vegPizza = new Pizza.PizzaBuilder("Whole Wheat", "Pesto")
                .addTopping("Mushrooms")
                .addTopping("Olives")
                .addTopping("Spinach")
                .spicy(false)
                .build();

        // 4. Minimal Pizza (only required parameters)
        Pizza minimalPizza = new Pizza.PizzaBuilder("Regular", "Marinara")
                .build();

        System.out.println("Margherita Pizza: " + margherita);
        System.out.println("Custom Pizza: " + customPizza);
        System.out.println("Vegetarian Pizza: " + vegPizza);
        System.out.println("Minimal Pizza: " + minimalPizza);


    }
}
