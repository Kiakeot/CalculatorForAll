package com.example.calculatorforall;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.airbnb.lottie.LottieAnimationView;

public class InternetDialog extends Dialog {
    Button errorButton;
    private LottieAnimationView animation;

    public InternetDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internet_error);
        errorButton = findViewById(R.id.errorButton);
        animation = findViewById(R.id.animationView);
        errorButton.setOnClickListener(view -> {
            dismiss();
        });
    }
}
