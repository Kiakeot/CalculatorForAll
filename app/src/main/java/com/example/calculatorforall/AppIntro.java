package com.example.calculatorforall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.github.appintro.AppIntroFragment;
import com.github.appintro.AppIntroPageTransformerType;

public class AppIntro extends com.github.appintro.AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.createInstance(getString(R.string.Hello),
                getString(R.string.Welcome),
                R.drawable.hello_icon,R.color.firstList));

        addSlide(AppIntroFragment.createInstance(
                getString(R.string.answer),
                getString(R.string.getAnswer),
                R.drawable.aswer_icon,R.color.secondList
        ));

        addSlide(AppIntroFragment.createInstance(
                getString(R.string.switch_off),
                getString(R.string.ShutDown),
                R.drawable.off_on_icon,R.color.thirdList
        ));

        setTransformer(AppIntroPageTransformerType.Fade.INSTANCE);


        showStatusBar(false);

        setScrollDurationFactor(2);

        setSystemBackButtonLocked(false);

        setSkipButtonEnabled(true);

        setImmersiveMode();

        setIndicatorEnabled(true);

        setButtonsEnabled(true);

    }

    @Override
    protected void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        finish();
    }

    @Override
    protected void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }
}