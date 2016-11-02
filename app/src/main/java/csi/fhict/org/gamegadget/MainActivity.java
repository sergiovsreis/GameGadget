package csi.fhict.org.gamegadget;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private static final String[]paths = {"Dungeons and Dragons", "Magic: The Gathering", "Bier Pong"};

    private Firebase mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                whenSelected(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        mRef = new Firebase("https://gamegadget-35933.firebaseio.com/");
        Firebase mRefChild = mRef.child("1");
        mRefChild.setValue("4");

        Firebase mRefChild2 = mRef.child("2");
        mRefChild2.setValue("1");


    }
    public void whenSelected(int position){

        switch (position) {
            case 0:
                Log.i("test1", "test1");
                break;
            case 1:
                Intent intent = new Intent(this, Dice.class);
                startActivity(intent);
                break;
            case 2:
                Log.i("test2", "test2");
                break;

        }
    }
}
