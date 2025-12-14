import java.util.ArrayList;
import java.util.List;

// Product class: The class for which Complex object to be built
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
    public String getDough() {
        return dough;
    }
    public String getSauce() {
        return sauce;
    }
    public String getCheese() {
        return cheese;
    }
    public List<String> getToppings() {
        return toppings;
    }
    public boolean isExtraCheese() {
        return extraCheese;
    }
    public boolean isSpicy() {
        return spicy;
    }

    // Override the toString method
    @Override
    public String toString() {
        return "Pizza{" +
                "dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", cheese='" + cheese + '\'' +
                ", toppings=" + toppings +
                ", extraCheese=" + extraCheese +
                ", spicy=" + spicy +
                '}';
    }

    // Builder class
    public static class PizzaBuilder {
        // Required parameter
        private final String dough;
        private final String sauce;

        // Optional parameters
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
            this.cheese = cheese;
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
