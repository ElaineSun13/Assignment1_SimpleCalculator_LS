package com.example.assignment1_calculator_li_sun;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    ArrayList<String> inputs =new ArrayList<String>();
    ArrayList<String> history=new ArrayList<>();
    int current_index = 0;
   ArrayList<Calculator> listOfCalculations=new ArrayList<>();


    public static final String CLEAR = "C";

    public Calculator() {
        //mCalculatorHistory = 0;
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

    int calculate(){
        int len = inputs.size();
        int num1= Integer.parseInt(inputs.get(0));
        int num2= 0;
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
                        num1 = num1 / num2;
                        break;

                }
            }
            i+=2;
        }
        String singleElement="";
        for(int j=0; j<inputs.size();j++){
            singleElement+=" "+ inputs.get(j);

        }
        singleElement=singleElement+"="+num1;
        history.add(singleElement);

        inputs.clear();


        return num1;
    }



}

