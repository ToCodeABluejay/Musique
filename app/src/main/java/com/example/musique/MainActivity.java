package com.example.musique;

import androidx.appcompat.app.AppCompatActivity;
import com.example.musique.databinding.ActivityMainBinding;
import android.os.Bundle;
import java.util.ArrayList;
import android.media.MediaPlayer;
import android.widget.ProgressBar;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements Interface {
    public static Library library;
    public static MediaPlayer mp;
    public static boolean isPlaying;
    public static FragmentManager fm;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        this.fm = getSupportFragmentManager();
        switchFrag(new Progress());
        this.library = new Library(this);
        this.mp = new MediaPlayer();
        binding.nav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.n_artists:
                    switchFrag(new Artists());
                    break;
                case R.id.n_albums:
                    switchFrag(new Albums());
                    break;
                case R.id.n_songs:
                    switchFrag(new Songs());
                    break;
                default:
                    switchFrag(new Player());
            }
            return true;
        });
    }

    public static void switchFrag(Fragment frag) {
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.constrain_layout, frag);
        ft.commit();
    }


    @Override
    public void onClick(int position) {

    }

    public static void initPlayer() {
        switchFrag(new Player());
    }

    public static void playSong(ArrayList<Song> songs, int position) {
        try {
            mp.setDataSource(songs.get(position).getFile());
            mp.prepare();
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Player.cover.setImageURI(songs.get(position).getCover());
    }

    public static void playButton() {
        if(isPlaying=mp.isPlaying()){
            mp.pause();
        } else {
            mp.start();
        }
    }
}