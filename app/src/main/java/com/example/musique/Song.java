package com.example.musique;

import android.net.Uri;
import android.content.res.Resources;

public class Song {
    String artist, album, name, file;
    Uri cover;

    Song(String artist, String album, String name, String file, Uri cover) {
        this.artist = artist;
        this.album = album;
        this.name = name;
        this.file = file;
        this.cover = cover;
        if (artist=="")
            this.artist = Resources.getSystem().getString(R.string.no_artist);
        if (album=="")
            this.album = Resources.getSystem().getString(R.string.no_album);
    }

    public String getArtist() {
        MainActivity.library.getArtists();
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getName() {
        return name;
    }

    public String getFile() {
        return file;
    }
}
