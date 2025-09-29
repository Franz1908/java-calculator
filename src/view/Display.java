package view;

import constants.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * Display panel that shows calculator input and results
 */
public class Display extends JPanel {

    private JLabel label;

    /**
     * Constructor that creates the display with initial styling
     */
    public Display() {
        setLayout(new BorderLayout());
        setBackground(Constants.EERIE_BLACK);
        setPreferredSize(new Dimension(Constants.DISPLAY_WIDTH, Constants.DISPLAY_HEIGHT));

        // Initialize and style the display label
        label = new JLabel("0");
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setForeground(Constants.WHITE);
        label.setOpaque(false);
        label.setVerticalAlignment(JLabel.BOTTOM);

        add(label, BorderLayout.EAST);
    }

    /**
     * Gets the current display text
     * @return The text currently shown on display
     */
    public String getText() {
        return label.getText();
    }

    /**
     * Sets new text on the display
     * @param text The text to display
     */
    public void setText(String text) {
        label.setText(text);
    }

    /**
     * Appends text to the current display text
     * @param text The text to append
     */
    public void appendText(String text) {
        label.setText(label.getText() + text);
    }
}
