package com.example.musique;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.musique.ui.songs.SongsFragment;

public class Songs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, SongsFragment.newInstance())
                    .commitNow();
        }
    }
}