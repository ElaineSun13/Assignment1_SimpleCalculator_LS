package com.example.assignment1_calculator_li_sun;

import java.util.ArrayList;

public class Calculator {

    ArrayList<String> inputs =new ArrayList<String>();
    int current_index = 0;
    ArrayList<Calculator> showHistory=new ArrayList<>();

    //operator type
    public static final String Add = "+";
    public static final String SUBTRACT = "-";
    public static final String TIMES = "*";
    public static final String Divide = "/";

    public static final String CLEAR = "C";

    public Calculator() {
        //mCalculatorHistory = 0;


    }



    public void push(String value){
        inputs.add(value);
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

        inputs.clear();

        return num1;
    }


    public static class CalculationManager { //app model
        //collection of calculations
        ArrayList<Calculator> listOfCalculations = new ArrayList<>(0);
        public ArrayList<Calculator> getListOfCalculations() {
            return listOfCalculations;
        }

        public void addNewCalculations(Calculator d){
            listOfCalculations.add(d);
        }

    }
}
