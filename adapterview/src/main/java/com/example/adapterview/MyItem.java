package com.example.adapterview;

/**
 * Created by vivek50 on 14/9/16.
 */
public class MyItem {

    private Long itemId;
    private int imageId;
    private String text;

    public MyItem(Long itemId, int imageId, String text) {

        this.imageId = imageId;
        this.itemId = itemId;
        this.text = text;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
