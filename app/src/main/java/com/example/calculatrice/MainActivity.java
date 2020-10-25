package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private int number1=0;
    private int number2=0;
    private boolean isOp1=true;
    private String operation= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculatrice);
        text = (TextView) findViewById(R.id.textView);

        Button btnEgal = (Button)findViewById(R.id.buttonEgal);

        btnEgal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculer();

            }
        });


    }
    private void afficher() {

        if(!isOp1) {
          if(number2==0){
              text.setText(number1+" "+operation+" ");


          }
          else  text.setText(number1+" "+operation+" "+number2);


        }
        else{ text.setText(" "+number1);


        }

    }
    public void clean(View v){
        text.setText("");
        operation="";
        number1=0;
        number2 =0;
        afficher();

    }
    public void calculer() {
        if(!isOp1){
            switch(operation) {
                case "+" : number1 = number1 + number2; break;
                case "-" : number1 = number1 - number2; break;
                case "*" : number1 = number1 * number2; break;
                case "/" : number1 = number1 / number2; break;
                default : return; // do nothing if no operator
            }
            number2 = 0;
            isOp1 = true;
            afficher();
        }

    }
    public void ajouterNbr(View v){

            int val = Integer.parseInt(((Button)v).getText().toString());
            if (isOp1) {
                number1 = number1 * 10 + val;
                afficher();
            } else {
                number2 = number2 * 10 + val;
                afficher();
            }

    }
    public void setOperator(View v) {
        switch (v.getId()) {
            case R.id.btnMul   : operation="*";  break;
            case R.id.buttonMoins : operation="-"; break;
            case R.id.buttonDiv : operation="/";  break;
            case R.id.buttonPlus    :operation="+";   break;
            default : return;

        }
        isOp1=false;
        afficher();
    }
}
