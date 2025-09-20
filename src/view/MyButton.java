package view;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Custom button class for calculator with different styling based on button type
 */
public class MyButton extends JButton {

    // Color constants for different button types
    private final Color DARKGRAY = new Color(80, 80, 80);
    private final Color WHITE = new Color(249, 249, 249);
    private final Color LIGHTGRAY = new Color(222, 222, 220);
    private final Color ORANGE = new Color(255, 149, 0);

    // Button categories
    private static final String[] DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+/-"};
    private static final String[] FUNCTIONS = {"AC", "%", "√"};
    private static final String[] OPERATORS = {"+", "-", "x", "/", "="};

    /**
     * Constructor that creates a styled button based on its text
     * @param text The text to display on the button
     */
    public MyButton(String text) {
        super(text);

        // Set background color based on button type
        if (Arrays.asList(DIGITS).contains(text)) {
            setBackground(DARKGRAY);
        } else if (Arrays.asList(FUNCTIONS).contains(text)) {
            setBackground(LIGHTGRAY);
        } else if (Arrays.asList(OPERATORS).contains(text)) {
            setBackground(ORANGE);
        }

        // Set common styling properties
        setForeground(WHITE);
        setFont(new Font("Arial", Font.PLAIN, 20));
        setFocusPainted(false);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
