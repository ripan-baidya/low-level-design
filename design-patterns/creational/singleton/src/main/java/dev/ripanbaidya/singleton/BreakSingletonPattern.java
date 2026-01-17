package dev.ripanbaidya.singleton;


import java.io.*;
import java.lang.reflect.Constructor;

/*
 * We will see how we can break the singleton pattern in Java.
 * There are several ways to do so, we will discuss few of them and will
 * also see how we can fix them.
 *
 * 1. Reflection
 * 2. Serialization and Deserialization
 */
public class BreakSingletonPattern {

    // ***** Breaking Singleton using Reflection *****

    static void breakSingletonUsingReflection() throws Exception {
        // With the help of reflection we are accessing the private constructor
        Constructor<Singleton> constructors = Singleton.class.getDeclaredConstructor();

        // Making the private constructor accessible
        constructors.setAccessible(true);

        // Creating a new instance of Singleton using Singleton class itself
        // and using reflection
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = constructors.newInstance();

        // The hashcode of both the instances will be different
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        System.out.println(instance2.equals(instance1)); // false
    }

    // ***** Breaking Singleton using Serialization *****

    static void breakSingletonUsingSerialization() throws Exception {

        Singleton instance1 = Singleton.getInstance();

        // Serializing the instance
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("file"));
        oos.writeObject(instance1);
        oos.close();

        // Deserializing the instance
        ObjectInputStream ooi = new ObjectInputStream(new FileInputStream("file"));
        Singleton instance2 = (Singleton) ooi.readObject();
        ooi.close();

        // The hashcode of both the instances will be different
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        System.out.println(instance2.equals(instance1)); // false
    }

    public static void main(String[] args) throws Exception {
        breakSingletonUsingReflection(); // Reflection

//        breakSingletonUsingSerialization(); // Serialization
    }
}

/**
 * Helper class we will use to break the singleton pattern.
 * This class implements Serializable interface so that we can serialize
 * and deserialize it.
 */
class Singleton implements Serializable {

    private static final long serialVersionUID = 1L;
    private static boolean initialized = false;
    private static Singleton instance;

    // We are using this variable to prevent the reflection attack
    // If the instance is already created, we will throw an exception
    private Singleton() {
        if (initialized) {
            throw new RuntimeException("Reflection Attack detected!");
        }
        initialized = true;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    /*
     * We are overriding the readResolve method to return the singleton instance
     * every time we deserialize the object.
     * It prevents the creation of a new instance of the object when we deserialize it.
     */
    protected Object readResolve() {
        return getInstance();
    }
}
