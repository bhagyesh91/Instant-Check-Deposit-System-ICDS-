package com.example.icds;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Notify extends AppCompatActivity {
    
    Button Mailus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);


        Mailus = findViewById(R.id.mailus);

        Mailus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:senderbank@gmail.com,receiverbank@gmail.com,icdsapp@gmail.com")));
            }
        });
           }
}
