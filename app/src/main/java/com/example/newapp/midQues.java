package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class midQues extends AppCompatActivity {


    Button btnCheck1, btnCheck2, btnCheck3, btnToNext, btnToPrev;


    RadioButton[] answers = new RadioButton[9];
    List<RadioButton[]> groups = new ArrayList<RadioButton[]>();
    int[] correctAnswerID = new int[answers.length / 3];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mid_ques);
        init();

        setOnClick(btnCheck1, 0);
        setOnClick(btnCheck2, 1);
        setOnClick(btnCheck3, 2);


        btnToNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(midQues.this, hardQues.class));
            }
        });
        btnToPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(midQues.this, MainActivity.class));
            }
        });




    }


    public boolean isCorrect(int answerNum, int questionNum){
        return correctAnswerID[questionNum] == answerNum;
    }
    private  void setOnClick(Button btn, int numQues){


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton curAnswer = answers[(numQues * correctAnswerID.length) + correctAnswerID[numQues]];
                RadioButton[] curQues = groups.get(numQues);
                for(int i = 0; i < curQues.length; i++){
                    curQues[i].setTextColor(isCorrect(i, numQues)
                            ? Color.rgb(0, 255, 0)
                            : Color.rgb(255, 0, 0));
                }


            }
        });
    }

    public void init(){
        answers[0] = findViewById(R.id.radioButton0);
        answers[1] = findViewById(R.id.radioButton1);
        answers[2] = findViewById(R.id.radioButton2);

        answers[3] = findViewById(R.id.radioButton3);
        answers[4] = findViewById(R.id.radioButton4);
        answers[5] = findViewById(R.id.radioButton5);

        answers[6] = findViewById(R.id.radioButton6);
        answers[7] = findViewById(R.id.radioButton7);
        answers[8] = findViewById(R.id.radioButton8);

        btnCheck1 = findViewById(R.id.button1);
        btnCheck2 = findViewById(R.id.button2);
        btnCheck3 = findViewById(R.id.button3);

        correctAnswerID[0] = 0;
        correctAnswerID[1] = 0;
        correctAnswerID[2] = 1;

        btnToNext = findViewById(R.id.button8);
        btnToPrev = findViewById(R.id.button7);

        groups.add(new RadioButton[]{answers[0], answers[1], answers[2]});
        groups.add(new RadioButton[]{answers[3], answers[4], answers[5]});
        groups.add(new RadioButton[]{answers[6], answers[7], answers[8]});


    }
}