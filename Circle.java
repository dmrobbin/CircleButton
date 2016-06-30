package com.example.xross.circlebutton2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.content.Context;
import java.util.Random;

public class Circle extends Shape {

    Paint paint = new Paint();


    public Circle(Context context){
        super(context);
    }

    public String getShapeType(){
        return "circle";
    }

    @Override
    public void onDraw(Canvas canvas){
        Random rand = new Random();
        canvas.drawColor(Color.LTGRAY);
        paint.setColor(rand.nextInt());
        canvas.drawCircle(rand.nextFloat()*(300-100)+100,rand.nextFloat()*(300-100)+100,
                rand.nextFloat()*(300-100)+100,paint);

    }

}