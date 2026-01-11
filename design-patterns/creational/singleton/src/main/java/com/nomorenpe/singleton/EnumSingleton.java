package com.nomorenpe.singleton;

/**
 * Enum Singleton:
 *
 * <p>This approach defines the singleton as an enum rather than a class.
 * Java guarantees that an enum value is instantiated only once, making this implementation inherently
 * thread-safe.</p>
 *
 * <p><b>Why it’s preferred:</b>
 * Enum Singleton is concise, safe against reflection and serialization issues, and requires no additional
 * synchronization.</p>
 *
 * <p><b>Recommendation:</b>
 * Widely regarded as the best way to implement a singleton in Java and recommended by experts such as
 * Joshua Bloch.</p>
 */
public enum EnumSingleton {

    // Singleton instance
    INSTANCE;

    // Sample method for test
    public void greet() {
        System.out.println("Hello World!!");
    }
}
