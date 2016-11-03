package csi.fhict.org.gamegadget;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;

public class BasicTimer extends Activity {
    Chronometer mChronometer;
    private long lastPause;
    private long Reset = 0;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_basic_timer);

        Button button;

        mChronometer = (Chronometer) findViewById(R.id.chronometer);


        // Watch for button clicks.
        button = (Button) findViewById(R.id.start);
        if(button != null) {
            button.setOnClickListener(mStartListener);
        }
        button = (Button) findViewById(R.id.stop);
        if(button != null) {
            button.setOnClickListener(mStopListener);
        }
        button = (Button) findViewById(R.id.reset);
        if(button != null) {
            button.setOnClickListener(mResetListener);
        }

    }

    OnClickListener mStartListener = new OnClickListener() {
        public void onClick(View v) {
            Button button = (Button) findViewById(R.id.start);
            button.setEnabled(false);
            if (Reset == 1) {
                mChronometer.setBase(mChronometer.getBase() + SystemClock.elapsedRealtime() - lastPause);
                mChronometer.start();

            }
            else{
                mChronometer.start();

            }
        }
    };

    OnClickListener mStopListener = new OnClickListener() {
        public void onClick(View v) {
            lastPause = SystemClock.elapsedRealtime();
            mChronometer.stop();
            Reset = 1;
            Button button = (Button) findViewById(R.id.start);
            button.setEnabled(true);
        }
    };

    OnClickListener mResetListener = new OnClickListener() {
        public void onClick(View v) {
            mChronometer.setBase(SystemClock.elapsedRealtime());
            Reset = 0;
        }
    };

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();

    }
}