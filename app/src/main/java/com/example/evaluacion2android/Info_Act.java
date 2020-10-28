package com.example.evaluacion2android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Info_Act extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_);
        getSupportActionBar().hide();

        videoView = (VideoView)findViewById(R.id.videoView);  // llamo el elemento por id.


        // Es colocar el video dentro del videoView a través de su ruta.

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta);  // ruta en el content provider.
        videoView.setVideoURI(uri);  // le pasamos la ruta al video.

        // Control de navegación

        MediaController media = new MediaController(this); // creamos el control.
        videoView.setMediaController(media); // pasamos el control al videoview.
    }

    public void maps (View view){
        Intent intent = new Intent(this, Maps_Act.class);
        startActivity(intent);

    }

}