package com.example.lesson3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintSet;

public class MyDraw extends View {
    Paint paint = new Paint();
    int i = 0;
    int N = 100;
    int[] MassPointX = new int[N];
    int[] MassPointY = new int[N];
    float TouchX, TouchY;


    public MyDraw(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP: {
                TouchX = event.getX();
                TouchY = event.getY();
            }
            break;
            case MotionEvent.ACTION_MOVE: {
                i++;
                MassPointX[i % N] = (int) event.getX();
                MassPointY[i % N] = (int) event.getY();
            }
            break;

        }


        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        for (int i = 0; i < N; i++) {
            canvas.drawRect(MassPointX[i] - 50, MassPointY[i] - 50, MassPointX[i] + 50, MassPointY[i] + 50, paint);

        }


        invalidate();
    }
}

