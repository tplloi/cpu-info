package com.galaxyjoy.cpuinfo.widget.swiperv.listener

import com.galaxyjoy.cpuinfo.widget.swiperv.SwipeMenuLayout

interface SwipeFractionListener {
    fun beginMenuSwipeFraction(swipeMenuLayout: SwipeMenuLayout?, fraction: Float)
    fun endMenuSwipeFraction(swipeMenuLayout: SwipeMenuLayout?, fraction: Float)
}
