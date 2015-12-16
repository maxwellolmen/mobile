package com.maxwellolmen.togl;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    InterstitialAd interstitialAd;
    boolean music = true;

    MediaPlayer song1;
    MediaPlayer song2;
    MediaPlayer song3;

    int songNum = 0;
    boolean song1P = false;
    boolean song2P = false;
    boolean song3P = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdView hav = (AdView) findViewById(R.id.homeAdView);
        AdRequest har = new AdRequest.Builder().build();

        hav.loadAd(har);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstitial_leave_id));

        requestNewInterstitial();
        while(songNum < 3) {
            Handler handler = new Handler();
            switch (songNum) {
                case 0:
                    if (!(song3.isPlaying())) {
                        songNum = 1;
                        song1 = MediaPlayer.create(MainActivity.this, R.raw.song1);
                        song1.start();
                    }
                    break;
                case 1:
                    if (!(song1.isPlaying())) {
                        songNum = 2;
                        song2 = MediaPlayer.create(MainActivity.this, R.raw.song1);
                        song2.start();
                    }
                    break;
                case 2:
                    if (!(song2.isPlaying())) {
                        songNum = 0;
                        song3 = MediaPlayer.create(MainActivity.this, R.raw.song1);
                        song3.start();
                    }
                    break;
            }
        }


        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectorActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TutorialSelectorActivity.class);
                startActivity(intent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
                startActivity(intent);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreditsActivity.class);
                startActivity(intent);
            }
        });
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();

        interstitialAd.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            super.onBackPressed();
        }
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
    @Override
    protected void onPause(){
        super.onPause();
        switch (songNum){
            case 0:
                if(song1 != null) {
                    song1.pause();
                }
                break;
            case 1:
                if(song2 != null) {
                    song2.pause();
                }
                break;
            case 2:
                if(song3 != null) {
                    song3.pause();
                }
                break;
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        switch (songNum) {
            case 0:
                if (song1 != null) {
                    song1.start();
                }
                break;
            case 1:
                if (song2 != null) {
                    song2.start();
                }
                break;
            case 2:
                if (song3 != null) {
                    song3.start();
                }
                break;
        }
    }
}
