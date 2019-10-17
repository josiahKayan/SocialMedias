package com.example.socialmedias;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Do something in response to button click

        String urlVideo = "http://dev.pensematematica.educacional.net/arquivos/Dinamica/template1.mp4";

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, urlVideo);
        shareIntent.setType("video/mp4");
        startActivity(Intent.createChooser(shareIntent,"teste pense"));


    }
}
