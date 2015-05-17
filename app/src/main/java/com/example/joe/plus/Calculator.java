package com.example.joe.plus;

/**
 * Created by Jose & Vanice on 5/5/15.
 */
public class Calculator {

    private double operand = 0;
    private double waitingOperand = 0;
    private String waitingOperator = "";
    private double calculatorMemory = 0;

    public void setOperand(double operand) {
        this.operand = operand;
    }

    public double getResult() {
        return operand;
    }

    // used on screen orientation change
    public void setMemory(double calculatorMemory) {
        this.calculatorMemory = calculatorMemory;
    }

    // used on screen orientation change
    public double getMemory() {
        return calculatorMemory;
    }

    public String toString() {
        return Double.toString(operand);
    }

    protected double performOperation(String operator) {

        if (operator.equalsIgnoreCase("ac")) {
            operand = 0;
            waitingOperator = "";
            waitingOperand = 0;
            calculatorMemory = 0;
        } else if (operator.equals("Sqrt")) {
            calculatorMemory = operand = Math.sqrt(operand);
        } else if (operator.equals("1/x")) {
            if (operand != 0) {
               calculatorMemory = operand = 1 / operand;
            }
        } else if (operator.equals("+/-")) {
            calculatorMemory = operand = -operand;
        } else if (operator.equals("sin")) {
            calculatorMemory = operand = Math.sin(operand);
        } else if (operator.equals("cos")) {
           calculatorMemory = operand = Math.cos(operand);
        } else {
            performWaitingOperation();
            waitingOperator = operator;
            waitingOperand = operand;
        }

        return operand;
    }

    protected void performWaitingOperation() {

        if (waitingOperator.equals("+")) {
            operand = waitingOperand + operand;
            calculatorMemory = operand;
        } else if (waitingOperator.equalsIgnoreCase("x")) {
            operand = waitingOperand * operand;
            calculatorMemory = operand;
        } else if (waitingOperator.equals("-")) {
            operand = waitingOperand - operand;
            calculatorMemory = operand;
        } else if (waitingOperator.equals("÷")) {
            if (operand != 0) {
                operand = waitingOperand / operand;
                calculatorMemory = operand;
            }
        }

    }

}
