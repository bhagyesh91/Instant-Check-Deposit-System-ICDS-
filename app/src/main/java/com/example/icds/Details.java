package com.example.icds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Details extends AppCompatActivity {


    private EditText teachline, amount, account, cheque, mirc,rbi, transaction,ifsc,phone;
    public Button next;
    public ImageView image;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        teachline = findViewById(R.id.eteachline);
        amount = findViewById(R.id.eamount);
        account = findViewById(R.id.eaccount);
        cheque = findViewById(R.id.echeque);
        mirc = findViewById(R.id.emirc);
        rbi = findViewById(R.id.erbi);
        transaction = findViewById(R.id.etransation);
        image = findViewById(R.id.eimage);
        next = findViewById(R.id.enext);
        ifsc=findViewById(R.id.ifsc);
        phone=findViewById(R.id.phone);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDatabase = FirebaseDatabase.getInstance();
                mDbRef = mDatabase.getReference("Customer").push();
                Map<String,Object> map= new HashMap<>();
                map.put("Phone Number",phone.getText().toString());
                map.put("Teachline",teachline.getText().toString());
                map.put("Amount",amount.getText().toString());
                map.put("Cheque",cheque.getText().toString());
                map.put("Account",account.getText().toString());
                map.put("IFSC",ifsc.getText().toString());
                map.put("Transaction",transaction.getText().toString());
                map.put("MIRC",mirc.getText().toString());
                map.put("RBI",rbi.getText().toString());

                mDbRef.updateChildren(map);
                Toast.makeText(getApplicationContext(), "INSERTED", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Details.this, Upload.class);
                startActivity(intent);
            }
        });
    }
}