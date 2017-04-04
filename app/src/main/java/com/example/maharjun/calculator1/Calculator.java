package com.example.maharjun.calculator1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {

    String finalValue = "";
    int count =0;
    TextView button1;
    TextView button2;
    TextView button3;
    TextView button4;
    TextView button5;
    TextView button6;
    TextView button7;
    TextView button8;
    TextView button9;
    TextView button0;
    TextView divideOperator;
    TextView plusOperator;
    TextView minusOperator;
    TextView multiplyOperator;
    TextView pointOperator;
    TextView deleteOperator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        createAndClickNumbers();
        createAndClickOperators();
        createAndClickOnDelete();

    }

    private void createAndClickOnDelete() {
        deleteOperator = (TextView) findViewById(R.id.textView);
        deleteOperator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalValue = getString(R.string.emptyString);
                TextView finalText = (TextView) findViewById(R.id.textView18);
                finalText.setText(finalValue);
            }
        });
    }

    private void createAndClickOperators() {
        divideOperator = (TextView) findViewById(R.id.textView2);
        pointOperator = (TextView) findViewById(R.id.textView11);
        plusOperator = (TextView) findViewById(R.id.textView5);
        minusOperator = (TextView) findViewById(R.id.textView4);
        multiplyOperator = (TextView) findViewById(R.id.textView3);
        clickOperator(divideOperator);
        clickOperator(plusOperator);
        clickOperator(minusOperator);
        clickOperator(multiplyOperator);
        clickOperator(pointOperator);
    }

    private void clickOperator(final TextView operator) {
        operator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = finalValue.length() - 1;
                if(finalValue.charAt(length) != '-' || finalValue.charAt(length) != '+' || finalValue.charAt(length) != 'X' || finalValue.charAt(length) != (char)246){
                    count++;
                    finalValue += (String) operator.getText();
                }
                TextView finalText = (TextView) findViewById(R.id.textView18);
                finalText.setText(finalValue);
            }
        });
    }

    private void createAndClickNumbers() {

        button1 = (TextView) findViewById(R.id.textView13);
        button2 = (TextView) findViewById(R.id.textView14);
        button3 = (TextView) findViewById(R.id.textView15);
        button4 = (TextView) findViewById(R.id.textView9);
        button5 = (TextView) findViewById(R.id.textView10);
        button6 = (TextView) findViewById(R.id.textView12);
        button7 = (TextView) findViewById(R.id.textView6);
        button8 = (TextView) findViewById(R.id.textView7);
        button9 = (TextView) findViewById(R.id.textView8);
        button0 = (TextView) findViewById(R.id.textView16);

        clickbutton(button1);
        clickbutton(button2);
        clickbutton(button3);
        clickbutton(button4);
        clickbutton(button5);
        clickbutton(button6);
        clickbutton(button7);
        clickbutton(button8);
        clickbutton(button9);
        clickbutton(button0);
    }

    public void clickbutton(final TextView button){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalValue += (String) button.getText();
                if(count==1){
                    Double sum = 0.0;
                    int characterIndex = finalValue.indexOf('+');
                    Log.e("index",finalValue);
                    Double operator = Double.valueOf(finalValue.substring(0, characterIndex - 1));
                    int length = finalValue.length();
                    Double operand = Double.valueOf(finalValue.substring(characterIndex+1, length - 1));
                    if(finalValue.charAt(characterIndex) == '+'){
                        sum = operand + operator;
                    }
                    TextView sumText = (TextView) findViewById(R.id.textView19);
                    sumText.setText("" + sum);

                }
                TextView finalText = (TextView) findViewById(R.id.textView18);
                finalText.setText(finalValue);
            }
        });
    }
}
