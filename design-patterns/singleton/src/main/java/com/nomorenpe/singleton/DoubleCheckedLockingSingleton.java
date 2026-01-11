package com.nomorenpe.singleton;

/**
 * Double-Checked Locking
 *
 * <p>This implementation reduces synchronization overhead by applying locking only during the
 * first time the instance is created.
 *
 * <p><b>How it works:</b>
 * The instance is checked twice—once without synchronization and once inside a synchronized block.
 * The {@code volatile} keyword ensures visibility and prevents instruction reordering issues.</p>
 *
 * <p><b>When to use:</b>
 * Use this approach when lazy initialization and high performance are both required in a
 * multithreaded environment.</p>
 */
public class DoubleCheckedLockingSingleton {

    // Prevent external instantiation
    private DoubleCheckedLockingSingleton() {
    }

    // Singleton instance, initialized to null, marked as volatile
    private static volatile DoubleCheckedLockingSingleton instance;

    public static DoubleCheckedLockingSingleton getInstance() {
        // First check (not synchronized)
        if (instance == null) {
            // Synchronize on the class object
            synchronized (DoubleCheckedLockingSingleton.class) {
                // Second check (synchronized)
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }

        // Return the instance (either newly created or existing)
        return instance;
    }
}
