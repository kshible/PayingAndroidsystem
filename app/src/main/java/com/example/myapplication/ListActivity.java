package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
ListView Lv;
Button Listactivity_btn_pr,Listactivity_btn_edit_pr ;
EditText Listactivity_editText_pr;
int Indexx=-1;
ArrayList<String> names=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Lv=findViewById(R.id.ListActivity_list);
        Listactivity_editText_pr=findViewById(R.id.Listactivity_editText);
        Listactivity_btn_pr=findViewById(R.id.Listactivity_btn);
        Listactivity_btn_edit_pr=findViewById(R.id.Listactivity_btn_edit);

        for (int i = 0; i <20 ; i++) {
            names.add("Item "+i);
        }

     //  ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,names)
        MyAdapter adapter=new MyAdapter(this, android.R.layout.simple_list_item_1, names);

Lv.setAdapter(adapter);

        Listactivity_btn_pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addItem(Listactivity_editText_pr.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        Listactivity_btn_edit_pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.editItem(Indexx,Listactivity_editText_pr.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // Toast.makeText(ListActivity.this,adapter.getItem(i),Toast.LENGTH_SHORT).show();
                Indexx=i;

            }
        });
    }
}