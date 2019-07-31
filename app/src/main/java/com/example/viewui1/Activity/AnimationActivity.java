package com.example.viewui1.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.viewui1.R;

public class AnimationActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvData;
    private Button btnBlink, btnBounce, btnFadeIn, btnFadeOut,
            btnMove, btnRotate, btnSlideUp, btnSlideDown, btnZoomIn, btnPrev;
    private Animation animation;
    private EditText etData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        init();
    }

    private void init() {
        //tvData = findViewById(R.id.tvData);
        etData = findViewById(R.id.etData);
        btnBlink = findViewById(R.id.btnBlink);
        btnPrev = findViewById(R.id.btnPrev);
        btnBounce = findViewById(R.id.btnBounce);
        btnFadeIn = findViewById(R.id.btnFadeIn);
        btnFadeOut = findViewById(R.id.btnFadeOut);
        btnMove = findViewById(R.id.btnMove);
        btnRotate = findViewById(R.id.btnRotate);
        btnSlideDown = findViewById(R.id.btnSlideDown);
        btnSlideUp = findViewById(R.id.btnSlideUp);
        btnZoomIn = findViewById(R.id.btnZoomIn);

        btnZoomIn.setOnClickListener(this);
        btnSlideUp.setOnClickListener(this);
        btnSlideDown.setOnClickListener(this);
        btnRotate.setOnClickListener(this);
        btnMove.setOnClickListener(this);
        btnFadeOut.setOnClickListener(this);
        btnFadeIn.setOnClickListener(this);
        btnBounce.setOnClickListener(this);
        btnBlink.setOnClickListener(this);
        btnPrev.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnBlink:
                animation = AnimationUtils.loadAnimation(this, R.anim.blink);
                break;
            case R.id.btnBounce:
                animation = AnimationUtils.loadAnimation(this, R.anim.bounce);
                break;
            case R.id.btnFadeIn:
                animation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
                break;
            case R.id.btnFadeOut:
                animation = AnimationUtils.loadAnimation(this, R.anim.fade_out);
                break;
            case R.id.btnMove:
                animation = AnimationUtils.loadAnimation(this, R.anim.move);
                break;
            case R.id.btnRotate:
                animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                break;
            case R.id.btnSlideDown:
                animation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
                break;
            case R.id.btnSlideUp:
                animation = AnimationUtils.loadAnimation(this, R.anim.slide_up);
                break;
            case R.id.btnZoomIn:
                animation = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
                break;
            case R.id.btnPrev:
                Intent i = new Intent(this, TestActivity.class);
                startActivity(i);
                break;
        }
        etData.startAnimation(animation);
    }
}
