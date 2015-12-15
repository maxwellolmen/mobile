package com.maxwellolmen.togl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.maxwellolmen.togl.adapter.SelectorAdapter;

public class SelectorActivity extends Selector {

    Context ctx;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String[] mDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
        Toolbar toolbar = (Toolbar) findViewById(R.id.selector_toolbar);
        setSupportActionBar(toolbar);

        mDataset = new String[] {getString(R.string.lvl1), getString(R.string.lvl2), getString(R.string.lvl3), getString(R.string.lvl4), getString(R.string.lvl5), getString(R.string.lvl6), getString(R.string.lvl7)};

        ctx = SelectorActivity.this;
        sharedPref = PreferenceManager.getDefaultSharedPreferences(ctx);

        mRecyclerView = (RecyclerView) findViewById(R.id.selector_recycler);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new SelectorAdapter(mDataset, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void processClick(int position) {
        switch (position) {
            case 0:
                startIntent(GameActivity1.class);
                break;
            case 1:
                startIntent(GameActivity2.class);
                break;
            case 2:
                startIntent(GameActivity3.class);
                break;
            case 3:
                startIntent(GameActivity4.class);
                break;
            case 4:
                startIntent(GameActivity5.class);
                break;
            case 5:
                startIntent(GameActivity6.class);
                break;
            case 6:
                startIntent(GameActivity7.class);
                break;
        }
    }

    public void startIntent(Class<?> activity) {
        Intent intent = new Intent(SelectorActivity.this, activity);
        startActivity(intent);
    }
}
