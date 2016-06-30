package com.example.xross.circlebutton2;

import android.graphics.Canvas;
import android.view.View;
import android.content.Context;

abstract class Shape extends View {

    public Shape(Context context){
        super(context);
    }

    void setShapeAlpha(float Alpha){

    }

    float getShapeAlpha(){
        //TODO code logic here
        float alpha= 14214141;
        return alpha;
    }

    void removeShape(){

    }

    abstract String getShapeType();

    @Override
    public abstract void onDraw(Canvas canvas);
}