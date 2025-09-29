# Calculator

A simple yet functional calculator application built with Java Swing following the MVC (Model-View-Controller) design pattern.

## Features

- **Basic Operations**: Addition (+), Subtraction (-), Multiplication (×), Division (÷)
- **Unary Operations**: 
  - Percentage (%)
  - Square root (√)
  - Sign toggle (+/-)
- **Decimal Support**: Handle decimal numbers with precision
- **Clear Function**: AC (All Clear) button to reset the calculator
- **Error Handling**: Validation for invalid operations (e.g., square root of negative numbers)
- **Clean UI**: Dark themed interface inspired by modern calculator designs

## Project Structure

```
Calculator/
├── src/
│   ├── Main.java                           # Entry point
│   ├── constants/
│   │   └── Constants.java                  # Application constants
│   ├── controller/
│   │   └── CalculatorController.java       # Controller logic
│   ├── model/
│   │   └── CalculatorModel.java            # Business logic
│   └── view/
│       ├── CalculatorWindow.java           # Main window
│       ├── Display.java                    # Display panel
│       ├── KeypadPanel.java                # Keypad layout
│       └── MyButton.java                   # Custom button component
```

## Requirements

- Java JDK 21 or higher
- No external dependencies required

## How to Run

1. Clone the repository:
```bash
git clone <repository-url>
cd Calculator
```

2. Compile the project:
```bash
javac -d out src/**/*.java src/*.java
```

3. Run the application:
```bash
java -cp out Main
```

Alternatively, open the project in IntelliJ IDEA and run `Main.java`.

## Usage

- **Number Input**: Click on digit buttons (0-9) to input numbers
- **Decimal Point**: Click "." to add a decimal point
- **Operations**: Click +, -, ×, or ÷ to select an operation
- **Equals**: Click "=" to calculate the result
- **Special Functions**:
  - **AC**: Clear all and reset calculator
  - **%**: Convert current number to percentage
  - **√**: Calculate square root of current number
  - **+/-**: Toggle between positive and negative

## Design Patterns

This project implements the **MVC (Model-View-Controller)** pattern:

- **Model** (`CalculatorModel`): Handles all calculation logic and state management
- **View** (`CalculatorWindow`, `Display`, `KeypadPanel`, `MyButton`): Manages UI components and display
- **Controller** (`CalculatorController`): Coordinates between model and view, handles user input

## Color Scheme

- Background: Eerie Black (#1C1C1C)
- Digits: Dark Gray (#505050)
- Functions: Light Gray (#DEDCDC)
- Operators: Orange (#FF9500)
- Display Text: White (#F9F9F9)

## To-Do / Future Improvements

- [ ] **Operation Chaining**: Allow multiple operations without pressing equals (e.g., 2 + 3 + 4 should work continuously)

## Known Limitations

- Operations cannot be chained - you must press "=" between each operation
- Maximum display length is 15 characters
- Square root only works with non-negative numbers

