package com.maxwellolmen.togl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class GameActivity3 extends GameActivity {

    public boolean[] on;

    @Override
    public boolean[] getOn() {
        return on;
    }

    @Override
    public void initLayout() {
        setContentView(R.layout.activity_game3);
    }

    @Override
    public void initBooleans() {
        on = new boolean[6];

        on[0] = true;
        on[1] = false;
        on[2] = true;
        on[3] = false;
        on[4] = true;
        on[5] = false;
    }

    @Override
    public ImageView[] initCells() {
        return new ImageView[]{(ImageView) findViewById(R.id.cell1),(ImageView) findViewById(R.id.cell2),(ImageView) findViewById(R.id.cell3),(ImageView) findViewById(R.id.cell4), (ImageView) findViewById(R.id.cell5), (ImageView) findViewById(R.id.cell6)};
    }

    @Override
    public Integer[][] initListeners() {
        return new Integer[][]{{R.id.cell1, R.id.cell2}, {R.id.cell1, R.id.cell2, R.id.cell3}, {R.id.cell2, R.id.cell3, R.id.cell4}, {R.id.cell3, R.id.cell4, R.id.cell5}, {R.id.cell4, R.id.cell5, R.id.cell6}, {R.id.cell5, R.id.cell6}};
    }

    @Override
    public Intent getIntent() {
        return new Intent(GameActivity3.this, GoodJobActivity.class);
    }

    @Override
    public int getNextLevel() {
        return R.string.u4;
    }

    @Override
    public Bundle getBundle() {
        Bundle b = new Bundle();
        b.putInt("level", 3);

        return b;
    }
}
