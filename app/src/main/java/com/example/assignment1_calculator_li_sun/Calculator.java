package com.example.assignment1_calculator_li_sun;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.security.InvalidParameterException;
import java.text.NumberFormat;

public class Calculator {

    ArrayList<String> inputs =new ArrayList<String>();
    ArrayList<String> history=new ArrayList<>();
    int mode; // 0: basic, 1: advance

    public Calculator() {
        mode = 0;
    }

    public  void setMode(int mode) {
        this.mode = mode;
        history.clear();
    }


    public void push(String value){
        inputs.add(value);
    }

    public String getHistory(){
        String historyResult="";
        for(int i=0; i<history.size();i++){
            historyResult+=history.get(i)+"\n";

        }
        return historyResult;

    }

    public void clear() {
        inputs.clear();
    }

    int calculate() {
        int len = inputs.size();
        int num1, num2;
        //validate num1: it must be an integer, otherwise throw an error
        try {
            num1= Integer.parseInt(inputs.get(0));
        } catch (Exception e) {
            inputs.clear();
            throw new InvalidParameterException("The first input must be a number");
        }

        int i = 1;
        while (i<len) {
            char op = inputs.get(i).charAt(0);
            if(op =='+'||op =='-' ||op =='*'||op =='/'||op=='C') {
                num2 = Integer.parseInt(inputs.get(i + 1));

                switch (op) {
                    case '+':
                        num1 = num1 + num2;
                        break;
                    case '-':
                        num1 = num1 - num2;
                        break;
                    case '*':
                        num1 = num1 * num2;
                        break;
                    case '/':

                        if(num2!=0)  {
                            num1 = num1 / num2;
                            break;
                        } else {
                            inputs.clear();
                            throw new InvalidParameterException("Argument:'The divisor' cannot be 0");
                        }
                }
            }
            else {
                inputs.clear();
                throw new InvalidParameterException("The expected input is '+,or -,or *,or /', but got " + op+ " . All operands must be one digit.");
            }
            i+=2;
        }
        //advance with history
        if( mode == 1) {
            String singleElement="";
            for(int j=0; j<inputs.size();j++){
                singleElement+=" "+ inputs.get(j);

            }
            singleElement = singleElement + "=" + num1;
            history.add(singleElement);
        }

        inputs.clear();


        return num1;
    }



}

