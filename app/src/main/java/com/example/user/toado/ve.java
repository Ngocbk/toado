package com.example.user.toado;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.view.MotionEvent;
import android.view.View;
import android.util.AttributeSet;
import android.widget.ImageView;
import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;

public class ve extends View{
    public static int z, t, i;
    public static float x, y, dx,dy, eventX, eventY;
    public static float D[] = new float[2000];
    MainActivity main = new MainActivity();
    thuattoan thuattoan = new thuattoan();
    map map = new map();
    public Path path;
    public Handler handler = new Handler();

    public static int size;
    public static float M[] = new float[150];
    public static float G[] = new float[100];
    public Paint paint2;
    public Paint paint;
    public Paint robot;
    public Paint duong;
    public void initPant(){
        paint2 =new Paint(Paint.ANTI_ALIAS_FLAG);
        paint2.setColor(Color.BLUE);
        paint2.setStrokeWidth(size*2/3);
    }

    public ve(Context context){
        super(context);

    }

    public ve(Context context, AttributeSet attrs){
        super(context, attrs);
        paint = new Paint();
        path = new Path();
        paint.setAntiAlias(true);// khu rang cua
        paint.setStrokeWidth(6f);// do day
        paint.setColor(Color.RED);// gan mau
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        robot =new Paint(Paint.ANTI_ALIAS_FLAG);
        robot.setColor(R.color.colorAccent);
        robot.setStrokeWidth(size*2/3);
        duong =new Paint(Paint.ANTI_ALIAS_FLAG);
        duong.setColor(Color.GREEN);
        duong.setStrokeWidth(size*2/3);
        initPant();
    }
    @Override
    public void onDraw(final Canvas canvas){
        super.onDraw(canvas);
        canvas.drawPath( path, paint);
        for(int a=0; a<2000; a = a + 2){
            for(int b= a+2; b<2000; b = b + 2){
                if(D[a]!=0||D[a+1]!=0){
                    if(D[a]==D[b]&& D[a+1]==D[b+1]){
                        D[b]= 0 ;
                        D[b+1]= 0;
                    }
                }
                int ngang = (int)D[a]/size;
                int doc = (int) D[a+1]/size;
                if(thuattoan.A[doc][ngang]==1){
                    D[a]=0;
                    D[a+1]=0;
                }
            }

        }
        thuattoan.thuattoan1();


        for(int c= 0; c<150; c++){
            M[c]= thuattoan.E[c]*size;
        }

        canvas.drawPoint(thuattoan.b*size,thuattoan.a*size,robot);
        canvas.drawPoints(M, duong);
        canvas.drawPoints(D , paint2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        eventX = event.getX();
        eventY = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX,eventY);
                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                for (i=0; i<2000; i= i+2){
                    if(D[i]==0&&D[i+1]==0){
                        D[i]= (int)eventX/size;
                        D[i] = D[i] *size;
                        D[i+1] = (int)eventY/size;
                        D[i+1] = D[i+1] *size;
                    }
                }

                break;
            default:
                return false;
        }
        invalidate();
        return true;
    }
}
