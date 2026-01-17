package dev.ripanbaidya.singleton;

public class DoubleCheckedSingleton {

    // Making the instance variable volatile so that any changes made this
    // variable by other thread should be visible to other threads immediately
    private static volatile DoubleCheckedSingleton instance;

    private DoubleCheckedSingleton() {
    }

    public static DoubleCheckedSingleton getInstance() {
        // First Check (no synchronize)
        if (instance == null) {
            // Synchronize on the class object
            synchronized (DoubleCheckedSingleton.class) {
                // Second check (synchronize)
                if (instance == null) {
                    instance = new DoubleCheckedSingleton();
                }
            }
        }
        return instance;
    }
}
