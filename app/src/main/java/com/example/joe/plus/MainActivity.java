package com.example.joe.plus;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private TextView calculatorDisplay;
    private static final String DIGITS = "0123456789.";
    private boolean typing = false;



    DecimalFormat df = new DecimalFormat("@###########");

    Calculator brain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        brain = new Calculator();
        calculatorDisplay = (TextView) findViewById(R.id.calc_view);

        //Numbers
        findViewById(R.id.decimal).setOnClickListener(this);
        findViewById(R.id.zero).setOnClickListener(this);
        findViewById(R.id.one).setOnClickListener(this);
        findViewById(R.id.two).setOnClickListener(this);
        findViewById(R.id.three).setOnClickListener(this);
        findViewById(R.id.four).setOnClickListener(this);
        findViewById(R.id.five).setOnClickListener(this);
        findViewById(R.id.six).setOnClickListener(this);
        findViewById(R.id.seven).setOnClickListener(this);
        findViewById(R.id.eight).setOnClickListener(this);
        findViewById(R.id.nine).setOnClickListener(this);

        //Operators
        findViewById(R.id.plus).setOnClickListener(this);
        findViewById(R.id.minus).setOnClickListener(this);
        findViewById(R.id.mult).setOnClickListener(this);
        findViewById(R.id.div).setOnClickListener(this);
        findViewById(R.id.neg).setOnClickListener(this);
        findViewById(R.id.equals).setOnClickListener(this);
        findViewById(R.id.clear).setOnClickListener(this);
        findViewById(R.id.perc).setOnClickListener(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        String buttonPressed = ((Button) view).getText().toString();

        if (DIGITS.contains(buttonPressed)) {
            // digit was pressed
            if (typing) {
                calculatorDisplay.append(buttonPressed);
            } else {
                calculatorDisplay.setText(buttonPressed);
                typing = true;
            }
        } else{
            // operator was pressed
            if (typing) {
                brain.setOperand(Double.parseDouble(calculatorDisplay.getText().toString()));
                typing = false;
            }
            brain.performOperation(buttonPressed);
            calculatorDisplay.setText(df.format(brain.getResult()));
        }
    }
}