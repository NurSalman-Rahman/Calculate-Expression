package com.example.calculateexpression;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.concurrent.BlockingDeque;


public class MainActivity extends AppCompatActivity {

    private TextView resultTV;
    private EditText expressionET;
    private Button submitBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    /*    Expression e = new ExpressionBuilder("5+5")
                .variables("x", "y")
                .build()
                .setVariable("x", 2.3)
                .setVariable("y", 3.14);
        double result = e.evaluate();
        Log.d("salman", "onCreate: "+result);*/

        initComponent();
        initListener();
    }

    private void initListener() {
        submitBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = expressionET.getText().toString();
                if (!value.isEmpty()) {
                    try {
                        resultTV.setText(String.valueOf(new ExpressionBuilder(value).build().evaluate()));
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Please check your input !!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Enter The Expression!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initComponent() {
        submitBTN = findViewById(R.id.submit_btn);
        resultTV = findViewById(R.id.result_id);
        expressionET = findViewById(R.id.expression_id);
    }
}