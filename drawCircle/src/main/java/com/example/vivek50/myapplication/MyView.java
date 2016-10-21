package com.example.vivek50.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by vivek50 on 13/9/16.
 */
public class MyView extends TextView{

    private float Cx,Cy,Radius;
    private Paint paint;

    public MyView(Context context) {
        super(context);

        initpaint();

    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initpaint();

    }

    public void initpaint(){

        paint = new Paint();
        paint.setColor(Color.RED);
    }
    public void changeAttr(float Cx, float Cy, float Radius){

        this.Cx = Cx;
        this.Cy = Cy;
        this.Radius = Radius;
        invalidate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(Cx,Cy,Radius,paint);
    }
}
