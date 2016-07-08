package rukina.learningschoolrl.activity.principal;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import rukina.learningschoolrl.R;
import rukina.learningschoolrl.activity.girls.s108;
import rukina.learningschoolrl.activity.office_and_library.s124_01;
import rukina.learningschoolrl.activity.paper.s91;
import rukina.learningschoolrl.activity.pencil.s22;
import rukina.learningschoolrl.activity.principal.s159;
import rukina.learningschoolrl.activity.table.s40;
import rukina.learningschoolrl.utils.CustomDialogClass;
import rukina.learningschoolrl.utils.s2;
import rukina.learningschoolrl.activity.chair.s3;
import rukina.learningschoolrl.activity.book.s57;
import rukina.learningschoolrl.activity.boys.s75;

/**
 * Created by Nandha on 14-01-2016.
 */
public class s175 extends AppCompatActivity {

    ImageView next, door, back, home;
    private MediaPlayer mp;
    TextView text1, text2, text3;
    TextView s175_1, s175_2, s175_3;
    private static int SPLASH_TIME_OUT = 1000;
    CustomDialogClass cdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s175);

        mp = new MediaPlayer();
        playTitle();

        next = (ImageView) findViewById(R.id.next);
        back = (ImageView) findViewById(R.id.back);
        home = (ImageView) findViewById(R.id.home);
        text1 = (TextView) findViewById(R.id.txt1);
        text2 = (TextView) findViewById(R.id.txt2);
        text3 = (TextView) findViewById(R.id.txt3);
        s175_1 = (TextView) findViewById(R.id.s175_1);
        s175_2 = (TextView) findViewById(R.id.s175_2);
        s175_3 = (TextView) findViewById(R.id.s175_3);

        text1.setVisibility(View.VISIBLE);
        Text1();

        s175_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                if (s175_1.getText().toString().charAt(0) == text1.getText().toString().charAt(0)) {
                    //playPerfect();
                    s175_1.setText("1.Principal Is the Head of the School and Organizes all the activities of the School\n");
                    s175_1.setVisibility(View.GONE);
                    text2.setVisibility(View.VISIBLE);
                    Text2();
                }
            }
        });
        s175_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                if (s175_2.getText().toString().charAt(0) == text2.getText().toString().charAt(0)) {
                    //playPerfect();
                    text2.setText("2. There books give more information on the lesson we have learnt in the library\n");
                    s175_2.setVisibility(View.GONE);
                    text3.setVisibility(View.VISIBLE);
                    Text3();
                }
            }
        });
        s175_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                if (s175_3.getText().toString().charAt(0) == text3.getText().toString().charAt(0)) {
                    //playPerfect();
                    text3.setText("3.We can use tray to   serve snacks and tea to guest at home");
                    s175_3.setVisibility(View.GONE);
                    playPerfect();
                    cdd = new CustomDialogClass(s175.this);
                    cdd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    cdd.show();

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
                                        wait(13000);
                                    }
                                } catch (InterruptedException ex) {
                                }

                                //finish();
                                if (mp.isPlaying()) {
                                    mp.stop();
                                }
                                Intent i = new Intent(getApplicationContext(),
                                        s176.class);
                                startActivity(i);
                                cdd.dismiss();
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
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                Intent i = new Intent(getApplicationContext(),
                        s176.class);
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                finish();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                Intent i = new Intent(getApplicationContext(),
                        s2.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                finish();
            }
        });

    }

    // Initiating Menu XML file (menu.xml)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_home:

                Intent Home = new Intent(getApplicationContext(),
                        s2.class);
                Home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(Home);
                finish();
                return true;
            case R.id.menu_chair:

                Intent Chair = new Intent(getApplicationContext(),
                        s3.class);
                Chair.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(Chair);
                return true;

            case R.id.menu_pencil:

                Intent Pencil = new Intent(getApplicationContext(),
                        s22.class);
                Pencil.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(Pencil);
                finish();
                return true;

            case R.id.menu_book:

                Intent Book = new Intent(getApplicationContext(),
                        s57.class);
                Book.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(Book);
                finish();
                return true;

            case R.id.menu_table:

                Intent Table = new Intent(getApplicationContext(),
                        s40.class);
                Table.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(Table);
                finish();
                return true;

            case R.id.menu_girls:

                Intent Girls = new Intent(getApplicationContext(),
                        s108.class);
                Girls.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(Girls);
                finish();
                return true;

            case R.id.menu_boys:

                Intent Boys = new Intent(getApplicationContext(),
                        s75.class);
                Boys.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(Boys);
                finish();
                return true;

            case R.id.menu_paper:

                Intent Paper = new Intent(getApplicationContext(),
                        s91.class);
                Paper.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(Paper);
                finish();
                return true;

            case R.id.menu_office:

                Intent OfficeAndLibrary = new Intent(getApplicationContext(),
                        s124_01.class);
                OfficeAndLibrary.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(OfficeAndLibrary);
                finish();
                return true;

            case R.id.menu_principal:

                Intent Principal = new Intent(getApplicationContext(),
                        s159.class);
                Principal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(Principal);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void playTitle() {

        mp.reset();// stops any current playing song
        mp = MediaPlayer.create(getApplicationContext(), R.raw.s175_1);// create's
        mp.start(); // starting mediaplayer
    }

    public void Text1() {

        mp.reset();// stops any current playing song
        mp = MediaPlayer.create(getApplicationContext(), R.raw.s175_2);// create's
        mp.start(); // starting mediaplayer
    }

    public void Text2() {

        mp.reset();// stops any current playing song
        mp = MediaPlayer.create(getApplicationContext(), R.raw.s175_2);// create's
        mp.start(); // starting mediaplayer
    }

    public void Text3() {

        mp.reset();// stops any current playing song
        mp = MediaPlayer.create(getApplicationContext(), R.raw.s175_3);// create's
        mp.start(); // starting mediaplayer
    }

    public void playPerfect() {

        mp.reset();// stops any current playing song
        mp = MediaPlayer.create(getApplicationContext(), R.raw.star);// create's
        mp.start(); // starting mediaplayer
    }

    public void playWrong() {

        mp.reset();// stops any current playing song
        mp = MediaPlayer.create(getApplicationContext(), R.raw.ouch);// create's
        mp.start(); // starting mediaplayer
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.release();
    }
}
