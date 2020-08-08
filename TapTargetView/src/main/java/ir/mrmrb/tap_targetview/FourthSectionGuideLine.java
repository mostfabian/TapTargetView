package ir.mrmrb.tap_targetview;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;


import java.util.Timer;
import java.util.TimerTask;

import ir.mrmrb.tap_targetview.Model.GuideLine;

public class FourthSectionGuideLine extends BaseGuideLineClass {
    public FourthSectionGuideLine(GuideLine guideLine) {
        super(guideLine);
    }

    @Override
    public void createAnimation(final View v, final int height) {
        int time = 5000;
        final ViewGroup.LayoutParams params = v.getLayoutParams();
        final int mHeight = (int) height + v.getLayoutParams().height;
        int delay = 0;   // delay for 0 sec.
        int period = 10;  // repeat every sec.
        final int step = time / period;
        final Timer timer = new Timer();
        final int addValue;
        if (step > (int) height) {
            addValue = step / (int) height;

        } else
            addValue = (int) height / step;
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {

                // do work inside ui thread
                ((Activity) view.getContext()).runOnUiThread(new Runnable() {
                    public void run() {
                        if ((params.height + addValue) > mHeight)
                            params.height = mHeight;
                        else
                            params.height = params.height + addValue;

                        v.setLayoutParams(params);
                        v.invalidate();
                        if (v.getLayoutParams().height == mHeight)
                            timer.cancel();
                    }
                });
            }
        }, delay, period);
    }

    @Override
    public void createFirstGuideLine() {
        float vX = (screenWidth / 2) - (screenWidth / 4);
        float vHeight = (screenHeight / 2);
        float vY = (viewStartY - statusBarHeight) + (viewHeight / 2);

        View view1 = new View(view.getContext());
        view1.setBackground(view.getContext().getResources().getDrawable(R.drawable.rectangle_background));
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(5, 5);
        view1.setLayoutParams(params);
        view1.setY(vY - vHeight);
        view1.setX(vX);

        ((ViewGroup) inflatedLayout).addView(view1);

        float view2Width = (viewStartX - vX);
        View view2 = new View(view.getContext());
        view2.setBackground(view.getContext().getResources().getDrawable(R.drawable.rectangle_background));
        ViewGroup.LayoutParams params1 = new ViewGroup.LayoutParams((int) view2Width, 5);
        view2.setLayoutParams(params1);
        view2.setY(vY);
        view2.setX(vX);

        ((ViewGroup) inflatedLayout).addView(view2);

        createAnimation(view1 , (int) vHeight);

    }
}
