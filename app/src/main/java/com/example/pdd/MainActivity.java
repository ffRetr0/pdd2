package com.example.pdd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
Button button_start, button_exam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        button_start= (Button) findViewById(R.id.button_start); //кнопка начать
        button_exam= (Button) findViewById(R.id.button_exam); //кнопка экзамена
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override //переход на другой активити
            public void onClick(View view) {
                try {
                    Intent intent=new Intent(MainActivity.this, pdd_levels.class);
                    intent.putExtra("exam_mode",false);
                    startActivity(intent);finish();
                }catch (Exception e){ }
            }
        });

        button_exam.setOnClickListener(new View.OnClickListener() {
            @Override //переход на другой активити
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(MainActivity.this, pdd_levels.class);
                    intent.putExtra("exam_mode", true);
                    startActivity(intent);
                    finish();
                }catch (Exception e){ }
            }
        });
    }
}