package com.example.xross.shapesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.graphics.Canvas;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap;
import android.widget.RelativeLayout;
import android.widget.ImageView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textView);
        text.setText("SJL");
        shape1 = ShapeFactory.getShape(this,"Circle");
        shape2 = ShapeFactory.getShape(this,"Rectangle");
        /*
        canvas = (RelativeLayout) findViewById(R.id.canvasLayout);
        canvas.addView(drawView);
        Canvas imageCanvas = new Canvas();
        */

        text.setText(shape1.getShapeType()+ " " + shape2.getShapeType());
    }

    void adjustShapeAlpha(){

    }

    void updateShapeCount(){

    }
}
