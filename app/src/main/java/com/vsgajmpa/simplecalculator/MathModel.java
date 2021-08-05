package com.vsgajmpa.simplecalculator;

public class MathModel {

    private Integer number1;
    private Integer number2;

    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    public Integer plus() {
        return number1 + number2;
    }

    public Integer minus() {
        return number1 - number2;
    }

    public Integer multiples() {
        return number1 * number2;
    }

    public Integer divide() {
        if (number2.compareTo(0) == 0) {
            throw new NumberFormatException();
        }

        return number1 / number2;
    }

    enum Operation {
        PLUS, MINUS, MULTIPLES, DIVIDES;
    }


}
