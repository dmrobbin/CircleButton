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
    Shape[] shapes;
    int numberOfCircles;
    int numberOfRectanlges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textView);;
        shape1 = ShapeFactory.getShape(this,"Circle");
        shape2 = ShapeFactory.getShape(this,"Rectangle");

        drawView = new Circle(this);
        canvas = (RelativeLayout) findViewById(R.id.canvasLayout);
        shapes = new Shape[10];

        circleButton = (Button) findViewById(R.id.cButton);
        rectButton = (Button) findViewById(R.id.rectangleButton);
        final Context context = this.getApplicationContext();


        text.setText(shape1.getShapeType()+ " " + shape2.getShapeType());


        circleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { adjustShapesAlpha();

                    shape1 = ShapeFactory.getShape(context,"Circle");;

            canvas.addView(shape1); updateShapesCount();
        } });



        rectButton.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View v) { adjustShapesAlpha();

                shape1 =ShapeFactory.getShape(context,"Rectangle");;

            canvas.addView(shape1); updateShapesCount();
        } });
    }

    void adjustShapesAlpha(){

    }

    void updateShapesCount(){
        text.setText(numberOfRectanlges+ " Rectangles" +numberOfCircles+ " Circles");

    }
}
