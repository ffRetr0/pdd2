package com.example.pdd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/*
у меня много переменных по названию которых понятно за что они отвечают
в других билетах не буду комментить, там все аналогично
 */
public class TicketActivity extends AppCompatActivity {
    Dialog dialog; //сверху кнопка что делать
    Dialog dialogEnd;
    Button button_back;
    ImageView img;
    TextView quest;
    Button ans1;
    Button ans2;
    Button wdl;
    Button ans3;
    Button butcon1;//кнопка продолжить в первом диалоговом окне (кнопка что делать)
    Button butcon; //кнопка хорошо во втором диалоговом окне
    boolean exam_mode = false;
    int i = 1, number_ticket = 1;
    public  int truan = 0; //cкок правильных (хочу сделать чтобы при всех верных загоралось зеленым)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        Bundle arguments = getIntent().getExtras();
        exam_mode = arguments.getBoolean("exam_mode");
        number_ticket = arguments.getInt("number_ticket");
        UniversalTicket universalTicket = new UniversalTicket(number_ticket, this);
        TextView text_tikets = (TextView) findViewById(R.id.text_tikets);
        text_tikets.setText("Билет " + Integer.toString(number_ticket));
        wdl = (Button) findViewById(R.id.wdl);
        img = (ImageView) findViewById(R.id.imgleft);
        quest = (TextView) findViewById(R.id.quest);
        ans1 = (Button) findViewById(R.id.ans1);
        ans2 = (Button) findViewById(R.id.ans2);
        ans3 = (Button) findViewById(R.id.ans3);
        img.setImageResource(universalTicket.getImageQuestion(i));
        quest.setText(universalTicket.getTextQuestion(i));
        ans1.setText(universalTicket.getAnswerQuestion1(i));
        ans2.setText(universalTicket.getAnswerQuestion2(i));
        ans3.setText(universalTicket.getAnswerQuestion3(i));
        //это те самые полоски сверху
        final int[] progressbar ={
                R.id.point1,
                R.id.point2,
                R.id.point3,
                R.id.point4,
                R.id.point5,
                R.id.point6,
                R.id.point7,
                R.id.point8,
                R.id.point9,
                R.id.point10,
                R.id.point11,
                R.id.point12,
                R.id.point13,
                R.id.point14,
                R.id.point15,
                R.id.point16,
                R.id.point17,
                R.id.point18,
                R.id.point19,
                R.id.point20
        };
        button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(TicketActivity.this, pdd_levels.class);
                    intent.putExtra("exam_mode", exam_mode);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        dialog = new Dialog(this);
        wdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); //cкрываем заголовок
                dialog.setContentView(R.layout.what_doing);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалога
                dialog.show();
                butcon1 = (Button) dialog.findViewById(R.id.butcon1);
                butcon1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });
            }
        });
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); //cкрываем заголовок
        dialogEnd.setContentView(R.layout.congrat);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалога
        TextView descript = (TextView)dialogEnd.findViewById(R.id.descript);
        butcon= (Button)dialogEnd.findViewById(R.id.butcon);
        butcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(TicketActivity.this, pdd_levels.class);
                    intent.putExtra("exam_mode", exam_mode);
                    startActivity(intent);
                    finish();
                } catch (Exception e){

                }
                dialogEnd.cancel();
            }
        });
        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) findViewById(progressbar[i - 1]);
                if (universalTicket.getRightAnswer(i) == 1) { //сверяем правильный ли ответ
                    if (exam_mode) {
                        textView.setBackgroundResource(R.drawable.style_points_exam);
                    } else {
                        textView.setBackgroundResource(R.drawable.style_points_right);
                    }
                    truan++; //счетчик правильных ответов
                }
                else {
                    if (exam_mode) {
                        textView.setBackgroundResource(R.drawable.style_points_exam);
                    } else {
                        textView.setBackgroundResource(R.drawable.style_points_wrong);
                    }
                }
                if(i == 20){
                    dialogEnd.show();
                    descript.setText(Html.fromHtml("<b>Правильных ответов: " + Integer.toString(truan) + " из 20<br><br></b>" + getResources().getString(R.string.nicenigga)));
                }
                else {
                    i++;
                    img.setImageResource(universalTicket.getImageQuestion(i));
                    ans1.setText(universalTicket.getAnswerQuestion1(i));
                    ans2.setText(universalTicket.getAnswerQuestion2(i));
                    ans3.setText(universalTicket.getAnswerQuestion3(i));
                    quest.setText(universalTicket.getTextQuestion(i));
                }
            }
        });
        //аналогично
        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) findViewById(progressbar[i - 1]);
                if (universalTicket.getRightAnswer(i) == 2) { //сверяем правильный ли ответ
                    if (exam_mode) {
                        textView.setBackgroundResource(R.drawable.style_points_exam);
                    } else {
                        textView.setBackgroundResource(R.drawable.style_points_right);
                    }
                    truan++; //счетчик правильных ответов
                }
                else {
                    if (exam_mode) {
                        textView.setBackgroundResource(R.drawable.style_points_exam);
                    } else {
                        textView.setBackgroundResource(R.drawable.style_points_wrong);
                    }
                }
                if(i == 20){
                    dialogEnd.show();
                    descript.setText(Html.fromHtml("<b>Правильных ответов: " + Integer.toString(truan) + " из 20<br><br></b>" + getResources().getString(R.string.nicenigga)));
                }
                else {
                    i++;
                    img.setImageResource(universalTicket.getImageQuestion(i));
                    ans1.setText(universalTicket.getAnswerQuestion1(i));
                    ans2.setText(universalTicket.getAnswerQuestion2(i));
                    ans3.setText(universalTicket.getAnswerQuestion3(i));
                    quest.setText(universalTicket.getTextQuestion(i));
                }
            }
        });
        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = (TextView) findViewById(progressbar[i - 1]);
                if (universalTicket.getRightAnswer(i) == 3) { //сверяем правильный ли ответ
                    if (exam_mode) {
                        textView.setBackgroundResource(R.drawable.style_points_exam);
                    } else {
                        textView.setBackgroundResource(R.drawable.style_points_right);
                    }
                    truan++; //счетчик правильных ответов
                }
                else {
                    if (exam_mode) {
                        textView.setBackgroundResource(R.drawable.style_points_exam);
                    } else {
                        textView.setBackgroundResource(R.drawable.style_points_wrong);
                    }
                }
                if(i == 20){
                    dialogEnd.show();
                    descript.setText(Html.fromHtml("<b>Правильных ответов: " + Integer.toString(truan) + " из 20<br><br></b>" + getResources().getString(R.string.nicenigga)));
                }
                else {
                    i++;
                    img.setImageResource(universalTicket.getImageQuestion(i));
                    ans1.setText(universalTicket.getAnswerQuestion1(i));
                    ans2.setText(universalTicket.getAnswerQuestion2(i));
                    ans3.setText(universalTicket.getAnswerQuestion3(i));
                    quest.setText(universalTicket.getTextQuestion(i));
                }
            }
        });
    }

    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(TicketActivity.this, pdd_levels.class);
            intent.putExtra("exam_mode", exam_mode);
            startActivity(intent);
            finish();
        }catch (Exception e){

        }
    }
}



