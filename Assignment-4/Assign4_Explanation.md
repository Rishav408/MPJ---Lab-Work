# Complete Code Explanation: Assign4.java

## Overview
This program demonstrates **exception handling and file I/O** in Java. It implements a simple banking system where users can create accounts, perform transactions (deposit/withdraw), and save records to a file. The system uses custom exceptions to handle various error conditions like invalid IDs, insufficient funds, and negative amounts.

---

## 1. Custom Exception Classes

### InvalidIDException

```java
class InvalidIDException extends Exception {
    public InvalidIDException(String message) { super(message); }
}
```

**Key Points:**
- **Extends Exception**: Creates a custom checked exception
- **Constructor**: Takes a message string and passes it to parent Exception class
- **Purpose**: Thrown when customer ID is outside the valid range (1-20)

---

### MinimumBalanceException

```java
class MinimumBalanceException extends Exception {
    public MinimumBalanceException(String message) { super(message); }
}
```

**Key Points:**
- **Extends Exception**: Custom checked exception for minimum balance violations
- **Purpose**: Thrown when initial deposit is less than Rs. 1000

---

### InsufficientFundsException

```java
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) { super(message); }
}
```

**Key Points:**
- **Extends Exception**: Custom exception for overdrawing accounts
- **Purpose**: Thrown when withdrawal amount exceeds current balance

---

### InvalidAmountException

```java
class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) { super(message); }
}
```

**Key Points:**
- **Extends Exception**: Custom exception for negative or zero amounts
- **Purpose**: Thrown when deposit or withdrawal amounts are not positive

---

## 2. BankingSystem Main Class

### Main Method Structure

```java
public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cid = 0;
        String cname = "";
        double amount = 0;

        try {
            // 1. Get Customer ID with range check 
            System.out.print("Enter Customer ID (1-20): ");
            cid = sc.nextInt();
            if (cid < 1 || cid > 20) {
                throw new InvalidIDException("Error: CID must be between 1 and 20.");
            }

            // 2. Get Name
            System.out.print("Enter Customer Name: ");
            sc.nextLine(); // consume newline
            cname = sc.nextLine();

            // 3. Get Initial Deposit with min balance check 
            System.out.print("Enter Initial Deposit (Min Rs. 1000): ");
            amount = sc.nextDouble();
            if (amount < 1000) {
                throw new MinimumBalanceException("Error: Account must start with at least Rs. 1000.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }
}
```

**Key Points:**
- **Scanner Input**: Reads user input for ID, name, and amounts
- **Validation Checks**: Uses if statements to throw custom exceptions
- **Try-Catch Block**: Catches all exceptions and displays error messages
- **Finally Block**: Ensures Scanner is closed regardless of exceptions

---

## 3. Transaction Menu System

```java
// Menu for Transactions 
boolean exit = false;
while (!exit) {
    System.out.println("\n1. Deposit  2. Withdraw  3. Save & Exit");
    System.out.print("Choice: ");
    int choice = sc.nextInt();

    switch (choice) {
        case 1: // Deposit 
            System.out.print("Enter deposit amount: ");
            double dep = sc.nextDouble();
            if (dep <= 0) throw new InvalidAmountException("Amount must be positive.");
            amount += dep;
            System.out.println("Balance updated: " + amount);
            break;

        case 2: // Withdraw 
            System.out.print("Enter withdrawal amount: ");
            double draw = sc.nextDouble();
            if (draw <= 0) throw new InvalidAmountException("Amount must be positive.");
            if (draw > amount) throw new InsufficientFundsException("Insufficient funds!");
            amount -= draw;
            System.out.println("Withdrawal successful. Remaining: " + amount);
            break;

        case 3: // Save to File 
            saveToFile(cid, cname, amount);
            exit = true;
            break;
    }
}
```

**Key Points:**
- **Menu-Driven Interface**: While loop with switch statement for user choices
- **Deposit Logic**: Adds positive amounts to balance
- **Withdraw Logic**: Checks for positive amount and sufficient funds before deduction
- **Exit Option**: Calls saveToFile() and terminates the loop

---

## 4. File I/O Implementation

```java
// Using Character Streams (FileWriter) for storage 
public static void saveToFile(int id, String name, double bal) {
    try (FileWriter fw = new FileWriter("BankRecords.txt", true);
         BufferedWriter bw = new BufferedWriter(fw)) {
        
        String record = "ID: " + id + " | Name: " + name + " | Balance: " + bal;
        bw.write(record);
        bw.newLine();
        System.out.println("Record saved to BankRecords.txt");
        
    } catch (IOException e) {
        System.out.println("File Error: " + e.getMessage());
    }
}
```

