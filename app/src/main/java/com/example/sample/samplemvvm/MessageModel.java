package com.example.sample.samplemvvm;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by azimmemon on 18/07/19.
 */

@Entity(tableName = "USER_MESSAGES")
public class MessageModel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String message;

    private int viewType;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }
}
