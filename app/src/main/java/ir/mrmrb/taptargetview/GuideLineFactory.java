package com.example.testapplication.TapTargetView;

import android.view.View;

import com.example.testapplication.TapTargetView.Model.GuideLine;

public class GuideLineFactory {


    public static BaseGuideLineClass getGuideLine(GuideLine guideLine) {
        
        switch (guideLine.getSection()){
            case TapTargetConst.FIRST_SECTION:
                return new FirstSectionGuideLine(guideLine);
            case TapTargetConst.SECOND_SECTION:
                return new SecondSectionGuideLine(guideLine);
            case TapTargetConst.THIRD_SECTION:
                return new ThirdSectionGuideLine(guideLine);
            case TapTargetConst.FOURTH_SECTION:
                return new FourthSectionGuideLine(guideLine);
        }
        return null;
    }
}
