package com.example.musique;

import androidx.appcompat.app.AppCompatActivity;
import com.example.musique.databinding.ActivityMainBinding;
import android.os.Bundle;
import java.util.ArrayList;
import android.media.MediaPlayer;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.view.View;
import android.Manifest;
import android.content.DialogInterface;
import android.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements Interface {
    public static Library library;
    public static MediaPlayer mp;
    public static boolean isPlaying;
    public static FragmentManager fm;
    private int CODE = 1;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_MEDIA_AUDIO) != getPackageManager().PERMISSION_GRANTED)
            requestMedia();
        fm = getSupportFragmentManager();
        switchFrag(new Progress());
        library = new Library(this);
        mp = new MediaPlayer();
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

    void requestMedia() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.READ_MEDIA_AUDIO)) {

            new AlertDialog.Builder(this)
                    .setTitle("Permission needed")
                    .setMessage("This permission is needed because of this and that")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this,
                                    new String[] {Manifest.permission.READ_MEDIA_AUDIO}, CODE);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.READ_MEDIA_AUDIO}, CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == CODE)  {
            if (grantResults.length > 0 && grantResults[0] == getPackageManager().PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}