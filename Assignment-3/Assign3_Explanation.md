# Complete Code Explanation: Assignment 3

## Overview
This assignment demonstrates two important concepts in Java:
1. **Method Overloading and Constructor Overloading** using a Shapes class
2. **Inheritance, Method Overriding, and Dynamic Method Dispatch** using Hillstations hierarchy

---

## Part 1: Shapes.java - Method Overloading and Constructor Overloading

### 1. Shapes Class

```java
class Shapes {
    double area;

    // Constructor Overloading: No-arg constructor
    Shapes() {
        System.out.println("--- Calculating Areas ---");
    }

    // Method Overloading: Area of a Square (one parameter)
    void calculateArea(double side) {
        area = side * side;
        System.out.println("Area of Square: " + area);
    }

    // Method Overloading: Area of a Rectangle (two parameters)
    void calculateArea(double length, double width) {
        area = length * width;
        System.out.println("Area of Rectangle: " + area);
    }

    // Method Overloading: Area of a Circle (different parameter type)
    void calculateArea(float radius) {
        area = 3.14 * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
}
```

**Key Points:**
- **`double area`**: Instance variable to store calculated area
- **Constructor Overloading**: Multiple constructors with different parameters
  - No-arg constructor prints header message
- **Method Overloading**: Multiple `calculateArea()` methods with different signatures:
  - `calculateArea(double side)` - Square (side²)
  - `calculateArea(double length, double width)` - Rectangle (length × width)
  - `calculateArea(float radius)` - Circle (πr²)

---

### 2. Main Method Execution

```java
public static void main(String[] args) {
    Shapes myShape = new Shapes(); // Calls no-arg constructor
    
    // Calling overloaded methods
    myShape.calculateArea(5.0);        // Square
    myShape.calculateArea(10.0, 4.0);  // Rectangle
    myShape.calculateArea(7.0f);       // Circle
}
```

**Execution Flow:**
1. Creates Shapes object → calls no-arg constructor → prints "--- Calculating Areas ---"
2. `calculateArea(5.0)` → Square area = 5×5 = 25.0
3. `calculateArea(10.0, 4.0)` → Rectangle area = 10×4 = 40.0
4. `calculateArea(7.0f)` → Circle area = 3.14×7×7 = 153.86

---

## Part 2: Hillstations.java - Inheritance and Method Overriding

### 1. Parent Class: `Hillstations`

```java
class Hillstations {
    void location() {
        System.out.println("Location: Various Hill Stations in India");
    }

    void famousfood() {
        System.out.println("Famous Food: Local Delicacies");
    }

    void famousfor() {
        System.out.println("Famous for: Scenic Beauty");
    }
}
```

**Key Points:**
- **Parent class** with three methods providing default implementations
- Methods can be overridden by child classes for specific behavior

---

### 2. Child Class 1: `Manali`

```java
class Manali extends Hillstations {
    @Override
    void famousfood() {
        System.out.println("Manali Food: Siddu and Thukpa");
    }

    @Override
    void famousfor() {
        System.out.println("Manali is famous for: Adventure Sports and Rohtang Pass");
    }
}
```

**Key Points:**
- **`extends Hillstations`**: Inherits from parent class
- **Method Overriding**: Overrides `famousfood()` and `famousfor()` with Manali-specific information
- **`@Override` annotation**: Indicates method overriding (optional but good practice)

---

### 3. Child Class 2: `Mussoorie`

```java
class Mussoorie extends Hillstations {
    @Override
    void famousfood() {
        System.out.println("Mussoorie Food: Garhwali Cuisine and Momos");
    }

    @Override
    void famousfor() {
        System.out.println("Mussoorie is famous for: Kempty Falls and Mall Road");
    }
}
```

**Key Points:**
- Similar to Manali, overrides methods with Mussoorie-specific details
- Demonstrates polymorphism through different implementations

---

### 4. Child Class 3: `Gulmarg`

```java
class Gulmarg extends Hillstations {
    @Override
    void famousfood() {
        System.out.println("Gulmarg Food: Rogan Josh and Wazwan");
    }

    @Override
    void famousfor() {
        System.out.println("Gulmarg is famous for: Skiing and Gondola Rides");
    }
}
```

