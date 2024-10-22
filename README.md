# Employee Payroll System

This is a simple Employee Payroll System implemented in Java. The system handles both full-time and part-time employees, calculates their salaries, and manages an employee list using basic operations like adding, removing, and displaying employee details.

## Features

- **Full-Time Employee**: Salaries are calculated based on a fixed monthly salary.
- **Part-Time Employee**: Salaries are calculated based on hourly rates and the number of hours worked.
- **Employee Management**: The system supports adding, removing, and displaying employee details.

## Classes and Structure

### 1. `Employe` (Abstract Class)
- **Attributes**:
  - `name`: Employee name.
  - `id`: Employee ID.
- **Methods**:
  - `getname()`: Returns the employee name.
  - `getid()`: Returns the employee ID.
  - `calculatesalary()`: Abstract method for calculating salary (implemented by subclasses).
  - `toString()`: Provides a string representation of the employee details.

### 2. `FullTimeEmploye` (Subclass of `Employe`)
- **Attributes**:
  - `monthlysalary`: Monthly salary for full-time employees.
- **Methods**:
  - `calculatesalary()`: Returns the full-time employee's fixed monthly salary.

### 3. `parttimeemploye` (Subclass of `Employe`)
- **Attributes**:
  - `hoursworked`: Number of hours worked by the part-time employee.
  - `hourlyrate`: Hourly wage of the part-time employee.
- **Methods**:
  - `calculatesalary()`: Calculates the salary by multiplying hours worked with the hourly rate.

### 4. `payrollsystem` (Class)
- **Attributes**:
  - `employeelist`: A list that holds all employees (both full-time and part-time).
- **Methods**:
  - `addemploye(Employe employe)`: Adds an employee to the list.
  - `removeemploye(int id)`: Removes an employee from the list based on their ID.
  - `displayemploye()`: Displays all employee details.

### 5. `main` (Main Class)
- Contains the main method where:
  - Full-time and part-time employees are created.
  - Employees are added, removed, and displayed using the `payrollsystem` class.

## How to Run

1. Clone the repository.
2. Compile and run the `main` class in a Java environment.

```bash
javac main.java
java Employee.main
