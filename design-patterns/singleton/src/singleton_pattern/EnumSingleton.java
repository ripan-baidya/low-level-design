package singleton_pattern;

/**
 * Java ensures that only one instance of an enum value is created, even in a multithreaded environment.
 * The Enum Singleton pattern is the most robust and concise way to implement a singleton in Java.
 * It may not always be suitable especially if you need to extend a class or if lazy initialization is a
 * strict requirement.
 */
public enum EnumSingleton {
    INSTANCE;

    // public method
    public void doSomething() {
        System.out.println("Doing something");
    }
}
