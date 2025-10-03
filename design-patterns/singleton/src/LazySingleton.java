package singleton_pattern;

/**
 * Lazy Singleton ensures that only one instance of a class is created at any given time, and provides
 * a global point of access to that instance. It does this by using a private static instance variable
 * and a private constructor. The private constructor prevents any other class from instantiating  the
 * singleton, and the static method getInstance() returns the singleton instance if it has already been
 * created, or creates a new instance if it hasn't.
 *
 * This implementation of Lazy Singleton is not thread-safe. If multiple threads call getInstance() method
 * to get the instance simultaneously when instance is null, it's possible to create multiple instances.
 * Therefore, it's necessary to ensure that this class is only used in a single-threaded environment or to
 * add appropriate synchronization mechanisms to ensure thread safety.
 */
public class LazySingleton {
    // The single instance, initialized to null
    private static LazySingleton instance;

    // private constructor to prevent instantiation
    private LazySingleton() { }


    // public method to get the instance.
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
