package com.nomorenpe.singleton;

/**
 * Thread-Safe Singleton
 *
 * <p>This implementation ensures that only one instance is created even in a multi-threaded environment
 * by synchronizing the {@code getInstance()} method.
 *
 * <p><b>How it works:</b>
 * Only one thread can execute the synchronized method at a time, preventing multiple instances from
 * being created.</p>
 *
 * <p><b>Drawbacks:</b>
 * Synchronization introduces performance overhead, as every call to {@code getInstance()} requires
 * acquiring a lock, even after the instance has already been created.</p>
 *
 * <p><b>When to use:</b>
 * Use this approach when thread safety is required and the performance impact is acceptable, or when
 * simplicity is preferred over optimization.</p>
 */
public class ThreadSafeSingleton {

    // Prevent external instantiation
    private ThreadSafeSingleton() {
    }

    // Singleton instance
    private static ThreadSafeSingleton instance;

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}
