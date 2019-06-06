package com.aunico.os.textbookapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    private TextSwitcher switcher,switcherradio1,switcherradio2,switcherradio3,switcherradio4;
    private Button btnprevious,btnnext;
    private static final String[] text={"question1","question2","question3"};
    private int mposition=-1;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);

        btnprevious=(Button)findViewById(R.id.btnprevious);
        btnnext=(Button)findViewById(R.id.btnnext);


        switcher=(TextSwitcher)findViewById(R.id.switcher);
        switcherradio1=(TextSwitcher)findViewById(R.id.switcherradio1);
        switcherradio2=(TextSwitcher)findViewById(R.id.switcherradio2);
        switcherradio3=(TextSwitcher)findViewById(R.id.switcherradio3);
        switcherradio4=(TextSwitcher)findViewById(R.id.switcherradio4);

        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView textView=new TextView(MainActivity.this);
                textView.setTextSize(18);

//                RadioButton radioButton=new RadioButton(MainActivity.this);
//                radioButton.setTextSize(18);
                return textView;
            }
        });




        switcherradio1.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                RadioButton radioButton=new RadioButton(MainActivity.this);
                radioButton.setTextSize(10);
                return radioButton;
            }
        });


        switcherradio2.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                RadioButton radioButton=new RadioButton(MainActivity.this);
                radioButton.setTextSize(10);
                return radioButton;
            }
        });

        switcherradio3.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                RadioButton radioButton=new RadioButton(MainActivity.this);
                radioButton.setTextSize(10);
                return radioButton;
            }
        });


        switcherradio4.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {

                RadioButton radioButton=new RadioButton(MainActivity.this);
                radioButton.setTextSize(10);
                return radioButton;
            }
        });
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mposition<(text.length-1))
                {
                    mposition=mposition+1;
                    switcher.setText(text[mposition]);
                    switcherradio1.setText(text[mposition]);
                    switcherradio2.setText(text[mposition]);
                    switcherradio3.setText(text[mposition]);
                    switcherradio4.setText(text[mposition]);

                }
            }
        });

        btnprevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mposition>0)
                {
                    mposition=mposition-1;
                    switcher.setText(text[mposition]);
                    switcherradio1.setText(text[mposition]);
                    switcherradio2.setText(text[mposition]);
                    switcherradio3.setText(text[mposition]);
                    switcherradio4.setText(text[mposition]);

                }
            }
        });

    }
}
