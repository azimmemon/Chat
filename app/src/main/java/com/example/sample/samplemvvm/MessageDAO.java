package com.example.sample.samplemvvm;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by azimmemon on 30/08/19.
 */

@Dao
public interface MessageDAO {

    @Insert
    void insertMessage(MessageModel note);

    @Query("SELECT * FROM USER_MESSAGES")
    LiveData<List<MessageModel>> getAllMessages();

}
