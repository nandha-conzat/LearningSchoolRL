package rukina.learningschoolrl.activity.book;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
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
import android.widget.TextView;
import android.widget.Toast;

import rukina.learningschoolrl.R;
import rukina.learningschoolrl.activity.boys.s75;
import rukina.learningschoolrl.activity.girls.s108;
import rukina.learningschoolrl.activity.office_and_library.s124_01;
import rukina.learningschoolrl.activity.paper.s91;
import rukina.learningschoolrl.activity.pencil.s22;
import rukina.learningschoolrl.activity.principal.s159;
import rukina.learningschoolrl.activity.table.s40;
import rukina.learningschoolrl.utils.CustomDialogClass;
import rukina.learningschoolrl.utils.s2;
import rukina.learningschoolrl.activity.chair.s3;

/**
 * Created by Nandha on 14-01-2016.
 */
public class s73 extends AppCompatActivity {

    TextView option_a1, option_a2, option_a3, option_a4, option_a5, option_a6, option_a7,
            option_b1, option_b2, option_b3, option_b4, option_b5, option_b6, option_b7,
            option_c1, option_c2, option_c3, option_c4, option_c5, option_c6, option_c7,
            option_d1, option_d2, option_d3, option_d4, option_d5, option_d6, option_d7,
            option_e1, option_e2, option_e3, option_e4, option_e5, option_e6, option_e7,
            choice_f1, choice_f2, choice_f3, choice_f4, choice_f5, choice_f6, choice_f7,
            choice_g1, choice_g2, choice_g3, choice_g4, choice_g5, choice_g6, choice_g7;
    public CharSequence dragData;
    ImageView next, back, home;
    private MediaPlayer mp;
    private static int SPLASH_TIME_OUT = 1000;
    CustomDialogClass cdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s73);

        mp = new MediaPlayer();
        playTitle();
        next = (ImageView) findViewById(R.id.next);
        back = (ImageView) findViewById(R.id.back);
        home = (ImageView) findViewById(R.id.home);


        //views to drag
        option_a2 = (TextView) findViewById(R.id.option_a2);
        option_a3 = (TextView) findViewById(R.id.option_a3);
        option_a4 = (TextView) findViewById(R.id.option_a4);
        option_a5 = (TextView) findViewById(R.id.option_a5);
        option_a6 = (TextView) findViewById(R.id.option_a6);
        option_b2 = (TextView) findViewById(R.id.option_b2);
        option_b3 = (TextView) findViewById(R.id.option_b3);
        option_b4 = (TextView) findViewById(R.id.option_b4);
        option_b5 = (TextView) findViewById(R.id.option_b5);
        option_b6 = (TextView) findViewById(R.id.option_b6);
        option_b7 = (TextView) findViewById(R.id.option_b7);
        option_c4 = (TextView) findViewById(R.id.option_c4);
        option_c5 = (TextView) findViewById(R.id.option_c5);
        option_c6 = (TextView) findViewById(R.id.option_c6);
        option_c7 = (TextView) findViewById(R.id.option_c7);
        option_d3 = (TextView) findViewById(R.id.option_d3);
        option_d4 = (TextView) findViewById(R.id.option_d4);
        option_d5 = (TextView) findViewById(R.id.option_d5);
        option_d6 = (TextView) findViewById(R.id.option_d6);
        option_d7 = (TextView) findViewById(R.id.option_d7);
        option_e4 = (TextView) findViewById(R.id.option_e4);
        option_e5 = (TextView) findViewById(R.id.option_e5);
        option_e6 = (TextView) findViewById(R.id.option_e6);
        option_e7 = (TextView) findViewById(R.id.option_e7);


        //views to drop onto
        choice_f2 = (TextView) findViewById(R.id.option_f2);
        choice_f3 = (TextView) findViewById(R.id.option_f3);
        choice_f4 = (TextView) findViewById(R.id.option_f4);
        choice_f5 = (TextView) findViewById(R.id.option_f5);
        choice_f6 = (TextView) findViewById(R.id.option_f6);
        choice_f7 = (TextView) findViewById(R.id.option_f7);
        choice_g2 = (TextView) findViewById(R.id.option_g2);
        choice_g3 = (TextView) findViewById(R.id.option_g3);
        choice_g4 = (TextView) findViewById(R.id.option_g4);
        choice_g5 = (TextView) findViewById(R.id.option_g5);
        choice_g6 = (TextView) findViewById(R.id.option_g6);
        choice_g7 = (TextView) findViewById(R.id.option_g7);

        //set touch listeners
        option_a2.setOnDragListener(new ChoiceDragListener());
        option_a3.setOnDragListener(new ChoiceDragListener());
        option_a4.setOnDragListener(new ChoiceDragListener());
        option_a5.setOnDragListener(new ChoiceDragListener());
        option_a6.setOnDragListener(new ChoiceDragListener());
        option_b2.setOnDragListener(new ChoiceDragListener());
        option_b3.setOnDragListener(new ChoiceDragListener());
        option_b4.setOnDragListener(new ChoiceDragListener());
        option_b5.setOnDragListener(new ChoiceDragListener());
        option_b6.setOnDragListener(new ChoiceDragListener());
        option_b7.setOnDragListener(new ChoiceDragListener());
        option_c4.setOnDragListener(new ChoiceDragListener());
        option_c5.setOnDragListener(new ChoiceDragListener());
        option_c6.setOnDragListener(new ChoiceDragListener());
        option_c7.setOnDragListener(new ChoiceDragListener());
        option_d3.setOnDragListener(new ChoiceDragListener());
        option_d4.setOnDragListener(new ChoiceDragListener());
        option_d5.setOnDragListener(new ChoiceDragListener());
        option_d6.setOnDragListener(new ChoiceDragListener());
        option_d7.setOnDragListener(new ChoiceDragListener());
        option_e4.setOnDragListener(new ChoiceDragListener());
        option_e5.setOnDragListener(new ChoiceDragListener());
        option_e6.setOnDragListener(new ChoiceDragListener());
        option_e7.setOnDragListener(new ChoiceDragListener());

        //set drag listeners
        choice_f2.setOnTouchListener(new ChoiceTouchListener());
        choice_f3.setOnTouchListener(new ChoiceTouchListener());
        choice_f4.setOnTouchListener(new ChoiceTouchListener());
        choice_f5.setOnTouchListener(new ChoiceTouchListener());
        choice_f6.setOnTouchListener(new ChoiceTouchListener());
        choice_f7.setOnTouchListener(new ChoiceTouchListener());
        choice_g2.setOnTouchListener(new ChoiceTouchListener());
        choice_g3.setOnTouchListener(new ChoiceTouchListener());
        choice_g4.setOnTouchListener(new ChoiceTouchListener());
        choice_g5.setOnTouchListener(new ChoiceTouchListener());
        choice_g6.setOnTouchListener(new ChoiceTouchListener());
        choice_g7.setOnTouchListener(new ChoiceTouchListener());

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                Intent i = new Intent(getApplicationContext(),
                        s74.class);
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

    /**
     * ChoiceTouchListener will handle touch events on draggable views
     */
    private final class ChoiceTouchListener implements View.OnTouchListener {
        @SuppressLint("NewApi")
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            /*
             * Drag details: we only need default behavior
             * - clip data could be set to pass data as part of drag
             * - shadow can be tailored
             */
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
                //start dragging the item touched
                view.startDrag(data, shadowBuilder, view, 0);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * DragListener will handle dragged views being dropped on the drop area
     * - only the drop action will have processing added to it as we are not
     * - amending the default behavior for other parts of the drag process
     */
    @SuppressLint("NewApi")
    private class ChoiceDragListener implements View.OnDragListener {

        String userEntered = "";

        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DRAG_STARTED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_ENTERED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //no action necessary
                    break;
                case DragEvent.ACTION_DROP:

                    //handle the dragged view being dropped over a drop view
                    View view = (View) event.getLocalState();
                    //view dragged item is being dropped on
                    TextView dropTarget = (TextView) v;
                    //view being dragged and dropped
                    TextView dropped = (TextView) view;
                    //checking whether first character of dropTarget equals first character of dropped
                    if (dropTarget.getText().toString().charAt(0) == dropped.getText().toString().charAt(0)) {
                        //stop displaying the view where it was before it was dragged
                        //view.setVisibility(View.INVISIBLE);
                        //update the text in the target view to reflect the data being dropped
                        //dropTarget.setText(dropTarget.getText().toString() + dropped.getText().toString());
                        dropTarget.setText(dropTarget.getText().toString() + ".");

                        String a = option_a2.getText().toString().trim();
                        String b = option_a3.getText().toString().trim();
                        String c = option_a4.getText().toString().trim();
                        String d = option_a5.getText().toString().trim();
                        String e = option_a6.getText().toString().trim();
                        String a1 = option_b2.getText().toString().trim();
                        String b1 = option_b3.getText().toString().trim();
                        String c1 = option_b4.getText().toString().trim();
                        String d1 = option_b5.getText().toString().trim();
                        String e1 = option_b6.getText().toString().trim();
                        String f1 = option_b7.getText().toString().trim();
                        String a2 = option_c4.getText().toString().trim();
                        String b2 = option_c5.getText().toString().trim();
                        String c2 = option_c6.getText().toString().trim();
                        String d2 = option_c7.getText().toString().trim();
                        String a3 = option_d3.getText().toString().trim();
                        String b3 = option_d4.getText().toString().trim();
                        String c3 = option_d5.getText().toString().trim();
                        String d3 = option_d6.getText().toString().trim();
                        String e3 = option_d7.getText().toString().trim();
                        String a4 = option_e4.getText().toString().trim();
                        String b4 = option_e5.getText().toString().trim();
                        String c4 = option_e6.getText().toString().trim();
                        String d4 = option_e7.getText().toString().trim();

                        userEntered = "" + a + b + c + d + e + a1 + b1 + c1 + d1 + e1 + f1 + a2 + b2 + c2 + d2 + a3 + b3 + c3 + d3 + e3 + a4 + b4 + c4 + d4;
                        if (userEntered.equals("ch.a.ir.pe.n.ci.lbo.o.kta.b.le.fi.s.h")) {
                            playPerfect();

                            cdd = new CustomDialogClass(s73.this);
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
                                                s74.class);
                                        startActivity(i);
                                        cdd.dismiss();
                                    }
                                }, SPLASH_TIME_OUT);
                            } catch (OutOfMemoryError g) {
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Your phone memory is too low, free your cache memory and start the application",
                                        Toast.LENGTH_LONG).show();
                            }

                        }

                        dropTarget.setTextColor(Color.BLACK);
                        //make it bold to highlight the fact that an item has been dropped
                        dropTarget.setTypeface(Typeface.DEFAULT_BOLD);
                        //if an item has already been dropped here, there will be a tag


                        Object tag = dropTarget.getTag();
                        //if there is already an item here, set it back visible in its original place
                        if (tag != null) {
                            //the tag is the view id already dropped here
                            int existingID = (Integer) tag;
                            //set the original view visible again
                            findViewById(existingID).setVisibility(View.VISIBLE);
                        }
                        //set the tag in the target view being dropped on - to the ID of the view being dropped
                        dropTarget.setTag(dropped.getId());
                        //remove setOnDragListener by setting OnDragListener to null, so that no further drag & dropping on this TextView can be done
                        dropTarget.setOnDragListener(null);
                    } else
                        playWrong();
                    //displays message if first character of dropTarget is not equal to first character of dropped
                    //Toast.makeText(MainActivity.this, dropTarget.getText().toString() + "is not " + dropped.getText().toString(), Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_LONG).show();
                    break;
                case DragEvent.ACTION_DRAG_ENDED:
                    //no action necessary
                    break;
                default:
                    break;
            }
            return true;
        }
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
        mp = MediaPlayer.create(getApplicationContext(), R.raw.s73);// create's
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
