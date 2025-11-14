package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model class that handles calculator data and operations with support for chained operations
 */
public class CalculatorModel {

    // Calculator state variables using lists for chained operations
    private List<Double> numbers;
    private List<String> operations;
    private Double currentResult;

    /**
     * Default constructor
     */
    public CalculatorModel() {
        this.numbers = new ArrayList<>();
        this.operations = new ArrayList<>();
        this.currentResult = null;
    }

    /**
     * Adds a number to the numbers list
     * @param number The number to add
     */
    public void addNumber(Double number) {
        this.numbers.add(number);
    }

    /**
     * Adds an operation to the operations list
     * @param operation The operation string (+, -, x, /)
     */
    public void addOperation(String operation) {
        this.operations.add(operation);
    }

    /**
     * Gets the current result
     * @return The current result
     */
    public Double getCurrentResult() {
        return this.currentResult;
    }

    /**
     * Sets the current result
     * @param result The result to set
     */
    public void setCurrentResult(Double result) {
        this.currentResult = result;
    }

    /**
     * Checks if there are pending operations
     * @return True if there are operations waiting to be executed
     */
    public boolean hasPendingOperations() {
        return !this.operations.isEmpty();
    }

    /**
     * Gets the number of stored numbers
     * @return The count of numbers in the list
     */
    public int getNumbersCount() {
        return this.numbers.size();
    }

    /**
     * Calculates partial result after adding a new number
     * This method calculates the result of the last pending operation
     * @return The partial result
     */
    public Double calculatePartialResult() {
        if (numbers.isEmpty()) {
            return null;
        }

        // If this is the first number, just return it
        if (numbers.size() == 1) {
            currentResult = numbers.get(0);
            return currentResult;
        }

        // Calculate based on the last operation
        if (operations.isEmpty()) {
            return currentResult;
        }

        String lastOperation = operations.get(operations.size() - 1);
        Double leftOperand = (currentResult != null) ? currentResult : numbers.get(numbers.size() - 2);
        Double rightOperand = numbers.get(numbers.size() - 1);

        switch (lastOperation) {
            case "+":
                currentResult = leftOperand + rightOperand;
                break;
            case "-":
                currentResult = leftOperand - rightOperand;
                break;
            case "x":
                currentResult = leftOperand * rightOperand;
                break;
            case "/":
                if (rightOperand == 0) {
                    return null; // Division by zero
                }
                currentResult = leftOperand / rightOperand;
                break;
        }

        return currentResult;
    }

    /**
     * Calculates the final result when equals is pressed
     * @return The final result
     */
    public Double calculateFinalResult() {
        if (numbers.isEmpty()) {
            return null;
        }

        if (numbers.size() == 1) {
            return numbers.get(0);
        }

        // Start with the first number
        Double result = numbers.get(0);

        // Apply each operation sequentially
        for (int i = 0; i < operations.size() && i + 1 < numbers.size(); i++) {
            String operation = operations.get(i);
            Double nextNumber = numbers.get(i + 1);

            switch (operation) {
                case "+":
                    result = result + nextNumber;
                    break;
                case "-":
                    result = result - nextNumber;
                    break;
                case "x":
                    result = result * nextNumber;
                    break;
                case "/":
                    if (nextNumber == 0) {
                        return null; // Division by zero
                    }
                    result = result / nextNumber;
                    break;
            }
        }

        currentResult = result;
        return result;
    }

    /**
     * Performs unary operations (percentage, square root)
     * @param operation The operation to perform
     * @param value The value to operate on
     * @return The result of the operation, null if invalid
     */
    public Double unaryOperations(String operation, Double value) {
        switch (operation) {
            case "%":
                return value / 100;
            case "√":
                if (value < 0) {
                    return null; // Cannot calculate square root of negative number
                }
                return Math.sqrt(value);
        }
        return null;
    }

    /**
     * Resets all calculator state to initial values
     */
    public void reset() {
        this.numbers.clear();
        this.operations.clear();
        this.currentResult = null;
    }

    /**
     * Prepares for a new calculation after equals was pressed
     * Keeps the current result as the starting point
     */
    public void startNewCalculation() {
        if (currentResult != null) {
            numbers.clear();
            operations.clear();
            numbers.add(currentResult);
        }
    }
}
