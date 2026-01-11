package com.nomorenpe.singleton;

/**
 * Eager Singleton
 *
 * This implementation creates the singleton instance at class loading time.
 * The JVM guarantees thread safety during class initialization, so no explicit
 * synchronization is required.
 *
 * <p><b>Drawbacks:</b>
 * The instance is created even if it is never used, which may lead to unnecessary
 * memory usage or resource consumption.</p>
 *
 * <p><b>When to use:</b>
 * Use this approach when the singleton is lightweight, always required, and
 * early initialization is acceptable or preferred.</p>
 *
 * <p><b>Note:</b>
 * This is the simplest and most reliable singleton implementation in terms of
 * thread safety.</p>
 */
public class EagerSingleton {

    // Prevent external instantiation
    private EagerSingleton() {
    }

    // Singleton instance, created immediately
    private static final EagerSingleton instance = new EagerSingleton();

    public static EagerSingleton getInstance() {
        return instance;
    }
}

