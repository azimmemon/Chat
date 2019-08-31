package com.example.sample.samplemvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    MessagesViewModel messagesViewModel;
    @BindView(R.id.messages_view)
    RecyclerView mMessageView;
    private MessageRecyclerAdapter mAdapter;
    @BindView(R.id.type_message)
    EditText mTypeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mMessageView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MessageRecyclerAdapter(this);

        messagesViewModel = ViewModelProviders.of(this).get(MessagesViewModel.class);

        messagesViewModel.getAllMessages().observe(this, new Observer<List<MessageModel>>() {
            @Override
            public void onChanged(@Nullable List<MessageModel> messageModels) {

                mAdapter.addMessage(messageModels);
                mMessageView.scrollToPosition(messageModels.size()-1);
                mMessageView.setAdapter(mAdapter);

            }
        });
    }

    @OnClick(R.id.send_message)
    public void onButtonClick(View view) {
        String message = mTypeMessage.getText().toString();
        if (!TextUtils.isEmpty(message)){
            MessageModel messageModel = new MessageModel();
            messageModel.setMessage(message);
            messageModel.setViewType(1);
            messagesViewModel.insert(messageModel);
            mTypeMessage.setText("");

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    MessageModel staticMessage = new MessageModel();
                    staticMessage.setViewType(0);
                    staticMessage.setMessage("Thank you!! Send me more testing messages. I am enjoying it.");
                    messagesViewModel.insert(staticMessage);
                }
            }, 2000);



        }else {
            Toast.makeText(MainActivity.this, getString(R.string.type_message_warning), Toast.LENGTH_LONG).show();
        }

    }
}
