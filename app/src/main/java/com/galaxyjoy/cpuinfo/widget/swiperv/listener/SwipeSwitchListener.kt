package com.galaxyjoy.cpuinfo.widget.swiperv.listener

import com.galaxyjoy.cpuinfo.widget.swiperv.SwipeMenuLayout

interface SwipeSwitchListener {
    fun beginMenuClosed(swipeMenuLayout: SwipeMenuLayout?)
    fun beginMenuOpened(swipeMenuLayout: SwipeMenuLayout?)
    fun endMenuClosed(swipeMenuLayout: SwipeMenuLayout?)
    fun endMenuOpened(swipeMenuLayout: SwipeMenuLayout?)
}
