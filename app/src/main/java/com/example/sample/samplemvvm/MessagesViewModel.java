package com.example.sample.samplemvvm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by azimmemon on 30/08/19.
 */

public class MessagesViewModel extends AndroidViewModel {

    private MessageRepository repository;
    private LiveData<List<MessageModel>> allMessages;

    public MessagesViewModel(@NonNull Application application) {
        super(application);

        repository = new MessageRepository(application);
        allMessages = repository.getAllNotes();

    }

    public void insert(MessageModel messageModel){
        repository.insert(messageModel);
    }

    public LiveData<List<MessageModel>> getAllMessages(){
        return allMessages;
    }
}