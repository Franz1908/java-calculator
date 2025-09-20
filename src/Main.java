import controller.CalculatorController;
import model.CalculatorModel;
import view.*;

public class Main {
    public static void main(String[] args) {
        CalculatorWindow calculatorWindow = new CalculatorWindow();
        CalculatorModel calculatorModel = new CalculatorModel();
        CalculatorController calculatorController = new CalculatorController(calculatorWindow, calculatorModel);
    }
}
