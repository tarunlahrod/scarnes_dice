package com.example.dabba.scarnes_dice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public int counterUser = 0, counterComp = 0, totalUser = 0, totalComp = 0, rollval;
    TextView scoreU, scoreC,msgL,msgW, scrCurComp,scrCurUsr;
    ImageView d1, d2, d3, d4, d5, d6;
    Button roll, reset, hold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scrCurComp = (TextView) findViewById(R.id.cscrC);
        scrCurUsr = (TextView) findViewById(R.id.cscrU);
        scoreU = (TextView) findViewById(R.id.User);
        scoreC = (TextView) findViewById(R.id.Comp);
        msgL = (TextView) findViewById(R.id.msgL);
        msgW = (TextView) findViewById(R.id.msgW);
        d1 = (ImageView) findViewById(R.id.d1);
        d2 = (ImageView) findViewById(R.id.d2);
        d3 = (ImageView) findViewById(R.id.d3);
        d4 = (ImageView) findViewById(R.id.d4);
        d5 = (ImageView) findViewById(R.id.d5);
        d6 = (ImageView) findViewById(R.id.d6);
        roll = (Button) findViewById(R.id.roll);
        reset = (Button) findViewById(R.id.reset);
        hold = (Button) findViewById(R.id.hold);
    }

    public void display(int rno) {
        switch (rno) {
            case 1:
                d6.setVisibility(View.INVISIBLE);
                d5.setVisibility(View.INVISIBLE);
                d4.setVisibility(View.INVISIBLE);
                d3.setVisibility(View.INVISIBLE);
                d2.setVisibility(View.INVISIBLE);
                d1.setVisibility(View.VISIBLE);
                scoreC.setText("" + totalComp);
                scrCurComp.setText(""+ counterComp);
                scoreU.setText("" + totalUser);
                scrCurUsr.setText(""+ counterUser);
                break;

            case 2:
                d6.setVisibility(View.INVISIBLE);
                d5.setVisibility(View.INVISIBLE);
                d4.setVisibility(View.INVISIBLE);
                d3.setVisibility(View.INVISIBLE);
                d2.setVisibility(View.VISIBLE);
                d1.setVisibility(View.INVISIBLE);
                scoreC.setText("" + totalComp);
                scoreU.setText("" + totalUser);
                scrCurUsr.setText(""+ counterUser);
                scrCurComp.setText(""+ counterComp);
                break;

            case 3:
                d6.setVisibility(View.INVISIBLE);
                d5.setVisibility(View.INVISIBLE);
                d4.setVisibility(View.INVISIBLE);
                d3.setVisibility(View.VISIBLE);
                d2.setVisibility(View.INVISIBLE);
                d1.setVisibility(View.INVISIBLE);
                scoreC.setText("" + totalComp);
                scoreU.setText("" + totalUser);
                scrCurUsr.setText(""+ counterUser);
                scrCurComp.setText(""+ counterComp);
                break;

            case 4:
                d6.setVisibility(View.INVISIBLE);
                d5.setVisibility(View.INVISIBLE);
                d4.setVisibility(View.VISIBLE);
                d3.setVisibility(View.INVISIBLE);
                d2.setVisibility(View.INVISIBLE);
                d1.setVisibility(View.INVISIBLE);
                scoreC.setText("" + totalComp);
                scoreU.setText("" + totalUser);
                scrCurUsr.setText(""+ counterUser);
                scrCurComp.setText(""+ counterComp);
                break;

            case 5:
                d6.setVisibility(View.INVISIBLE);
                d5.setVisibility(View.VISIBLE);
                d4.setVisibility(View.INVISIBLE);
                d3.setVisibility(View.INVISIBLE);
                d2.setVisibility(View.INVISIBLE);
                d1.setVisibility(View.INVISIBLE);
                scoreC.setText("" + totalComp);
                scoreU.setText("" + totalUser);
                scrCurUsr.setText(""+ counterUser);
                scrCurComp.setText(""+ counterComp);
                break;

            case 6:
                d6.setVisibility(View.VISIBLE);
                d5.setVisibility(View.INVISIBLE);
                d4.setVisibility(View.INVISIBLE);
                d3.setVisibility(View.INVISIBLE);
                d2.setVisibility(View.INVISIBLE);
                d1.setVisibility(View.INVISIBLE);
                scoreC.setText("" + totalComp);
                scoreU.setText("" + totalUser);
                scrCurUsr.setText(""+ counterUser);
                scrCurComp.setText(""+ counterComp);
                break;
        }
    }

   public void ROLL(View view)
    {
        Random r = new Random();
        rollval = r.nextInt(6)+1;
        turn(1);
    }

    public int getrol() {
        return rollval;
    }

    public void HOLD(View view)
    {
        counterUser=0;
     turn(2);
    }

    public void RESET(View view) {
        counterUser = 0;
        counterComp = 0;
        totalUser = 0;
        totalComp = 0;
        scrCurUsr.setText("0");
        scrCurComp.setText("0");
        scoreU.setText("0");
        scoreC.setText("0");
        msgL.setText(" ");
        msgW.setText(" ");
    }

    public void turn(int t) {

        while (totalComp <= 100 || totalUser <= 100) {

            if (t % 2 == 1)  // user's turn
            {
                int roll = getrol();
                if (roll == 1) {
                    t++;
                    break;
                }

                totalUser = totalUser + roll;
                counterUser = counterUser + roll;
                display(roll);
                break;

            } else {
                Random r = new Random();
                int roll = r.nextInt(6) + 1;
                if (roll == 1)
                    break;
                totalComp = totalComp + roll;
                counterComp = counterComp + roll;
                display(roll);
            }

        }
        if (totalComp > 100) {
            roll.setEnabled(false);
            hold.setEnabled(false);
            msgL.setText("You Lose!");
        } else if (totalUser > 100) {
            roll.setEnabled(false);
            hold.setEnabled(false);
            msgW.setText("You Win!");

        }


    }

}
