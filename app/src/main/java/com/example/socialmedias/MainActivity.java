package com.example.socialmedias;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.io.File;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;



public class MainActivity extends AppCompatActivity {


    public final String[] EXTERNAL_PERMS = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE
    };

    public final int EXTERNAL_REQUEST = 138;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getImagesFromExternal()){



        // Do something in response to button click

        String urlVideo = "file:///storage/emulated/0/Android/data/br.com.educacional.pensematematicamobile/files/pense.mp4";

        urlVideo = urlVideo.replace("file://","content://");

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        //shareIntent.setAction(Intent.ACTION_SEND);

        shareIntent.setType("video/mp4");


        // Create the URI from the media
        File media = new File(urlVideo);
        Uri uri = Uri.fromFile(media);

        shareIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        // Add the URI to the Intent.
        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse(urlVideo));



        startActivity(Intent.createChooser(shareIntent,"teste pense"));

        }
        else{
            Log.e("VENDO","FALSE");
        }

    }




    public boolean getImagesFromExternal() {
        boolean t =   requestForPermission();
        return t ;
    }


    public boolean requestForPermission() {

        boolean isPermissionOn = true;
        final int version = Build.VERSION.SDK_INT;
        if(version >= 23) {
            if(!canAccessExternalSd()) {
                isPermissionOn = false;
                requestPermissions(EXTERNAL_PERMS, EXTERNAL_REQUEST);
            }
        }

        return isPermissionOn;
    }

    public boolean canAccessExternalSd() {
        return (hasPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE));
    }

    private boolean hasPermission(String perm) {
        return (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, perm));

    }


}
