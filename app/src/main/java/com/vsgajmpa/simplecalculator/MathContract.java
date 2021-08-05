package com.vsgajmpa.simplecalculator;

import java.math.BigDecimal;

public interface MathContract {

    interface View {
        void result(String result);

        void reset();

        void showError(String message);
    }

    interface Presenter {
        void calculateResult(MathModel.Operation operation, String number1, String number2);

        boolean checkNumber(String number1, String number2);

        void cleanNumber();
    }

}
