package com.example.badow.iz_2_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText eTC;
    EditText eTF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTC = (EditText)findViewById(R.id.eCelsjusz);
        eTF = (EditText)findViewById(R.id.eFahrenheit);

        final Button button = (Button) findViewById(R.id.bPotwierdz);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(eTC.isClickable())
                {
                    double tempCelsjusz;
                    tempCelsjusz = Double.parseDouble(String.valueOf(eTC.getText()));
                    double tempFahrenheit = 9.0/5.0 * tempCelsjusz + 32;
                    eTF.setText(Double.toString(tempFahrenheit), TextView.BufferType.EDITABLE);
                }

                if(eTF.isClickable())
                {
                    double tempFahrenheit;
                    tempFahrenheit = Double.parseDouble(String.valueOf(eTF.getText()));
                    double tempCelsjusz = (tempFahrenheit-32)*5/9;
                    eTC.setText(Double.toString(tempCelsjusz), TextView.BufferType.EDITABLE);
                }

            }
        });
    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();


        switch(view.getId()) {
            case R.id.rbCelsjusz:
                if (checked)
                {
                    eTC.setFocusable(true);
                    eTC.setFocusableInTouchMode(true);
                    eTC.setClickable(true);
                    eTC.setBackgroundColor(Color.GREEN);

                    eTF.setFocusable(false);
                    eTF.setFocusableInTouchMode(false);
                    eTF.setClickable(false);
                    eTF.setBackgroundColor(Color.RED);
                }
                break;
            case R.id.rbFahrenheit:
                if (checked)
                {
                    eTF.setFocusable(true);
                    eTF.setFocusableInTouchMode(true);
                    eTF.setClickable(true);
                    eTF.setBackgroundColor(Color.GREEN);

                    eTC.setFocusable(false);
                    eTC.setFocusableInTouchMode(false);
                    eTC.setClickable(false);
                    eTC.setBackgroundColor(Color.RED);
                }
                break;
        }
    }

}
