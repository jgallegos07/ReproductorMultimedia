package com.example.multimedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ejecutar_musica(View view) {
        Intent i=new Intent(this,Musica.class);
        startActivity(i);
    }
    public void ejecutar_video(View view) {
        Intent i=new Intent(this,Video.class);
        startActivity(i);
    }
    public void ejecutar_grabadora(View view) {
        Intent i=new Intent(this,Grabadora.class);
        startActivity(i);
    }
    public void ejecutar_camara(View view) {
        Intent i=new Intent(this,Camara.class);
        startActivity(i);
    }
}
