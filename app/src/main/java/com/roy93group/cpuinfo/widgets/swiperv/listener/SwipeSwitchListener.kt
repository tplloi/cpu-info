package com.roy93group.cpuinfo.widgets.swiperv.listener

import com.roy93group.cpuinfo.widgets.swiperv.SwipeMenuLayout

interface SwipeSwitchListener {
    fun beginMenuClosed(swipeMenuLayout: SwipeMenuLayout?)
    fun beginMenuOpened(swipeMenuLayout: SwipeMenuLayout?)
    fun endMenuClosed(swipeMenuLayout: SwipeMenuLayout?)
    fun endMenuOpened(swipeMenuLayout: SwipeMenuLayout?)
}
