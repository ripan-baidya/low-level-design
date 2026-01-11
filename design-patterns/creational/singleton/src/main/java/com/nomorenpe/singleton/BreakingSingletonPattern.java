package com.nomorenpe.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * Breaking the singleton pattern
 *
 * 1. Using Reflection API
 * 2. Using Serialization
 */
public class BreakingSingletonPattern {

    void usingReflection() throws Exception{
        // First instance
        EagerSingleton instance = EagerSingleton.getInstance();

        // Accessing all the constructors of EagerSingleton class
        Constructor<EagerSingleton> constructors = EagerSingleton.class.getDeclaredConstructor();

        // Making the constructor visibility private to public
        constructors.setAccessible(true);

        // Second instance
        EagerSingleton instance2 = constructors.newInstance();

        System.out.println(instance == instance2); // false, Break Singleton pattern
    }

    void usingSerialization() throws Exception{
        EagerSingleton s1 = EagerSingleton.getInstance();

        // Serializing the instance
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.obj"));
        out.writeObject(s1);
        out.close();

        // Deserializing the instance
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("singleton.obj"));
        EagerSingleton s2 = (EagerSingleton) in.readObject();
        in.close();

        // Comparing the instances
        System.out.println(s1 == s2); // false, Singleton broken
    }
}
