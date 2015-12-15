package com.maxwellolmen.togl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.maxwellolmen.togl.adapter.SelectorAdapter;

public class TutorialSelectorActivity extends Selector {

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
        setContentView(R.layout.activity_tutorial_selector);

        mDataset = new String[]{};

        ctx = TutorialSelectorActivity.this;
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

        }
    }

    public void startIntent(Class<?> activity) {
        Intent intent = new Intent(TutorialSelectorActivity.this, activity);
        startActivity(intent);
    }
}