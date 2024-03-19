package com.app.calculator;

public class Expression implements ArithmeticExpression {
    private ArithmeticExpression leftPart;
    private ArithmeticExpression rightPart;
    private Operation operation;

    public Expression(ArithmeticExpression leftPart, ArithmeticExpression rightPart, Operation operation) {
        this.leftPart = leftPart;
        this.rightPart = rightPart;
        this.operation = operation;
    }

    @Override
    public int evaluate() {
        switch (operation) {
            case ADD:
                return leftPart.evaluate() + rightPart.evaluate();
            case SUBTRACT:
                return leftPart.evaluate()- rightPart.evaluate();
            case MULTIPLY:
                return leftPart.evaluate() * rightPart.evaluate();
            case DIVIDE:
                return leftPart.evaluate() / rightPart.evaluate();
            default:
                throw new RuntimeException("Invalid request");
        }
    }
}
