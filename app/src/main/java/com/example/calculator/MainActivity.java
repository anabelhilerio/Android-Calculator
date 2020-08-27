package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private  TextView topTextView;
    private String temp = "0";
    private String temp2 = "";
    private String operation;
    private  String answer;

    private View.OnClickListener createNumOnTextListener() {
        return new View.OnClickListener() {
            public void onClick(View v) {
                topTextView.setText(topTextView.getText().toString() + ((Button) v).getText());
            }
        };
    }

    private View.OnClickListener createOpOnTextListener(){
        return new View.OnClickListener() {
            public void onClick(View v) {
                temp = topTextView.getText().toString();
                if(temp.equals("")){
                    temp = "0";
                }
                topTextView.setText("");
                operation = ((Button) v).getText().toString();
            }
        };
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final GridLayout operations = findViewById(R.id.operations);

        final TextView bottomTextView = findViewById(R.id.bottom);
        topTextView = findViewById(R.id.equation);
        final Button oneButton = findViewById(R.id.number_one);
        final Button twoButton = findViewById(R.id.number_two);
        final Button threeButton = findViewById(R.id.number_three);
        final Button fourButton = findViewById(R.id.number_four);
        final Button fiveButton = findViewById(R.id.number_five);
        final Button sixButton = findViewById(R.id.number_six);
        final Button sevenButton = findViewById(R.id.number_seven);
        final Button eightButton = findViewById(R.id.number_eight);
        final ImageButton backspaceButton = findViewById(R.id.backspace);
        final Button nineButton = findViewById(R.id.number_nine);
        final Button zeroButton = findViewById(R.id.number_zero);
        final Button decimalButton = findViewById(R.id.decimal_point);

        final Button clearButton = findViewById(R.id.clear);
        final Button addButton = findViewById(R.id.add);
        final Button subButton = findViewById(R.id.minus);
        final Button multiplyButton = findViewById(R.id.multiply);
        final Button divButton = findViewById(R.id.division);
        final Button perctButton = findViewById(R.id.percent);
        final Button sinButton = findViewById(R.id.sin);
        final Button cosButton = findViewById(R.id.cos);
        final Button tanButton = findViewById(R.id.tan);
        final Button sqrtButton = findViewById(R.id.sqr_root);
        final Button equalButton = findViewById(R.id.equals);

        final Button standardButton = findViewById(R.id.standard);
        final Button financialButton = findViewById(R.id.financial);
        final Button scientificButton = findViewById(R.id.scientific);

        oneButton.setOnClickListener(createNumOnTextListener());
        twoButton.setOnClickListener(createNumOnTextListener());
        threeButton.setOnClickListener(createNumOnTextListener());
        fourButton.setOnClickListener(createNumOnTextListener());
        fiveButton.setOnClickListener(createNumOnTextListener());
        sixButton.setOnClickListener(createNumOnTextListener());
        sevenButton.setOnClickListener(createNumOnTextListener());
        eightButton.setOnClickListener(createNumOnTextListener());
        nineButton.setOnClickListener(createNumOnTextListener());
        zeroButton.setOnClickListener(createNumOnTextListener());
        decimalButton.setOnClickListener(createNumOnTextListener());

        //todo for backspacing testing and adding stuff : backspacing one
        backspaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                topTextView.setText(topTextView.getText().toString().substring(0,topTextView.length()-1));
            }
        });

        //todo clear screen
        clearButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                temp = "0";
                topTextView.setText("");
            }
        });

        addButton.setOnClickListener(createOpOnTextListener());
        subButton.setOnClickListener(createOpOnTextListener());
        multiplyButton.setOnClickListener(createOpOnTextListener());
        divButton.setOnClickListener(createOpOnTextListener());
        perctButton.setOnClickListener(createOpOnTextListener());

        sinButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                temp = topTextView.getText().toString();
                double degrees = Double.parseDouble(topTextView.getText().toString());
                double radians = Math.toRadians(degrees);
                double result = Math.sin(radians);
                answer = String.valueOf((long)result);
                topTextView.setText(answer);
                bottomTextView.setText(getString(R.string.sin_wrapper, temp));
            }
        });

        cosButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                temp = topTextView.getText().toString();
                double degrees = Double.parseDouble(topTextView.getText().toString());
                double radians = Math.toRadians(degrees);
                double result = Math.cos(radians);
                answer = String.valueOf((long)result);
                topTextView.setText(answer);
                bottomTextView.setText(getString(R.string.cos_wrapper, temp));
            }
        });

        tanButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                temp = topTextView.getText().toString();
                double degrees = Double.parseDouble(topTextView.getText().toString());
                double radians = Math.toRadians(degrees);
                double result = Math.tan(radians);
                answer = String.valueOf((long)result);
                topTextView.setText(answer);
                bottomTextView.setText(getString(R.string.tan_wrapper, temp));
            }
        });
        sqrtButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                temp = topTextView.getText().toString();
                answer = String.valueOf(Math.sqrt(Double.parseDouble(temp)));
                topTextView.setText(answer);
                bottomTextView.setText(getString(R.string.sqrt_wrapper, temp));
            }
        });

        equalButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(operation.equals("+")){
                    temp2 = topTextView.getText().toString();
                    answer = String.valueOf(Double.parseDouble(temp) + Double.parseDouble(topTextView.getText().toString()));
                    topTextView.setText(answer);
                    bottomTextView.setText(getString(R.string.add_wrapper, temp,temp2));
                }
                else if(operation.equals("-")){
                    answer = String.valueOf(Double.parseDouble(temp) - Double.parseDouble(topTextView.getText().toString()));
                    topTextView.setText(answer);
                    //bottomTextView.setText(getString(R.string.add_wrapper, temp,temp2));
                }
                else if(operation.equals("x")){
                    answer = String.valueOf(Double.parseDouble(temp) * Double.parseDouble(topTextView.getText().toString()));
                    topTextView.setText(answer);
                }
                else if(operation.equals("/")){
                    answer = String.valueOf(Double.parseDouble(temp) / Double.parseDouble(topTextView.getText().toString()));
                    topTextView.setText(answer);
                }
                else{
                    answer = String.valueOf((Double.parseDouble(temp) / 100) * Double.parseDouble(topTextView.getText().toString()));
                    topTextView.setText(answer);
                    //bottomTextView.setText();
                }
            }
        });

        standardButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                perctButton.setVisibility(View.INVISIBLE);
                sinButton.setVisibility(View.INVISIBLE);
                cosButton.setVisibility(View.INVISIBLE);
                tanButton.setVisibility(View.INVISIBLE);
                sqrtButton.setVisibility(View.INVISIBLE);
            }
        });

        financialButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                perctButton.setVisibility(View.VISIBLE);
                sinButton.setVisibility(View.INVISIBLE);
                cosButton.setVisibility(View.INVISIBLE);
                tanButton.setVisibility(View.INVISIBLE);
                sqrtButton.setVisibility(View.INVISIBLE);
            }
        });

        scientificButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                perctButton.setVisibility(View.VISIBLE);
                sinButton.setVisibility(View.VISIBLE);
                cosButton.setVisibility(View.VISIBLE);
                tanButton.setVisibility(View.VISIBLE);
                sqrtButton.setVisibility(View.VISIBLE);
            }
        });
    }
}