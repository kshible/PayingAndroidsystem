package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class CalculateActivity extends AppCompatActivity {
    private NumberPicker picker1;
    private String[] pickerVals;
      TextView tv1;
    EditText text;

    Button btn;
    Button btn1,camerazbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        picker1 = findViewById(R.id.numberpicker_main_picker);
        picker1.setMaxValue(4);
        picker1.setMinValue(0);
       // picker1.setWrapSelectorWheel(true);

        Toast.makeText(getBaseContext(),"oncreate",Toast.LENGTH_LONG).show();


            text=findViewById(R.id.Calculate_text1);
          tv1=findViewById(R.id.Calculate_textView1);
        btn1=findViewById(R.id.button2);
        btn=findViewById(R.id.button);
        camerazbtn=findViewById(R.id.btn_camera);
        final Spinner spnr=findViewById(R.id.Calculate_spinner1);
        tv1.setText("tv1value");
        text.setText("24259aaaaaaaaaaaaaaaaa");

        camerazbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent camerscreen_intent=new Intent(getBaseContext(),CameraActivity.class);
startActivity(camerscreen_intent);


            }
        });


      btn1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent();
              intent.setAction(intent.ACTION_DIAL);
              intent.setData(Uri.parse("tel:" + Uri.encode("+12345#123")));
              startActivity(intent);



          }
      });



        pickerVals  = new String[] {"dog", "cat", "lizard", "turtle", "axolotl"};
        picker1.setDisplayedValues(pickerVals);

        picker1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                int valuePicker1 = picker1.getValue();
                Log.d("picker value=================>", pickerVals[valuePicker1]);

            }
        });


        spnr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {



           @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });





        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (btn.getText()=="تغيير نمط الخطوط") {

                    btn.setText("تغيير نمط جديد");
                  //  btn.setBackground('red');
              }
                  else
              {
                  btn.setText("تغيير نمط الخطوط");

              }
            }


        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getBaseContext(),"إيقاف مؤقت",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getBaseContext(),"onStart message",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getBaseContext(),"إيقاف البرنامج",Toast.LENGTH_LONG).show();
Bundle b=new Bundle();
b.putString("abc1","aaaaaaaaaaaaaaaaaa");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getBaseContext(),"onDestroy...",Toast.LENGTH_LONG).show();

    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getBaseContext(),"onSaveInstanceState...",Toast.LENGTH_LONG).show();
        outState.putString("abc", text.getText().toString());
    }



    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
String x1=savedInstanceState.getString("abc");
        tv1.setText(x1);
        Toast.makeText(getBaseContext(),x1+"",Toast.LENGTH_LONG).show();

    }



    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getBaseContext(),"إعادة تشغيل",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getBaseContext(),"إستئناف وإستعداد",Toast.LENGTH_LONG).show();

    }
}