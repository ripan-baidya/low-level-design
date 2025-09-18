package singleton_pattern;

/**
 * This implementation uses a static inner helper class to hold the singleton instance.
 * The inner class is lazily loaded when the getInstance() method is called for the first time.
 * It's thread-safe and efficient, as the loading of the SingletonHelper class is triggered just once.
 * The final keyword ensures that the INSTANCE cannot be reassigned.
 * The Bill Pugh Singleton pattern is a simple and efficient way to create a singleton in Java.
 */
class BillPughSingleton {
    private BillPughSingleton() {}

    // Static inner class that holds the instance
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}