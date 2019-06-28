package com.app.thestream.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.app.thestream.R;
import com.app.thestream.models.User;
import com.app.thestream.utils.UserPref;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;
import com.github.paolorotolo.appintro.model.SliderPage;

public class IntroAct extends AppIntro {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Instead of fragments, you can also use our default slide.
        // Just create a `SliderPage` and provide title, description, background and image.
        // AppIntro will do the rest.
        SliderPage sliderPage = new SliderPage();
        sliderPage.setTitle("first page");
        sliderPage.setDescription("Discription of first page");
        sliderPage.setImageDrawable(R.drawable.ic_other_email);
        sliderPage.setBgColor(getResources().getColor(android.R.color.holo_blue_light));
        addSlide(AppIntroFragment.newInstance(sliderPage));

        SliderPage sliderPage2= new SliderPage();
        sliderPage.setTitle("seccond page");
        sliderPage.setDescription("Discription of seccond page");
        sliderPage.setImageDrawable(R.drawable.ic_other_email);
        sliderPage.setBgColor(getResources().getColor(android.R.color.holo_blue_light));
        addSlide(AppIntroFragment.newInstance(sliderPage));

        SliderPage sliderPage3 = new SliderPage();
        sliderPage.setTitle("third page");
        sliderPage.setDescription("Discription of third page");
        sliderPage.setImageDrawable(R.drawable.ic_other_email);
        sliderPage.setBgColor(getResources().getColor(android.R.color.holo_blue_light));
        addSlide(AppIntroFragment.newInstance(sliderPage));
        // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#3F51B5"));
        setSeparatorColor(Color.parseColor("#2196F3"));

        // Hide Skip/Done button.
        showSkipButton(true);
        setProgressButtonEnabled(true);


        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
        setVibrate(true);
        setVibrateIntensity(30);




    }
    @Override
    public void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        // Do something when users tap on Skip button.
               startActivity(new Intent(this,MainActivity.class));
               finish();

    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        // Do something when users tap on Done button.
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    @Override
    public void onSlideChanged(@Nullable Fragment oldFragment, @Nullable Fragment newFragment) {
        super.onSlideChanged(oldFragment, newFragment);
        // Do something when the slide changes.
    }
}
