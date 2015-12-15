package com.maxwellolmen.togl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.app.Activity;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public abstract class GameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayout();

        AdView hav = (AdView) findViewById(R.id.gameAdView);
        AdRequest har = new AdRequest.Builder().build();
        hav.loadAd(har);

        initBooleans();
        initButtons();
    }

    public void initButtons() {
        ImageView[] images = initCells();

        for (int i = 0; i < images.length; i++) {
            images[i].setImageResource(getOn()[i] ? R.mipmap.cell1 : R.mipmap.cell19);
        }


        ArrayList<View.OnClickListener> listeners = new ArrayList<View.OnClickListener>();

        Integer[][] lists = initListeners();

        for (int i = 0; i < lists.length; i++) {
            final Integer[] ids = lists[i];

            listeners.add(new View.OnClickListener() {
                public void onClick(View v) {
                    for (int id : ids) {
                        toggleAnimation(id);
                    }

                    boolean won = true;

                    for (boolean b : getOn()) {
                        if (!b) {
                            won = false;
                            break;
                        }
                    }

                    if (won) {
                        win();
                    }
                }
            });
        }

        for (int i = 0; i < images.length; i++) {
            images[i].setOnClickListener(listeners.get(i));
        }
    }

    public abstract boolean[] getOn();

    public abstract void initLayout();

    public abstract void initBooleans();

    public abstract ImageView[] initCells();

    public abstract Integer[][] initListeners();

    public void toggleAnimation(int cellId) {
        AnimationDrawable cellAnimation;
        ImageView cell0 = (ImageView) findViewById(cellId);
        if (getWhich(cellId)) {
            cell0.setImageResource(R.drawable.cell_off);
            cellAnimation = (AnimationDrawable) cell0.getDrawable();
            cellAnimation.start();

            toggleWhich(cellId);
        } else if (!getWhich(cellId)) {
            cell0 = (ImageView) findViewById(cellId);
            cell0.setImageResource(R.drawable.cell_on);
            cellAnimation = (AnimationDrawable) cell0.getDrawable();
            cellAnimation.start();

            toggleWhich(cellId);
        }
    }

    public boolean getWhich(int cellId) {
        switch (cellId) {
            case R.id.cell1:
                return getOn()[0];
            case R.id.cell2:
                return getOn()[1];
            case R.id.cell3:
                return getOn()[2];
            case R.id.cell4:
                return getOn()[3];
            case R.id.cell5:
                return getOn()[4];
            case R.id.cell6:
                return getOn()[5];
            case R.id.cell7:
                return getOn()[6];
            case R.id.cell8:
                return getOn()[7];
            case R.id.cell9:
                return getOn()[8];
            default:
                return false;
        }
    }

    public void toggleWhich(int cellId) {
        switch (cellId) {
            case R.id.cell1:
                getOn()[0] = !getOn()[0];
                break;
            case R.id.cell2:
                getOn()[1] = !getOn()[1];
                break;
            case R.id.cell3:
                getOn()[2] = !getOn()[2];
                break;
            case R.id.cell4:
                getOn()[3] = !getOn()[3];
                break;
            case R.id.cell5:
                getOn()[4] = !getOn()[4];
                break;
            case R.id.cell6:
                getOn()[5] = !getOn()[5];
                break;
            case R.id.cell7:
                getOn()[6] = !getOn()[6];
                break;
            case R.id.cell8:
                getOn()[7] = !getOn()[7];
                break;
            case R.id.cell9:
                getOn()[8] = !getOn()[8];
                break;
        }
    }

    public void win() {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(GameActivity.this);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(getString(getNextLevel()), 1);
        editor.apply();

        AsyncStarter as = new AsyncStarter(this, getIntent(), getBundle());
        as.run();
        finish();
    }

    public abstract Intent getIntent();

    public abstract int getNextLevel();

    public abstract Bundle getBundle();
}
