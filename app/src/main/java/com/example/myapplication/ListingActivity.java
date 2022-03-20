package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListingActivity extends AppCompatActivity {
    ListView lv_pr;
    Button btnload_pr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        btnload_pr=findViewById(R.id.button100);
        lv_pr=findViewById(R.id.lv10);
        ArrayList<Posts> posts=new ArrayList<>();

        //public Posts(String name, String date, String body, int follower, int follwing, int posts) {

        posts.add(new Posts("kshible","novamber 3 2022","ddddd",1000,254,1515));


       PostAdapter adapterr=new PostAdapter(this,R.layout.costom_post_layout,posts);
       lv_pr.setAdapter(adapterr);

    }
}