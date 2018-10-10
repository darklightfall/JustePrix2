package com.example.darkbook.therightprice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TimeUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    int target;
    int input=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        target = (int) (Math.random()*100);
        Log.d("","target :"+target);


        ImageButton btn0 = findViewById(R.id.btn0);
        ImageButton btn1 = findViewById(R.id.btn1);
        ImageButton btn2 = findViewById(R.id.btn2);
        ImageButton btn3 = findViewById(R.id.btn3);
        ImageButton btn4 = findViewById(R.id.btn4);
        ImageButton btn5 = findViewById(R.id.btn5);
        ImageButton btn6 = findViewById(R.id.btn6);
        ImageButton btn7 = findViewById(R.id.btn7);
        ImageButton btn8 = findViewById(R.id.btn8);
        ImageButton btn9 = findViewById(R.id.btn9);

        Button btnCancel = findViewById(R.id.buttonC);
        btnCancel.setOnClickListener(cancel);

        btn0.setOnClickListener(myClickListener);
        btn1.setOnClickListener(myClickListener);
        btn2.setOnClickListener(myClickListener);
        btn3.setOnClickListener(myClickListener);
        btn4.setOnClickListener(myClickListener);
        btn5.setOnClickListener(myClickListener);
        btn6.setOnClickListener(myClickListener);
        btn7.setOnClickListener(myClickListener);
        btn8.setOnClickListener(myClickListener);
        btn9.setOnClickListener(myClickListener);


    }
    View.OnClickListener myClickListener;

    {
        myClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                EditText textInput = findViewById(R.id.editText);
                ImageView img = (ImageView) findViewById(R.id.imageView);
                String tag = (String) v.getContentDescription();
                textInput.append(tag);
                input = Integer.parseInt(textInput.getText().toString());
                if ((target - input) < 0) {
                    img.setImageResource(R.drawable.minus);
                } else if ((target - input) > 0) {
                    img.setImageResource(R.drawable.plus);
                } else {
                    img.setImageResource(android.R.color.transparent);
                    textInput.setText("BRAVO !");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                        target = (int) Math.random() * 100;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Log.d("", "tag : " + tag);
                // your stuff
            }
        };
    }
            View.OnClickListener cancel;

            {
                cancel = new View.OnClickListener() {
                    public void onClick(View v) {
                        EditText textInput = findViewById(R.id.editText);
                        String str= textInput.getText().toString();
                        ImageView img = findViewById(R.id.imageView);
                        if (str != null && str.length() > 0) {
                            str = str.substring(0, str.length() - 1);
                        }
                        if ((target-input) < 0)
                        {
                            img.setImageResource(R.drawable.minus);
                        }else if ((target-input) > 0)
                        {
                            img.setImageResource(R.drawable.plus);
                        }else
                        {
                            img.setImageResource(android.R.color.transparent);
                            textInput.setText("BRAVO !");
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            target = (int)(Math.random()*100);
                            str="";
                        }
                        textInput.setText(str);
                        // your stuff
                    }
                };
    }

}
