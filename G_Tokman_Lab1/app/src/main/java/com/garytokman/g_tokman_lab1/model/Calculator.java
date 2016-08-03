package com.garytokman.g_tokman_lab1.model;

/**
 * Gary Tokman
 * JAV1 - MDV3810
 */
public class Calculator {

    private int mTotal;
    private int mFirstInt;
    private int mSecondInt;
    private String mOperator;

    public Calculator() {
        mTotal = 0;
        mFirstInt = 0;
        mSecondInt = 0;
        mOperator = null;
    }

    // Operator
    public String getOperator() {
        return mOperator;
    }

    public void setOperator(String operator) {
        mOperator = operator;
    }

    // Total
    public int getTotal() {
        return mTotal;
    }

    // Temp Integers
    public int getFirstInt() {
        return mFirstInt;
    }

    public void setFirstInt(int firstInt) {
        mFirstInt = firstInt;
    }

    public int getSecondInt() {
        return mSecondInt;
    }

    public void setSecondInt(int secondInt) {
        mSecondInt = secondInt;
    }

    public void setTotal(String operator, int firstInt, int secondInt) {

        switch (operator) {
            case "+":
                mTotal = firstInt + secondInt;
                break;
            case "-":
                mTotal = firstInt - secondInt;
                break;
            case "*":
                mTotal = firstInt * secondInt;
                break;
            case "/":
                mTotal = firstInt / secondInt;
            case "=":
                this.getTotal();
                break;
            default:
                // Clear total
                this.setFirstInt(0);
                this.setSecondInt(0);
                mTotal = 0;
        }

    }

}
