package view;

import constants.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * Main window class for the calculator application
 */
public class CalculatorWindow extends JFrame {

    // Window dimensions
    private final int HEIGHT = 540;
    private final int WIDTH = 360;

    // UI components
    private Display display;
    private KeypadPanel keypadPanel;

    /**
     * Constructor that initializes the calculator window
     */
    public CalculatorWindow() {
        super("Calculator");
        setLayout(new BorderLayout());

        // Initialize components
        display = new Display();
        keypadPanel = new KeypadPanel();

        // Add components to the frame
        add(display, BorderLayout.PAGE_START);
        add(keypadPanel, BorderLayout.CENTER);

        // Set window properties
        setSize(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Gets the display component
     * @return The display panel
     */
    public Display getDisplay() {
        return this.display;
    }

    /**
     * Gets the keypad panel component
     * @return The keypad panel
     */
    public KeypadPanel getKeypadPanel() {
        return this.keypadPanel;
    }
}

