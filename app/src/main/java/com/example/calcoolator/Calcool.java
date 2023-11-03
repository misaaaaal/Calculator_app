package com.example.calcoolator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calcool extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcool);

        EditText e1=(EditText) findViewById(R.id.ed1);
        EditText e2=(EditText) findViewById(R.id.ed2);
        EditText res=(EditText) findViewById(R.id.result);

        Button b1=(Button) findViewById(R.id.plus);
        Button b2=(Button) findViewById(R.id.minus);
        Button b3=(Button) findViewById(R.id.mul);
        Button b4=(Button) findViewById(R.id.div);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int a=Integer.parseInt(e1.getText().toString());
                int b=Integer.parseInt(e2.getText().toString());
                int c=a+b;

                res.setText(Integer.toString(c));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt(e1.getText().toString());
                int b=Integer.parseInt(e2.getText().toString());
                int c=a-b;

                res.setText(Integer.toString(c));
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt(e1.getText().toString());
                int b=Integer.parseInt(e2.getText().toString());
                int c=a*b;
                System.out.println(c);
                res.setText(Integer.toString(c));
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a=Integer.parseInt(e1.getText().toString());
                int b=Integer.parseInt(e2.getText().toString());
                int c=a/b;

                res.setText(Integer.toString(c));
            }
        });
    }
}
