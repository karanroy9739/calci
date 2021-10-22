package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnAdd,btnMult,btnSub,btnDivide,btnEqual,btnClear,btnDel,btnDot;
TextView textViewResult,textViewHistory;
    Switch switchbtn;

    private String number = null;

    double firstNumber = 0;
    double lastNumber = 0;
    boolean eqlBtnClick=false;
    String status = null;
    boolean operator = false;

    DecimalFormat myFormatter = new DecimalFormat("######.######");

    String history, currentResult;

    boolean dot = true;

    boolean btnACcontrol = true;

    boolean btnEqualsControl = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btnAdd=findViewById(R.id.btnPlus);
        btnSub=findViewById(R.id.btnMinus);
        btnMult=findViewById(R.id.btnMulti);
        btnDivide=findViewById(R.id.btnDivide);
        btnEqual=findViewById(R.id.btnEqual);
        btnClear=findViewById(R.id.btnAC);
        btnDel=findViewById(R.id.btnDEL);
        btnDot=findViewById(R.id.btnDot);
        switchbtn=findViewById(R.id.switch1);
        textViewHistory=findViewById(R.id.textViewHistory);
        textViewResult=findViewById(R.id.textViewResult);
        Toast.makeText(MainActivity.this,"welcome!!",Toast.LENGTH_LONG).show();
        switchbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);

                }
                else{
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eqlBtnClick){
                    textViewHistory.setText("");
                    eqlBtnClick=false;
                }
                numberClick("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eqlBtnClick){
                    textViewHistory.setText("");
                    eqlBtnClick=false;
                }
                numberClick("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eqlBtnClick){
                    textViewHistory.setText("");
                    eqlBtnClick=false;
                }
                numberClick("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eqlBtnClick){
                    textViewHistory.setText("");
                    eqlBtnClick=false;
                }
                numberClick("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eqlBtnClick){
                    textViewHistory.setText("");
                    eqlBtnClick=false;
                }
                numberClick("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eqlBtnClick){
                    textViewHistory.setText("");
                    eqlBtnClick=false;
                }
                numberClick("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eqlBtnClick){
                    textViewHistory.setText("");
                    eqlBtnClick=false;
                }
                numberClick("6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eqlBtnClick){
                    textViewHistory.setText("");
                    eqlBtnClick=false;
                }
                numberClick("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eqlBtnClick){
                    textViewHistory.setText("");
                    eqlBtnClick=false;
                }
                numberClick("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eqlBtnClick){
                    textViewHistory.setText("");
                    eqlBtnClick=false;
                }
                numberClick("9");
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number = null;
                status = null;
                textViewResult.setText("");
                textViewHistory.setText("");
                firstNumber = 0;
                lastNumber = 0;
                dot = true;
                btnACcontrol = true;

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(number==null){
                    return;
                }
                if (btnACcontrol) {
                    textViewResult.setText("0");
                } else {
                    number = number.substring(0, number.length() - 1);
                    if (number.length() == 0) {
                        btnDel.setClickable(false);
                    } else if (number.contains(".")) {
                        dot = false;
                    } else {
                        dot = true;
                    }

                    textViewResult.setText(number);
                }


            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textViewResult.getText().toString().equals("0")||textViewResult.getText().toString().equals("")){
                    return;
                }



                if (operator) {
                    history = textViewHistory.getText().toString();
                    currentResult = textViewResult.getText().toString();
                    textViewHistory.setText(history + currentResult + "+");
                    if (status == "multiplacition") {
                        multiply();
                    } else if (status == "division") {
                        divide();
                    } else if (status == "subtraction") {
                        minus();
                    } else {
                        plus();
                    }
                }

                status = "sum";
                operator = false;
                number = null;

            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textViewResult.getText().toString().equals("0")||textViewResult.getText().toString().equals("")){
                    return;
                }



                if (operator) {
                    history = textViewHistory.getText().toString();
                    currentResult = textViewResult.getText().toString();
                    textViewHistory.setText(history + currentResult + "-");
                    if (status == "multiplacition") {
                        multiply();
                    } else if (status == "division") {
                        divide();
                    } else if (status == "sum") {
                        plus();
                    } else {
                        minus();
                    }
                }

                status = "subtraction";
                operator = false;
                number = null;

            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textViewResult.getText().toString().equals("0")||textViewResult.getText().toString().equals("")){
                    return;
                }


                if (operator) {
                    history = textViewHistory.getText().toString();
                    currentResult = textViewResult.getText().toString();
                    textViewHistory.setText(history + currentResult + "*");

                    if (status == "sum") {
                        plus();
                    } else if (status == "division") {
                        divide();
                    } else if (status == "subtraction") {
                        minus();
                    } else {
                        multiply();
                    }

                }

                status = "multiplacition";
                operator = false;
                number = null;

            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textViewResult.getText().toString().equals("0")||textViewResult.getText().toString().equals("")){
                    return;
                }


                if (operator) {
                    history = textViewHistory.getText().toString();
                    currentResult = textViewResult.getText().toString();
                    textViewHistory.setText(history + currentResult + "/");
                    if (status == "multiplacition") {
                        multiply();
                    } else if (status == "sum") {
                        plus();
                    } else if (status == "subtraction") {
                        minus();
                    } else {
                        divide();
                    }

                }

                status = "division";
                operator = false;
                number = null;

            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(textViewResult.getText().toString().equals("0")||textViewResult.getText().toString().equals("")){
                    return;
                }

                if (operator) {
                    eqlBtnClick=true;
                    if (status == "sum") {
                        plus();
                        textViewHistory.setText(textViewResult.getText().toString());
                        textViewResult.setText("");
                    } else if (status == "subtraction") {
                        minus();
                        textViewHistory.setText(textViewResult.getText().toString());
                        textViewResult.setText("");
                    } else if (status == "multiplacition") {
                        multiply();
                        textViewHistory.setText(textViewResult.getText().toString());
                        textViewResult.setText("");
                    } else if (status == "division") {
                        divide();
                        textViewHistory.setText(textViewResult.getText().toString());
                        textViewResult.setText("");
                    } else {
                        firstNumber = Double.parseDouble(textViewResult.getText().toString());
                    }
                }

                operator = false;
                btnEqualsControl = true;

            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (dot) {

                    if (number == null) {
                        number = "0.";
                    } else {
                        number = number + ".";
                    }

                }

                textViewResult.setText(number);
                dot = false;
            }
        });

    }

    public void numberClick(String view) {
        if (number == null) {
            number = view;
        } else if (btnEqualsControl) {
            firstNumber = 0;
            lastNumber = 0;
            number = view;
        } else {
            number = number + view;
        }

        textViewResult.setText(number);
        operator = true;
        btnACcontrol = false;
        btnDel.setClickable(true);
        btnEqualsControl = false;
    }

    public void plus() {
        lastNumber = Double.parseDouble(textViewResult.getText().toString());
        firstNumber = firstNumber + lastNumber;

        textViewResult.setText(myFormatter.format(firstNumber));
        dot = true;
    }

    public void minus() {
        if (firstNumber == 0) {
            firstNumber = Double.parseDouble(textViewResult.getText().toString());
        } else {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber - lastNumber;
        }

        textViewResult.setText(myFormatter.format(firstNumber));
        dot = true;
    }

    public void multiply() {
        if (firstNumber == 0) {
            firstNumber = 1;
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        } else {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }

        textViewResult.setText(myFormatter.format(firstNumber));
        dot = true;
    }

    public void divide() {
        if (firstNumber == 0) {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = lastNumber / 1;
        } else {
            lastNumber = Double.parseDouble(textViewResult.getText().toString());
            firstNumber = firstNumber / lastNumber;
        }

        textViewResult.setText(myFormatter.format(firstNumber));
        dot = true;
    }


}