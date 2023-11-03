package com.example.calcoolator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import com.google.android.material.button.MaterialButton;
import android.widget.EditText;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class calculator extends AppCompatActivity implements View.OnClickListener{

    MaterialButton b0, b1, b2,b3,b4,b5,b6,b7,b8,b9;
    MaterialButton plus,minus,div,mul,mod;
    MaterialButton clear,leftp,rightp,equals,point,ac;
    TextView res, ans;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        res=(TextView) findViewById(R.id.result);
        ans=(TextView) findViewById(R.id.answer);

        assignId(b0, R.id.zero);
        assignId(b1, R.id.one);
        assignId(b2, R.id.two);
        assignId(b3, R.id.three);
        assignId(b4, R.id.four);
        assignId(b5, R.id.five);
        assignId(b6, R.id.six);
        assignId(b7, R.id.seven);
        assignId(b8, R.id.eight);
        assignId(b9, R.id.nine);
        assignId(plus, R.id.plus);
        assignId(minus, R.id.minus);
        assignId(mul, R.id.mul);
        assignId(div, R.id.div);
        assignId(mod, R.id.mod);
        assignId(clear, R.id.clear);
        assignId(leftp, R.id.leftp);
        assignId(rightp, R.id.rightp);
        assignId(equals, R.id.equals);
        assignId(point, R.id.point);
        assignId(ac, R.id.ac);
    }

    void assignId(MaterialButton btn, int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton btn=(MaterialButton) view;
        String s=btn.getText().toString();      /*button pressed*/
        String expn=res.getText().toString();   /*string in textview res*/
        if(s.equals("AC")){
            ans.setText("");
            res.setText("");
            return;
        }
        else if(s.equals("C")){
            expn=expn.substring(0, expn.length()-1);
        }
        else if(s.equals("=")){
            res.setText(ans.getText());
            return;
        }
        else {
            expn=expn+s;
        }
        res.setText(expn);
        String finalres=calcres(expn);
        if(!finalres.equals("Error!")){
            ans.setText(finalres);
        }
    }

    String calcres(String s){
        try{
            Context context=Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable=context.initStandardObjects();
            String f=context.evaluateString(scriptable,s,"Javascript", 1, null).toString();
            if(f.endsWith(".0")){
                f=f.replace(".0", "");
            }
            return f;
        }catch(Exception e){
            return "Error!";
        }
    }
}