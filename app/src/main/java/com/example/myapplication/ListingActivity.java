package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
//ActivityResultLauncher<Intent> aRlun=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {



public class ListingActivity extends AppCompatActivity {
    ListView lv_pr;
    Button ListingActivity_btn_add_pr;
final  int Req_code_Add=1;
    PostAdapter adapterr;
   ActivityResultLauncher<Intent> runIntent=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
       @Override
       public void onActivityResult(ActivityResult result) {
          // if (result.getResultCode() == RESULT_OK && result != null) {
               // Here, no request code
              // Intent data = result.getData();
               Posts postz=(Posts) result.getData().getSerializableExtra("postx");
               adapterr.addItems(postz);
              // adapterr.notifyDataSetChanged();
          // }
       }
   });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);

        ListingActivity_btn_add_pr=findViewById(R.id.ListingActivity_btn_add);
        lv_pr=findViewById(R.id.lv10);


        ArrayList<Posts> posts=new ArrayList<>();


        posts.add(new Posts("kshibleaaaa","novamber 3 2022","ddddd",100,254,1515));
        posts.add(new Posts("kshible1","novamber 3 2022","ddddd",1520,254,1515));
        posts.add(new Posts("kshible2","novamber 3 2022","ddddd",106,254,1515));


         adapterr=new PostAdapter(this,R.layout.activity_gridz,posts);
       lv_pr.setAdapter(adapterr);


        ListingActivity_btn_add_pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adddetailedItemesActivity_intent=new Intent(getBaseContext(),adddetailedItemesActivity.class);


                runIntent.launch(adddetailedItemesActivity_intent);
                           }
        });

    }
}