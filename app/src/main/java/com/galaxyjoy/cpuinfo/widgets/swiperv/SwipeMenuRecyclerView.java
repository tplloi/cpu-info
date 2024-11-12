package com.galaxyjoy.cpuinfo.widgets.swiperv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class SwipeMenuRecyclerView extends RecyclerView implements SwipeMenuHelper.Callback {

    protected SwipeMenuHelper mHelper;

    public SwipeMenuRecyclerView(Context context) {
        super(context);
        init();
    }

    public SwipeMenuRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SwipeMenuRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    protected void init() {
        mHelper = new SwipeMenuHelper(getContext(), this);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean isIntercepted = super.onInterceptTouchEvent(ev);
        // ignore Multi-Touch
        if (ev.getActionIndex() != 0) return true;
        int action = ev.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            isIntercepted = mHelper.handleListDownTouchEvent(ev, isIntercepted);
        }
        return isIntercepted;
    }

    public int getPositionForView(View touchView) {
        return getChildAdapterPosition(touchView);
    }

    @Override
    public int getRealChildCount() {
        return getChildCount();
    }

    @Override
    public View getRealChildAt(int index) {
        return getChildAt(index);
    }

    @Override
    public View transformTouchingView(int touchingPosition, View touchingView) {
        ViewHolder vh = findViewHolderForAdapterPosition(touchingPosition);
        if (vh != null) {
            return vh.itemView;
        }
        return touchingView;
    }
}
