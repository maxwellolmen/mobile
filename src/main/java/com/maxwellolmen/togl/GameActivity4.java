package com.maxwellolmen.togl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class GameActivity4 extends GameActivity {

    public boolean[] on;

    @Override
    public boolean[] getOn() {
        return on;
    }

    @Override
    public void initLayout() {
        setContentView(R.layout.activity_game4);
    }

    @Override
    public void initBooleans() {
        on = new boolean[] {true, false, false, true, true, false, false, true};

    }

    @Override
    public ImageView[] initCells() {
        return new ImageView[]{(ImageView) findViewById(R.id.cell1),(ImageView) findViewById(R.id.cell2),(ImageView) findViewById(R.id.cell3),(ImageView) findViewById(R.id.cell4), (ImageView) findViewById(R.id.cell5), (ImageView) findViewById(R.id.cell6), (ImageView) findViewById(R.id.cell7), (ImageView) findViewById(R.id.cell8)};
    }

    @Override
    public Integer[][] initListeners() {
        return new Integer[][]{{R.id.cell1, R.id.cell2}, {R.id.cell2, R.id.cell1, R.id.cell3}, {R.id.cell3, R.id.cell2, R.id.cell4}, {R.id.cell4, R.id.cell3, R.id.cell5}, {R.id.cell5, R.id.cell4, R.id.cell6}, {R.id.cell6, R.id.cell5, R.id.cell7}, {R.id.cell7, R.id.cell6, R.id.cell8}, {R.id.cell8, R.id.cell7}};
    }

    @Override
    public Intent getIntent() {
        return new Intent(GameActivity4.this, GoodJobActivity.class);
    }

    @Override
    public int getNextLevel() {
        return R.string.u5;
    }

    @Override
    public Bundle getBundle() {
        Bundle b = new Bundle();
        b.putInt("level", 4);

        return b;
    }
}
