# Complete Code Explanation: Assign2.java

## Overview
This program demonstrates **inheritance and method overriding** in Java. It implements a salary management system where different employee types get different salary hikes.

---

## 1. Parent Class: `Employee`

```java
class Employee{
    protected double salary;
    
    Employee(double salary){
        this.salary=salary;
    }
    void displaySalary(){
        System.out.println("Salary : "+salary);
    }
}
```

**Key Points:**
- **`protected double salary`**: Stores salary. `protected` allows child classes to access it directly.
- **Constructor `Employee(double salary)`**: Initializes salary when an Employee object is created.
- **`displaySalary()` method**: Prints the current salary. This is inherited by child classes.

---

## 2. Child Class 1: `FullTimeEmployee`

```java
class FullTimeEmployee extends Employee{
    
    FullTimeEmployee(double salary){
        super(salary);
    }
    void calculateSalary(){
        salary=salary+(salary*0.5);
    }
}
```

**Key Points:**
- **`extends Employee`**: Inherits from Employee class
- **`super(salary)`**: Calls parent class constructor to initialize salary
- **`calculateSalary()` method**: Increases salary by **50%** (salary + 50% of salary)
  - Formula: `new_salary = salary + (salary × 0.5)` = `salary × 1.5`
- **Method Overriding**: This class defines its own `calculateSalary()` (different from InternEmployee)

---

## 3. Child Class 2: `InternEmployee`

```java
class InternEmployee extends Employee{
    
    InternEmployee(double salary){
        super(salary);
    }
    void calculateSalary(){
        salary=salary+(salary*.25);
    }
}
```

**Key Points:**
- **`extends Employee`**: Inherits from Employee class
- **`calculateSalary()` method**: Increases salary by **25%** (salary + 25% of salary)
  - Formula: `new_salary = salary + (salary × 0.25)` = `salary × 1.25`
- Different hike percentage than FullTimeEmployee (25% vs 50%)

---

## 4. Main Method Execution

```java
public class Assign2 {
    public static void main(String[] args){
        // Full Time Employee
        FullTimeEmployee fte=new FullTimeEmployee(40000);
        System.out.println("Full time employee before hike : ");
        fte.displaySalary();  // Output: Salary : 40000.0
        fte.calculateSalary();  // 40000 + (40000 * 0.5) = 60000
        System.out.println("Full time employee salary after hike : ");
        fte.displaySalary();  // Output: Salary : 60000.0
        
        // Intern Employee
        InternEmployee intern=new InternEmployee(20000);
        System.out.println("Intern employee before hike : ");
        intern.displaySalary();  // Output: Salary : 20000.0
        intern.calculateSalary();  // 20000 + (20000 * 0.25) = 25000
        System.out.println("Intern employee salary after hike : ");
        intern.displaySalary();  // Output: Salary : 25000.0
    }
}
```

**Execution Flow:**
1. Creates FullTimeEmployee with ₹40,000 salary
2. Displays initial salary
3. Applies 50% hike → ₹60,000
4. Creates InternEmployee with ₹20,000 salary
5. Displays initial salary
6. Applies 25% hike → ₹25,000

---

## Expected Output
```
Full time employee before hike : 
Salary : 40000.0
Full time employee salary after hike : 
Salary : 60000.0

Intern employee before hike : 
Salary : 20000.0
Intern employee salary after hike : 
Salary : 25000.0
```

---

## Key Concepts for Viva (Important)

| Concept | Explanation |
|---------|-------------|
| **Inheritance** | `FullTimeEmployee` and `InternEmployee` inherit from `Employee` |
| **Method Overriding** | Both child classes override `calculateSalary()` with different logic |
| **Access Modifiers** | `protected` allows child classes to access `salary` directly |
| **Constructor Chaining** | `super()` calls parent constructor to initialize base properties |
| **Polymorphism** | Different salary calculations based on employee type |

---

## Viva Questions You May Face

### Q1: What is the purpose of `super()` keyword?
**A:** It calls the parent class constructor to initialize inherited properties.

### Q2: Why is `salary` declared as `protected` and not `private`?
**A:** Because child classes need direct access to modify it in `calculateSalary()`.

### Q3: What happens if `calculateSalary()` is called twice?
**A:** Salary gets multiplied again. FullTime: 40000 → 60000 → 90000.

### Q4: Can you create an object of `Employee` class?
**A:** Yes, since it's not abstract. But in this design, only child classes are used.

### Q5: What is method overriding here?
**A:** Both `FullTimeEmployee` and `InternEmployee` override `calculateSalary()` with different salary hike logic.

### Q6: What is the difference between inheritance and polymorphism?
**A:** Inheritance is acquiring properties from parent class. Polymorphism is using the same method name with different implementations in child classes.

### Q7: Why not use `private` instead of `protected` for salary?
**A:** With `private`, child classes cannot directly access or modify the salary field. `protected` allows controlled access to child classes.

### Q8: Explain the concept of "IS-A" relationship here.
**A:** FullTimeEmployee IS-A Employee, and InternEmployee IS-A Employee. They inherit all properties and methods from Employee.

### Q9: Can we add more employee types (like ContractEmployee)?
**A:** Yes, we can create another class extending Employee with its own `calculateSalary()` implementation with a different hike percentage.

### Q10: What would happen if both classes had the same `calculateSalary()` implementation?
**A:** It wouldn't demonstrate method overriding properly, but would still work. The purpose of overriding is to provide type-specific behavior.

---

## Quick Summary

- **Employee** = Parent class with basic salary functionality
- **FullTimeEmployee** = Child class with 50% salary hike
- **InternEmployee** = Child class with 25% salary hike
- Uses **inheritance** to share common code
- Uses **method overriding** for type-specific behavior
- Demonstrates **polymorphism** through different salary calculations
