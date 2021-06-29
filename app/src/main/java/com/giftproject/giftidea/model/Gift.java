package com.giftproject.giftidea.model;

public class Gift {
    private String giftCategoryName,fullListGiftImg,giftTitle,giftPrice;
    private int giftCategoryImg;

    public Gift() {
    }

    public Gift(int giftCategoryImg) {
        this.giftCategoryImg = giftCategoryImg;
    }

    public Gift(String giftCategoryName, int giftCategoryImg) {
        this.giftCategoryName = giftCategoryName;
        this.giftCategoryImg = giftCategoryImg;
    }

    public Gift(String fullListGiftImg, String giftTitle, String giftPrice) {
        this.fullListGiftImg = fullListGiftImg;
        this.giftTitle = giftTitle;
        this.giftPrice = giftPrice;
    }

    public String getGiftCategoryName() {
        return giftCategoryName;
    }

    public int getGiftCategoryImg() {
        return giftCategoryImg;
    }

    public String getFullListGiftImg() {
        return fullListGiftImg;
    }

    public String getGiftTitle() {
        return giftTitle;
    }

    public String getGiftPrice() {
        return giftPrice;
    }
}
