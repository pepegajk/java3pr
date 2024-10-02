package com.example.calculate;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private String currentInput = "";
    private String operator = "";
    private double firstOperand = 0;
    private boolean isNewOperation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
    }


    public void onNumberClick(View view) {
        if (isNewOperation) {
            tvResult.setText("");
            isNewOperation = false;
        }

        Button button = (Button) view;
        currentInput += button.getText().toString();
        tvResult.setText(currentInput);
    }


    public void onOperationClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        firstOperand = Double.parseDouble(tvResult.getText().toString());
        currentInput = "";
        isNewOperation = true;
    }


    public void onEqualClick(View view) {
        double secondOperand = Double.parseDouble(tvResult.getText().toString());
        double result = 0;

        switch (operator) {
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand - secondOperand;
                break;
            case "*":
                result = firstOperand * secondOperand;
                break;
            case "/":
                result = firstOperand / secondOperand;
                break;
        }

        tvResult.setText(new DecimalFormat("0.#####").format(result));
        isNewOperation = true;
    }


    public void onLogClick(View view) {
        double value = Double.parseDouble(tvResult.getText().toString());
        double result = Math.log10(value);
        tvResult.setText(new DecimalFormat("0.#####").format(result));
        isNewOperation = true;
    }


    public void onSqrtClick(View view) {
        double value = Double.parseDouble(tvResult.getText().toString());
        double result = Math.sqrt(value);
        tvResult.setText(new DecimalFormat("0.#####").format(result));
        isNewOperation = true;
    }


    public void onPowerClick(View view) {
        firstOperand = Double.parseDouble(tvResult.getText().toString());
        currentInput = "";
        operator = "^";
        isNewOperation = true;
    }


    public void onPercentClick(View view) {
        double value = Double.parseDouble(tvResult.getText().toString());
        double result = value / 100;
        tvResult.setText(new DecimalFormat("0.#####").format(result));
        isNewOperation = true;
    }


    public void onClearClick(View view) {
        tvResult.setText("0");
        currentInput = "";
        firstOperand = 0;
        operator = "";
        isNewOperation = true;
    }


    public void onDotClick(View view) {
        if (!currentInput.contains(".")) {
            currentInput += ".";
            tvResult.setText(currentInput);
        }
    }
}