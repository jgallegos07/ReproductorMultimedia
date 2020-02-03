package com.example.multimedia;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.IOException;


public class Grabadora extends Activity {
    private MediaRecorder miGrabacion;
    private String outputFile = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grabadora);

        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Grabadora.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO}, 1000);
        }
    }

    public void grabar(View view) {
        outputFile = Environment.getExternalStorageDirectory().
                getAbsolutePath() + "/MiGrabacion.3gp";
        miGrabacion = new MediaRecorder();
        miGrabacion.setAudioSource(MediaRecorder.AudioSource.MIC);
        miGrabacion.setOutputFormat(MediaRecorder.OutputFormat.
                THREE_GPP);
        miGrabacion.setAudioEncoder(MediaRecorder.OutputFormat.AMR_NB);
        miGrabacion.setOutputFile(outputFile);

        try {
            miGrabacion.prepare();
            miGrabacion.start();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "Grabando", Toast.LENGTH_LONG).show();
    }

    public void detener(View view) {
        if (miGrabacion != null) {
            miGrabacion.stop();
            miGrabacion.release();
            miGrabacion = null;
            Toast.makeText(getApplicationContext(), "Audio grabado con éxito", Toast.LENGTH_LONG).show();
        }
    }

    public void reproducir(View view) {
        MediaPlayer m_reproducir = new MediaPlayer();
        try {
            m_reproducir.setDataSource(outputFile);
            m_reproducir.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        m_reproducir.start();
        Toast.makeText(getApplicationContext(), "reproduciendo", Toast.LENGTH_LONG).show();
    }

    public void ejecutar_menu(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
