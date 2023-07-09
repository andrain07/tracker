package ru.job4j.oop;

public class Calculator {

    private static final int X = 5;

    public static int sum(int y) {
        return X + y;
    }

    public static int minus(int number) {
        return number - X;
    }

    public double divide(int number) {
        return (double) number / X;
    }

    public int multiply(int number) {
        return number * X;
    }

    public double sumAllOperation(int number) {
        return sum(number) + minus(number) + divide(number) + multiply(number);
    }

    public static void main(String[] args) {
        int number = 10;
        int result = Calculator.sum(number);
        Calculator calculator = new Calculator();
        System.out.println(result);
        result = Calculator.minus(number);
        System.out.println(result);
        result = calculator.multiply(number);
        System.out.println(result);

        double divisionResult = calculator.divide(number);
        System.out.println(divisionResult);
        double sumAllOperation = calculator.sumAllOperation(number);
        System.out.println(sumAllOperation);

    }
}