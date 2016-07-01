package com.example.xross.shapesapp;

/**
 * Created by Xross on 6/29/16.
 */
import android.content.Context;

public class ShapeFactory {

public static Shape getShape(Context context, String Shape){
    if(Shape==null){
        return null;
    }
    if(Shape.equals("Rectangle")){
        return new Rectangle(context);
    }
    if(Shape.equals("Circle")){
        return new Circle(context);
    }
    return null;
}
}
