package com.example.user.toado;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.github.nkzawa.socketio.client.IO;

import com.github.nkzawa.socketio.client.Socket;
import java.net.URISyntaxException;

public class time extends AppCompatActivity {
    MainActivity main = new MainActivity();
    thuattoan thuattoan = new thuattoan();
    int i;
    int j;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time);
        Button back3 = (Button) findViewById(R.id.settime);
        thuattoan.d = (int)ve.D[0]/ve.size;
        thuattoan.c = (int)ve.D[1]/ve.size;
        thuattoan.thuattoan1();


        for(i=0;i<50;i=i+2){
            j = (int)ve.D[i+1]/ve.size;
            MainActivity.msocket.emit("mess", j*100+ve.D[i]/ve.size);
        }

        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(time.this, MainActivity.class);
                startActivity(intent3);
            }
        });
    }
}
