# Classes and Objects

classes and objects are basic concepts of Object Oriented Programming (OOPs) that are used to represent real-world concepts and entities.

## What is a Class?

A class is a blueprint or template with the help of which we create real-world entities known as objects that share common characteristics and properties.

### Defining a Class in Java

To define a class in Java, you use the `class` keyword followed by the name of the class. 

Here's a simple example:

```java
public class Student {
    // Attributes
    private String name;
    private int age;
    private String email;
    private String address;

    // Constructor
    public Student(String name, int age, String email, String address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
    }

    // Method to display student details
    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Student Email: " + email);
        System.out.println("Student Address: " + address);
    }
}
```
- **Attributes**: The class `Student` has four attributes that describe its state: `name`, `age`, `email`, and `address`.
- **Constructor**: The constructor `Student(String name, int age, String email, String address)` initializes new objects of the class.
- **Methods**: The `displayInfo` method is responsible for showcasing the student details.

## What is an Object?

An object is an instance of a class. When you create an object, you are bringing the blueprint of the class into reality. It consists of state and behavior defined by the class, with each object holding its own copy of the data.

### Creating Objects in Java

To create an object, you use the `new` keyword followed by the class constructor. 

Here's how you can instantiate objects from the `Student` class:

```java
public class Main {
    public static void main(String[] args) {
        // Creating an object of the Student class
        Student student1 = new Student("Ripan", 20, "ripan@gmail.com", "Bangalore");
        Student student2 = new Student("Aryan", 21, "aryan@gmail.com", "Hyderabad");

        // Displaying information of each student
        student1.displayInfo();
        System.out.println("-----------------");
        student2.displayInfo();
    }
}
```
**Output**
```
Student Name: Ripan
Student Age: 20
Student Email: ripan@gmail.com
Student Address: Bangalore
-----------------
Student Name: Aryan
Student Age: 21
Student Email: aryan@gmail.com
Student Address: Hyderabad
```
1. **Instantiation**: The `new` keyword is used to create an object, which allocates memory for it.
2. **Initialization**: The constructor (`Student`) initializes the object state with given parameters.
3. **Reference**: The object is referenced through a variable (`student1`, `student2`) that points to its memory location.
