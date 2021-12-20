package lesson8;

import java.util.Scanner;

public class SimpleCalculator {
    String operator;
    double number1, number2, result;

    public void getCalculatorType() {
        System.out.println("SimpleCalculator");
    }

    public void getOperatorType() {
        System.out.println("Choose an operator: +, -, *, or /");
    }

    public void getCalculatorFunction() {

        // create an object of Scanner class
        Scanner input = new Scanner(System.in);

        // ask users to enter operator
        getOperatorType();
        operator = input.next();

        // ask users to enter numbers
        System.out.println("Enter first number");
        number1 = input.nextDouble();

        System.out.println("Enter second number");
        number2 = input.nextDouble();

        switch (operator) {
            // performs addition between numbers
            case "+":
                getAdd();
                getResult(operator);
                break;
            case "-":
                getSub();
                getResult(operator);
                break;
            case "*":
                getMul();
                getResult(operator);
                break;
            case "/":
                getDiv();
                getResult(operator);
                break;
            default:
                System.out.println("Invalid operator!");
                break;
        }

        input.close();
    }

    public void getResult(String operator) {
        System.out.println("Result of " + operator + " = " + result);
    }

    public void getAdd() {
        result = number1 + number2;
    }

    public void getSub() {
        result = number1 - number2;
    }

    public void getMul() {
        result = number1 * number2;
    }

    public void getDiv() {
        result = number1 / number2;
    }


}