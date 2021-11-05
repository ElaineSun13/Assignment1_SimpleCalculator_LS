package com.example.assignment1_calculator_li_sun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


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
    //CalculatorManager calculatorManager;


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


        //CalculatorManager calculatorManager=new CalculatorManager();

    }


    @Override
    public void onClick(View v) {


        if(v==buttonEqual) {
            //String data = ((Button) v).getText().toString();


            int total = calculator.calculate();
            String new_result = (String) resultView.getText();
            String buttonText=((Button) v).getText().toString();
            String historyViewItem=new_result+buttonText+total;
            resultView.setText(historyViewItem);
        }
        else if(v==buttonClear){

           resultView.setText(" ");

        }
        else if(v==buttonStandard){
            Button buttonS=(Button)v;
            buttonS.setVisibility(View.GONE);
            buttonAdvanced.setVisibility(View.VISIBLE);

        }
        else if(v==buttonAdvanced){

            int total = calculator.calculate();
            String new_result = (String) resultView.getText();
            String buttonText=((Button) v).getText().toString();
            String historyViewItem=new_result+buttonText+total;
           // calculatorManager.addNewCalculations(calculator);
            //builder.create();



            //history_View.append(historyViewItem);

        }
        else{
            Button b=(Button)v;
            String buttonText=b.getText().toString();
            calculator.push(buttonText);
            String new_result = (String) resultView.getText();

            resultView.setText(new_result+" "+buttonText);
        }

    }
}