package com.strategy;

public class OperationSubtract implements IStrategy{
    @Override
    public int doOps(int num1, int num2) {
        return num1 > num2 ? num1-num2 : num2-num1;
    }
}
