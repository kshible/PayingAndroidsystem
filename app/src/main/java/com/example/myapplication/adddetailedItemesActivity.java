package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class adddetailedItemesActivity extends AppCompatActivity {
Button adddetailedItemesActivity_btn_addpost_pr ;
EditText  adddetailedItemesActivity_name_pr,adddetailedItemesActivity_date_pr, adddetailedItemesActivity_body_pr, adddetailedItemesActivity_follower_pr,adddetailedItemesActivity_follwing_pr,adddetailedItemesActivity_posts_pr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddetailed_itemes);






        adddetailedItemesActivity_name_pr=findViewById(R.id.adddetailedItemesActivity_name);
        adddetailedItemesActivity_date_pr=findViewById(R.id.adddetailedItemesActivity_date);
        adddetailedItemesActivity_body_pr=findViewById(R.id.adddetailedItemesActivity_body);
        adddetailedItemesActivity_follower_pr=findViewById(R.id.adddetailedItemesActivity_follower);
        adddetailedItemesActivity_follwing_pr=findViewById(R.id.adddetailedItemesActivity_follwing);
        adddetailedItemesActivity_posts_pr=findViewById(R.id.adddetailedItemesActivity_posts);



        adddetailedItemesActivity_btn_addpost_pr=findViewById(R.id.adddetailedItemesActivity_btn_addpost);

        adddetailedItemesActivity_btn_addpost_pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

String name_pr=adddetailedItemesActivity_name_pr.getText().toString();
String date_pr=adddetailedItemesActivity_date_pr.getText().toString();
 String body_pr=adddetailedItemesActivity_body_pr.getText().toString();

  int follower_pr=Integer.parseInt( adddetailedItemesActivity_follower_pr.getText().toString());
 int follwing_pr=Integer.parseInt( adddetailedItemesActivity_follwing_pr.getText().toString());
 int posts_pr=Integer.parseInt( adddetailedItemesActivity_posts_pr.getText().toString());

                Intent intent=new Intent();

               Posts post=new Posts(name_pr, date_pr,body_pr, follower_pr, follwing_pr, posts_pr);
                intent.putExtra("postx",post);



         setResult(RESULT_OK,intent);
       finish();
            }
        });


    }
}