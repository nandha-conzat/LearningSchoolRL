package rukina.learningschoolrl.utils;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import rukina.learningschoolrl.R;
import rukina.learningschoolrl.activity.book.s57;
import rukina.learningschoolrl.activity.boys.s75;
import rukina.learningschoolrl.activity.girls.s108;
import rukina.learningschoolrl.activity.office_and_library.s124_01;
import rukina.learningschoolrl.activity.paper.s91;
import rukina.learningschoolrl.activity.pencil.s22;
import rukina.learningschoolrl.activity.principal.s159;
import rukina.learningschoolrl.activity.table.s40;
import rukina.learningschoolrl.activity.chair.s3;

/**
 * Created by Nandha on 10-01-2016.
 */
public class s2 extends AppCompatActivity {
    ImageView chair, pencil, table, book, boys, paper, girls, office_and_library, principal;
    boolean doubleBackToExitPressedOnce = false;
    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s2);
        chair = (ImageView) findViewById(R.id.dash_chair);
        pencil = (ImageView) findViewById(R.id.dash_pencil);
        table = (ImageView) findViewById(R.id.dash_table);
        book = (ImageView) findViewById(R.id.dash_book);
        boys = (ImageView) findViewById(R.id.dash_boys);
        paper = (ImageView) findViewById(R.id.dash_paper);
        girls = (ImageView) findViewById(R.id.dash_girls);
        office_and_library = (ImageView) findViewById(R.id.dash_office_and_library);
        principal = (ImageView) findViewById(R.id.dash_principal);
        mp = new MediaPlayer();

        chair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                playYeah();

                Intent Chair = new Intent(getApplicationContext(),
                        s3.class);
                startActivity(Chair);
            }
        });

        pencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                playYeah();

                Intent Pencil = new Intent(getApplicationContext(),
                        s22.class);
                startActivity(Pencil);

            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                playYeah();

                Intent Book = new Intent(getApplicationContext(),
                        s57.class);
                startActivity(Book);
            }
        });

        table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                playYeah();

                Intent Table = new Intent(getApplicationContext(),
                        s40.class);
                startActivity(Table);
            }
        });

        girls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mp.isPlaying()) {
                    mp.stop();
                }
                playYeah();
                Intent Girls = new Intent(getApplicationContext(),
                        s108.class);
                startActivity(Girls);
            }
        });

        boys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Boys = new Intent(getApplicationContext(),
                        s75.class);
                startActivity(Boys);
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                playYeah();

                Intent Paper = new Intent(getApplicationContext(),
                        s91.class);
                startActivity(Paper);
            }
        });

        office_and_library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                playYeah();

                Intent OfficeAndLibrary = new Intent(getApplicationContext(),
                        s124_01.class);
                startActivity(OfficeAndLibrary);
            }
        });

        principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                playYeah();

                Intent Principal = new Intent(getApplicationContext(),
                        s159.class);
                startActivity(Principal);
            }
        });
    }

//    @Override
//    public void onBackPressed() {
//        if (doubleBackToExitPressedOnce) {
//            super.onBackPressed();
//            return;
//        }
//
//        this.doubleBackToExitPressedOnce = true;
//        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
//
//        new Handler().postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                doubleBackToExitPressedOnce = false;
//            }
//        }, 2000);
//    }

    public void playYeah() {

        mp.reset();// stops any current playing song
        mp = MediaPlayer.create(getApplicationContext(), R.raw.yeah);// create's
        mp.start(); // starting mediaplayer
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.release();
    }
}
