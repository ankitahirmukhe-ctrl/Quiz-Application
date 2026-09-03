# Java Quiz Application

A simple Multiple Choice Quiz Application developed using Java Swing.

## Features

- Multiple-choice questions
- 10 questions
- 4 options for each question
- 10-second timer for each question
- Automatic question skip when time runs out
- Score calculation
- Final result display
- Performance message
- Restart quiz option
- Exit option
- Simple graphical user interface

## Technologies Used

- Java
- Java Swing
- Java AWT
- Object-Oriented Programming (OOP)

## Project Structure

Quiz-Application/
└── Java-Quiz-Application/
    ├── src/
    │   ├── Main.java
    │   ├── Question.java
    │   └── Quiz.java
    ├── .gitignore
    └── README.md

## File Description

### Main.java

The main class of the application.

It handles:

- Graphical user interface
- Displaying questions
- Displaying answer options
- Timer
- Next question
- Final result
- Restart quiz

### Question.java

Stores information about each question:

- Question text
- Answer options
- Correct answer

### Quiz.java

Manages:

- Quiz questions
- Answer checking
- Score calculation
- Score reset

## How the Application Works

1. The application starts.
2. A question is displayed.
3. Four answer options are displayed.
4. The user has 10 seconds to answer.
5. The user selects an answer and clicks Next.
6. The answer is checked.
7. The score is updated.
8. The next question is displayed.
9. After all 10 questions, the final score is displayed.
10. The user can restart or exit the application.

## Scoring System

Each correct answer gives 1 point.

Maximum score: 10/10

- 8–10: Excellent!
- 5–7: Good Job!
- 0–4: Keep Practicing!

