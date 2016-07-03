package com.example.xross.shapesapp;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.content.Context;
import java.util.Random;

public class Rectangle extends Shape {
        Paint paint = new Paint();
        public float alpha = getShapeAlpha();

    public Rectangle(Context context){
        super(context);
    }

    public String getShapeType(){
        return "Rectangle";
    }

    @Override
    public void onDraw(Canvas canvas){
        Random rand = new Random();
        paint.setColor(Color.BLACK);
        canvas.drawRect(230,230,230,230,paint);

    }



}
