package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
 import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraActivity extends AppCompatActivity {
Button btn_gitpicture_l ,btn_image;
ImageView iMges;

//ActivityResultLauncher<intent> mGetContent;
ActivityResultLauncher<Intent>mGetContent;
ActivityResultLauncher<String> mgitimages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        btn_gitpicture_l=findViewById(R.id.btn_gitpicture);
        btn_image=findViewById(R.id.btn_images);
        iMges=findViewById(R.id.imageView);



// intent for using image directory
        mgitimages=registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<Uri>() {
            @Override
            public void onActivityResult(Uri result) {
                iMges.setImageURI(result);
            }
        });



        btn_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mgitimages.launch( "image/*" );
            }
        });


//intent for using camera
        mGetContent=registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode()==RESULT_OK && result.getData()!=null){
                            Bundle bndl=result.getData().getExtras();
                            Bitmap bitmp=(Bitmap) bndl.get("data");
                            iMges.setImageBitmap(bitmp);
                        }
                    }
                });





                btn_gitpicture_l.setOnClickListener(new View.OnClickListener() {
                                                        @Override
                                                        public void onClick(View view) {
                                                            //  Intent camera_intent=new Intent();
                                                            //camera_intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                                                            // startActivityForResult(camera_intent,CAPTURE_);
                                                           // mGetContent.launch("image/*");

                                                            Intent in =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                                            if(in.resolveActivity(getPackageManager())!=null){
                                                                mGetContent.launch(in);

                                                            }else{
                                                                Toast.makeText(getBaseContext(),"لايوجد تطبيق يدعم الصور",Toast.LENGTH_LONG).show();

                                                            }


                                                        }


                                                    }


                );


}


}