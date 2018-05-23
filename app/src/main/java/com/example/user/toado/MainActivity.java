package com.example.user.toado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.view.View;
import android.util.AttributeSet;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;

import com.github.nkzawa.socketio.client.Socket;
import java.net.URISyntaxException;
import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    public static int amap1 = 1;
    public static int amap;
    public static float x, y;
    public static ImageView imageView;
    public map map;

    public static Socket msocket;
    public static String ip="http://192.168.43.20:3000";
    {
        try {
            msocket = IO.socket(ip);
        }catch (URISyntaxException e){}
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById((R.id.imageview));
        Button setmap = findViewById(R.id.map);
        Button starttime = findViewById(R.id.starttime);
        Button reset = findViewById(R.id.reset);
        final Button ipconfig= (Button)findViewById(R.id.ipconfig);
        final EditText editText= (EditText)findViewById(R.id.edittext);
        msocket.connect();
        editText.setText(ip);

        Intent intent = getIntent();

        amap = intent.getIntExtra("amap", 0);
        if(amap!=0){
            amap1=amap;
        }
        if(amap1==1){
            imageView.setImageResource(R.mipmap.map1);
            thuattoan.dai=39;
            thuattoan.rong=30;
            thuattoan.a = 35;
            thuattoan.b = 5;
            ve.size = 24;
            for (int i =0; i<thuattoan.dai; i++){
                for (int j =0; j<thuattoan.rong; j++){
                    thuattoan.A[i][j]= map.A[i][j];
                }
            }
        }

        if(amap1==2){
            imageView.setImageResource(R.mipmap.map2);
            thuattoan.dai=15;
            thuattoan.rong = 12;
            thuattoan.a = 7;
            thuattoan.b = 4;
            ve.size = 60;
            for (int i =0; i<thuattoan.dai; i++){
                for (int j =0; j<thuattoan.rong; j++){
                    thuattoan.A[i][j]= map.B[i][j];
                }
            }

        }

        if(amap1==3){
            imageView.setImageResource(R.mipmap.map3);
            thuattoan.dai=14;
            thuattoan.rong = 10;
            thuattoan.a = 2;
            thuattoan.b = 2;
            ve.size = 68;
            for (int i =0; i<thuattoan.dai; i++){
                for (int j =0; j<thuattoan.rong; j++){
                    thuattoan.A[i][j]= map.C[i][j];
                }
            }
        }

        if(amap1==4){
            imageView.setImageResource(R.mipmap.map4);
        }

        setmap.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, map.class);
                startActivity(intent);
            }
        });

        starttime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, time.class);
                startActivity(intent);
            }
        });


        ipconfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.ip = editText.getText().toString();
                Intent intent3 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent3);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i<150 ;i++){
                    thuattoan.E[i]=0;
                    ve.M[i]=0;
                }
                thuattoan.dodai=0;
                for(int a=0; a<2000; a ++){
                    ve.D[a]=0;
                }
                thuattoan.d = 0;
                thuattoan.c = 0;
                for (int i=0; i<90;i++){
                    thuattoan.D[i]=0;
                    for (int j= 0; j<90;j++){
                        thuattoan.C[i][j]=0;
                    }
                }
                MainActivity.msocket.disconnect();
                Intent intent1 = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent1);
                }
        });


    }


}