**Key Points:**
- **Try-With-Resources**: Automatically closes FileWriter and BufferedWriter
- **Append Mode**: `true` parameter appends to existing file instead of overwriting
- **Character Streams**: FileWriter and BufferedWriter for text file operations
- **Record Format**: Structured string with ID, Name, and Balance
- **Error Handling**: Catches IOException for file operation failures

---

## Expected Output

### Successful Account Creation and Transactions:
```
Enter Customer ID (1-20): 5
Enter Customer Name: John Doe
Enter Initial Deposit (Min Rs. 1000): 5000
--- Account Created Successfully ---

1. Deposit  2. Withdraw  3. Save & Exit
Choice: 1
Enter deposit amount: 2000
Balance updated: 7000.0

1. Deposit  2. Withdraw  3. Save & Exit
Choice: 2
Enter withdrawal amount: 1000
Withdrawal successful. Remaining: 6000.0

1. Deposit  2. Withdraw  3. Save & Exit
Choice: 3
Record saved to BankRecords.txt
```

### Error Scenarios:

**Invalid ID:**
```
Enter Customer ID (1-20): 25
Error: CID must be between 1 and 20.
```

**Insufficient Initial Deposit:**
```
Enter Customer ID (1-20): 5
Enter Customer Name: John Doe
Enter Initial Deposit (Min Rs. 1000): 500
Error: Account must start with at least Rs. 1000.
```

**Negative Deposit:**
```
Enter deposit amount: -100
Amount must be positive.
```

**Overdraft Attempt:**
```
Enter withdrawal amount: 10000
Insufficient funds!
```

### File Content (BankRecords.txt):
```
ID: 5 | Name: John Doe | Balance: 6000.0
```

---

## Key Concepts for Viva (Important)

| Concept | Explanation |
|---------|-------------|
| **Custom Exceptions** | User-defined exception classes extending Exception |
| **Checked Exceptions** | Must be caught or declared in method signature |
| **Try-Catch-Finally** | Exception handling blocks with resource cleanup |
| **File I/O** | Character streams (FileWriter, BufferedWriter) for text files |
| **Try-With-Resources** | Automatic resource management for I/O operations |
| **Validation** | Input checking with conditional exception throwing |
| **Menu-Driven Program** | Switch-case structure for user interaction |

---

## Viva Questions You May Face

### Q1: What is a custom exception in Java?
**A:** A user-defined exception class that extends Exception or RuntimeException to handle specific error conditions in the application.

### Q2: What is the difference between checked and unchecked exceptions?
**A:** Checked exceptions must be caught or declared (like IOException), while unchecked exceptions (RuntimeException) don't require explicit handling.

### Q3: Why use try-with-resources?
**A:** It automatically closes resources like files, preventing resource leaks even if exceptions occur.

### Q4: What happens if you don't handle checked exceptions?
**A:** Compilation fails - the code won't compile until exceptions are caught or declared.

### Q5: Explain the purpose of finally block.
**A:** Code in finally always executes, used for cleanup operations like closing resources, regardless of whether an exception occurred.

### Q6: What is the difference between FileWriter and BufferedWriter?
**A:** FileWriter writes directly to file, BufferedWriter buffers data for efficient writing in larger chunks.

### Q7: Why append mode (true) in FileWriter?
**A:** Prevents overwriting existing file content, allows multiple records to be saved in the same file.

### Q8: Can custom exceptions be runtime exceptions?
**A:** Yes, by extending RuntimeException instead of Exception, making them unchecked.

### Q9: What is exception chaining?
**A:** When one exception causes another, using constructors that take both message and cause (Throwable).

### Q10: How does the program handle multiple transactions?
**A:** Using a while loop with switch statement, allowing repeated operations until user chooses to save and exit.

---

## Quick Summary

- **Custom Exceptions**: Four user-defined exceptions for different error conditions
- **Exception Handling**: Try-catch-finally blocks for robust error management
- **File I/O**: Character streams to persist account data to text file
- **Input Validation**: Range and amount checks with appropriate exceptions
- **Menu System**: Interactive transaction processing with deposit/withdraw/save options
- Demonstrates **exception handling best practices** and **file operations** in Java