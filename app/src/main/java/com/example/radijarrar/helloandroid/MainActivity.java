package com.example.radijarrar.helloandroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private int firstNumber;
    private int secondNumber;
    private int points = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.Generate();
    }

    /*
    * Generate the Random numbers and put them on the text buttons
    */
    public void Generate(){
        Random randomNumber = new Random();

        this.firstNumber = randomNumber.nextInt(9);
        this.secondNumber = randomNumber.nextInt(9);

        while(firstNumber == secondNumber)
        {
            firstNumber = randomNumber.nextInt(9);
        }

        Button leftButton = (Button)findViewById(R.id.buttonLeft);
        leftButton.setText("" + firstNumber);

        Button rightButton = (Button) findViewById(R.id.buttonRight);
        rightButton.setText("" + secondNumber);

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

    public void Compare(int firstNumber, int secondNumber){
        if (firstNumber > secondNumber)
        {
            points++;
            Toast.makeText(this, "Yep!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            points--;
            Toast.makeText(this, "Nope! Wrong!", Toast.LENGTH_LONG).show();
        }

        TextView textViewPoint = (TextView)findViewById(R.id.textViewPoint);
        textViewPoint.setText("Your points:" + points);

        this.Generate();
    }

    public void buttonLeft_Click(View view) {
        this.Compare(firstNumber, secondNumber);
    }

    public void buttonRight_Click(View view) {
        this.Compare(secondNumber, firstNumber);
    }
}
