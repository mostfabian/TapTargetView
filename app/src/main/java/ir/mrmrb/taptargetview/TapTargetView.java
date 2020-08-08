package com.example.testapplication.TapTargetView;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.testapplication.R;
import com.example.testapplication.TapTargetView.Model.GuideLine;

import java.util.Timer;
import java.util.TimerTask;

public class TapTargetView {
    private View view;
    private View inflatedLayout;

    private float viewStartX;
    private float viewStartY;

    private float viewWidth;
    private float viewHeight;
    private float screenWidth;
    private float screenHeight;


    public TapTargetView(final View view) {
        this.view = view;
        inflateLayout();
        getScreenSize();
        view.getRootView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                showTargetView();
                viewWidth = view.getMeasuredWidth();
                viewHeight = view.getMeasuredHeight();
                createGuideLine();
                view.getRootView().getViewTreeObserver()
                        .removeOnGlobalLayoutListener(this);
                Log.e("test", getViewSection() + "");
            }
        });
    }

    private void inflateLayout() {
        inflatedLayout = LayoutInflater.from(view.getContext())
                .inflate(R.layout.tap_target_view, (ViewGroup) view.getRootView(), true);
    }

    private void showTargetView() {

        View targetView = new View(view.getContext());
        targetView.setBackground(view.getContext().getResources().getDrawable(R.drawable.rectangle_background));
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(view.getWidth(), view.getHeight());
        targetView.setLayoutParams(params);
        targetView.setX(view.getX());
        targetView.setY(view.getY() - getStatusBarHeight());

        viewStartX = view.getX();
        viewStartY = view.getY();

        ((ViewGroup) inflatedLayout).addView(targetView);

    }

    private float getViewStartX() {
        return viewStartX;
    }

    public float getViewEndX() {
        return viewStartX + viewWidth;
    }

    public float getViewStartY() {
        return viewStartY;
    }

    public float getViewEndY() {
        return viewStartY + viewHeight;
    }

    private void getScreenSize() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) view.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenHeight = displayMetrics.heightPixels;
        screenWidth = displayMetrics.widthPixels;
    }

    private int getViewSection() {
        if (viewStartX < screenWidth / 2) {
            if (viewStartY < screenHeight / 2)
                return TapTargetConst.FIRST_SECTION;
            else return TapTargetConst.THIRD_SECTION;
        } else {
            if (viewStartY < screenHeight / 2)
                return TapTargetConst.SECOND_SECTION;
            else return TapTargetConst.FOURTH_SECTION;
        }

    }

    private float getStatusBarHeight() {
        Rect rectangle = new Rect();
        Window window = ((Activity) view.getContext()).getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
        int statusBarHeight = rectangle.top;
        int contentViewTop =
                window.findViewById(Window.ID_ANDROID_CONTENT).getTop();
        return contentViewTop - statusBarHeight;
    }

    private void createGuideLine() {
        GuideLine guideLineModel = new GuideLine(getViewSection(), screenWidth, viewStartY, getViewEndY(), viewStartX, getViewEndX(),
                getStatusBarHeight(), viewHeight, screenHeight, view, inflatedLayout);

        BaseGuideLineClass guideLine = GuideLineFactory.getGuideLine(guideLineModel);
        if (guideLine != null) {
            guideLine.createFirstGuideLine();
        }
    }

}
