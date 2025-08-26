# DRY (Don’t Repeat Yourself) Principle in Java

## Introduction

DRY (Don’t Repeat Yourself) is a principle in programming that means you should avoid writing the same piece of code multiple times. In Java, if you find the same code written in many places, it means you are not following the DRY rule.

Instead of repeating code, you can put it inside a method and call that method whenever you need it. This way, your code becomes shorter, cleaner, and easier to maintain. It also makes the code reusable.

### Why DRY is important:

- Reduces code duplication
- Makes programs easier to read and maintain
- Encourages reusability

## Example:

### Implementation: Without DRY approach

```java
// Main class
public class StudentMarks {

    // Method 1: Print marks for Math
    public void mathMarks() {
        System.out.println("Subject: Math");
        System.out.println("Marks: 90");
    }

    // Method 2: Print marks for Science
    public void scienceMarks() {
        System.out.println("Subject: Science");
        System.out.println("Marks: 85");
    }

    // Method 3: Print marks for English
    public void englishMarks() {
        System.out.println("Subject: English");
        System.out.println("Marks: 88");
    }

    // Main method
    public static void main(String[] args) {
        // Creating object of class
        StudentMarks s = new StudentMarks();

        // Calling methods one by one
        s.mathMarks();
        s.scienceMarks();
        s.englishMarks();
    }
}
```

### Output:
```
Subject: Math
Marks: 90
Subject: Science
Marks: 85
Subject: English
Marks: 88
```

### What’s wrong here?

- We repeated the same printing logic (System.out.println("Subject: ..."); and System.out.println("Marks: ...");) in every method.

- This violates the DRY principle because the same type of code is scattered in multiple places.


### Implementation: With DRY approach

```java
public class StudentMarks {

    // Single method to print subject and marks
    public void printMarks(String subject, int marks) {
        System.out.println("Subject: " + subject);
        System.out.println("Marks: " + marks);
    }

    // Main method
    public static void main(String[] args) {
        // Creating object of class
        StudentMarks s = new StudentMarks();

        // Reusing the same method for all subjects
        s.printMarks("Math", 90);
        s.printMarks("Science", 85);
        s.printMarks("English", 88);
    }
}
```

### Output
```
Subject: Math
Marks: 90
Subject: Science
Marks: 85
Subject: English
Marks: 88
```

### Why this is better (DRY):

- No code duplication – we have only one method for printing.
- Reusable – just pass subject name and marks.
- Easier to maintain – if we change how marks are displayed, we edit only one method.


## Where it’s used:

- Online marketing applications
- Education software
- Financial applications