package com.example.calculatorforall;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

import com.airbnb.lottie.LottieAnimationView;

public class AlertDialog extends Dialog {
    Button errorButton;
    private LottieAnimationView animation;

    public AlertDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_error);
        errorButton = findViewById(R.id.errorButton);
        animation = findViewById(R.id.animationView);
        errorButton.setOnClickListener(view -> {
            dismiss();
        });
    }
}
