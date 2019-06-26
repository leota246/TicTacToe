package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static Button button_00, button_01, button_02, button_10, button_11, button_12, button_20, button_21, button_22;
    static TextView score1, score2;
    static Button newgame,btnUser,clearscore;
    static int turn, s1, s2,set;
    static String p1 = "X";
    static String p2 = "O";
    private String user = "";
    private EditText user1,user2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_00 = (Button) findViewById(R.id.button_00);
        clicked(button_00);

        button_01 = (Button) findViewById(R.id.button_01);
        clicked(button_01);

        button_02 = (Button) findViewById(R.id.button_02);
        clicked(button_02);

        button_10 = (Button) findViewById(R.id.button_10);
        clicked(button_10);

        button_11 = (Button) findViewById(R.id.button_11);
        clicked(button_11);

        button_12 = (Button) findViewById(R.id.button_12);
        clicked(button_12);

        button_20 = (Button) findViewById(R.id.button_20);
        clicked(button_20);

        button_21 = (Button) findViewById(R.id.button_21);
        clicked(button_21);

        button_22 = (Button) findViewById(R.id.button_22);
        clicked(button_22);

        newgame = (Button) findViewById(R.id.newgame);
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });

        clearscore=(Button)findViewById(R.id.clearscore);
        clearscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearScore();
            }
        });
        score1 = (TextView) findViewById(R.id.score1);
        score2 = (TextView) findViewById(R.id.score2);

        user1 = (EditText) findViewById(R.id.pl1);
        user2 = (EditText) findViewById(R.id.pl2);

        btnUser = findViewById(R.id.btnUser);
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Enter Your Name:");

                // Set up the input
                final EditText input = new EditText(MainActivity.this);

                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (user1.getText().toString().equals("Player 1:"))

                            user1.setText(input.getText().toString());
                        else user2.setText(input.getText().toString());

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which){
                            dialog.cancel();
                        }

                });

                builder.show();
            }
            });
    }

    public void clicked(final Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (turn % 2 == 0) {
                    button.setText(p1);
                } else {
                    button.setText(p2);
                }
                if (button_00.getText().equals(button_01.getText()) && button_01.getText().equals(button_02.getText())) {
                    whoWon(button_00);
                }if (button_00.getText().equals(button_10.getText()) && button_10.getText().equals(button_20.getText())) {
                    whoWon(button_00);
                }if (button_10.getText().equals(button_11.getText()) && button_11.getText().equals(button_12.getText())) {
                    whoWon(button_10);
                }if (button_20.getText().equals(button_21.getText()) && button_21.getText().equals(button_22.getText())) {
                    whoWon(button_20);
                }if (button_01.getText().equals(button_11.getText()) && button_11.getText().equals(button_21.getText())) {
                    whoWon(button_01);
                }if (button_02.getText().equals(button_12.getText()) && button_12.getText().equals(button_22.getText())) {
                    whoWon(button_02);
                }if (button_00.getText().equals(button_11.getText()) && button_11.getText().equals(button_22.getText())) {
                    whoWon(button_00);
                }if (button_02.getText().equals(button_11.getText()) && button_11.getText().equals(button_20.getText())) {
                    whoWon(button_02);
                }
                button.setClickable(false);
                turn++;
                ++set;
                if (set==10){
                    final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Sorry")
                            .setMessage("It's a tie!")
                            .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    clear();
                                }
                            });
                    AlertDialog alert = builder.create();
                    alert.show();
                    set=0;
                }
            }
        });
    }

    public static void clear() {
        button_00.setText("");
        button_00.setClickable(true);
        button_01.setText("");
        button_01.setClickable(true);
        button_02.setText("");
        button_02.setClickable(true);
        button_10.setText("");
        button_10.setClickable(true);
        button_11.setText("");
        button_11.setClickable(true);
        button_12.setText("");
        button_12.setClickable(true);
        button_20.setText("");
        button_20.setClickable(true);
        button_21.setText("");
        button_21.setClickable(true);
        button_22.setText("");
        button_22.setClickable(true);
    }


    public void whoWon(Button button) {
        if (button.getText().equals(p1)) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Congratulation!")
                    .setMessage("Player 1 Won")
                    .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            clear();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
            score1.setText(Integer.toString(++s1));
            set=0;
            button_00.setClickable(false);
            button_01.setClickable(false);
            button_02.setClickable(false);
            button_10.setClickable(false);
            button_11.setClickable(false);
            button_12.setClickable(false);
            button_20.setClickable(false);
            button_21.setClickable(false);
            button_22.setClickable(false);
        } else if (button.getText().equals(p2)) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Congratulation!")
                    .setMessage("Player 2 Won")
                    .setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            clear();
                        }
                    });
            AlertDialog alert = builder.create();
            alert.show();
            score2.setText(Integer.toString(++s2));
            set=0;
            button_00.setClickable(false);
            button_01.setClickable(false);
            button_02.setClickable(false);
            button_10.setClickable(false);
            button_11.setClickable(false);
            button_12.setClickable(false);
            button_20.setClickable(false);
            button_21.setClickable(false);
            button_22.setClickable(false);
        }
    }
    public void clearScore(){
        score1.setText("0");
        score2.setText("0");
    }
}