package ir.mrmrb.tap_targetview;

import android.view.View;

import ir.mrmrb.tap_targetview.Model.GuideLine;


public abstract class BaseGuideLineClass implements IGuideLine {
    float screenWidth;
    float viewStartY;
    float viewEndY;
    float viewStartX;
    float viewEndX;
    float statusBarHeight;
    float viewHeight;
    float screenHeight;
    View view;
    View inflatedLayout;

    public BaseGuideLineClass(GuideLine guideLine) {
        this.screenWidth = guideLine.getScreenWidth();
        this.viewStartY = guideLine.getViewStartY();
        this.viewEndY = guideLine.getViewEndY();
        this.viewStartX = guideLine.getViewStartX();
        this.viewEndX = guideLine.getViewEndX();
        this.statusBarHeight = guideLine.getStatusBarHeight();
        this.viewHeight = guideLine.getViewHeight();
        this.screenHeight = guideLine.getScreenHeight();
        this.view = guideLine.getView();
        this.inflatedLayout = guideLine.getInflatedLayout();
    }
    public abstract void createAnimation(View view , int height);
}
