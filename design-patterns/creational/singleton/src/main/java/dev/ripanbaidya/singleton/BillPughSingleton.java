package dev.ripanbaidya.singleton;

/*
 * This implementation uses a static inner helper class to hold the singleton instance.
 * The inner class is not loaded into memory until it's referenced for the first time
 * in the getInstance() method.
 * It is thread-safe without requiring explicit synchronization.
 *
 * When the getInstance() method is called for the first time, it triggers the loading
 * of the SingletonHelper class.
 * When the inner class is loaded, it creates the INSTANCE of BillPughSingleton.
 * The final keyword ensures that the INSTANCE cannot be reassigned.
 * The Bill Pugh Singleton implementation, while more complex than Eager Initialization
 * provides a perfect balance of lazy initialization, thread safety, and performance,
 * without the complexities of some other patterns like double-checked locking.
 */
public class BillPughSingleton {

    private BillPughSingleton() {
    }

    private static class Holder {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return Holder.INSTANCE;
    }
}
