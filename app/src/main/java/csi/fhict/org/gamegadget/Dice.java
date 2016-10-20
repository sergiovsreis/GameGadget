package csi.fhict.org.gamegadget;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.Random;

public class Dice extends Activity {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);


        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (button.getText() == "1 Die") {
                    button.setText("2 Dice");
                    ImageView image = (ImageView) findViewById(R.id.imageView2);
                    image.setVisibility(View.INVISIBLE);
                }else{
                    button.setText("1 Die");
                    ImageView image = (ImageView) findViewById(R.id.imageView2);
                    image.setVisibility(View.VISIBLE);
                }
            }
        });



        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake() {
                rotateDice();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        randomDice((ImageView) findViewById(R.id.imageView));
                        randomDice((ImageView) findViewById(R.id.imageView2));
                    }
                }, 1000);
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,
                SensorManager.SENSOR_DELAY_UI);

    }

    @Override
    public void onPause() {

        super.onPause();
        mSensorManager.unregisterListener(mShakeDetector);

    }

    private void rotateDice() {

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
        final Button button = (Button) findViewById(R.id.button);

        if(button.getText() == "2 Dice") {
            ImageView image = (ImageView) findViewById(R.id.imageView);
            image.startAnimation(animation);
        }else{
            ImageView image = (ImageView) findViewById(R.id.imageView);
            ImageView image2 = (ImageView) findViewById(R.id.imageView2);
            image.startAnimation(animation);
            image2.startAnimation(animation);
        }
        Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = {300,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        vibe.vibrate(pattern, -1);

        MediaPlayer mPlayer = MediaPlayer.create(Dice.this, R.raw.dice);
        mPlayer.start();

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });




    }



    private void randomDice(ImageView image)
    {
        Random rand = new Random();
        int  n = rand.nextInt(6) + 1;



        switch(n){
            case 1:  image.setImageResource(R.drawable.d1);
                break;
            case 2:  image.setImageResource(R.drawable.d2);
                break;
            case 3:  image.setImageResource(R.drawable.d3);
                break;
            case 4:  image.setImageResource(R.drawable.d4);
                break;
            case 5:  image.setImageResource(R.drawable.d5);
                break;
            case 6:  image.setImageResource(R.drawable.d6);
                break;
        }
    }



}
