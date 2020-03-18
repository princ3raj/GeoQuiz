package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE
            ="com.example.geoquiz.extra_answer_is_true";



    public static Intent newIntent (Context packageContext, boolean answerIsTrue)
    {
        Intent  intent= new Intent(packageContext,CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        Button mShowAnswerButton;
      final  boolean mTrueAnswer;
       final TextView mAnswerTextView;

         mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);
        mShowAnswerButton = (Button) findViewById(R.id.show_answer_view);

        mTrueAnswer = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, true);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTrueAnswer) {
                    mAnswerTextView.setText(R.string.true_button); } else {
                    mAnswerTextView.setText(R.string.false_button); }
            } });


    }
}
