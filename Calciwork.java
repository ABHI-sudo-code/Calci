package com.example.android.calculator1;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Calciwork extends AppCompatActivity{

    private EditText usersInputBox;
    private ImageButton backspace;
    private EditText History;
    private Button btnClear;
    private Button btnDivide;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnMultiply;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnMinus;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnPlus;
    private Button btnZero;
    private Button btnEqual;
    private Button btnhistory;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calci);
        List<String> historye= new ArrayList<>();
        Stack<String> stack = new Stack<String>();
        //sets up the user interface views
        setupUI();
        //clear all text in users input
        usersInputBox.setText("");

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gets the cursors position
                int cursorPosEnd = usersInputBox.getSelectionEnd();
                int textLength = usersInputBox.getText().length();

                if (cursorPosEnd != 0 && textLength != 0){
                    SpannableStringBuilder selection = (SpannableStringBuilder) usersInputBox.getText();
                    selection.replace(cursorPosEnd - 1, cursorPosEnd, "");
                    //updates the text
                    usersInputBox.setText(selection);
                    //puts the cursor back in the correct spot
                    usersInputBox.setSelection(cursorPosEnd - 1);
                }
            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("0", usersInputBox.getText().toString(), pos));
                usersInputBox.setSelection(pos + 1);
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("1", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("2", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("3", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("4", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("5", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("6", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("7", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("8", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("9", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usersInputBox.setText("");
            }
        });





        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String expression = usersInputBox.getText().toString();

                expression = expression.replaceAll("÷", "/");
                expression = expression.replaceAll("×", "*");

                Expression exp = new Expression(expression);

                 String result = String.valueOf(exp.calculate());
                usersInputBox.setText(result);

                usersInputBox.setSelection(result.length());
                historye.add(String.valueOf(expression));
                stack.push(expression);

            }
        });

        btnhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(historye.isEmpty()){

                }else{
                    if(stack.empty()){
                        usersInputBox.setText("");
                    }else{
                        usersInputBox.setText(stack.pop());
                    }

                }

            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("÷", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("×", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("-", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = usersInputBox.getSelectionStart();
                usersInputBox.setText(updateText("+", usersInputBox.getText().toString(), usersInputBox.getSelectionStart()));
                usersInputBox.setSelection(pos + 1);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupUI(){
        usersInputBox = findViewById(R.id.textView);
        usersInputBox.setShowSoftInputOnFocus(false);   //used to prevent the users keyboard from popping up but keeps the carrot
       History = findViewById(R.id.textView);
        backspace = findViewById(R.id.backspace);

        btnClear = findViewById(R.id.clear);


        btnDivide = findViewById(R.id.divide);
        btnSeven = findViewById(R.id.seven);
        btnEight = findViewById(R.id.eight);
        btnNine = findViewById(R.id.nine);
        btnMultiply = findViewById(R.id.multiply);
        btnFour = findViewById(R.id.four);
        btnFive = findViewById(R.id.five);
        btnSix = findViewById(R.id.six);
        btnMinus = findViewById(R.id.minus);
        btnOne = findViewById(R.id.one);
        btnTwo = findViewById(R.id.two);
        btnThree = findViewById(R.id.three);
        btnPlus = findViewById(R.id.add);
        btnZero = findViewById(R.id.zero);
        btnEqual = findViewById(R.id.equals);
        btnhistory = findViewById(R.id.history);
    }

    private String updateText(String stringToAdd, String oldString, int cursorPos){
        String leftOfCursor = oldString.substring(0, cursorPos);
        String rightOfCursor = oldString.substring(cursorPos);

        return leftOfCursor + stringToAdd + rightOfCursor;

    }
}

