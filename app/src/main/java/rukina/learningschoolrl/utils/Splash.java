package rukina.learningschoolrl.utils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by Nandha on 16-12-2015.
 */
public class Splash extends Activity{

    private static int SPLASH_TIME_OUT = 3500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Typewriter writer = new Typewriter(this);
        setContentView(writer);

        //Add a character every 150ms
        writer.setCharacterDelay(150);
        writer.setTextSize(30);
        writer.setTextColor(Color.DKGRAY);
        writer.setGravity(Gravity.CENTER);
        writer.animateText("Learning School...");

        try {
            new Handler().postDelayed(new Runnable() {

				/*
				 * Showing splash screen with a timer. This will be useful when
				 * you want to show case your app logo / company
				 */

                @Override
                public void run() {
                    // This method will be executed once the timer is over
                    // Start your app main activity
                    try {
                        synchronized (this) {
                            // Wait given period of time or exit on touch
                            new Thread(new Runnable() {

                                @Override
                                public void run() {
                                    // TODO Auto-generated method stub
                                    try {

                                        Thread.sleep(0);

                                    } catch (InterruptedException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }

                                }
                            }).start();
                            wait(2000);
                        }
                    } catch (InterruptedException ex) {
                    }

                    finish();
                    Intent i = new Intent(Splash.this,
                            MainActivity.class);
                    startActivity(i);
                }
            }, SPLASH_TIME_OUT);
        } catch (OutOfMemoryError e) {
            Toast.makeText(
                    getApplicationContext(),
                    "Your phone memory is too low, free your cache memory and start the application",
                    Toast.LENGTH_LONG).show();
        }
    }
}
