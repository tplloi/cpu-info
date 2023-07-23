package com.roy93group.cpuinfo.widgets.swiperv.listener;

import com.roy93group.cpuinfo.widgets.swiperv.SwipeMenuLayout;


public interface SwipeFractionListener {
    void beginMenuSwipeFraction(SwipeMenuLayout swipeMenuLayout, float fraction);

    void endMenuSwipeFraction(SwipeMenuLayout swipeMenuLayout, float fraction);
}
