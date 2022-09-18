package com.lemzeeyyy.imagetotextapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ScannerActivity extends AppCompatActivity {
    private ImageView capturedImage;
    private TextView detectedTV;
    private Button snapBtn;
    private Button detectBtn;
    private Bitmap imageBitmap;
    static final int REQUEST_IMAGE_CODE = 1 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scannner);
        capturedImage = findViewById(R.id.captured_image);
        detectedTV = findViewById(R.id.detected_text);
        snapBtn = findViewById(R.id.snap_image_btn);
        detectBtn = findViewById(R.id.button_detect);

        detectBtn.setOnClickListener(view -> {
        DetectText();
        });
        snapBtn.setOnClickListener(view -> {
        if(CheckPermission()){
            captureImage();
        }else {
            RequestPermission();
        }
        });
    }

    private void RequestPermission() {
        int PERMISSION_CODE = 200;
        ActivityCompat.requestPermissions(this,new String[]{
                Manifest.permission.CAMERA
        },PERMISSION_CODE);
    }

    private boolean CheckPermission() {
        int cameraPermission = ContextCompat.checkSelfPermission(getApplicationContext(),CAMERA_SERVICE);
        return cameraPermission == PackageManager.PERMISSION_GRANTED;
    }


    private void captureImage() {

    }

    private void DetectText() {

    }
}