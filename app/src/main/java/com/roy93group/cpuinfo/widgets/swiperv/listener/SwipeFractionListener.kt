package com.roy93group.cpuinfo.widgets.swiperv.listener

import com.roy93group.cpuinfo.widgets.swiperv.SwipeMenuLayout

interface SwipeFractionListener {
    fun beginMenuSwipeFraction(swipeMenuLayout: SwipeMenuLayout?, fraction: Float)
    fun endMenuSwipeFraction(swipeMenuLayout: SwipeMenuLayout?, fraction: Float)
}
