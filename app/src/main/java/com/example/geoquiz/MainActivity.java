package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Gravity;

public class MainActivity extends AppCompatActivity {
     Button mTrueButton;
     Button mFalseButton;
     ImageButton mNextButton;
     TextView mQuestionTextView;
     ImageButton mPrevButton;

    private Question []mQuestionBank=new Question[]
            {


                new Question(R.string.question_africa,false),
                    new Question(R.string.question_americas,true),

                    new Question(R.string.question_asia,false),

                    new Question(R.string.question_mideast,true),

                    new Question(R.string.question_oceans,true)
            };
    private int mCurrentIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mTrueButton=(Button)findViewById(R.id.true_button);
        mFalseButton=(Button)findViewById(R.id.false_button);
        mNextButton=(ImageButton)findViewById(R.id.next_button);
        mQuestionTextView=findViewById(R.id.question_text_view);
        mPrevButton=(ImageButton)findViewById(R.id.prev_button);

        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PrevUpdate();
            }


        });


        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             CheckAnswer(true);

            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               CheckAnswer(false);
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateQuestion();
            }
        });



        UpdateQuestion();


    }

    private void UpdateQuestion() {
        if(mCurrentIndex<4) {
            mCurrentIndex = (mCurrentIndex + 1);
            int question = mQuestionBank[mCurrentIndex].getmTextResId();
            mQuestionTextView.setText(question);

        }

    }

    public void CheckAnswer(boolean  UserPressedTrue)
    {
      boolean isAnswerTrue=mQuestionBank[mCurrentIndex].getmAnswerTrue();
      int messageResId=0;

      if(UserPressedTrue==isAnswerTrue)
      {
          messageResId=R.string.correct_toast;

      }
      else
      {
          messageResId=R.string.incorrect_toast;
      }
      Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();




    }

    private void PrevUpdate() {
            if(mCurrentIndex>0) {
                mCurrentIndex = (mCurrentIndex - 1);
                int question = mQuestionBank[mCurrentIndex].getmTextResId();
                mQuestionTextView.setText(question);
            }


    }

}
