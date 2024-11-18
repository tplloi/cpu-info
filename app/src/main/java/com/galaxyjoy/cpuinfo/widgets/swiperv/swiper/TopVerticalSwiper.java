package com.galaxyjoy.cpuinfo.widgets.swiperv.swiper;

import android.view.View;
import android.widget.OverScroller;

import kotlin.Suppress;

@Suppress(names = "unused")
public class TopVerticalSwiper extends Swiper {

    public TopVerticalSwiper(View menuView) {
        super(BEGIN_DIRECTION, menuView);
    }

    @Override
    public boolean isMenuOpen(int scrollY) {
        return scrollY <= -getMenuView().getHeight() * getDirection();
    }

    @Override
    public boolean isMenuOpenNotEqual(int scrollY) {
        return scrollY < -getMenuView().getHeight() * getDirection();
    }

    @Override
    public void autoOpenMenu(OverScroller scroller, int scrollY, int duration) {
        if (scroller == null) {
            return;
        }
        scroller.startScroll(0, Math.abs(scrollY), 0, getMenuView().getHeight() - Math.abs(scrollY), duration);
    }

    @Override
    public void autoCloseMenu(OverScroller scroller, int scrollY, int duration) {
        if (scroller == null) {
            return;
        }
        scroller.startScroll(0, -Math.abs(scrollY), 0, Math.abs(scrollY), duration);
    }

    @Override
    public Checker checkXY(int x, int y) {
        mChecker.x = x;
        mChecker.y = y;
        mChecker.shouldResetSwiper = mChecker.y == 0;
        if (mChecker.y >= 0) {
            mChecker.y = 0;
        }
        if (mChecker.y <= -getMenuView().getHeight()) {
            mChecker.y = -getMenuView().getHeight();
        }
        return mChecker;
    }

    @Override
    public boolean isClickOnContentView(View contentView, float y) {
        return y > getMenuView().getHeight();
    }
}
