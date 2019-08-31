package com.example.sample.samplemvvm;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by azimmemon on 30/08/19.
 */

public class MessageRecyclerAdapter extends RecyclerView.Adapter<MessageRecyclerAdapter.MyHolder>{

    private Context mContext;
    List<MessageModel> mMessageList;

    public MessageRecyclerAdapter(Context mContext){
        this.mContext = mContext;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = null;
        switch (viewType){
            case 0:
                view = inflater.inflate(R.layout.message_view_sender_layout, parent, false);
                break;
            case 1:
                view = inflater.inflate(R.layout.message_view_receiver_layout, parent, false);
                break;
            default:

        }

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.mMessage.setText(mMessageList.get(position).getMessage());
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mMessageList.get(position).getViewType();
    }


    public void addMessage(List<MessageModel> list){
        this.mMessageList = list;
        notifyDataSetChanged();

    }


    public class MyHolder extends RecyclerView.ViewHolder{

        TextView mMessage;

        public MyHolder(View itemView) {
            super(itemView);

            mMessage = (TextView)itemView.findViewById(R.id.sent_message);
        }
    }
}
