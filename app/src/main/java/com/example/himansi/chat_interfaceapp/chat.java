package com.example.himansi.chat_interfaceapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class chat extends Fragment {

    List<msg_chat> messageList;

    private RecyclerView mMessageRecycler;
    public static MessageListAdapter mMessageAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_chat, container, false);

        messageList = new ArrayList<>();
        loadMessages();

        mMessageRecycler = view.findViewById(R.id.recylerview_message_list);
        mMessageAdapter = new MessageListAdapter(getContext(), messageList);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        mMessageRecycler.setAdapter(mMessageAdapter);

        LinearLayout layout = view.findViewById(R.id.chat_box);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.isConnected()) {
                    Log.e("STATUS", "CLICKED");
                    MessageListAdapter.currentListSize++;
                    mMessageAdapter.notifyDataSetChanged();
                    mMessageRecycler.smoothScrollToPosition(MessageListAdapter.currentListSize - 1);
                } else
                    MainActivity.replaceFragment();
            }
        });

        return view;
    }

    private void loadMessages() {

        Bitmap bp1 = BitmapFactory.decodeResource(getResources(),R.drawable.puppy);
        messageList.add(new msg_chat("Chat between two friends", 3, null));
        messageList.add(new msg_chat("Hey Akash!", 1, null));
        messageList.add(new msg_chat("Hey Anshu!", 2, null));
        messageList.add(new msg_chat("How was your day?", 1, null));
        messageList.add(new msg_chat("Good dude!", 2, null));
        messageList.add(new msg_chat("Anshu! You were telling me yesterday about a new puppy you are going to buy.", 2, null));
        messageList.add(new msg_chat("Yes Akash, I bought it today morning.", 1, null));
        messageList.add(new msg_chat("You know Akash,It's the best puppy i had till now.", 1, null));
        messageList.add(new msg_chat("Why is it so Anshu?", 2, null));
        messageList.add(new msg_chat("She is too cute and she never leaves me.", 1, null));
        messageList.add(new msg_chat("And also she doesn't bark at strangers.It's a friendly dog.", 1, null));
        messageList.add(new msg_chat("Will U introduce me to her?",2 , null));
        messageList.add(new msg_chat("Sure! Why not!", 1, null));
        messageList.add(new msg_chat("Send me a pic of it now.I would like to see her!",2 , null));
        messageList.add(new msg_chat(null,1 , bp1));
        messageList.add(new msg_chat("Chat ended",3 , null));


        messageList.add(new msg_chat("Chat between two friends", 3, null));
        messageList.add(new msg_chat("Hey Akash!", 1, null));
        messageList.add(new msg_chat("Hey Anshu!", 2, null));
        messageList.add(new msg_chat("How was your day?", 1, null));
        messageList.add(new msg_chat("Good dude!", 2, null));
        messageList.add(new msg_chat("Anshu! You were telling me yesterday about a new puppy you are going to buy.", 2, null));
        messageList.add(new msg_chat("Yes Akash, I bought it today morning.", 1, null));
        messageList.add(new msg_chat("You know Akash,It's the best puppy i had till now.", 1, null));
        messageList.add(new msg_chat("Why is it so Anshu?", 2, null));
        messageList.add(new msg_chat("She is too cute and she never leaves me.", 1, null));
        messageList.add(new msg_chat("And also she doesn't bark at strangers.It's a friendly dog.", 1, null));
        messageList.add(new msg_chat("Will U introduce me to her?",2 , null));
        messageList.add(new msg_chat("Sure! Why not!", 1, null));
        messageList.add(new msg_chat("Send me a pic of it now.I would like to see her!",2 , null));
        messageList.add(new msg_chat(null,1 , bp1));
        messageList.add(new msg_chat("Chat ended",3 , null));


        messageList.add(new msg_chat("Chat between two friends", 3, null));
        messageList.add(new msg_chat("Hey Akash!", 1, null));
        messageList.add(new msg_chat("Hey Anshu!", 2, null));
        messageList.add(new msg_chat("How was your day?", 1, null));
        messageList.add(new msg_chat("Good dude!", 2, null));
        messageList.add(new msg_chat("Anshu! You were telling me yesterday about a new puppy you are going to buy.", 2, null));
        messageList.add(new msg_chat("Yes Akash, I bought it today morning.", 1, null));
        messageList.add(new msg_chat("You know Akash,It's the best puppy i had till now.", 1, null));
        messageList.add(new msg_chat("Why is it so Anshu?", 2, null));
        messageList.add(new msg_chat("She is too cute and she never leaves me.", 1, null));
        messageList.add(new msg_chat("And also she doesn't bark at strangers.It's a friendly dog.", 1, null));
        messageList.add(new msg_chat("Will U introduce me to her?",2 , null));
        messageList.add(new msg_chat("Sure! Why not!", 1, null));
        messageList.add(new msg_chat("Send me a pic of it now.I would like to see her!",2 , null));
        messageList.add(new msg_chat(null,1 , bp1));
        messageList.add(new msg_chat("Chat ended",3, null));














    }
}
