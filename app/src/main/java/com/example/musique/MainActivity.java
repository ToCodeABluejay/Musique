package com.example.musique;

import androidx.appcompat.app.AppCompatActivity;
import com.example.musique.databinding.ActivityMainBinding;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {
    public static Library library;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        switchFrag(new Player());
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
        this.library = new Library(this);
    }

    public void popFrag() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        fm.popBackStackImmediate();
        ft.commit();
    }

    public void switchFrag(Fragment frag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, frag);
        ft.commit();
    }
}