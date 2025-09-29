package view;

import constants.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * Panel containing all calculator buttons arranged in a grid layout
 */
public class KeypadPanel extends JPanel {
    // Button arrays
    private MyButton[] digitButtons;
    private MyButton[] functionButtons;
    private MyButton[] operatorButtons;

    /**
     * Constructor that creates and arranges all calculator buttons
     */
    public KeypadPanel() {
        setLayout(new GridLayout(5, 4));
        setBackground(Constants.EERIE_BLACK);

        // Initialize button arrays
        digitButtons = new MyButton[Constants.DIGITS_KEYPAD_PANEL.length];      // 10 digits
        functionButtons = new MyButton[Constants.FUNCTIONS.length]; // 3 functions
        operatorButtons = new MyButton[Constants.OPERATORS_KEYPAD_PANEL.length]; // 7 operators

        // First row: AC, √, %, /
        add(functionButtons[0] = new MyButton("AC"));
        add(functionButtons[1] = new MyButton("√"));
        add(functionButtons[2] = new MyButton("%"));
        add(operatorButtons[0] = new MyButton("/"));

        // Second row: 7, 8, 9, x
        add(digitButtons[7] = new MyButton("7"));
        add(digitButtons[8] = new MyButton("8"));
        add(digitButtons[9] = new MyButton("9"));
        add(operatorButtons[1] = new MyButton("x"));

        // Third row: 4, 5, 6, -
        add(digitButtons[4] = new MyButton("4"));
        add(digitButtons[5] = new MyButton("5"));
        add(digitButtons[6] = new MyButton("6"));
        add(operatorButtons[2] = new MyButton("-"));

        // Fourth row: 1, 2, 3, +
        add(digitButtons[1] = new MyButton("1"));
        add(digitButtons[2] = new MyButton("2"));
        add(digitButtons[3] = new MyButton("3"));
        add(operatorButtons[3] = new MyButton("+"));

        // Fifth row: +/-, 0, ., =
        add(operatorButtons[6] = new MyButton("+/-"));
        add(digitButtons[0] = new MyButton("0"));
        add(operatorButtons[5] = new MyButton("."));
        add(operatorButtons[4] = new MyButton("="));
    }

    /**
     * Gets the digit buttons array
     * @return Array of digit buttons
     */
    public MyButton[] getDigitButtons() {
        return digitButtons;
    }

    /**
     * Gets the function buttons array
     * @return Array of function buttons
     */
    public MyButton[] getFunctionButtons() {
        return functionButtons;
    }

    /**
     * Gets the operator buttons array
     * @return Array of operator buttons
     */
    public MyButton[] getOperatorButtons() {
        return operatorButtons;
    }
}


