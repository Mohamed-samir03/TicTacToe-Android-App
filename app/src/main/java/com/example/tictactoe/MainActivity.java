package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tv_player;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    int player = 1;
    int buttonStates[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_player = findViewById(R.id.tv_player);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);

        addListenerToButton();

        buttonStates=new int[]{0,0,0,0,0,0,0,0,0};

    }

    private void addListenerToButton() {

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button1:
                checkWinner(0,view);
                break;
            case R.id.button2:
                checkWinner(1,view);
                break;
            case R.id.button3:
                checkWinner(2,view);
                break;
            case R.id.button4:
                checkWinner(3,view);
                break;
            case R.id.button5:
                checkWinner(4,view);
                break;
            case R.id.button6:
                checkWinner(5,view);
                break;
            case R.id.button7:
                checkWinner(6,view);
                break;
            case R.id.button8:
                checkWinner(7,view);
                break;
            case R.id.button9:
                checkWinner(8,view);
                break;
        }

    }

    private void checkWinner(int i,View v) {

        changeText(v,i);
        if(buttonStates[i] == 0){
            buttonStates[i] = player;
        }
        if((buttonStates[0]==player && buttonStates[1]==player && buttonStates[2]==player) ||
                (buttonStates[0]==player && buttonStates[3]==player && buttonStates[6]==player) ||
                (buttonStates[0]==player && buttonStates[4]==player && buttonStates[8]==player) ||
                (buttonStates[1]==player && buttonStates[4]==player && buttonStates[7]==player) ||
                (buttonStates[2]==player && buttonStates[5]==player && buttonStates[8]==player) ||
                (buttonStates[6]==player && buttonStates[7]==player && buttonStates[8]==player) ||
                (buttonStates[3]==player && buttonStates[4]==player && buttonStates[5]==player) ||
                (buttonStates[2]==player && buttonStates[4]==player && buttonStates[6]==player)){
            showAlertDialog();
        }

    }

    private void showAlertDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        int win;
        if(player == 1){
            win = 2;
        }else{
            win = 1;
        }
        builder.setTitle("Player : "+win+"  Win 🤩🎉")
                .setMessage("Want to play again?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        recreate();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private void changeText(View view,int i) {

        Button selectedButton = (Button) view;
        if(buttonStates[i] == 0) {
            if (player == 1) {
                selectedButton.setBackgroundResource(R.drawable.x);
                player = 2;
            } else {
                selectedButton.setBackgroundResource(R.drawable.o);
                player = 1;
            }
            tv_player.setText("Player : " + player);
        }

    }
}