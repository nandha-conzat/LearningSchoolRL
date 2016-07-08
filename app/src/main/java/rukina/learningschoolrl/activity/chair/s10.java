package rukina.learningschoolrl.activity.chair;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
public class s10 extends AppCompatActivity {

    ImageView drag, next, back, home;
    RelativeLayout s10_1, s10_2, s10_3;
    TextView dispaly;
    private MediaPlayer mp;
    private static int SPLASH_TIME_OUT = 1000;
    CustomDialogClass cdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s10);
        System.gc();

        mp = new MediaPlayer();
        playTitle();

        drag = (ImageView) findViewById(R.id.drag);
        s10_1 = (RelativeLayout) findViewById(R.id.s10_1);
        s10_2 = (RelativeLayout) findViewById(R.id.s10_2);
        s10_3 = (RelativeLayout) findViewById(R.id.s10_3);
        dispaly = (TextView) findViewById(R.id.txt_dispaly);
        next = (ImageView) findViewById(R.id.next);
        back = (ImageView) findViewById(R.id.back);
        home = (ImageView) findViewById(R.id.home);

        s10_1.setOnDragListener(new View.OnDragListener() {

            @Override
            public boolean onDrag(View v, DragEvent event) {
                // TODO Auto-generated method stub
                final int action = event.getAction();
                switch (action) {

                    case DragEvent.ACTION_DRAG_STARTED:
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;

                    case DragEvent.ACTION_DROP: {
//                        dispaly.setText("Perfect!");
//                        dispaly.setTextColor(Color.GREEN);
                        playPerfect();
                        cdd = new CustomDialogClass(s10.this);
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
                                    if (mp.isPlaying()) {
                                        mp.stop();
                                    }
                                    Intent i = new Intent(getApplicationContext(),
                                            s11.class);
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
                        return (true);
                    }
                    case DragEvent.ACTION_DRAG_ENDED: {
                        return (true);
                    }

                    default:
                        break;
                }

                return true;
            }
        });

        s10_2.setOnDragListener(new View.OnDragListener() {

            @Override
            public boolean onDrag(View v, DragEvent event) {
                // TODO Auto-generated method stub
                final int action = event.getAction();
                switch (action) {

                    case DragEvent.ACTION_DRAG_STARTED:
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;

                    case DragEvent.ACTION_DROP: {
//                        dispaly.setText("Wrong!");
//                        dispaly.setTextColor(Color.RED);
                        playWrong();
                        return (true);
                    }

                    case DragEvent.ACTION_DRAG_ENDED: {

                        return (true);
                    }
                    default:
                        break;
                }
                return true;
            }
        });

        s10_3.setOnDragListener(new View.OnDragListener() {

            @Override
            public boolean onDrag(View v, DragEvent event) {
                // TODO Auto-generated method stub
                final int action = event.getAction();
                switch (action) {

                    case DragEvent.ACTION_DRAG_STARTED:
                        break;

                    case DragEvent.ACTION_DRAG_EXITED:
                        break;

                    case DragEvent.ACTION_DRAG_ENTERED:
                        break;

                    case DragEvent.ACTION_DROP: {
//                        dispaly.setText("Wrong!");
//                        dispaly.setTextColor(Color.RED);
                        playWrong();
                        return (true);
                    }
                    case DragEvent.ACTION_DRAG_ENDED: {

                        return (true);
                    }
                    default:
                        break;
                }
                return true;
            }
        });

        drag.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent arg1) {
                // TODO Auto-generated method stub
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(drag);
                v.startDrag(data, shadow, null, 0);
                return false;
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                Intent i = new Intent(getApplicationContext(),
                        s11.class);
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
        mp = MediaPlayer.create(getApplicationContext(), R.raw.s10);// create's
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
