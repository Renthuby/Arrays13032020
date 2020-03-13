package ru.itschool.myrec;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyDraw extends View {

    int r = 200;
    int x;
    int y;
    int l = 2;

    public MyDraw(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);


//        paint.setAntiAlias(true);

        x = canvas.getWidth() / 2;
        y = canvas.getHeight() / 2;

        MyRect(r,canvas, x, y, l);


    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        x = w / 2;
        y = h / 2;
    }

    public void MyRect(int r, Canvas canvas, int x, int y, int n) {
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
        paint.setAntiAlias(true);
        if (n == 0) paint.setColor(Color.RED);
        if (n == 1) paint.setColor(Color.RED);
        if (n == 2) paint.setColor(Color.GREEN);
        if (n == 3) paint.setColor(Color.YELLOW);
        canvas.drawCircle(x,y,r,paint);

        if (n == 0) return;

        MyRect(r / 2, canvas, x + r, y, n - 1);
        MyRect(r / 2, canvas, x - r, y, n - 1);
        MyRect(r / 2, canvas, x, y + r, n - 1);
        MyRect(r / 2, canvas, x, y - r, n - 1);

    }
}
