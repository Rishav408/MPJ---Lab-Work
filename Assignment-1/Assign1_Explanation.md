# Assignment 1 — Explanation & Viva Preparation

**Overview**
- **Goal:** Read student details (name, roll no, marks for 5 subjects), compute each student's percentage and grade, then print individual results and the class average.
- **Source file:** [Assignment-1/Assignment1.java](Assignment-1/Assignment1.java#L1-L200)

**Code Structure**
- **Class `Student`:** Encapsulates student data and operations.
  - Fields: `name` (String), `rollNo` (int), `marks` (int[]), `percentage` (double).
  - Constructor: `Student(String name, int rollNo, int marks[])` — initializes fields.
  - Methods:
    - `calculatePercentage()` — sums `marks[]` and computes average as a `double`.
    - `getPercentage()` — returns `percentage`.
    - `displayResult()` — prints student details, marks, percentage and grade (A/B/C).

- **Class `Assignment1` (main):** Handles input and orchestrates processing.
  - Reads number of students `n` using `Scanner`.
  - For each student: reads name, roll no, and 5 marks into `int[] marks = new int[5]`.
  - Creates `Student` object, calls `calculatePercentage()`, and accumulates class total.
  - After input loop: prints all student results and computes class average (`totalClassPercentage / n`).

**Key Code Points (line references)**
- `calculatePercentage()` casts to `double` to avoid integer division: `percentage = total / (double) marks.length;`.
- `sc.nextLine()` is used after `nextInt()` to clear the leftover newline before reading the next `String` (name).
- Grade logic in `displayResult()`:
  - `>= 75` → A
  - `>= 60` → B
  - `< 60` → C

**Potential Issues & Improvements**
- No input validation: negative marks or marks > 100 are not checked.
- Fixed subject count: `marks` array size is hard-coded to 5. Use a constant or read subject count dynamically for flexibility.
- Division by zero risk: if user enters `n = 0`, class average calculation `totalClassPercentage / n` will throw `ArithmeticException` (divide by zero). Validate `n > 0` before dividing.
- Formatting: percentages printed raw — use `System.out.printf("%.2f", percentage)` for 2 decimal places.
- Memory/time: storing all students uses O(n * m) space (n students, m subjects); time is O(n * m).

**Time & Space Complexity**
- Time: O(n * m) where `n` = number of students, `m` = marks per student (here m = 5).
- Space: O(n * m) to store all marks plus O(n) for `Student` objects.

**Common Viva Questions (with concise answers)**
- Q: Why cast to `double` when computing percentage?
  - A: To avoid integer division which would truncate the result. Casting ensures fractional percentages are preserved.

- Q: Why use `sc.nextLine()` after `nextInt()`?
  - A: `nextInt()` leaves a newline in the buffer; `nextLine()` consumes it so the subsequent `nextLine()` reads the intended string.

- Q: Why are fields in `Student` `private`?
  - A: Encapsulation — restricts direct access and allows controlled access via methods.

- Q: What happens if `calculatePercentage()` is not called before `getPercentage()`?
  - A: `percentage` remains at its default value (0.0) and results will be incorrect.

- Q: Difference between `for (int i=0; ...)` and `for (int m : marks)`?
  - A: The indexed `for` gives access to index `i`. The enhanced `for-each` iterates elements directly and is shorter when indices are not needed.

- Q: How to handle variable number of subjects?
  - A: Read subject count from user, allocate `marks = new int[subjectCount]`, and loop accordingly.

- Q: Why close `Scanner` with `sc.close()`?
  - A: To free the underlying input resource. For `System.in`, closing is optional but is good practice.

- Q: How would you validate marks input?
  - A: Check each mark is within the range 0–100 and prompt again or throw an error if invalid.

**How to run (Windows PowerShell)**

```powershell
cd "Assignment-1"
javac Assignment1.java
java Assignment1
```

**Sample Input / Output (from project run)**

Input (user types):
- `2` (number of students)
- Student 1: `Rishav Singh`, `1`, marks: `9 98 87 98 98`
- Student 2: `Kunal Tailor`, `2`, marks: `89 79 89 86 88`

Output (program prints):
```
========= STUDENT RESULTS =========

------------------------------
Name       : Rishav Singh
Roll No    : 1
Marks      : 9 98 87 98 98
Percentage : 78.0
Grade      : A

------------------------------
Name       : Kunal Tailor
Roll No    : 2
Marks      : 89 79 89 86 88
Percentage : 86.2
Grade      : A

=================================
Class Average Percentage = 82.1
```

**Short Checklist to be Viva-ready**
- Explain the role of each class and method (`Student`, `calculatePercentage()`, `displayResult()`).
- Explain why casting to `double` is necessary for averages.
- Be able to describe I/O flow and why `nextLine()` is used after `nextInt()`.
- State time/space complexity and suggest improvements (input validation, dynamic subjects, formatting percentages).
- Be prepared to suggest small code edits: e.g., validate `n`, validate marks, use `printf` for formatting.

---

If you'd like, I can:
- Add input validation and re-generate the Java file,
- Format percentages to two decimals,
- Or produce a short set of flashcard-style viva questions for quick practice.

File created: [Assignment-1/Assignment1_explanation.md](Assignment-1/Assignment1_explanation.md#L1-L200)
