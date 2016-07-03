package com.example.xross.shapesapp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.content.Context;
import java.util.Random;
import android.graphics.drawable.ShapeDrawable;

public class Circle extends Shape {

    Paint paint = new Paint();
    public float alpha= getShapeAlpha();


    public Circle(Context context){
        super(context);
    }

    public String getShapeType(){
        return "Circle";
    }

    @Override
    public void onDraw(Canvas canvas){
        Random rand = new Random();
        paint.setColor(rand.nextInt());
        canvas.drawCircle(rand.nextFloat()*(800-300)+300,rand.nextFloat()*(1200-300)+300,
                rand.nextFloat()*(300-100)+100,paint);
    }




}

