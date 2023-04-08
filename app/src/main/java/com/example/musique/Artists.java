package com.example.musique;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.musique.ui.artists.ArtistsFragment;

public class Artists extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ArtistsFragment.newInstance())
                    .commitNow();
        }
    }
}