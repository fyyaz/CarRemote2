package com.yoyohoneysingh.fyyaz.carremote2;

import android.graphics.ImageFormat;
import android.hardware.ConsumerIrManager;
import android.media.Image;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int[] fwdCode = {
            169,168,21,63,21,63,21,63,21,21,21,21,21,21,21,21,21,21,21,63,21,63,21,63,21,21,21,21,21,21,21,21,21,21,21,21,21,63,21,21,21,21,21,21,21,21,21,21,21,21,21,64,21,21,21,63,21,63,21,63,21,63,21,63,21,63,21,1794,169,168,21,21,21,3694
    };
    private final int[] revCode = {
            546,1638,546,1638,546,1638,546,546,546,546,546,546,546,546,546,546,546,1638,546,1638,546,1638,546,546,546,546,546,546,546,546,546,546,546,546,546,1638,546,546,546,546,546,546,546,546,546,546,546,546,546,1664,546,546,546,1638,546,1638,546,1638,546,1638,546,1638,546,1638,546,46644,4394,4368,546,546,546,96044
    };
    private final int[]l_fwdCode = {

    };
    private final int FREQUENCY = 38000;
    final String DEBUG = "debug";
    private ImageButton fwd, rev, l_fwd, r_fwd,r_rev,l_rev;
    private Button brake;
    private ConsumerIrManager IRTransmitter;
    private void init() {
        IRTransmitter = (ConsumerIrManager)getSystemService(CONSUMER_IR_SERVICE);
        fwd = (ImageButton)findViewById(R.id.forward);
        fwd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "car is moving forwards", Toast.LENGTH_SHORT).show();
                IRTransmitter.transmit(FREQUENCY, fwdCode);
            }
        });
        rev = (ImageButton)findViewById(R.id.down);
        rev.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "car is moving backwards", Toast.LENGTH_SHORT).show();
                IRTransmitter.transmit(FREQUENCY, revCode);
            }
        });
        l_fwd = (ImageButton)findViewById(R.id.L_FWD);
        l_fwd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "car is turning left", Toast.LENGTH_SHORT).show();
            }
        });
        r_fwd = (ImageButton)findViewById(R.id.R_FWD);
        r_fwd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "car is turning right", Toast.LENGTH_SHORT).show();
            }
        });
        r_rev = (ImageButton)findViewById(R.id.R_REV);
        r_rev.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "car is reversing right", Toast.LENGTH_SHORT).show();
            }
        });
        l_rev = (ImageButton)findViewById(R.id.L_REV);
        l_rev.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "car is reversing left", Toast.LENGTH_SHORT).show();
            }
    });
        brake = (Button)findViewById(R.id.button);
        brake.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "car is stopped", Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();//initialize the buttons and shit
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
}
