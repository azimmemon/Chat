package com.example.sample.samplemvvm;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by azimmemon on 18/07/19.
 */

public class MessageRepository {

    private MessageDAO messageDAO;
    private MessageDatabase database;
    private LiveData<List<MessageModel>> messages;

    public MessageRepository(Context context){
        database = MessageDatabase.getInstance(context);
        messageDAO = database.messageDAO();

    }


    public void insert(MessageModel note){
        new InsertDataAsync(messageDAO).execute(note);
    }


    public LiveData<List<MessageModel>> getAllNotes(){
     messages = messageDAO.getAllMessages();
     return messages;
    }


    public static class InsertDataAsync extends AsyncTask<MessageModel, Void, Void>{

        MessageDAO messageDAO;

        public InsertDataAsync(MessageDAO noteDAO){
            this.messageDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(MessageModel... message) {
            messageDAO.insertMessage(message[0]);
            return null;
        }
    }
}
