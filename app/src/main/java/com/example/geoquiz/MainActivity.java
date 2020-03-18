package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Gravity;

      public class MainActivity extends AppCompatActivity {








     private static final String TAG="QuizActivity";
     Button mTrueButton;
     Button mFalseButton;
     ImageButton mNextButton;
     TextView mQuestionTextView;
     ImageButton mPrevButton;
     Button mCheatButton;


     private  static final String KEY_INDEX="index";


    private Question []mQuestionBank=new Question[]
            {


                    new Question(R.string.question_africa,false),

                    new Question(R.string.question_americas,true),

                    new Question(R.string.question_asia,false),

                    new Question(R.string.question_mideast,true),

                    new Question(R.string.question_oceans,true)
            };
    private int mCurrentIndex=-1;
    private int i=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate called");

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }


        setContentView(R.layout.activity_quiz);


        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
      mNextButton = (ImageButton) findViewById(R.id.next_button);
       mQuestionTextView = findViewById(R.id.question_text_view);
        mPrevButton = (ImageButton) findViewById(R.id.prev_button);






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

        mCheatButton=(Button)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                   cheatMessage();
               // Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show();
                boolean answerIsTrue = mQuestionBank[mCurrentIndex].getmAnswerTrue();
                Intent intent = CheatActivity.newIntent(MainActivity.this, answerIsTrue);
                startActivity(intent);




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

    public void cheatMessage()
    {
        int cheat=0;
        cheat=R.string.cheat;
        Toast.makeText(this,cheat, Toast.LENGTH_SHORT).show();


    }

    private void PrevUpdate() {
            if(mCurrentIndex>0) {
                mCurrentIndex = (mCurrentIndex - 1);
                int question = mQuestionBank[mCurrentIndex].getmTextResId();
                mQuestionTextView.setText(question);
            }


    }

    @Override
    public void onStart()
    {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }


    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called"); }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }




    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        Log.i(TAG,"onSaveInstanceState");
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(KEY_INDEX,mCurrentIndex);
    }


    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called"); }


    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called"); }




}

