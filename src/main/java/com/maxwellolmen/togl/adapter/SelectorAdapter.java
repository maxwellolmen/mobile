package com.maxwellolmen.togl.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.maxwellolmen.togl.R;
import com.maxwellolmen.togl.Selector;
import com.maxwellolmen.togl.SelectorActivity;

public class SelectorAdapter extends RecyclerView.Adapter<SelectorAdapter.ViewHolder> {

    private static String[] mDataset;
    private Selector selector;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View mCardView;
        public TextView mTextView;
        public ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            mCardView = v;
            mTextView = (TextView) v.findViewById(R.id.selector_text);
            mImageView = (ImageView) v.findViewById(R.id.selector_image);
        }
    }

    public SelectorAdapter(String[] mDataset, Selector selector) {
        SelectorAdapter.mDataset = mDataset;
        this.selector = selector;
    }

    public SelectorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_task, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mTextView.setText(mDataset[position]);

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selector.processClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public int getTheImage(int position) {
        if (position == 0) {
            return R.mipmap.cell1;
        } else {
            return -1;
        }
    }
}
