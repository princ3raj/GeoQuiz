package com.example.geoquiz;

public class Question
{
private  int mTextResId;
private Boolean mAnswerTrue;

    public Question(int mTextResId, Boolean mAnswerTrue) {
        this.mTextResId = mTextResId;
        this.mAnswerTrue = mAnswerTrue;
    }

    public int getmTextResId() {
        return mTextResId;
    }

    public void setmTextResId(int mTextResId) {
        this.mTextResId = mTextResId;
    }

    public Boolean getmAnswerTrue() {
        return mAnswerTrue;
    }

    public void setmAnswerTrue(Boolean mAnswerTrue) {
        this.mAnswerTrue = mAnswerTrue;
    }
}
