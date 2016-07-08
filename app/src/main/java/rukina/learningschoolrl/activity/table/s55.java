package rukina.learningschoolrl.activity.table;

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
public class s55 extends AppCompatActivity {

    private TextView option1, option2, option3, option4, option5, option6, option7, choice1, choice2, choice3, choice4, choice5;
    public CharSequence dragData;
    ImageView next, back, home;
    private MediaPlayer mp;
    private static int SPLASH_TIME_OUT = 1000;
    CustomDialogClass cdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s55);
        mp = new MediaPlayer();
        next = (ImageView) findViewById(R.id.next);
        back = (ImageView) findViewById(R.id.back);
        home = (ImageView) findViewById(R.id.home);

        //get both sets of text views

        //views to drag
        option1 = (TextView) findViewById(R.id.option_1);
        option2 = (TextView) findViewById(R.id.option_2);
        option3 = (TextView) findViewById(R.id.option_3);
        option4 = (TextView) findViewById(R.id.option_4);
        option5 = (TextView) findViewById(R.id.option_5);
        option6 = (TextView) findViewById(R.id.option_6);
        option7 = (TextView) findViewById(R.id.option_7);

        //views to drop onto
        choice1 = (TextView) findViewById(R.id.choice_1);
        choice2 = (TextView) findViewById(R.id.choice_2);
        choice3 = (TextView) findViewById(R.id.choice_3);
        choice4 = (TextView) findViewById(R.id.choice_4);
        choice5 = (TextView) findViewById(R.id.choice_5);


        //set touch listeners
        option1.setOnTouchListener(new ChoiceTouchListener());
        option2.setOnTouchListener(new ChoiceTouchListener());
        option3.setOnTouchListener(new ChoiceTouchListener());
        option4.setOnTouchListener(new ChoiceTouchListener());
        option5.setOnTouchListener(new ChoiceTouchListener());
        option6.setOnTouchListener(new ChoiceTouchListener());
        option7.setOnTouchListener(new ChoiceTouchListener());

        //set drag listeners
        choice1.setOnDragListener(new ChoiceDragListener());
        choice2.setOnDragListener(new ChoiceDragListener());
        choice3.setOnDragListener(new ChoiceDragListener());
        choice4.setOnDragListener(new ChoiceDragListener());
        choice5.setOnDragListener(new ChoiceDragListener());

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                Intent i = new Intent(getApplicationContext(),
                        s56.class);
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
                        view.setVisibility(View.INVISIBLE);

                        //update the text in the target view to reflect the data being dropped
                        //dropTarget.setText(dropTarget.getText().toString() + dropped.getText().toString());
                        dropTarget.setText(dropTarget.getText().toString() + ".");

                        dropTarget.setTextColor(Color.BLACK);
                        //make it bold to highlight the fact that an item has been dropped
                        dropTarget.setTypeface(Typeface.DEFAULT_BOLD);

                        String t = choice1.getText().toString().trim();
                        String a = choice2.getText().toString().trim();
                        String b = choice3.getText().toString().trim();
                        String l = choice4.getText().toString().trim();
                        String e = choice5.getText().toString().trim();

                        userEntered = "" + t + a + b + l + e;
                        if (userEntered.equals("t .a .b .l .e .")) {
                            playPerfect();
                            cdd = new CustomDialogClass(s55.this);
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
                                                s56.class);
                                        startActivity(i);
                                        cdd.dismiss();
                                    }
                                }, SPLASH_TIME_OUT);
                            } catch (OutOfMemoryError e1) {
                                Toast.makeText(
                                        getApplicationContext(),
                                        "Your phone memory is too low, free your cache memory and start the application",
                                        Toast.LENGTH_LONG).show();
                            }

                        }
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

    public void reset(View view) {
        option1.setVisibility(TextView.VISIBLE);
        option2.setVisibility(TextView.VISIBLE);
        option3.setVisibility(TextView.VISIBLE);
        option4.setVisibility(TextView.VISIBLE);
        option5.setVisibility(TextView.VISIBLE);
        option6.setVisibility(TextView.VISIBLE);
        option7.setVisibility(TextView.VISIBLE);

        choice1.setText("t");
        choice2.setText("a");
        choice3.setText("b");
        choice4.setText("l");
        choice5.setText("e");

        choice1.setTextColor(Color.TRANSPARENT);
        choice2.setTextColor(Color.TRANSPARENT);
        choice3.setTextColor(Color.TRANSPARENT);
        choice4.setTextColor(Color.TRANSPARENT);
        choice5.setTextColor(Color.TRANSPARENT);

        choice1.setTag(null);
        choice2.setTag(null);
        choice3.setTag(null);
        choice4.setTag(null);
        choice5.setTag(null);

        choice1.setTypeface(Typeface.DEFAULT);
        choice2.setTypeface(Typeface.DEFAULT);
        choice3.setTypeface(Typeface.DEFAULT);
        choice4.setTypeface(Typeface.DEFAULT);
        choice5.setTypeface(Typeface.DEFAULT);

        choice1.setOnDragListener(new ChoiceDragListener());
        choice2.setOnDragListener(new ChoiceDragListener());
        choice3.setOnDragListener(new ChoiceDragListener());
        choice4.setOnDragListener(new ChoiceDragListener());
        choice5.setOnDragListener(new ChoiceDragListener());
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
        mp = MediaPlayer.create(getApplicationContext(), R.raw.s9);// create's
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
