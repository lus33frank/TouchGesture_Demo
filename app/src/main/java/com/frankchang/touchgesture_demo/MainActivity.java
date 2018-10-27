package com.frankchang.touchgesture_demo;

import android.annotation.SuppressLint;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView show;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show = findViewById(R.id.tvShow);

        ConstraintLayout view = findViewById(R.id.layout);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                show.setText("");

                int action = event.getAction();
                int count = event.getPointerCount();

                for (int i = 0; i < count; i++) {
                    float x = event.getX();
                    float y = event.getY();

                    String msg = i + ".X: " + x + "; Y: " + y + "\n";
                    show.setText(msg);
                }

                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        show.append("ACTION_DOWN");
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        show.append("ACTION_MOVE");
                        return true;

                    case MotionEvent.ACTION_UP:
                        show.append("ACTION_UP");
                        return true;

                     default:
                        return false;
                }
            }
        });
    }

}
