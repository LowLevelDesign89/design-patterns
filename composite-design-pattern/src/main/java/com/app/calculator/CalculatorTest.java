package com.app.calculator;

public class CalculatorTest {
    public static void main(String[] args) {
        ArithmeticExpression num1 = new Number(1);
        ArithmeticExpression num2 = new Number(7);
        ArithmeticExpression expr1 = new Expression(num1, num2, Operation.ADD);

        ArithmeticExpression num3 = new Number(2);
        ArithmeticExpression expr2 = new Expression(num3, expr1, Operation.MULTIPLY);

        System.out.println(expr2.evaluate());
    }
}
