package com.example.listapp.dashboardmodel;

public class CardImageModel {
    private int cardListImage ;
    private String cardListTitle;
    private String cardListDescription;


    public CardImageModel(int cardListImage , String cardListTitle , String cardListDescription){
        this.cardListImage = cardListImage;
        this.cardListTitle = cardListTitle;
        this.cardListDescription = cardListDescription;

    }


    public int getCardListImage() {
        return cardListImage;
    }

    public void setCardListImage(int cardListImage) {
        this.cardListImage = cardListImage;
    }

    public String getCardListTitle() {
        return cardListTitle;
    }

    public void setCardListTitle(String cardListTitle) {
        this.cardListTitle = cardListTitle;
    }

    public String getCardListDescription() {
        return cardListDescription;
    }

    public void setCardListDescription(String cardListDescription) {
        this.cardListDescription = cardListDescription;
    }
}
