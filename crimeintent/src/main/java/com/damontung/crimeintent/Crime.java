package com.damontung.crimeintent;

import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2016/3/15.
 */
public class Crime {
    private UUID mId;
    private String mTitle;
    private String mDate;
    //private String mDateString;
    private boolean mSolved;


    public Crime(){
        mId = UUID.randomUUID();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mDate = format.format(new Date());

    }

    public String getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public boolean isSolved() {
        return mSolved;
    }

    public void setSolved(boolean solved) {
        mSolved = solved;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public UUID getId() {
        return mId;

    }


    @Override
    public String toString() {
        return mTitle;
    }
}
