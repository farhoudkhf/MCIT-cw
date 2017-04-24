package com.bignerdranch.android.mciotcw_t04;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocationListener;
import com.indooratlas.android.sdk.IALocationManager;
import com.indooratlas.android.sdk.IALocationRequest;

public class MainActivity extends AppCompatActivity {

    IALocationManager mIALocationManager;


    private String TAG;
    IALocationListener mIALocationListener = new IALocationListener() {

        //private String TAG;

        // Called when the location has changed.
        @Override
        public void onLocationChanged(IALocation location) {
            TextView t4tx = (TextView) findViewById(R.id.textView4);
            t4tx.setText(String.valueOf(location.getLatitude() + ", " + location.getLongitude()));

//            log(String.format(Locale.US, "%f,%f, accuracy: %.2f, certainty: %.2f",
//                    location.getLatitude(), location.getLongitude(), location.getAccuracy(),
//                    location.getFloorCertainty()));

//            Log(location.getLatitude())

            Log.d(TAG, "Latitude: " + location.getLatitude());
            Log.d(TAG, "Longitude: " + location.getLongitude());

            double long_Tag = location.getLatitude();

           // Toast.makeText(long_Tag)
        }

        public void onStatusChanged(String s, int i, Bundle boundle){

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIALocationManager = IALocationManager.create(this);

        Log.d(TAG, "onCreat(Bundle) called");
    }




    @Override
    protected void onResume() {
        super.onResume();
        mIALocationManager.requestLocationUpdates(IALocationRequest.create(), mIALocationListener);


    }

    @Override
    protected void onPause() {
        super.onPause();
        mIALocationManager.removeLocationUpdates(mIALocationListener);
    }

    @Override
    protected void onDestroy() {
        mIALocationManager.destroy();
        super.onDestroy();
    }

    //...
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
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
