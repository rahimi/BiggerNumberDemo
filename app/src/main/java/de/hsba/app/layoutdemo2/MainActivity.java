package de.hsba.app.layoutdemo2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int rightNumber = createRandomNumber();
    int leftNumber = createRandomNumber();
    int scoreNumber = 0;

    Button leftButton;
    Button rightButton;
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View v = findViewById(R.id.leftButton);
        leftButton = (Button)v;
        leftButton.setText(""+leftNumber);
        v = findViewById(R.id.rightButton);
        rightButton = (Button)v;
        rightButton.setText(""+rightNumber);
        v = findViewById(R.id.score);
        score = (TextView)v;
        score.setText(""+scoreNumber);
    }

    public static int createRandomNumber(){
        Random random = new Random();
        return random.nextInt(100);
    }

    public void randomize(){
        rightButton.setText("");
        rightNumber = createRandomNumber();
        rightButton.setText(""+rightNumber);

        leftButton.setText("");
        leftNumber = createRandomNumber();
        leftButton.setText(""+leftNumber);
    }

    public void rightBtnClick(View view) {
        if(rightNumber > leftNumber){
            scoreNumber++; // scoreNumber = scoreNumber + 1;
        }else{
            scoreNumber--; // scoreNumber = scoreNumber - 1;
        }
        score.setText(""+scoreNumber);
        randomize();
    }

    public void leftBtnClick(View view) {
        if(rightNumber < leftNumber){
            scoreNumber++; // scoreNumber = scoreNumber + 1;
        }else{
            scoreNumber--; // scoreNumber = scoreNumber - 1;
        }
        score.setText(""+scoreNumber);
        randomize();
    }
}