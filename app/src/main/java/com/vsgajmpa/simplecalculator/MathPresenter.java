package com.vsgajmpa.simplecalculator;

public class MathPresenter implements MathContract.Presenter {

    private final MathContract.View view;
    private final MathModel model;

    public MathPresenter(MathContract.View view, MathModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void calculateResult(MathModel.Operation operation, String number1, String number2) {
        if (checkNumber(number1, number2)) {
            calculate(operation, Integer.valueOf(number1), Integer.valueOf(number2));
        }
    }

    @Override
    public boolean checkNumber(String number1, String number2) {
        if (number1.isEmpty() && number2.isEmpty()) {
            view.showError("Angka pertama dan kedua harus di isi");
            return false;
        } else if (number1.isEmpty()) {
            view.showError("Angka pertama harus di isi");
            return false;
        } else if (number2.isEmpty()) {
            view.showError("Angka kedua harus di isi");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void cleanNumber() {
        view.reset();
    }

    private void calculate(MathModel.Operation operation, Integer number1, Integer number2) {
        model.setNumber1(number1);
        model.setNumber2(number2);

        switch (operation) {
            case PLUS: {
                view.result(model.plus().toString());
                break;
            }
            case MINUS: {
                view.result(model.minus().toString());
                break;
            }
            case MULTIPLES: {
                view.result(model.multiples().toString());
                break;
            }
            case DIVIDES: {
                try {
                    view.result(model.divide().toString());
                } catch (Exception e) {
                    view.showError("Angka kedua tidak boleh kosong");
                }
                break;
            }
            default:
                throw new IllegalArgumentException();
        }
    }


}
