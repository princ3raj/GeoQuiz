package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Gravity;

public class MainActivity extends AppCompatActivity {
     Button mTrueButton;
     Button mFalseButton;
     Button mNextButton;
     TextView mQuestionTextView;

    private Question []mQuestionBank=new Question[]
            {
                new Question(R.string.question_australia,true),

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
        setContentView(R.layout.activity_main);

        mTrueButton=(Button)findViewById(R.id.true_button);
        mFalseButton=(Button)findViewById(R.id.false_button);
        mNextButton=(Button)findViewById(R.id.next_button);
        mQuestionTextView=findViewById(R.id.question_text_view);


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


        mCurrentIndex=-1;
        UpdateQuestion();


    }

    private void UpdateQuestion() {
        mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;
              int question=mQuestionBank[mCurrentIndex].getmTextResId();
                mQuestionTextView.setText(question);



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



}
