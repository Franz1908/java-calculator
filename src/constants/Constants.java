package constants;

import java.awt.*;

public class Constants {

    //Window dimension constants
    public final static int WINDOW_WIDTH = 360;
    public final static int WINDOW_HEIGHT = 540;

    //Display dimension constants
    public final static int DISPLAY_WIDTH = 100;
    public final static int DISPLAY_HEIGHT = 75;

    //Color costants
    public static final Color DARK_GRAY = new Color(80, 80, 80);
    public static final Color WHITE = new Color(249, 249, 249);
    public static final Color LIGHT_GRAY = new Color(222, 222, 220);
    public static final Color ORANGE = new Color(255, 149, 0);
    public static final Color EERIE_BLACK = new Color(28, 28, 28);

    //Calculator function buttons
    public static final String[] FUNCTIONS = {"AC", "%", "√"};
    //Calculator digit buttons including decimal point and sign toggle
    public static final String[] DIGITS_BUTTON = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+/-"};
    //Calculator operator buttons
    public static final String[] OPERATORS_BUTTON = {"+", "-", "x", "/", "="};
    //Keypad panel digits
    public static final String[] DIGITS_KEYPAD_PANEL = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    //Keypad panel operators
    public static final String[]  OPERATORS_KEYPAD_PANEL = {"/", "x", "-", "+", "=", ".", "+/-"};
}
