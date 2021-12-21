package lesson8;

import java.util.Scanner;

public class FinancialCalculator extends EngineeringCalculator {
    double currencySum = number1;
    double currencyRate = number2;

    @Override
    public void getCalculatorType() {
        System.out.println("FinancialCalculator");
    }

    @Override
    public void getOperatorType() {
        System.out.println("Choose a converter: h = hryvnia to dollar or d = dollar to hryvnia");
    }

    public void getCalculatorFunction() {

        // create an object of Scanner class
        Scanner input = new Scanner(System.in);

        // ask users to enter operator
        getOperatorType();
        operator = input.next();

        // ask users to enter numbers
        System.out.println("Enter sum");
        currencySum = input.nextDouble();

        System.out.println("Enter currencyRate");
        currencyRate = input.nextDouble();

        switch (operator) {
            // performs addition between numbers
            case "h":
            case "d":
                getMul();
                getResult(operator);
                break;
            default:
                System.out.println("Invalid operator!");
                break;
        }

        input.close();
    }

    @Override
    public void getResult(String operator) {
        System.out.println("Result of " + operator + " = " + result);
    }

    @Override
    public void getMul() {
        result = currencySum * currencyRate;
    }

}
