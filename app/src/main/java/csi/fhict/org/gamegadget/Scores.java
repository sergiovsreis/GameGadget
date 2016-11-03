package csi.fhict.org.gamegadget;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Scores extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        Button buttonplus1;
        buttonplus1 = (Button) findViewById(R.id.plus1);
        Button buttonplus2;
        buttonplus2 = (Button) findViewById(R.id.plus2);
        Button buttonplus3;
        buttonplus3 = (Button) findViewById(R.id.plus3);
        Button buttonplus4;
        buttonplus4 = (Button) findViewById(R.id.plus4);
        Button buttonminus1;
        buttonminus1 = (Button) findViewById(R.id.minus1);
        Button buttonminus2;
        buttonminus2 = (Button) findViewById(R.id.minus2);
        Button buttonminus3;
        buttonminus3 = (Button) findViewById(R.id.minus3);
        Button buttonminus4;
        buttonminus4 = (Button) findViewById(R.id.minus4);



        View.OnClickListener sPlus1Listener = new View.OnClickListener() {
            public void onClick(View v) {
                TextView score1 = (TextView) findViewById(R.id.score1);
                String score = score1.getText().toString();
                Integer Score = Integer.parseInt(score);
                Score++;
                score1.setText(Integer.toString(Score));
            }
        };
        View.OnClickListener sPlus2Listener = new View.OnClickListener() {
            public void onClick(View v) {
                TextView score1 = (TextView) findViewById(R.id.score2);
                String score = score1.getText().toString();
                Integer Score = Integer.parseInt(score);
                Score++;
                score1.setText(Integer.toString(Score));
            }
        };
        View.OnClickListener sPlus3Listener = new View.OnClickListener() {
            public void onClick(View v) {
                TextView score1 = (TextView) findViewById(R.id.score3);
                String score = score1.getText().toString();
                Integer Score = Integer.parseInt(score);
                Score++;
                score1.setText(Integer.toString(Score));
            }
        };
        View.OnClickListener sPlus4Listener = new View.OnClickListener() {
            public void onClick(View v) {
                TextView score1 = (TextView) findViewById(R.id.score4);
                String score = score1.getText().toString();
                Integer Score = Integer.parseInt(score);
                Score++;
                score1.setText(Integer.toString(Score));
            }
        };
        View.OnClickListener sMinus1Listener = new View.OnClickListener() {
            public void onClick(View v) {
                TextView score1 = (TextView) findViewById(R.id.score1);
                String score = score1.getText().toString();
                Integer Score = Integer.parseInt(score);
                Score--;
                score1.setText(Integer.toString(Score));
            }
        };
        View.OnClickListener sMinus2Listener = new View.OnClickListener() {
            public void onClick(View v) {
                TextView score1 = (TextView) findViewById(R.id.score2);
                String score = score1.getText().toString();
                Integer Score = Integer.parseInt(score);
                Score--;
                score1.setText(Integer.toString(Score));
            }
        };
        View.OnClickListener sMinus3Listener = new View.OnClickListener() {
            public void onClick(View v) {
                TextView score1 = (TextView) findViewById(R.id.score3);
                String score = score1.getText().toString();
                Integer Score = Integer.parseInt(score);
                Score--;
                score1.setText(Integer.toString(Score));
            }
        };
        View.OnClickListener sMinus4Listener = new View.OnClickListener() {
            public void onClick(View v) {
                TextView score1 = (TextView) findViewById(R.id.score4);
                String score = score1.getText().toString();
                Integer Score = Integer.parseInt(score);
                Score--;
                score1.setText(Integer.toString(Score));
            }
        };

        buttonplus1.setOnClickListener(sPlus1Listener);
        buttonplus2.setOnClickListener(sPlus2Listener);
        buttonplus3.setOnClickListener(sPlus3Listener);
        buttonplus4.setOnClickListener(sPlus4Listener);
        buttonminus1.setOnClickListener(sMinus1Listener);
        buttonminus2.setOnClickListener(sMinus2Listener);
        buttonminus3.setOnClickListener(sMinus3Listener);
        buttonminus4.setOnClickListener(sMinus4Listener);
    }
}