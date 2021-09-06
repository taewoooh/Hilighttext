package com.example.hilighttext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    Button next;

    EditText et;

    TextView tv;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        et = (EditText) findViewById(R.id.editText);

        tv = (TextView) findViewById(R.id.textView);

        tv.setText("The name of our country is Bangladesh. Bangladesh is a land of rivers.");



        next = (Button) findViewById(R.id.button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                tv.setText("The name of our country is Bangladesh. Bangladesh is a land of rivers.");

                String ett = et.getText().toString();

                String tvt = tv.getText().toString();



                int ofe = tvt.indexOf(ett, 0);

                Spannable WordtoSpan = new SpannableString(tv.getText());



                for (int ofs = 0; ofs < tvt.length() && ofe != -1; ofs = ofe + 1) {

                    ofe = tvt.indexOf(ett, ofs);

                    if (ofe == -1)

                        break;

                    else {

                        WordtoSpan.setSpan(new BackgroundColorSpan(0xFFFFFF00), ofe, ofe + ett.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                        tv.setText(WordtoSpan, TextView.BufferType.SPANNABLE);

                    }

                }

            }

        });


    }
}
