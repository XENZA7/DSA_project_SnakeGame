# DSA_project_SnakeGame
Console-based Snake Game in Java using a custom generic ArrayList to demonstrate object-oriented programming and data structures and algorithm
# Snake Game Using a Custom Array List (Java)

## 1. Introduction
This project is a console-based Snake Game developed in Java as part of Object-Oriented
Programming practice. The main objective of the project is to demonstrate the implementation
and use of a custom generic Array List data structure in a practical application.

Instead of using Java’s built-in `ArrayList`, a custom class `MyArrayListHM<E>` is implemented
and used to store and manage the snake’s body during gameplay.

---

## 2. Project Description
The Snake Game runs on a 10x10 grid where the player controls a snake using keyboard input.
The snake moves continuously in one direction, grows when it eats food, and the game ends
when the snake collides with itself.

The project focuses on:
- Object-Oriented Programming principles
- Generic programming
- Custom data structure implementation
- Console-based input and output

---

## 3. Features
- Custom generic Array List implementation
- Snake movement using WASD keys
- Random food generation
- Snake growth when food is consumed
- Screen wrap-around movement
- Self-collision detection
- Score tracking
- Replay functionality after game over

---

## 4. Data Structures Used
### 4.1 Custom Array List (`MyArrayListHM<E>`)
The custom Array List supports the following operations:
- Adding elements at a specific index
- Removing elements
- Accessing elements by index
- Checking if the list contains an element
- Sorting elements using the `Comparable` interface
- Manual size management without Java Collections

This data structure is used to store the snake’s body segments.

---

## 5. Technologies Used
- Programming Language: Java
- Concepts:
  - Object-Oriented Programming (OOP)
  - Generics
  - Custom Data Structures and Algorithm
  - Console Input/Output

---

## 6. Game Controls
- **W** : Move Up  
- **S** : Move Down  
- **A** : Move Left  
- **D** : Move Right  

Symbols used in the grid:
- `H` : Snake Head
- `b` : Snake Body
- `*` : Food
- `.` : Empty Cell

---

## 7. How to Run the Program
### 7.1 Using an IDE
1. Open the project in an IDE (IntelliJ IDEA, Eclipse, or NetBeans)
2. Compile all `.java` files
3. Run the `SnakeGame` class

### 7.2 Using the Command Line
```bash
javac *.java
java SnakeGame
1. Open the project in an IDE (IntelliJ IDEA, Eclipse, or NetBeans)
2. Compile all `.java` files
3. Run the `SnakeGame` class
