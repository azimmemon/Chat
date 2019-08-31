package com.example.sample.samplemvvm;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by azimmemon on 30/08/19.
 */
@Database(entities = {MessageModel.class}, version = 1)

public abstract class MessageDatabase extends RoomDatabase {

    public static MessageDatabase instance = null;

    public abstract MessageDAO messageDAO();

    public static MessageDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, MessageDatabase.class, "message_table")
                    .build();
        }
        return instance;
    }
}
