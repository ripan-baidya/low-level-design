package singleton_pattern;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Even though Singleton pattern designed to ensure only one instance of a class exist, there are
 * several ways to Break Singleton pattern. One of the ways is using Reflection.
 * Reflection can access private constructors and create new instances.
 */
public class BreakingSingletonReflection {
    static void main() throws Exception {
        // Creating instance of EagerSingleton using getInstance() method
        EagerSingleton singleton = EagerSingleton.getInstance();

        // getting constructor of EagerSingleton class
        Constructor<EagerSingleton> constructor = EagerSingleton.class.getDeclaredConstructor();

        // making constructor accessible: private -> public
        constructor.setAccessible(true);

        // creating new instance of EagerSingleton using constructor
        EagerSingleton singleton2 = constructor.newInstance();

        System.out.println(singleton == singleton2); // false -> Singleton pattern broken
    }
}
