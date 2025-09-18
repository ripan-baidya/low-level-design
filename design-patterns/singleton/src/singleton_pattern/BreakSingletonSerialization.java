package singleton_pattern;

import java.io.*;

/**
 * Serializing and then deserializing creates a new object.
 */
public class BreakSingletonSerialization {
    static void main() throws Exception {
        LazySingleton s1 = LazySingleton.getInstance();

        // Serializing the instance
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.obj"));
        out.writeObject(s1);
        out.close();

        // Deserializing the instance
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("singleton.obj"));
        LazySingleton s2 = (LazySingleton) in.readObject();
        in.close();

        // Comparing the instances
        System.out.println(s1 == s2); // false -> Singleton broken
    }
}