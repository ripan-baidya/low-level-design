package com.nomorenpe.singleton;

/**
 * Bill Pugh Singleton
 *
 * <p>This implementation uses a static inner helper class to create the singleton instance.
 * The inner class is not loaded until {@code getInstance()} is called, which enables lazy initialization.</p>
 *
 * <p><b>Thread safety:</b>
 * Class loading in Java is thread-safe. When the helper class is loaded, the singleton instance
 * is created safely without explicit synchronization.</p>
 *
 * <p><b>How it works:</b>
 * Calling {@code getInstance()} triggers the loading of the helper class, which initializes the
 * {@code INSTANCE}. The {@code final} keyword ensures the instance cannot be reassigned.</p>
 *
 * <p><b>Why use it:</b>
 * This approach provides an excellent balance of lazy initialization, thread safety, and performance,
 * without the overhead or complexity of synchronized methods or double-checked locking.</p>
 */
public class BillPughSingleton {

    // Prevent external instantiation
    private BillPughSingleton(){
    }

    // Static inner class that holds the instance
    private static class SingletonHelper {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static  BillPughSingleton getInstance() {
        return SingletonHelper.INSTANCE;
    }
}
