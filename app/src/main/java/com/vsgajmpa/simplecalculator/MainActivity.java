package com.vsgajmpa.simplecalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements MathContract.View {

    private EditText inputNumber1;
    private EditText inputNumber2;

    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMultiples;
    private Button buttonDivides;

    private Button buttonClean;
    private TextView textResult;

    private MathContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber1 = findViewById(R.id.input_first_number);
        inputNumber2 = findViewById(R.id.input_second_number);

        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonMultiples = findViewById(R.id.button_multiples);
        buttonDivides = findViewById(R.id.button_divides);

        buttonClean = findViewById(R.id.button_clean);
        textResult = findViewById(R.id.text_result);

        presenter = new MathPresenter(this, new MathModel());

        buttonPlusListener();
        buttonMinusListener();
        buttonMultiplesListener();
        buttonDividesListener();
        buttonCleanListener();
    }

    private void buttonPlusListener() {
        buttonPlus.setOnClickListener(v -> presenter.calculateResult(
                MathModel.Operation.PLUS,
                inputNumber1.getText().toString().trim(),
                inputNumber2.getText().toString().trim()));
    }

    private void buttonMinusListener() {
        buttonMinus.setOnClickListener(v -> presenter.calculateResult(
                MathModel.Operation.MINUS,
                inputNumber1.getText().toString().trim(),
                inputNumber2.getText().toString().trim()));
    }

    private void buttonMultiplesListener() {
        buttonMultiples.setOnClickListener(v -> presenter.calculateResult(
                MathModel.Operation.MULTIPLES,
                inputNumber1.getText().toString().trim(),
                inputNumber2.getText().toString().trim()));
    }

    private void buttonDividesListener() {
        buttonDivides.setOnClickListener(v -> presenter.calculateResult(
                MathModel.Operation.DIVIDES,
                inputNumber1.getText().toString().trim(),
                inputNumber2.getText().toString().trim()));
    }


    private void buttonCleanListener() {
        buttonClean.setOnClickListener(v -> presenter.cleanNumber());
    }

    @Override
    public void reset() {
        inputNumber1.setText("");
        inputNumber2.setText("");
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void result(String result) {
        textResult.setText(result);
    }
}