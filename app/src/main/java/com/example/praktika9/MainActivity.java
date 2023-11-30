package com.example.praktika9;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.praktika9.R;


public class MainActivity extends AppCompatActivity {

    private TextView movableText;
    private float xDelta, yDelta;

    @SuppressLint({"MissingInflatedId", "ClickableViewAccessibility"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movableText = findViewById(R.id.movableText);

        movableText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final float x = event.getRawX();
                final float y = event.getRawY();

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        xDelta = x - view.getX();
                        yDelta = y - view.getY();
                        break;

                    case MotionEvent.ACTION_MOVE:
                        view.setX(x - xDelta);
                        view.setY(y - yDelta);
                        break;

                    case MotionEvent.ACTION_UP:
                        break;
                }

                return true;
            }
        });
    }
}