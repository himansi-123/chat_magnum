package com.example.himansi.chat_interfaceapp;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MessageListAdapter extends RecyclerView.Adapter {
    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;
    private static final int VIEW_TYPE_MESSAGE_OTHER = 3;
    public static int currentListSize = 0;
    private static int maxListSize;

    private Context mContext;
    private List<msg_chat> mMessageList;

    public MessageListAdapter(Context context, List<msg_chat> messageList) {
        mContext = context;
        mMessageList = messageList;
        maxListSize = messageList.size();
    }

    @Override
    public int getItemCount() {
        if (currentListSize <= maxListSize)
            return currentListSize;
        else
            currentListSize = maxListSize;
            return currentListSize;
    }

    @Override
    public int getItemViewType(int position) {
        msg_chat message = mMessageList.get(position);

        if (message.getMessageType() == VIEW_TYPE_MESSAGE_SENT) {
            return VIEW_TYPE_MESSAGE_SENT;
        } else if (message.getMessageType() == VIEW_TYPE_MESSAGE_RECEIVED) {
            return VIEW_TYPE_MESSAGE_RECEIVED;
        } else {
            return VIEW_TYPE_MESSAGE_OTHER;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == VIEW_TYPE_MESSAGE_SENT) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.message_sent, parent, false);
            return new SentMessageHolder(view);
        } else if (viewType == VIEW_TYPE_MESSAGE_RECEIVED) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.message_received, parent, false);
            return new ReceivedMessageHolder(view);
        } else if (viewType == VIEW_TYPE_MESSAGE_OTHER) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.other_msg, parent, false);
            return new OtherMessageHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        msg_chat message = mMessageList.get(position);
        switch (holder.getItemViewType()) {
            case VIEW_TYPE_MESSAGE_SENT:
                ((SentMessageHolder) holder).bind(message);
                break;
            case VIEW_TYPE_MESSAGE_RECEIVED:
                ((ReceivedMessageHolder) holder).bind(message);
                break;
            case VIEW_TYPE_MESSAGE_OTHER:
                ((OtherMessageHolder) holder).bind(message);
        }
    }

    private class ReceivedMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText;
        ImageView messageImage;

        ReceivedMessageHolder(View itemView) {
            super(itemView);
            messageText = itemView.findViewById(R.id.text_msg);
            messageImage = itemView.findViewById(R.id.image_item);
        }

        void bind(msg_chat message) {
            if (message.getImage() == null) {
                messageText.setVisibility(View.VISIBLE);
                messageImage.setVisibility(View.GONE);
                messageText.setText(message.getMessage());
            } else {
                messageText.setVisibility(View.GONE);
                messageImage.setVisibility(View.VISIBLE);
                messageImage.setImageBitmap(message.getImage());
            }
        }
    }

    private class SentMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText;
        ImageView messageImage;

        SentMessageHolder(View itemView) {
            super(itemView);
            messageText = itemView.findViewById(R.id.text_msg);
            messageImage = itemView.findViewById(R.id.image_item);
        }

        void bind(msg_chat message) {
            if (message.getImage() == null) {
                messageText.setVisibility(View.VISIBLE);
                messageImage.setVisibility(View.GONE);
                messageText.setText(message.getMessage());
            } else {
                messageText.setVisibility(View.GONE);
                messageImage.setVisibility(View.VISIBLE);
                messageImage.setImageBitmap(message.getImage());
            }
        }
    }

    private class OtherMessageHolder extends RecyclerView.ViewHolder {
        TextView messageText;

        OtherMessageHolder(View itemView) {
            super(itemView);
            messageText = itemView.findViewById(R.id.text_msg);
        }

        void bind(msg_chat message) {
            messageText.setText(message.getMessage());
        }
    }

}