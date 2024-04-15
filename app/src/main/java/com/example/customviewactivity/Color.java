package com.example.customviewactivity;

public enum Color implements Listable{

    WHITE(R.drawable.i_white),
    BLACK(R.drawable.i_black),
    BLUE(R.drawable.i_blue),
    GREEN(R.drawable.i_green),
    RED(R.drawable.i_red),
    ORANGE(R.drawable.i_orange);

    private int image;

    Color(int image){
        this.image = image;
    }



    @Override
    public String getDescription(){
        return this.name();
    }
    @Override
    public int getDrawableImage() {
        return image;
    }
}
