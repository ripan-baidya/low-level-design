package singleton_pattern;

/**
 * The ThreadSafeSingleton ensures that only one instance of a class is created at any given time,
 * and provides a global point of access to that instance. It does this by using a private static
 * instance variable and a private constructor. The private constructor prevents any other class
 * from instantiating  the singleton, and the static method getInstance() returns the singleton
 * instance if it has already been created, or creates a new instance if it hasn't.
 *
 * This implementation is thread-safe by using synchronized method.
 * Synchronized method ensures that only one thread can execute it at a time,
 * preventing multiple threads from creating multiple instances of the singleton class.
 * It also ensures that the singleton instance is loaded before any thread accesses it.
 */
class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {}


    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }

        return instance;
    }
}