# Race & Car — Project Work #1

This is a simple educational Java project for practicing basic OOP principles, user input handling, and simple validation.
The project consists of three classes: `Car`, `Race` and `Main`.

## Car Class
The `Car` class represents a car participating in the race. It contains two fields:

`name` — the name of the car  
`speed` — the car’s speed value

## Race Class
The `Race` class handles the main program flow:

1. Asks the user to input the names and speeds of three cars 
2. Performs basic validation of the entered data 
3. Creates `Car` objects based on the user input 
4. Calculates how far each car would travel in 24 hours, based on its speed
5. Compares the distances and determines the winner

The race logic is implemented in the `start()` method.

## Main Class
The `Main` class contains the `main()` method — the entry point of the program.
It creates a `Race` object and runs the race by calling its `start()` method.

```JAVA
public class Main {
    public static void main(String[] args) {
        Race race = new Race();
        race.start();
    }
}
```

## Purpose
- This project is intended for practicing:
- Object-oriented programming basics
- Working with classes and objects
- Input validation using `Scanner`
- Implementing simple program logic and comparisons