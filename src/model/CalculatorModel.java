package model;

/**
 * Model class that handles calculator data and operations
 */
public class CalculatorModel {

    // Calculator state variables
    private Double firstNumber;
    private Double secondNumber;
    private String operation;
    private Double result;
    //private boolean isNegative = false;
    //private boolean isPendingOPeration = false;

    /**
     * Default constructor
     */
    public CalculatorModel() {}

    /**
     * Sets the first number for calculations
     * @param firstNumber The first operand
     */
    public void setFirstNumber(Double firstNumber) {
        this.firstNumber = firstNumber;
    }

    /**
     * Sets the second number for calculations
     * @param secondNumber The second operand
     */
    public void setSecondNUmber(Double secondNumber) {
        this.secondNumber = secondNumber;
    }

    /**
     * Sets the operation to be performed
     * @param operation The operation string (+, -, x, /)
     */
    public void setOperation(String operation) {
        this.operation = operation;
    }

    /**
     * Gets the first number
     * @return The first operand
     */
    public Double getFirstNUmber() {
        return this.firstNumber;
    }

    /**
     * Gets the second number
     * @return The second operand
     */
    public Double getSecondNumber() {
        return this.secondNumber;
    }

    /**
     * Gets the current operation
     * @return The operation string
     */
    public String getOperation() {
        return this.operation;
    }

    /**
     * Checks if the current number is negative
     * @return True if negative, false otherwise

    public boolean isNegative() {
        return this.isNegative;
    }

    /**
     * Sets the negative flag
     * @param isNegative Boolean indicating if number is negative

    public void setIsNegative(boolean isNegative) {
        this.isNegative = isNegative;
    } */

   /* public boolean isPendingOPeration() {
        return this.isPendingOPeration;
    }

    public void setIsPendingOPeration(boolean isPendingOPeration) {
        this.isPendingOPeration = isPendingOPeration;
    } */

    /**
     * Performs binary operations (addition, subtraction, multiplication, division)
     * @return The result of the operation
     */
    public Double operations() {
        switch (this.operation) {
            case "+":
                result = this.firstNumber + this.secondNumber;
                break;
            case "-":
                result = this.firstNumber - this.secondNumber;
                break;
            case "x":
                result = this.firstNumber * this.secondNumber;
                break;
            case "/":
                result = this.firstNumber / this.secondNumber;
                break;
        }
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
                } else {
                    return Math.sqrt(value);
                }
        }
        return null;
    }

    /**
     * Resets all calculator state to initial values
     */
    public void reset() {
        this.firstNumber = null;
        this.secondNumber = null;
        this.result = null;
        this.operation = null;
        //this.isNegative = false;
    }
}
