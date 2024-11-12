package com.galaxyjoy.cpuinfo.widgets.swiperv.listener

import com.galaxyjoy.cpuinfo.widgets.swiperv.SwipeMenuLayout

interface SwipeFractionListener {
    fun beginMenuSwipeFraction(swipeMenuLayout: SwipeMenuLayout?, fraction: Float)
    fun endMenuSwipeFraction(swipeMenuLayout: SwipeMenuLayout?, fraction: Float)
}
