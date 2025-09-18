## What is Singleton Pattern?
Singleton Pattern is a creational design pattern that guarantees a class has only one instance and provides a global point of access to it.

It involves only one class which is responsible for instantiating itself, making sure it creates not more than one instance.

To implement the singleton pattern, we must prevent external objects from creating instances of the singleton class. Only the singleton class should be permitted to create its own objects.

Additionally, we need to provide a method for external objects to access the singleton object.

### 1. Lazy Initialization

This approach creates the singleton instance only when it is needed, saving resources if the singleton is never used in the application.

```java
class LazySingleton {
// The single instance, initially null
private static LazySingleton instance;

    // Private constructor to prevent instantiation
    private LazySingleton() {}

    // Public method to get the instance
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
```
- Checks if an instance already exists (instance == null).
- If not, it creates a new instance.
- If an instance already exists, it skips the creation step.


```markdown
warning:

This implementation is not thread-safe. If multiple threads call getInstance() simultaneously when instance is null,
it's possible to create multiple instances.
```
