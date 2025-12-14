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
