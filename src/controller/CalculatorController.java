package controller;

import model.CalculatorModel;
import view.CalculatorWindow;
import view.MyButton;

/**
 * Controller class that handles user interactions and coordinates between view and model
 * Now supports chained operations with partial results
 */
public class CalculatorController {

    private CalculatorWindow calculatorWindow;
    private CalculatorModel calculatorModel;
    private boolean isNewNumber;
    private boolean justCalculated;

    /**
     * Constructor that initializes the controller and sets up event listeners
     * @param calculatorWindow The main calculator window
     * @param calculatorModel The calculator model
     */
    public CalculatorController(CalculatorWindow calculatorWindow, CalculatorModel calculatorModel) {
        this.calculatorWindow = calculatorWindow;
        this.calculatorModel = calculatorModel;
        this.isNewNumber = true;
        this.justCalculated = false;

        // Add event listeners for digit buttons
        for (int i = 0; i < calculatorWindow.getKeypadPanel().getDigitButtons().length; i++) {
            MyButton digitButton = calculatorWindow.getKeypadPanel().getDigitButtons()[i];
            digitButton.addActionListener(e -> manageNumbers(digitButton));
        }

        // Add event listeners for operator buttons
        for (int i = 0; i < calculatorWindow.getKeypadPanel().getOperatorButtons().length; i++) {
            MyButton operatorButton = calculatorWindow.getKeypadPanel().getOperatorButtons()[i];
            operatorButton.addActionListener(e -> manageOperations(operatorButton));
        }

        // Add event listeners for function buttons
        for (int i = 0; i < calculatorWindow.getKeypadPanel().getFunctionButtons().length; i++) {
            MyButton functionButton = calculatorWindow.getKeypadPanel().getFunctionButtons()[i];
            functionButton.addActionListener(e -> manageFunctions(functionButton));
        }
    }

    /**
     * Handles digit button clicks
     * @param button The clicked digit button
     */
    public void manageNumbers(MyButton button) {
        // If we just calculated a result and user presses a digit, start fresh
        if (justCalculated) {
            calculatorModel.reset();
            calculatorWindow.getDisplay().setText("0");
            justCalculated = false;
            isNewNumber = true;
        }

        if (isNewNumber || calculatorWindow.getDisplay().getText().equals("0") ||
                calculatorWindow.getDisplay().getText().equals("-0")) {
            calculatorWindow.getDisplay().setText(button.getText());
            isNewNumber = false;
        } else if (calculatorWindow.getDisplay().getText().length() < 15) {
            calculatorWindow.getDisplay().appendText(button.getText());
        }
    }

    /**
     * Handles operator button clicks (+, -, x, /, =, ., +/-)
     * @param button The clicked operator button
     */
    public void manageOperations(MyButton button) {
        switch (button.getText()) {
            case "+": case "-": case "/": case "x":
                try {
                    // Get the current number from display
                    Double currentNumber = Double.parseDouble(calculatorWindow.getDisplay().getText());

                    // Add the number to the model
                    calculatorModel.addNumber(currentNumber);

                    // Calculate partial result if there's a pending operation
                    if (calculatorModel.hasPendingOperations()) {
                        Double partialResult = calculatorModel.calculatePartialResult();
                        if (partialResult != null) {
                            displayResult(partialResult);
                        } else {
                            calculatorWindow.getDisplay().setText("Error");
                            return;
                        }
                    }

                    // Add the new operation
                    calculatorModel.addOperation(button.getText());
                    isNewNumber = true;
                    justCalculated = false;

                } catch (NumberFormatException nfe) {
                    // If display is empty or invalid, just store the operation
                    if (calculatorModel.getNumbersCount() > 0) {
                        calculatorModel.addOperation(button.getText());
                        isNewNumber = true;
                    }
                }
                break;

            case "=":
                try {
                    // Add the last number if it's new
                    if (!isNewNumber) {
                        Double lastNumber = Double.parseDouble(calculatorWindow.getDisplay().getText());
                        calculatorModel.addNumber(lastNumber);
                    }

                    // Calculate final result
                    Double finalResult = calculatorModel.calculateFinalResult();

                    if (finalResult != null) {
                        displayResult(finalResult);
                        calculatorModel.startNewCalculation();
                        isNewNumber = true;
                        justCalculated = true;
                    } else {
                        calculatorWindow.getDisplay().setText("Error");
                        calculatorModel.reset();
                        isNewNumber = true;
                    }

                } catch (NumberFormatException nfe) {
                    // Just calculate with what we have
                    Double result = calculatorModel.calculateFinalResult();
                    if (result != null) {
                        displayResult(result);
                        calculatorModel.startNewCalculation();
                    }
                    isNewNumber = true;
                    justCalculated = true;
                }
                break;

            case ".":
                // Add decimal point only if not already present
                if (!calculatorWindow.getDisplay().getText().contains(".") &&
                        calculatorWindow.getDisplay().getText().length() < 15 &&
                        !calculatorWindow.getDisplay().getText().isEmpty()) {

                    if (isNewNumber) {
                        calculatorWindow.getDisplay().setText("0.");
                        isNewNumber = false;
                    } else {
                        calculatorWindow.getDisplay().setText(calculatorWindow.getDisplay().getText() + ".");
                    }
                }
                break;

            case "+/-":
                try {
                    double value = Double.parseDouble(calculatorWindow.getDisplay().getText().replace(",", "."));
                    value = value * (-1);
                    if (value % 1 == 0) {
                        calculatorWindow.getDisplay().setText(Integer.toString((int) value));
                    } else {
                        calculatorWindow.getDisplay().setText(Double.toString(value));
                    }
                } catch (NumberFormatException nfe) {
                    calculatorWindow.getDisplay().setText("0");
                }
                break;
        }
    }

    /**
     * Handles function button clicks (AC, %, √)
     * @param button The clicked function button
     */
    public void manageFunctions(MyButton button) {
        switch (button.getText()) {
            case "AC":
                // All Clear - reset calculator to initial state
                calculatorWindow.getDisplay().setText("0");
                calculatorModel.reset();
                isNewNumber = true;
                justCalculated = false;
                break;

            case "%":
                try {
                    Double result = calculatorModel.unaryOperations("%",
                            Double.parseDouble(calculatorWindow.getDisplay().getText()));
                    displayResult(result);
                    isNewNumber = true;
                } catch (NumberFormatException nfe) {
                    calculatorWindow.getDisplay().setText("0");
                }
                break;

            case "√":
                try {
                    Double result = calculatorModel.unaryOperations("√",
                            Double.parseDouble(calculatorWindow.getDisplay().getText()));
                    if (result == null) {
                        calculatorWindow.getDisplay().setText("Error");
                    } else {
                        displayResult(result);
                    }
                    isNewNumber = true;
                } catch (NumberFormatException nfe) {
                    calculatorWindow.getDisplay().setText("0");
                }
                break;
        }
    }

    /**
     * Helper method to display results with proper formatting
     * @param result The result to display
     */
    private void displayResult(Double result) {
        if (result % 1 == 0) {
            calculatorWindow.getDisplay().setText(Integer.toString(result.intValue()));
        } else {
            // Remove trailing zeros
            String formatted = String.format("%.10f", result).replaceAll("0*$", "").replaceAll("\\.$", "");
            calculatorWindow.getDisplay().setText(formatted);
        }
    }
}