**Key Points:**
- Overrides methods with Gulmarg-specific information
- Kashmiri cuisine and winter sports theme

---

### 5. Main Class: `MainHillstations` - Dynamic Method Dispatch

```java
class MainHillstations {
    public static void main(String[] args) {
        // Calling methods using Parent Class reference (Dynamic Method Dispatch)
        Hillstations h;

        System.out.println("--- Manali ---");
        h = new Manali(); // Reference to Manali object
        h.famousfood();   // Invokes Manali's version
        h.famousfor();

        System.out.println("\n--- Mussoorie ---");
        h = new Mussoorie();
        h.famousfood();
        h.famousfor();

        System.out.println("\n--- Gulmarg ---");
        h = new Gulmarg();
        h.famousfood();
        h.famousfor();
    }
}
```

**Key Points:**
- **Dynamic Method Dispatch**: Parent class reference `h` points to different child objects
- **Runtime Polymorphism**: Method call `h.famousfood()` resolves to appropriate child method at runtime
- Same reference `h` calls different implementations based on object type

---

## Expected Output

### Shapes.java Output:
```
--- Calculating Areas ---
Area of Square: 25.0
Area of Rectangle: 40.0
Area of Circle: 153.86
```

### Hillstations.java Output:
```
--- Manali ---
Manali Food: Siddu and Thukpa
Manali is famous for: Adventure Sports and Rohtang Pass

--- Mussoorie ---
Mussoorie Food: Garhwali Cuisine and Momos
Mussoorie is famous for: Kempty Falls and Mall Road

--- Gulmarg ---
Gulmarg Food: Rogan Josh and Wazwan
Gulmarg is famous for: Skiing and Gondola Rides
```

---

## Key Concepts for Viva (Important)

| Concept | Explanation |
|---------|-------------|
| **Method Overloading** | Same method name, different parameters (Shapes class) |
| **Constructor Overloading** | Multiple constructors with different parameters |
| **Method Overriding** | Child classes provide specific implementations of inherited methods |
| **Dynamic Method Dispatch** | Parent reference calls child methods at runtime |
| **Polymorphism** | Same method name behaves differently based on object type |
| **Inheritance** | Child classes acquire properties and methods from parent class |
| **@Override Annotation** | Indicates intentional method overriding |

---

## Viva Questions You May Face

### Q1: What is method overloading?
**A:** Same method name with different parameter lists in the same class.

### Q2: What is method overriding?
**A:** Child class provides specific implementation of a method inherited from parent class.

### Q3: What is dynamic method dispatch?
**A:** Runtime resolution of which method to call when using parent class reference to child objects.

### Q4: What is the difference between overloading and overriding?
**A:** Overloading: Same method name, different parameters, same class. Overriding: Same method signature, different classes in inheritance hierarchy.

### Q5: Why use @Override annotation?
**A:** It ensures the method is actually overriding a parent method and helps catch errors.

### Q6: Can constructors be overloaded?
**A:** Yes, as shown in Shapes class with no-arg and parameterized constructors.

### Q7: What is polymorphism?
**A:** Ability of objects to take multiple forms. Here, Hillstations reference behaves as Manali, Mussoorie, or Gulmarg.

### Q8: Can we overload main method?
**A:** Yes, but JVM calls the standard `public static void main(String[] args)`.

### Q9: What happens if we don't use @Override?
**A:** Code still works, but compiler won't check if method is actually overriding.

### Q10: Explain the IS-A relationship in hillstations.
**A:** Manali IS-A Hillstation, Mussoorie IS-A Hillstation, Gulmarg IS-A Hillstation.

---

## Quick Summary

- **Shapes.java**: Demonstrates method overloading (same name, different parameters) and constructor overloading
- **Hillstations.java**: Demonstrates inheritance, method overriding, and dynamic method dispatch
- **Method Overloading**: Compile-time polymorphism within a class
- **Method Overriding**: Runtime polymorphism across inheritance hierarchy
- **Dynamic Dispatch**: Parent reference resolves to appropriate child method at runtime