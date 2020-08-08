package ir.mrmrb.tap_targetview;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import ir.mrmrb.tap_targetview.Model.GuideLine;


public class SecondSectionGuideLine extends BaseGuideLineClass {
    public SecondSectionGuideLine(GuideLine guideLine) {
        super(guideLine);
    }

    @Override
    public void createAnimation(final View v , final int height) {

    }

    @Override
    public void createFirstGuideLine() {
        float vY = (viewStartY - statusBarHeight) + (viewHeight / 2);
        float vX = (screenWidth / 2) - (screenWidth / 4);
        float vHeight = (screenHeight / 2);
        Log.e("vHeight", vHeight + "");

        View view1 = new View(view.getContext());
        view1.setBackground(view.getContext().getResources().getDrawable(R.drawable.rectangle_background));
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(5, (int) vHeight);
        view1.setLayoutParams(params);
        view1.setY(vY);
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
    }
}
