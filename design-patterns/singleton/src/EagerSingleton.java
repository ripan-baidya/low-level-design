package singleton_pattern;

/**
 * This implementation of Eager Singleton guarantees that only one instance of a class is created at any given time,
 * and provides a global point of access to that instance. It leverages the guarantees provided by the JVM to ensure
 * the singleton instance is loaded before any thread accesses it. This implementation is thread-safe by nature and
 * does not require explicit synchronization.
 *
 * Note that while it is inherently thread-safe, it could potentially waste resources if the singleton instance is
 * never used by the client application.
 */
public class EagerSingleton {
    /**
     * 'static' variable ensures there's only one instance shared across all instances of the class.
     * 'final' prevents the instance from being reassigned after initialization.
     */
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() { }


    public static EagerSingleton getInstance() {
        return instance;
    }
}
