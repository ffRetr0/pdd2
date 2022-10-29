package com.example.pdd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
/*
по поводу хмл файла. при одном linear layout у меня приложение пишет что системный сбой, поэтому я делаю их столько же сколько билетов
 */
public class pdd_levels extends AppCompatActivity {
Button button_back;
public int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdd_levels);
        Bundle arguments = getIntent().getExtras();
        boolean exam_mode = arguments.getBoolean("exam_mode");
        button_back = (Button) findViewById(R.id.button_back);// кнопка назад
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(pdd_levels.this, MainActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){

                }
            }
        });

    //кнопка для 1 билета
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(pdd_levels.this, TicketActivity.class);
                    intent.putExtra("exam_mode", exam_mode);
                    intent.putExtra("number_ticket", 1);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });


        //для второго
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(pdd_levels.this, TicketActivity.class);
                    intent.putExtra("exam_mode", exam_mode);
                    intent.putExtra("number_ticket", 2);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });
        //и для третьего
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(pdd_levels.this, TicketActivity.class);
                    intent.putExtra("exam_mode", exam_mode);
                    intent.putExtra("number_ticket", 3);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(pdd_levels.this, TicketActivity.class);
                    intent.putExtra("exam_mode", exam_mode);
                    intent.putExtra("number_ticket", 4);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });
        TextView textView5 = (TextView) findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(pdd_levels.this, TicketActivity.class);
                    intent.putExtra("exam_mode", exam_mode);
                    intent.putExtra("number_ticket", 5);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });
        TextView textView6 = (TextView) findViewById(R.id.textView6);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(pdd_levels.this, TicketActivity.class);
                    intent.putExtra("exam_mode", exam_mode);
                    intent.putExtra("number_ticket", 6);
                    startActivity(intent);
                    finish();
                }catch (Exception e) {

                }
            }
        });
    }

    //cис кнопка назад
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(pdd_levels.this, MainActivity.class);
            startActivity(intent);finish();
        }catch (Exception e){

        }
    }
}