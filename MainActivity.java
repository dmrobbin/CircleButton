package com.example.xross.shapesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Paint;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.RelativeLayout;
import android.widget.ImageView;
import android.content.Context;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Shape shape1;
    Shape shape2;
    RelativeLayout canvas;
    ImageView imageView;
    BitmapFactory mainImage;
    Shape drawView;
    Paint paint;
    Bitmap bitmap;
    Button circleButton;
    Button rectButton;
    Button clear;
    Vector<Shape> vector;
    int numberOfCircles;
    int numberOfRectanlges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textView);;

        drawView = new Circle(this);
        canvas = (RelativeLayout) findViewById(R.id.canvasLayout);
        vector = new Vector<Shape>();
        circleButton = (Button) findViewById(R.id.cButton);
        rectButton = (Button) findViewById(R.id.rectangleButton);
        clear = (Button) findViewById(R.id.clearButton);

        final Context context = this.getApplicationContext();
        updateShapesCount();

        circleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

       //         adjustShapesAlpha();
                shape1 = ShapeFactory.getShape(context,"Circle");
                vector.add(shape1);

                canvas.addView(shape1);
                updateShapesCount();
        } });


        rectButton.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
            adjustShapesAlpha();
            shape1 =ShapeFactory.getShape(context,"Rectangle");;
            vector.add(shape1);

            canvas.addView(shape1); updateShapesCount();
        } });


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0;i<vector.size();i++){
                    Shape toDelete = vector.get(i);
                    toDelete.setShapeAlpha(0); //makes all shapes in vector invisible
                }
                vector.clear(); //empties vector
                updateShapesCount();
            } });
    }



    void adjustShapesAlpha(){
        if(vector.isEmpty())
            return;
        for (int i = 0; i < vector.size(); i++) { //loop to search though all shapes in vector
            Shape toAdjust = vector.get(i);
            toAdjust.setShapeAlpha(toAdjust.getShapeAlpha()-0.2f);// lowers alpha of each element by 0.2f

            if(toAdjust.getShapeAlpha()<=0){ //removes vector if it's alpha is 0 or less
                toAdjust.removeShape();
                vector.remove(toAdjust);
            }
        }
    }

    void updateShapesCount(){
        numberOfCircles=0;
        numberOfRectanlges=0;

        if (vector.isEmpty()==false) { //only bothers to count if vector isn't empty
            for (int i = 0; i < vector.size(); i++) { //loop to search though all shapes in vector
                Shape toCount = vector.get(i);
                if (toCount.getShapeType() == "Circle")
                    numberOfCircles += 1; //count circles
                if (toCount.getShapeType() == "Rectangle")
                    numberOfRectanlges += 1; //count rectangles
            }
        }
        text.setText(numberOfRectanlges+ " Rectangles " +numberOfCircles+ " Circles");

    }
}
