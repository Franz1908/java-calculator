# Calculator

A simple yet functional calculator application built with Java Swing
following the MVC (Model-View-Controller) design pattern.

## Features

-   **Basic Operations**: Addition (+), Subtraction (-), Multiplication
    (×), Division (÷)
-   **Chained Operations**: Perform sequences like `2 + 3 × 4 - 5`
    without pressing equals between steps\
    (now implemented using list-based state management in the Model)
-   **Unary Operations**:
    -   Percentage (%)
    -   Square root (√)
    -   Sign toggle (+/-)
-   **Decimal Support**: Handle decimal numbers with precision
-   **Clear Function**: AC (All Clear) button to reset the calculator
-   **Error Handling**: Validation for invalid operations (e.g., square
    root of negative numbers)
-   **Clean UI**: Dark themed interface inspired by iOS calculator

## Project Structure

    Calculator/
    ├── src/
    │   ├── Main.java                           # Entry point
    │   ├── constants/
    │   │   └── Constants.java                  # Application constants
    │   ├── controller/
    │   │   └── CalculatorController.java       # Updated controller logic with chaining support
    │   ├── model/
    │   │   └── CalculatorModel.java            # Refactored: list-based model for chained operations
    │   └── view/
    │       ├── CalculatorWindow.java           # Main window
    │       ├── Display.java                    # Display panel
    │       ├── KeypadPanel.java                # Keypad layout
    │       └── MyButton.java                   # Custom button component

## Requirements

-   Java JDK 21 or higher\
-   No external dependencies required

## How to Run

1.  Clone the repository:

``` bash
git clone <repository-url>
cd Calculator
```

2.  Compile the project:

``` bash
javac -d out src/**/*.java src/*.java
```

3.  Run the application:

``` bash
java -cp out Main
```

Alternatively, open the project in IntelliJ IDEA and run `Main.java`.

## Usage

-   **Number Input**: Click digit buttons (0--9)
-   **Decimal Point**: Click "." to add a decimal
-   **Operations**: Click +, -, ×, ÷ to add them to the operation list
-   **Equals**: Compute the full expression
-   **Special Functions**:
    -   **AC**: Reset calculator
    -   **%**: Convert number to percentage
    -   **√**: Square root
    -   **+/-**: Toggle sign

## Design Patterns

This project implements the **MVC (Model-View-Controller)** pattern:

-   **Model** (`CalculatorModel`): Now uses a **list-based structure**
    to store numbers and operations for chained evaluation
-   **View** (`CalculatorWindow`, `Display`, `KeypadPanel`, `MyButton`):
    UI components and display
-   **Controller** (`CalculatorController`): Updated to coordinate
    chained operations and user input

## Color Scheme

-   Background: Eerie Black (#1C1C1C)
-   Digits: Dark Gray (#505050)
-   Functions: Light Gray (#DEDCDC)
-   Operators: Orange (#FF9500)
-   Display Text: White (#F9F9F9)

## To-Do / Future Improvements

-   [x] **Operation Chaining**: Allow sequences of operations without
    pressing "="\

## Known Limitations

-   Maximum display length is 15 characters\
-   Square root works only for non-negative numbers

