package com.example.musique;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.musique.ui.albums.AlbumsFragment;

public class Albums extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, AlbumsFragment.newInstance())
                    .commitNow();
        }
    }
}