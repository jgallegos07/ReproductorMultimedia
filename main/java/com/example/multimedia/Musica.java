package com.example.multimedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Musica extends AppCompatActivity {

    Button play_pause, btn_repetir;
    MediaPlayer mp;
    ImageView iv;

    int repetir =2, posicion =0;

    MediaPlayer vetormp [] = new MediaPlayer[8];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);

        play_pause = (Button)findViewById(R.id.btn_play);
        btn_repetir = (Button)findViewById(R.id.btn_repetir);
        iv = (ImageView)findViewById(R.id.imageView);

        vetormp[0] = MediaPlayer.create(this, R.raw.bailemos);
        vetormp[1] = MediaPlayer.create(this, R.raw.bota_fuego);
        vetormp[2] = MediaPlayer.create(this, R.raw.china);
        vetormp[3] = MediaPlayer.create(this, R.raw.guru);
        vetormp[4] = MediaPlayer.create(this, R.raw.indeciso);
        vetormp[5] = MediaPlayer.create(this, R.raw.ritmo);
        vetormp[6] = MediaPlayer.create(this, R.raw.soltera_remix);
        vetormp[7] = MediaPlayer.create(this, R.raw.te_olvidare);
    }

    public void PlayPause(View view){
        if (vetormp[posicion].isPlaying()){
            vetormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.play);
            Toast.makeText(this,"Pausa",Toast.LENGTH_SHORT).show();
        }else {
            vetormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this,"Play",Toast.LENGTH_SHORT).show();
        }
    }

    public void Stop(View view){
        if (vetormp[posicion] != null){
            vetormp[posicion].stop();

            vetormp[0] = MediaPlayer.create(this, R.raw.bailemos);
            vetormp[1] = MediaPlayer.create(this, R.raw.bota_fuego);
            vetormp[2] = MediaPlayer.create(this, R.raw.china);
            vetormp[3] = MediaPlayer.create(this, R.raw.guru);
            vetormp[4] = MediaPlayer.create(this, R.raw.indeciso);
            vetormp[5] = MediaPlayer.create(this, R.raw.ritmo);
            vetormp[6] = MediaPlayer.create(this, R.raw.soltera_remix);
            vetormp[7] = MediaPlayer.create(this, R.raw.te_olvidare);

            posicion = 0;

            play_pause.setBackgroundResource(R.drawable.play);
            iv.setImageResource(R.drawable.portada1);
            Toast.makeText(this,"Stop",Toast.LENGTH_SHORT).show();

        }
    }

    public void Repetir(View view){
        if (repetir ==1){
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);
            Toast.makeText(this,"No repetir",Toast.LENGTH_SHORT).show();
            vetormp[posicion].setLooping(false);
            repetir =2;

        }else{
            btn_repetir.setBackgroundResource(R.drawable.repetir);
            Toast.makeText(this,"Repetir",Toast.LENGTH_SHORT).show();
            vetormp[posicion].setLooping(true);
            repetir =1;
        }
    }

    public void Siguiente (View view){
        if (posicion < vetormp.length -1){

            if (vetormp[posicion].isPlaying()){
                vetormp[posicion].stop();
                posicion++;
                vetormp[posicion].start();

            }else{
                posicion++;
            }

        }else{
            Toast.makeText(this,"No ahí mas canciones",Toast.LENGTH_SHORT).show();

        }
    }

    public void Anterior(View view){
        if (posicion>=1){

            if (vetormp[posicion].isPlaying()){
                vetormp[posicion].stop();

                vetormp[0] = MediaPlayer.create(this, R.raw.bailemos);
                vetormp[1] = MediaPlayer.create(this, R.raw.bota_fuego);
                vetormp[2] = MediaPlayer.create(this, R.raw.china);
                vetormp[3] = MediaPlayer.create(this, R.raw.guru);
                vetormp[4] = MediaPlayer.create(this, R.raw.indeciso);
                vetormp[5] = MediaPlayer.create(this, R.raw.ritmo);
                vetormp[6] = MediaPlayer.create(this, R.raw.soltera_remix);
                vetormp[7] = MediaPlayer.create(this, R.raw.te_olvidare);

                posicion--;

                vetormp[posicion].start();

            }else{
                posicion--;
            }

        }else{
            Toast.makeText(this,"No ahí mas canciones",Toast.LENGTH_SHORT).show();

        }
    }

    public void ejecutar_menu(View view) {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
