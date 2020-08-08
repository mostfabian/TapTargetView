package com.example.testapplication.TapTargetView.Model;

import android.view.View;

public class GuideLine {
    private int section;
    private float screenWidth;
    private float viewStartY;
    private float viewEndY;
    private float viewStartX;
    private float viewEndX;
    private float statusBarHeight;
    private float viewHeight;
    private float screenHeight;
    private View view;
    private View inflatedLayout;

    public GuideLine(int section, float screenWidth, float viewStartY, float viewEndY, float viewStartX, float viewEndX,
                     float statusBarHeight, float viewHeight, float screenHeight, View view, View inflatedLayout) {
        this.section = section;
        this.screenWidth = screenWidth;
        this.viewStartY = viewStartY;
        this.viewEndY = viewEndY;
        this.viewStartX = viewStartX;
        this.viewEndX = viewEndX;
        this.statusBarHeight = statusBarHeight;
        this.viewHeight = viewHeight;
        this.screenHeight = screenHeight;
        this.view = view;
        this.inflatedLayout = inflatedLayout;
    }

    public int getSection() {
        return section;
    }

    public float getScreenWidth() {
        return screenWidth;
    }

    public float getViewStartY() {
        return viewStartY;
    }

    public float getViewEndY() {
        return viewEndY;
    }

    public float getViewStartX() {
        return viewStartX;
    }

    public float getViewEndX() {
        return viewEndX;
    }

    public float getStatusBarHeight() {
        return statusBarHeight;
    }

    public float getViewHeight() {
        return viewHeight;
    }

    public float getScreenHeight() {
        return screenHeight;
    }

    public View getView() {
        return view;
    }

    public View getInflatedLayout() {
        return inflatedLayout;
    }
}
