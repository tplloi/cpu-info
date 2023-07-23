package com.roy93group.cpuinfo.widgets.swiperv.swiper

import android.view.View
import android.widget.OverScroller

abstract class Swiper(val direction: Int, val menuView: View) {
    @JvmField
    protected var mChecker: Checker

    init {
        mChecker = Checker()
    }

    abstract fun isMenuOpen(scrollDis: Int): Boolean
    abstract fun isMenuOpenNotEqual(scrollDis: Int): Boolean
    abstract fun autoOpenMenu(scroller: OverScroller?, scrollDis: Int, duration: Int)
    abstract fun autoCloseMenu(scroller: OverScroller?, scrollDis: Int, duration: Int)
    abstract fun checkXY(x: Int, y: Int): Checker?
    abstract fun isClickOnContentView(contentView: View?, clickPoint: Float): Boolean
    val menuWidth: Int
        get() = menuView.width

    @get:Suppress("unused")
    val menuHeight: Int
        get() = menuView.height

    class Checker {
        @JvmField
        var x = 0

        @JvmField
        var y = 0

        @JvmField
        var shouldResetSwiper = false
    }

    companion object {
        protected const val BEGIN_DIRECTION = 1
        protected const val END_DIRECTION = -1
    }
}
