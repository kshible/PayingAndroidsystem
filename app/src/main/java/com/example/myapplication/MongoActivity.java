package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MongoActivity extends AppCompatActivity {
Button camera_btn_open ;
TextView Mongo_txt_camera_pr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mongo);
        Mongo_txt_camera_pr=findViewById(R.id.Mongo_txt_camera);


        camera_btn_open =findViewById(R.id.Mongo_btn_camera);

        camera_btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camera_intent=new Intent(getBaseContext(),CameraActivity.class);
                startActivityForResult(camera_intent,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

       String oldTxt= Mongo_txt_camera_pr.getText().toString();

int Newarea= data.getIntExtra("Rabc",0);
        Mongo_txt_camera_pr.setText(oldTxt + "\n"+Newarea);


    }
}