package com.example.assignment1_calculator_li_sun;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.DialogInterface;

import java.util.ArrayList;
import java.util.List;
import java.security.InvalidParameterException;
import java.text.NumberFormat;


public class MainActivity<onclick> extends AppCompatActivity implements View.OnClickListener {


    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button0;
    Button buttonPlus;
    Button buttonMinus;
    Button buttonTimes;
    Button buttonDivide;
    Button buttonClear;
    Button buttonEqual;
    Button buttonStandard;
    Button buttonAdvanced;
    TextView resultView;
    TextView history_View;

    Calculator calculator = new Calculator();
    AlertDialog.Builder builder;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       button1=findViewById(R.id.btn_one);
       button2=findViewById(R.id.btn_two);
       button3=findViewById(R.id.btn_three);
       button4=findViewById(R.id.btn_four);
       button5=findViewById(R.id.btn_five);
       button6=findViewById(R.id.btn_six);
       button7=findViewById(R.id.btn_seven);
       button8=findViewById(R.id.btn_eight);
       button9=findViewById(R.id.btn_nine);
       button0=findViewById(R.id.btn_zero);
       buttonPlus=findViewById(R.id.btn_plus);
       buttonMinus=findViewById(R.id.btn_minus);
       buttonTimes=findViewById(R.id.btn_times);
       buttonDivide=findViewById(R.id.btn_divide);
       buttonClear=findViewById(R.id.btn_clear);
       buttonEqual=findViewById(R.id.btn_equal);
       buttonStandard=findViewById(R.id.btn_standard);
       buttonAdvanced=findViewById(R.id.btn_advance);
       history_View=findViewById(R.id.historyView);
       resultView=findViewById(R.id.result);
       resultView.setText(" ");
        builder = new AlertDialog.Builder(this);
        //outlet
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonTimes.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonStandard.setOnClickListener(this);
        buttonAdvanced.setOnClickListener(this);
    }

      @Override
    public void onClick(View v) {
        if(v==buttonEqual) {
            try{
                int  total = calculator.calculate();
                String new_result = (String) resultView.getText();
                String buttonText=((Button) v).getText().toString();
                String operationViewItem=new_result+buttonText+total;
                resultView.setText(operationViewItem);

                String historyShow=calculator.getHistory();
                history_View.setText(historyShow);

            }

            catch(InvalidParameterException e){
                builder.setMessage(e.getMessage() );
                builder.setTitle(R.string.errorMessage);
;
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d("Calculation App","in dialog ok button");
                        resultView.setText("");
                    }
                });
//                builder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Log.d("Calculation App","in dialog cancel button");
//                    }
//                });
                builder.show();
//                resultView.setText("");
            }

        }
        else if(v==buttonClear){
           resultView.setText(" ");
           calculator.clear();
        }
        else if(v==buttonStandard){
               resultView.setText("");
               Button buttonS=(Button)v;
               buttonS.setVisibility(View.GONE);
               buttonAdvanced.setVisibility(View.VISIBLE);
               history_View.setVisibility(View.INVISIBLE);
               calculator.setMode(0);


        } else if(v==buttonAdvanced){
               resultView.setText("");
               Button buttonS=(Button)v;
               buttonS.setVisibility(View.GONE);
               buttonStandard.setVisibility(View.VISIBLE);
               calculator.setMode(1);
               history_View.setVisibility(View.VISIBLE);
        }
        else{
            Button b=(Button)v;
            String buttonText=b.getText().toString();
            calculator.push(buttonText);
            String new_result = (String) resultView.getText();

            resultView.setText(new_result+" "+buttonText);
            //history_View.setText(new_result+" "+buttonText);
        }

    }
}