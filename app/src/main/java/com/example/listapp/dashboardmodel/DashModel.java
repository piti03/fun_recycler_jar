package com.example.listapp.dashboardmodel;

public class DashModel {
    private int card_color;
    private int image_id;

    public String getImageTX() {
        return imageTX;
    }

    public void setImageTX(String imageTX) {
        this.imageTX = imageTX;
    }

    private String imageTX;
    public int getCard_color() {
        return card_color;
    }

    public void setCard_color(int card_color) {
        this.card_color = card_color;
    }



    public DashModel(int card_color,int image_id , String imageTX){
        this.image_id = image_id;
        this.card_color = card_color;
        this.imageTX = imageTX;
    }


    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }
}
