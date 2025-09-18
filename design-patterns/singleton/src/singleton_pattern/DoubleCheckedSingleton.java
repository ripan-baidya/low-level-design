package singleton_pattern;

/**
 * This approach minimizes performance overhead from synchronization by only synchronizing when
 * the object is first created.
 * It uses the volatile keyword to ensure that changes to the instance variable are immediately
 * visible to other threads.
 */
class DoubleCheckedSingleton {
    // The single instance, initially null, marked as volatile so that any changes to the instance
    // are immediately visible to other threads.
    private static volatile DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton() {}


    public static DoubleCheckedSingleton getInstance() {
        // First check (not synchronized)
        if (instance == null) {
            // Synchronize on the class object
            synchronized (DoubleCheckedSingleton.class) {
                // Second check (synchronized)
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        // Return the instance (either newly created or existing)
        return instance;
    }
}