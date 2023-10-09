package com.example.bmiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button btnCalculate;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        LinearLayout llMain = findViewById(R.id.llMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn = ft * 12 + in;
                double totalCM = totalIn * 2.59;
                double totalM = totalCM / 100;
                double bmi = wt / (totalM * totalM);

                if(bmi > 25){
                    txtResult.setText("You are Overweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.overweight));
                } else if (bmi < 18) {
                    txtResult.setText("you are Underweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.underweight));
                } else {
                    txtResult.setText("You are healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.healthy));
                }
            }
        });


    }
}