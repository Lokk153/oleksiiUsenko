package lesson8;

import java.util.Scanner;

public class EngineeringCalculator extends SimpleCalculator {
    @Override
    public void getCalculatorType() {
        System.out.println("EngineeringCalculator");
    }
    @Override
    public void getOperatorType() {
        System.out.println("Choose an operator: +, -, *, /, pow, sqrt, sin or cos");
    }

    @Override
    public void getCalculatorFunction() {

        // create an object of Scanner class
        Scanner input = new Scanner(System.in);

        // ask users to enter operator
        getOperatorType();
        operator = input.next();

        if ("+".equals(operator) | "-".equals(operator) | "*".equals(operator) | "/".equals(operator)) {
            System.out.println("Enter first number");
            number1 = input.nextDouble();
            System.out.println("Enter second number");
            number2 = input.nextDouble();
        } else if ("sin".equals(operator) | "cos".equals(operator)) {
            System.out.println("Enter radian");
            number1 = input.nextDouble();
        } else if ("pow".equals(operator)) {
            System.out.println("Enter base");
            number1 = input.nextDouble();
            System.out.println("Enter exponent");
            number2 = input.nextDouble();
        } else if ("sqrt".equals(operator)) {
            System.out.println("Enter exponent");
            number1 = input.nextDouble();
        } else {
            System.out.println("Invalid operator!");
        }


        switch (operator) {
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
            case "pow":
                getPow();
                getResult(operator);
                break;
            case "sqrt":
                getSqrt();
                getResult(operator);
                break;
            case "sin":
                getSin();
                getResult(operator);
                break;
            case "cos":
                getCos();
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
    public void getAdd() {
        result = number1 + number2;
    }

    @Override
    public void getSub() {
        result = number1 - number2;
    }

    @Override
    public void getMul() {
        result = number1 * number2;
    }

    @Override
    public void getDiv() {
        result = number1 / number2;
    }

    public void getSin() {
        result = Math.sin(number1);
    }

    public void getCos() {
        result = Math.cos(number1);
    }

    public void getPow() {
        result = Math.pow(number1, number2);
    }

    public void getSqrt() {
        result = Math.sqrt(number1);
    }


}
