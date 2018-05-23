package com.example.user.toado;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class thuattoan {
    public static int[][] A = new int[50][50];
    public static int[][] B = new int[50][50];
    public static int C[][] = new  int[100][100];
    public static int D[] = new  int[100];
    public static int E[] = new int[200];
    public static int i,j,a,b,c,d,e,f,g,h,k,n;
    public static int o,p=0,q=0;
    public static int dodai=0;
    public static int chuoi;
    public static int so;
    public static int hang;
    public static int hang2;
    public static int cot;
    public static int rong;
    public static int dai;
    public static int lap;
    public static int dodai1=0;
    public static void thuattoan1(){
        for(i=0 ;i<dai ;i++){
            for (j=0;j<rong;j++){
                if(A[i][j]==1){
                    B[i][j] = 2;
                }
                if(A[i][j]==0){
                    B[i][j] = 0;
                }
            }
        }


        if(a!=0||b!=0){

            if(c!=0||d!=0){
                if(a!=c||b!=d){
                    e=a+1;
                    f=a-1;
                    g=b+1;
                    h=b-1;
                    if(	B[e][b]==0){
                        B[e][b]=1;
                        C[0][0]=1;
                        C[0][1]= e*100+b;
                    }
                    if(	B[f][b]==0){
                        B[f][b]=1;
                        C[1][0]=1;
                        C[1][1]= f*100+b;
                    }
                    if(	B[a][g]==0){
                        B[a][g]=1;
                        C[2][0]=1;
                        C[2][1]=a*100+g;
                    }
                    if(	B[a][h]==0){
                        B[a][h]=1;
                        C[3][0]=1;
                        C[3][1]= a*100 + h;
                    }

                }
                while(p!=c||q!=d){
                    dodai = dodai + 1;
                    for(chuoi=0; chuoi<=50; chuoi++){
                        if(C[chuoi][0]==dodai){
                            so = C[chuoi][dodai];
                            hang = so / 100;
                            cot = so % 100;
                            if(hang==c&&cot==d){
                                p=hang;
                                q=cot;
                                for(k=1; k<=dodai;k++){
                                    D[k]=C[chuoi][k];
                                }
                            }
                            e = hang +1;
                            f = hang -1;
                            g = cot + 1;
                            h = cot -1;
                            dodai1 = dodai + 1;
                            if(B[e][cot]==0){
                                lap = 0;
                                B[e][cot]=1;
                                while(C[lap][0]!=0){
                                    lap = lap +1;
                                }
                                C[lap][0]= dodai1;
                                C[lap][dodai1]= e*100 + cot;
                                for(k=1;k<=dodai;k++){
                                    C[lap][k]=C[chuoi][k];
                                }
                            }
                            if(B[f][cot]==0){
                                lap = 0;
                                B[f][cot]=1;
                                while(C[lap][0]!=0){
                                    lap = lap +1;
                                }
                                C[lap][0]= dodai1;
                                C[lap][dodai1]= f*100 + cot;
                                for(k=1;k<=dodai;k++){
                                    C[lap][k]=C[chuoi][k];
                                }
                            }
                            if(B[hang][g]==0){
                                lap = 0;
                                B[hang][g]=1;
                                while(C[lap][0]!=0){
                                    lap = lap +1;
                                }
                                C[lap][0]= dodai1;
                                C[lap][dodai1]= hang*100 + g;
                                for(k=1;k<=dodai;k++){
                                    C[lap][k]=C[chuoi][k];
                                }
                            }
                            if(B[hang][h]==0){
                                lap = 0;
                                B[hang][h]=1;
                                while(C[lap][0]!=0){
                                    lap = lap +1;
                                }
                                C[lap][0]= dodai1;
                                C[lap][dodai1]= hang*100 + h;
                                for(k=1;k<=dodai;k++){
                                    C[lap][k]=C[chuoi][k];
                                }
                            }
                            C[chuoi][0] = 0;
                        }

                    }
                }

                for (i= 1; i<70; i++){
                    j = (i-1)*2;
                    E[j]= D[i]%100;
                    E[j+1] = D[i]/100;
                }
            }

        }

    }

}
