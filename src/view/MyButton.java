package view;

import constants.Constants;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Custom button class for calculator with different styling based on button type
 */
public class MyButton extends JButton {
    /**
     * Constructor that creates a styled button based on its text
     * @param text The text to display on the button
     */
    public MyButton(String text) {
        super(text);
        // Set background color based on button type
        if (Arrays.asList(Constants.DIGITS_BUTTON).contains(text)) {
            setBackground(Constants.DARK_GRAY);
        } else if (Arrays.asList(Constants.FUNCTIONS).contains(text)) {
            setBackground(Constants.LIGHT_GRAY);
        } else if (Arrays.asList(Constants.OPERATORS_BUTTON).contains(text)) {
            setBackground(Constants.ORANGE);
        }

        // Set common styling properties
        setForeground(Constants.WHITE);
        setFont(new Font("Arial", Font.PLAIN, 20));
        setFocusPainted(false);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
