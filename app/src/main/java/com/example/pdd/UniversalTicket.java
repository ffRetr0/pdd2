package com.example.pdd;

import android.content.Context;

public class UniversalTicket {
    public Context context;
    public int number_ticket = 0;
    public int[] image_question = new int[21];
    public int[] text_question = new int[21];
    public int[] answer_question_1 = new int[21];
    public int[] answer_question_2 = new int[21];
    public int[] answer_question_3 = new int[21];
    public int[] right_answer = new int[21];
    public UniversalTicket(int number_ticket, Context context){
        this.number_ticket = number_ticket;
        this.context = context;
        for (int i = 1; i <= 20; i++){
            image_question[i] = context.getResources().getIdentifier("t" + Integer.toString(number_ticket) + "q" + Integer.toString(i), "drawable", context.getPackageName());
            text_question[i] = context.getResources().getIdentifier("tik" + Integer.toString(number_ticket) + "q" + Integer.toString(i), "string", context.getPackageName());
            answer_question_1[i] = context.getResources().getIdentifier("tik" + Integer.toString(number_ticket) + "q" + Integer.toString(i) + "a1", "string", context.getPackageName());
            answer_question_2[i] = context.getResources().getIdentifier("tik" + Integer.toString(number_ticket) + "q" + Integer.toString(i) + "a2", "string", context.getPackageName());
            answer_question_3[i] = context.getResources().getIdentifier("tik" + Integer.toString(number_ticket) + "q" + Integer.toString(i) + "a3", "string", context.getPackageName());
            right_answer[i] = context.getResources().getIdentifier("tik" + Integer.toString(number_ticket) + "r" + Integer.toString(i), "string", context.getPackageName());
        }
    }
    public int getImageQuestion(int number_question){
        return image_question[number_question];
    }
    public int getTextQuestion(int number_question){
        return text_question[number_question];
    }
    public int getAnswerQuestion1(int number_question){
        return answer_question_1[number_question];
    }
    public int getAnswerQuestion2(int number_question){
        return answer_question_2[number_question];
    }
    public int getAnswerQuestion3(int number_question){
        return answer_question_3[number_question];
    }
    public int getRightAnswer(int number_question){
        return Integer.parseInt(context.getString(right_answer[number_question]));
    }
}
