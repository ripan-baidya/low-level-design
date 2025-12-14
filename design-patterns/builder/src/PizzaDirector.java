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
