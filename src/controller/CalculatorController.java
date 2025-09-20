package controller;

import model.CalculatorModel;
import view.CalculatorWindow;
import view.MyButton;

/**
 * Controller class that handles user interactions and coordinates between view and model
 */
public class CalculatorController {

    private CalculatorWindow calculatorWindow;
    private CalculatorModel calculatorModel;

    /**
     * Constructor that initializes the controller and sets up event listeners
     * @param calculatorWindow The main calculator window
     * @param calculatorModel The calculator model
     */
    public CalculatorController(CalculatorWindow calculatorWindow, CalculatorModel calculatorModel) {
        this.calculatorWindow = calculatorWindow;
        this.calculatorModel = calculatorModel;

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
        if (calculatorWindow.getDisplay().getText().equals("0") ||
                calculatorWindow.getDisplay().getText().equals("-0")) {
            calculatorWindow.getDisplay().setText(button.getText());
            calculatorModel.setIsNegative(false);
        } else if(calculatorWindow.getDisplay().getText().length() < 15){
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
                    calculatorModel.setFirstNumber(Double.parseDouble(calculatorWindow.getDisplay().getText()));
                    calculatorModel.setOperation(button.getText());
                    calculatorWindow.getDisplay().setText("");
                    // Note: setPressed method not found in model, might need to be added
                } catch (NumberFormatException nfe) {
                    calculatorWindow.getDisplay().setText("");
                }
                break;

            case "=":
                if (calculatorModel.getFirstNUmber() != null && calculatorModel.getOperation() != null) {
                    try {
                        calculatorModel.setSecondNUmber(Double.parseDouble(calculatorWindow.getDisplay().getText()));
                        Double result = calculatorModel.operations();
                        // Display integer if result has no decimal part
                        if (result % 1 == 0) {
                            calculatorWindow.getDisplay().setText(Integer.toString(result.intValue()));
                        } else {
                            calculatorWindow.getDisplay().setText(String.format("%.10f", result));
                        }
                    } catch (NumberFormatException nfe) {
                        calculatorWindow.getDisplay().setText("");
                    }
                }
                break;

            case ".":
                // Add decimal point only if not already present
                if (!calculatorWindow.getDisplay().getText().contains(".") && calculatorWindow.getDisplay().getText().length() < 15) {
                    calculatorWindow.getDisplay().setText(calculatorWindow.getDisplay().getText() + ".");
                }
                break;

            case "+/-":
                // Toggle sign of current number
                if (Double.parseDouble(calculatorWindow.getDisplay().getText()) > 0) {
                    calculatorModel.setIsNegative(true);
                    calculatorWindow.getDisplay().setText("-" + calculatorWindow.getDisplay().getText());
                } else {
                    calculatorModel.setIsNegative(false);
                    calculatorWindow.getDisplay().setText(calculatorWindow.getDisplay().getText().replace("-", ""));
                }
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
                break;

            case "%":
                try {
                    Double result = calculatorModel.unaryOperations("%",
                            Double.parseDouble(calculatorWindow.getDisplay().getText()));
                    calculatorWindow.getDisplay().setText(Double.toString(result));
                } catch (NumberFormatException nfe) {
                    calculatorWindow.getDisplay().setText("");
                }
                break;

            case "√":
                try {
                    Double result = calculatorModel.unaryOperations("√",
                            Double.parseDouble(calculatorWindow.getDisplay().getText()));
                    if (result == null) {
                        calculatorWindow.getDisplay().setText("Invalid operation");
                    } else {
                        calculatorWindow.getDisplay().setText(Double.toString(result));
                    }
                } catch (NumberFormatException nfe) {
                    calculatorWindow.getDisplay().setText("");
                }
        }
    }
}
