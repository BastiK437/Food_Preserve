package com.example.android.foodpreserve;

import android.content.Context;

public class SwipeControllerActions {

    FoodAdapter mAdapter;
    Context context;

    public SwipeControllerActions(FoodAdapter mAdapter, Context context) {
        this.mAdapter = mAdapter;
        this.context = context;
    }
    public void onLeftClicked(int position) {
    }

    public void onRightClicked(int position) {
        ((Data) context.getApplicationContext()).removeEntry(position);
        mAdapter.list.remove(position);
        mAdapter.notifyItemRemoved(position);
        mAdapter.notifyItemRangeChanged(position, mAdapter.getItemCount());
    }
}
