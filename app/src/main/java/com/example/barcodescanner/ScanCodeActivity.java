package com.example.barcodescanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanCodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    ZXingScannerView scanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scanner = new ZXingScannerView(this);
        setContentView(scanner);
    }

    @Override
    public void handleResult(Result result) {
        Log.e("Result", result.getText());
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        scanner.stopCamera();
    }

    @Override
    protected void onResume() {
        super.onResume();
        scanner.setResultHandler(this);
        scanner.startCamera();
    }
}
