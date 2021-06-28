package com.oscar.team13;

public class Taiwan implements Comparable<Taiwan>{

    private String mArea;
    private String mName;
    private int mPeople;

    public Taiwan(String Area,String Name,int People){
        mArea = Area;
        mName = Name;
        mPeople = People;
    }

    public String getArea(){
        return mArea;
    }

    public void setArea(String Area){
        mArea = Area;
    }

    public String getName(){
        return mName;
    }

    public void setJobTitle(String Name){
        mName = Name;
    }

    public int getPeople(){
        return mPeople;
    }

    public void setPeople(int People){
        mPeople = People;
    }

    @Override
    public String toString() {
        return "Taiwan " +
                "區域: " + mArea +
                ", 縣市: " + mName +
                ", 確診人數: " + mPeople;
    }

    @Override
    public int compareTo(Taiwan taiwan) {
        return this.mPeople > taiwan.mPeople ? 1 :(this.mPeople < taiwan.mPeople ? -1 :0);
    }
}

