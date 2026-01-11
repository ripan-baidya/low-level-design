package com.nomorenpe.singleton;

/**
 * Lazy Singleton
 *
 * This implementation creates the singleton instance only when it is first requested.
 * It provides a global access point using a static {@code getInstance()} method and
 * prevents external instantiation through a private constructor.
 *
 * <p><b>Drawbacks:</b>
 * This version is <b>not thread-safe</b>. If multiple threads access {@code getInstance()}
 * at the same time when the instance is not yet created, more than one instance may be created.
 * Synchronization is required if used in a multi-threaded environment.</p>
 *
 * <p><b>When to use:</b>
 * Use this approach in <b>single-threaded</b> applications or when thread safety is handled
 * externally and lazy initialization is important to save resources.</p>
 *
 * <p><b>Note:</b>
 * A null check is performed every time {@code getInstance()} is called, but the overhead
 * is usually negligible.</p>
 */
public class LazySingleton {

    // Making the Constructor private to prevent instantiation from outside
    private LazySingleton(){
    }
    
    // Singleton instance
    private static LazySingleton instance;

    // Public method to get the instance
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return  instance;
    }
}
