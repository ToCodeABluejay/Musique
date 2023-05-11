package com.example.musique;

import android.net.Uri;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import androidx.annotation.NonNull;

public class Song implements Parcelable {
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

    public Uri getCover() {
        return cover;
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

    private ArrayList<Song> songs;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeList(songs);
    }
}
