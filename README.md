A simple yet functional calculator application built with Java Swing following the MVC (Model-View-Controller) design pattern.
Features

Basic Operations: Addition (+), Subtraction (-), Multiplication (×), Division (÷)
Unary Operations:

Percentage (%)
Square root (√)
Sign toggle (+/-)

Decimal Support: Handle decimal numbers with precision
Clear Function: AC (All Clear) button to reset the calculator
Error Handling: Validation for invalid operations (e.g., square root of negative numbers)
Clean UI: Dark themed interface inspired by modern calculator designs
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

Requirements

Java JDK 21 or higher
No external dependencies required

How to Run

1. Clone the repository:
```
   git clone <repository-url>
   cd Calculator
```



















