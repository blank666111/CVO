package com.example.cvo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UserModel{
    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    private String str;

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    private String createDate;
}