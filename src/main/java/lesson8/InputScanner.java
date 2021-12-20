package lesson8;

import java.util.Scanner;

public class InputScanner {
    public void getInputData() {
        char calculatorType;
        System.out.println("Choose a calculator type: S E F");
        Scanner input = new Scanner(System.in);
        calculatorType = input.next().charAt(0);

        switch (calculatorType) {

            case 'S' | 's':
                SimpleCalculator SimpleCalculator = new SimpleCalculator();
                SimpleCalculator.getCalculatorType();
                SimpleCalculator.getCalculatorFunction();
                break;

            case 'E' | 'e':
                EngineeringCalculator EngineeringCalculator = new EngineeringCalculator();
                EngineeringCalculator.getCalculatorType();
                EngineeringCalculator.getCalculatorFunction();
                break;

            case 'F' | 'f':
                FinancialCalculator FinancialCalculator = new FinancialCalculator();
                FinancialCalculator.getCalculatorType();
                FinancialCalculator.getCalculatorFunction();
                break;

            default:
                System.out.println("Invalid calculator type!");
                break;
        }

        input.close();

    }
}



