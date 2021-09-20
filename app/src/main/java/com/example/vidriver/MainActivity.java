package com.example.vidriver;

import android.app.Activity;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends Activity {

    private VideoView vv;
    private MediaController mediaController;
    private Button pv,sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vv = findViewById(R.id.video);
        pv = findViewById(R.id.play);
        sv = findViewById(R.id.stop);
        mediaController = new MediaController(this);

       pv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.valheim);

                vv.setVideoURI(uri);
                vv.setMediaController(mediaController);
                mediaController.setAnchorView(vv);
                vv.start();
                Toast.makeText(getApplicationContext(),"Video Diputar", Toast.LENGTH_LONG).show();
            }
        });

        sv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    vv.stopPlayback();
                Toast.makeText(getApplicationContext(),"Video Dihentikan", Toast.LENGTH_LONG).show();
            }
        });

    }
}