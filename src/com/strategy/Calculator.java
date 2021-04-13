package com.strategy;

public class Calculator {
    private IStrategy iStrategy;

    Calculator(IStrategy iStrategy) {
        this.iStrategy = iStrategy;
    }

    public int execute(int num1, int num2) {
        return iStrategy.doOps(num1, num2);
    }
}
