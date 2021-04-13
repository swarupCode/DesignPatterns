package com.strategy;

public class OperationAdd implements IStrategy{
    @Override
    public int doOps(int num1, int num2) {
        return num1 + num2;
    }
}
