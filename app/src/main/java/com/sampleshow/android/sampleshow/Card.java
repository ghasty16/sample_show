package com.sampleshow.android.sampleshow;

public class Card implements Comparable{
    int mNumber;
    String mValue;
    int mImageRes;
    public Card(int number,String value,int imageRes){
        mNumber=number;
        mValue=value;
        mImageRes=imageRes;
    }

    public int getNumber() {
        return mNumber;
    }
    public String getValue(){
        return mValue;
    }
    public int getImageRes(){
        return mImageRes;
    }

    @Override
    public int compareTo(Object o) {
        Card compareCard=(Card)o;
        int compareNumber=compareCard.getNumber();
        return this.mNumber-compareNumber;
    }
}
