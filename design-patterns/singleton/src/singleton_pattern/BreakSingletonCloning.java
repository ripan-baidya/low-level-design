package singleton_pattern;

/**
 * If the class implements Cloneable, clone() can duplicate the instance.
 */
class Singleton implements Cloneable {
    private static final Singleton instance = new Singleton();
    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // returns new instance
    }
}

public class BreakSingletonCloning {
     static void main() throws Exception {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = (Singleton) s1.clone();

        System.out.println(s1 == s2); // false -> Singleton broken
    }
}
