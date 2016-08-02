package com.garytokman.g_tokman_lab1.model;

/**
 * Gary Tokman
 * JAV1 - MDV3810
 */
public class Calculator {

    // Fields
    private int mClear;
    private String mAdd;
    private String mSubtract;
    private String mMultiply;
    private String mDivide;
    private String mTotal;
    private String[] mInput;
    private int mFirstInt;
    private int mSecondInt;
    private int mCurrentValue;

    // Clear
    public int getClear() {

        // Clear Temp values
        mFirstInt = 0;
        mSecondInt = 0;

        return 0;
    }

    // Temp
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

    // Operators
    public String getAdd() {
        return "+";
    }

    public String getSubtract() {
        return "-";
    }

    public String getMultiply() {
        return "*";
    }

    public String getDivide() {
        return "/";
    }

    // Get total
    public String getTotal() {

        for (String value : getInput()) {
            // Logic to pull out the in and return total
        }

        return mTotal;
    }

    public String[] getInput() {
        return mInput;
    }

    public void setInput(String[] input) {
        mInput = input;
    }
}
