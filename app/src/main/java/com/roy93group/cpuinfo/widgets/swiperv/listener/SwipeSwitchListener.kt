package com.roy93group.cpuinfo.widgets.swiperv.listener;

import com.roy93group.cpuinfo.widgets.swiperv.SwipeMenuLayout;

public interface SwipeSwitchListener {

    void beginMenuClosed(SwipeMenuLayout swipeMenuLayout);

    void beginMenuOpened(SwipeMenuLayout swipeMenuLayout);

    void endMenuClosed(SwipeMenuLayout swipeMenuLayout);

    void endMenuOpened(SwipeMenuLayout swipeMenuLayout);

}
