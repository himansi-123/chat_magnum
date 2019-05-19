package com.example.himansi.chat_interfaceapp;

import android.graphics.Bitmap;

public class msg_chat {

    private String message;
    private int messageType;
    private Bitmap image;

    public msg_chat(String message, int messageType, Bitmap image) {
        this.message = message;
        this.messageType = messageType;
        this.image = image;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

}
