package com.sandwichwizard.sandwichguys.sandwichwizard;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Activity for shaking the phone to get a random sandwich.
 * Currently depends on a sandwich text file to be functional.
 *
 * @author Ogden Greene
 *
 */
public class ShakerActivity extends ActionBarActivity {
    SandwichMenu sandwichMenu;

    private Animation animWiz;
    private Animation animSpin;
    private ShakeDetector mShakeDetector;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private long shakeTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shaker);

        // create animations
        animWiz = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.flip);
        animSpin = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.spinin);

        sandwichMenu = new SandwichMenu(R.raw.sandwich_ingredients, this);

        shakeTime = System.currentTimeMillis();
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector(new OnShakeListener() {
            @Override
            public void onShake() {
                // avoid accidental double-shakes
                if (System.currentTimeMillis() - shakeTime > 1350) {
                    shakeTime = System.currentTimeMillis();
                    // wizardsound!
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.wizardtone);
                    mp.start();
                    // wizardflip!
                    findViewById(R.id.imageView).startAnimation(animWiz);
                    // get and show random sandwich
                    Sandwich randsand = sandwichMenu.getSandwich();
                    ((TextView) findViewById(R.id.randomSandwich)).setText(randsand.getName());
                    // eventually will get corresponding picture (TODO)
                    ((ImageView) findViewById(R.id.imageView2)).setImageResource(randsand.getPicture());
                    findViewById(R.id.imageView2).startAnimation(animSpin);
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shaker, menu);
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

    // Register and unregister listener
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }
}
