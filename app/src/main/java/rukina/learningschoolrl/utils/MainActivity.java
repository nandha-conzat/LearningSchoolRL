package rukina.learningschoolrl.utils;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import rukina.learningschoolrl.R;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mp;
    ImageView repeat, go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = new MediaPlayer();
        repeat = (ImageView) findViewById(R.id.imageRepeat);
        go = (ImageView) findViewById(R.id.imageGo);
        playSong();

        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSong();
            }
        });

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()) {
                    mp.stop();
                }
                Intent i = new Intent(getApplicationContext(),
                        s2.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void playSong() {

        mp.reset();// stops any current playing song
        mp = MediaPlayer.create(getApplicationContext(), R.raw.s1);// create's
        mp.start(); // starting mediaplayer
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.release();
    }
}
